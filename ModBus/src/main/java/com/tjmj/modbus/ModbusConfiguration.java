package com.tjmj.modbus;

import com.tjmj.ModbusProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuhusheng
 * @date 2016/11/9
 */
@Configuration
public class ModbusConfiguration {



    @Bean
    public List<ModbusDevice> modbusDevices(ModbusProperties properties) {

        return properties.getModbusNodes().stream()
                .map(m -> new ModbusDevice(m.getDevice(),
                                new ModbusMasterWrapper(m.getHost(), m.getPort(), m.getSlaveId())))
                .collect(Collectors.toList());
    }

}
