import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.msg.WriteRegistersRequest;
import com.serotonin.modbus4j.msg.WriteRegistersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/3.
 */
public class ModBusMasterWrapperTest {
    private static final Logger log = LoggerFactory.getLogger(ModBusMasterWrapperTest.class);

    private String hostIp="127.0.0.1";
    private int hostPort=502;
    private int slaveId=2;

    private ModbusMaster modbusMaster;
    private boolean connected;

    public ModBusMasterWrapperTest(String hostIp,
                               int port,
                               int slaveId) {
        this.hostIp = hostIp;
        this.hostPort = port;
        this.slaveId = slaveId;
        log.info("hostIp: {}, port: {}, slaveId: {}", hostIp, port, slaveId);
    }

    public boolean connect() {
        disconnect();

        try {
            IpParameters ipParameters = new IpParameters();
            ipParameters.setHost(this.getHostIp());
            ipParameters.setPort(this.getHostPort());

            log.info("connect: ip: {}, port: {}", this.getHostIp(), this.getHostPort());
            modbusMaster = new ModbusFactory().createTcpMaster(ipParameters, true);
            modbusMaster.init();
            connected = true;
        } catch (ModbusInitException ex) {
//        log.error("connect error, try to disconnect...", ex);
            disconnect();
        }

        return isConnected();
    }

    public void disconnect() {
        if (modbusMaster != null) {
            modbusMaster.destroy();
        }
        connected = false;
        log.info("disconnect");
    }

    public boolean isConnected() {
        return connected;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }

    public int getSlaveId() {
        return slaveId;
    }

    public void setSlaveId(int slaveId) {
        this.slaveId = slaveId;
    }

    public short[] readHoldingRegisterValues(int startOffset, int numberOfRegisters) throws ModbusTransportException {
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId,
                startOffset, numberOfRegisters);
        log.info("Reading Holding Registers, startAddress: {}, len: {}", startOffset, numberOfRegisters);

        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) modbusMaster.send(request);

        if (response != null && response.isException()) {
            log.error("Modbus execution failed: \nslaveId: {}, startAddress: {}, len: {}", slaveId, startOffset, numberOfRegisters);
            return null;
        } else if (response != null) {
            return response.getShortData();
        }

        connected = false;
        return null;
    }

    public Short readHoldingRegisterValue(int startOffset) throws ModbusTransportException {
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId,
                startOffset, 1);
        log.info("Reading Holding Register, startAddress: %d", startOffset);

        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) modbusMaster.send(request);

        if (response != null && response.isException()) {
            log.error("Modbus execution failed: \nslaveId: {}, startAddress: {}", slaveId, startOffset);
            return null;
        } else if (response != null && response.getShortData().length > 0) {
            return response.getShortData()[0];
        }

        connected = false;
        return null;
    }

    public String readHoldingRegisterTexts(int startOffset, int numberOfRegisters) throws ModbusTransportException {
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId,
                startOffset, numberOfRegisters);
        log.info("Reading Holding Register Text, startAddress: %d, len: %d", startOffset, numberOfRegisters);

        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) modbusMaster.send(request);

        if (response != null && response.isException()) {
            log.error("Modbus execution failed: \nslaveId: {}, startAddress: {}, len: {}", slaveId, startOffset, numberOfRegisters);
            return null;
        } else if (response != null) {
            // skip the even values (because each short type contains 2 bytes)
            byte[] oldValue = response.getData();
//      byte[] newValue = new byte[oldValue.length];
//      for (int i=0; i<oldValue.length; i++) {
//        if (i % 2 == 1) {
//          newValue[i-1] = oldValue[i];
//          newValue[i] = oldValue[i-1];
//        }
//      }
            return new String(oldValue).trim();
        }

        connected = false;
        return null;
    }

    public void writeRegisterValues(int startOffset, short[] values) throws ModbusTransportException {
        WriteRegistersRequest request = new WriteRegistersRequest(slaveId, startOffset, values);
        log.info(String.format("WRITE Holding Register, startOffset: %d, values: %s",
                startOffset, Arrays.toString(values)));

        WriteRegistersResponse response = (WriteRegistersResponse) modbusMaster.send(request);
        if (response != null && response.isException()) {
            throw new ModbusTransportException(response.getExceptionMessage());
        }
    }

    public void writeRegisterValue(int startOffset, short value)
            throws ModbusTransportException {
        WriteRegistersRequest request = new WriteRegistersRequest(slaveId, startOffset,
                new short[]{value});
        log.info(String.format("Writing Holding Register, startAddress: %d, value: %d", startOffset, value));

        WriteRegistersResponse response = (WriteRegistersResponse) modbusMaster.send(request);
        if (response != null && response.isException()) {
            throw new ModbusTransportException(response.getExceptionMessage());
        }
    }

}
