package com.tjmj.modbus.listener.stockinplc;


import com.tjmj.modbus.PLCService;
import com.tjmj.modbus.util.ModbusValueChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * 码垛时托盘请求流走信号
 *
 * @author zhuhusheng
 * @date 2016/12/5
 */
@Slf4j
@Component
public class TestInAskTrayMoveListener implements ModbusValueChangeListener {

    @Inject
    private PLCService plcService;

    @Override
    public void onDataChange(String nodeName, Object preValue, Object newValue) {
        System.out.println("************");
        log.info("nodeName {} value change from {} to {}", nodeName, preValue, newValue);
        // 1. 判断左右 0 为左， 1为右
        List<PLCService.ChangeIndex> changeIndices = plcService.getChangeIndex(preValue, newValue, true);
        for(int i=0;i<changeIndices.size();i++)
        {

            System.out.println("#####TestInAskTrayMoveListener实现方法"+changeIndices.get(i));
        }
        changeIndices.forEach(c -> plcService.askTrayMove(c.getIndex()));
    }

}
