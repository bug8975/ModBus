package com.tjmj.modbus.util;


import com.tjmj.modbus.listener.stockinplc.InAskTrayMoveListener;
import com.tjmj.modbus.listener.stockinplc.TestInAskTrayMoveListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuhusheng
 * @date 2016/11/11
 */
@Data
@Slf4j
@Component
public class ModbusNodesUtil {

    public static Map<String, ModbusValueChangeListener> MODBUS_LISTENER_MAP = new HashMap<>();

    // TODO: @all add modbus listener here
    @Inject
    private InAskTrayMoveListener inAskTrayMoveListener;
    private TestInAskTrayMoveListener testInAskTrayMoveListener;


    @PostConstruct
    public void initListener() {
        log.info("-------> init modbus listener start <-------");
        // TODO: @all put inject listener in map
        MODBUS_LISTENER_MAP.put("StockInPLCRead.AskTrayMove", inAskTrayMoveListener);
        MODBUS_LISTENER_MAP.put("TestStockInPLCWrite.TestAskTrayMove", testInAskTrayMoveListener);
//        MODBUS_LISTENER_MAP.put("StockInPLCRead.TransferAsk", inTransferAskListener);
//        MODBUS_LISTENER_MAP.put("StockInPLCRead.TransferClear", inTransferClearListener);
//        MODBUS_LISTENER_MAP.put("StockInPLCRead.TransferBad", inTransferBadListener);
//        MODBUS_LISTENER_MAP.put("StockInPLCRead.TransferOutReady", inTransferOutReadyListener);
//        MODBUS_LISTENER_MAP.put("StockInPLCRead.TransferReceiveOK", inTransferReceiveOKListener);
//
//        MODBUS_LISTENER_MAP.put("StockOutPLC.TransferAsk", outTransferAskListener);
//        MODBUS_LISTENER_MAP.put("StockOutPLC.TransferClear", outTransferClearListener);
//        MODBUS_LISTENER_MAP.put("StockOutPLC.TransferOutReady", outTransferOutReadyListener);
//        MODBUS_LISTENER_MAP.put("StockOutPLC.TransferClearOutlet", outTransferClearOutletListener);
//        MODBUS_LISTENER_MAP.put("StockOutPLC.OutletEnough", outOutletEnoughListener);

        MODBUS_LISTENER_MAP.keySet().forEach(k -> log.info("add listener [{}]", k));

        log.info("-------> init modbus listener finished <-------");
    }

    public ModbusValueChangeListener getByNodeName(String nodeName) {
        if (MODBUS_LISTENER_MAP.get(nodeName) == null) {
            log.error("nodeName:{} or its'listener is not set", nodeName);
        }
        return MODBUS_LISTENER_MAP.get(nodeName);
    }
}
