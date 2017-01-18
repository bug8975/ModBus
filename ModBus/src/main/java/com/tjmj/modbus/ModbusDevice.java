package com.tjmj.modbus;

import com.serotonin.modbus4j.exception.ModbusTransportException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * @author zhuhusheng
 * @date 2016/11/9
 */
@Data
@Slf4j
public class ModbusDevice {
    private String device;
    private ModbusMasterWrapper modbusMasterWrapper;
    public ModbusDevice() {
    }

    public ModbusDevice(String device, ModbusMasterWrapper modbusMasterWrapper) {
        this.device = device;
        this.modbusMasterWrapper = modbusMasterWrapper;
    }

    public String getHost() {
        return modbusMasterWrapper.getHostIp();
    }

    public int getPort() {
        return modbusMasterWrapper.getHostPort();
    }

    public int getSlaveId() {
        return modbusMasterWrapper.getSlaveId();
    }

    public boolean connect() {
        return modbusMasterWrapper.connect();
    }

    public void disconnect() {
        modbusMasterWrapper.disconnect();
    }

    public boolean isConnected() {
        return modbusMasterWrapper.isConnected();
    }

    public Integer[] readHoldingRegisterValues(int startOffset, int numberOfRegisters) {
        short[] values = new short[numberOfRegisters];
        try {
            values = modbusMasterWrapper.readHoldingRegisterValues(startOffset, numberOfRegisters);
        } catch (ModbusTransportException m) {
            log.error("device:{}, modbus://{}:{}/{} read address[{}-{}] error",
                    device, getHost(), getPort(), getSlaveId(),
                    startOffset, startOffset + numberOfRegisters);
        }
        Integer[] newValues = new Integer[numberOfRegisters];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = Short.valueOf(values[i]).intValue();
        }
        return newValues;
    }

    public Integer readHoldingRegisterValue(int startOffset) {
        Short value = -1;
        try {
            value = modbusMasterWrapper.readHoldingRegisterValue(startOffset);
        } catch (ModbusTransportException m) {
            log.error("device:{}, modbus://{}:{}/{} read address[{}] error",
                    device, getHost(), getPort(), getSlaveId(), startOffset);
        }
        return value.intValue();
    }

    public String readHoldingRegisterTexts(int startOffset, int numberOfRegisters) {
        String value = "ERROR";
        try {
            value = modbusMasterWrapper.readHoldingRegisterTexts(startOffset, numberOfRegisters);
        } catch (ModbusTransportException m) {
            log.error("device:{}, modbus://{}:{}/{} read address[{}-{}] error",
                    device, getHost(), getPort(), getSlaveId(),
                    startOffset, startOffset + numberOfRegisters);
        }
        return value;
    }

    public void writeRegisterValues(int startOffset, short[] values) {
        try {
            modbusMasterWrapper.writeRegisterValues(startOffset, values);
        } catch (ModbusTransportException m) {
            log.error("device:{}, modbus://{}:{}/{} write address[{}-{}] error",
                    device, getHost(), getPort(), getSlaveId(), startOffset,
                    startOffset + values.length - 1);
        }
    }

    public void writeRegisterValue(int startOffset, int value) {

      //  System.out.println("write startoffset is "+startOffset+"value is "+value);

        try {
            modbusMasterWrapper.writeRegisterValue(startOffset, (short)value);
        } catch (ModbusTransportException m) {
            log.error("device:{}, modbus://{}:{}/{} write address[{}] error",
                    device, getHost(), getPort(), getSlaveId(), startOffset);
        }
    }
}
