package com.tjmj.modbus;

import com.google.common.collect.Lists;
import com.tjmj.modbus.util.ModbusNodesUtil;
import com.tjmj.modbus.util.ModbusValueChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tjmj.ModbusProperties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author zhuhusheng
 * @date 2016/11/9
 */
@Slf4j
@Service
@Transactional
public class ModbusService {

    @Inject
    private ModbusProperties modbusProperties;

    @Inject
    private List<ModbusDevice> modbusDevices;




    @PostConstruct
    public void initModbus() {
        log.info("-------> init modbus module start <-------");
        modbusDevices.stream().forEach(m -> {
            m.connect();
            if (m.isConnected()) {
                log.info("-----> device:{}, modbus://{}:{}/{} is connected <-----",
                        m.getDevice(), m.getHost(),
                        m.getPort(), m.getSlaveId());
            } else {
                log.info("-----> device:{}, modbus://{}:{}/{} connect error <-----",
                        m.getDevice(), m.getHost(),
                        m.getPort(), m.getSlaveId());
            }
        });
        modbusProperties.getModbusNodes().forEach(m -> m.getSubscribeNodes()
                .forEach(s -> {
                           // if (!redisService.hasKey(s.getNodeName()))
                                if (s.getDataType().equals("String")) {
                                 //   redisService.saveObject(s.getNodeName(), "");
                                } else if (s.getLength() == 1) {
                                  //  redisService.saveObject(s.getNodeName(), 0);
                                } else {
                                    List<Integer> list = Lists.newArrayList();
                                    for (int i = 0; i < s.getLength(); i++) {
                                        list.add(0);
                                    }
                                  //  redisService.saveList(s.getNodeName(), list);
                                }
                        }
                ));
        log.info("-------> init modbus module finished <-------");
    }

//    @Scheduled(fixedRate = 500)
//    public void bindListenerAndMonitor() {
//       // System.out.println("15000的定时任务轮询modbus");
//        modbusProperties.getModbusNodes().forEach(m -> m.getSubscribeNodes()
//                .forEach(s -> monitor(getByDevice(m.getDevice()).get(), s)));
//      //  System.out.println("ModbusNodes is "+modbusProperties.getModbusNodes().size());
//    }
    @Scheduled(fixedRate = 500)
    public void TestbindListenerAndMonitor() {
        // System.out.println("15000的定时任务轮询modbus");
        modbusProperties.getModbusNodes().forEach(m -> m.getSubscribeNodes()
                .forEach(s -> Testmonit(getByDevice(m.getDevice()).get(), s)));
        //  System.out.println("ModbusNodes is "+modbusProperties.getModbusNodes().size());
    }
    @Scheduled(fixedRate = 5000)
    public void checkAndReconnect() {
       /// System.out.println("重新连接modbus的定时任务");
        modbusDevices.stream()
                .filter(m -> !m.isConnected())
                .forEach(ModbusDevice::connect);
    }

    private void monitor(ModbusDevice device, ModbusProperties.ModbusField.SubscribeNode node) {
        if (device.isConnected()) {
          //  ModbusValueChangeListener listener = ModbusNodesUtil.MODBUS_LISTENER_MAP.get(node.getNodeName());
         //   System.out.println("node name is "+node.getNodeName());
            if (node.getDataType().equals("String")) {
         //       String oldValue = redisService.readObject(node.getNodeName()).toString();
                String newValue = device.readHoldingRegisterTexts(node.getStartAddress(), node.getLength());

            //    System.out.println("String newValue is "+newValue);
//                if (!Objects.equals(oldValue, newValue)) {
//                    listener.onDataChange(node.getNodeName(), oldValue, newValue);
//                    redisService.saveObject(node.getNodeName(), newValue);
//                }
            } else if (node.getLength() == 1) {
              //  Integer oldValue = (Integer) redisService.readObject(node.getNodeName());
                Integer newValue = device.readHoldingRegisterValue(node.getStartAddress());
              // System.out.println("Device startAddress is"+node.getStartAddress());
               // System.out.println("Integer newValue is "+newValue);
//                if (oldValue.shortValue() != newValue.shortValue()) {
//                    listener.onDataChange(node.getNodeName(), oldValue, newValue);
//                    redisService.saveObject(node.getNodeName(), newValue);
//                }
            } else {
               // List<Integer> oldValue = (List<Integer>) redisService.readList(node.getNodeName());
                List<Integer> newValue = Arrays.asList(device.readHoldingRegisterValues(node.getStartAddress(), node.getLength()));
               // System.out.println("Device startAddress is"+node.getStartAddress());
//              for(int i=-0;i<newValue.size();i++)
//                System.out.println("getlength is not 1 "+newValue.get(i));
//                if (!compareList(oldValue, newValue)) {
//                    listener.onDataChange(node.getNodeName(), oldValue, newValue);
//                    redisService.saveList(node.getNodeName(), newValue);
//                }
            }
        }
    }
    private void Testmonit(ModbusDevice device, ModbusProperties.ModbusField.SubscribeNode node)
    {
        if (device.isConnected()) {
            ModbusValueChangeListener listener = ModbusNodesUtil.MODBUS_LISTENER_MAP.get(node.getNodeName());
             System.out.println("Testmonit node name is "+node.getNodeName());
            if (node.getDataType().equals("String")) {
                //       String oldValue = redisService.readObject(node.getNodeName()).toString();
                String newValue = device.readHoldingRegisterTexts(node.getStartAddress(), node.getLength());

                //    System.out.println("String newValue is "+newValue);
//                if (!Objects.equals(oldValue, newValue)) {
//                    listener.onDataChange(node.getNodeName(), oldValue, newValue);
//                    redisService.saveObject(node.getNodeName(), newValue);
//                }
            } else if (node.getLength() == 1) {
                //  Integer oldValue = (Integer) redisService.readObject(node.getNodeName());
                Integer newValue = device.readHoldingRegisterValue(node.getStartAddress());
                 System.out.println("Device startAddress is"+node.getStartAddress());
                 System.out.println("Integer newValue is "+newValue);
                if (0 != newValue.shortValue()) {
                    listener.onDataChange(node.getNodeName(), 1, newValue);
                    System.out.println("发现地址的不为0");
                  //  redisService.saveObject(node.getNodeName(), newValue);
                }
            } else {
                // List<Integer> oldValue = (List<Integer>) redisService.readList(node.getNodeName());
                List<Integer> newValue = Arrays.asList(device.readHoldingRegisterValues(node.getStartAddress(), node.getLength()));
                System.out.println("Device startAddress is"+node.getStartAddress());
            for(int i=-0;i<newValue.size();i++)

//              if (!compareList(oldValue, newValue)) {
//                    listener.onDataChange(node.getNodeName(), oldValue, newValue);
//                    redisService.saveList(node.getNodeName(), newValue);
//                }
                System.out.println("getlength is not 1 "+newValue.get(i));
            }
        }

    }

    public Optional<ModbusDevice> getByDevice(String device) {
        return modbusDevices.stream()
                .filter(m -> m.getDevice().equals(device))
                .findAny();
    }

    public Optional<ModbusDevice> getByHostAndPort(String host, Integer port) {
        return modbusDevices.stream()
                .filter(m -> m.getModbusMasterWrapper().getHostIp().equals(host)
                        && m.getModbusMasterWrapper().getHostPort() == port)
                .findAny();
    }

    private boolean compareList(List<Integer> oldValue, List<Integer> newValue) {
        if (oldValue.size() != newValue.size()) return false;
        for (int i = 0; i < oldValue.size(); i++) {
            if (oldValue.get(i).intValue() != newValue.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
