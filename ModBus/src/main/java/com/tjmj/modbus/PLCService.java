package com.tjmj.modbus;

import com.google.common.collect.Lists;
import com.tjmj.ModbusProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.*;

/**
 * handle interaction with PLC
 *
 * @author zhuhusheng
 * @date 2016/11/8
 */
@Slf4j
@Service
@Transactional
@RestController
public class PLCService {


    @Inject
    private ModbusService modbusService;


    private static int heartbeatValue = 0;

    public static final String STOCK_IN_PLC_READ = "StockInPLCRead";
    public static final String STOCK_IN_PLC_WRITE = "StockInPLCWrite";

    public static final String STOCK_OUT_PLC = "StockInPLC";


    // FIXME: 2016/12/6 配置任务调度的线程池
    @Scheduled(fixedRate = 5000)
    public void keepAliveWithPLC() {
        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(
                m -> m.writeRegisterValue(
                        ModbusAddressMap.STOCK_IN_PLC_WRITE.get("Heartbeat"), heartbeatValue
                ));
        modbusService.getByDevice(STOCK_OUT_PLC).ifPresent(
                m -> m.writeRegisterValue(
                        ModbusAddressMap.STOCK_OUT_PLC_WRITE.get("Heartbeat"), heartbeatValue
                ));
        heartbeatValue = heartbeatValue == 0 ? 1 : 0;
    }

    /*******************  入库plc  method ************************/
    /**
     * 0 为左， 1 为右
     *
     * @param  / 1
     */
    @RequestMapping(value="/writeplc")
    public String writeplc(int userName)
    {

        //   request.getParameter("userName");
// int   j=Integer.parseInt(request.getParameter("userName"));
        //   System.out.println("j is"+j);

        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(modbusDevice -> modbusDevice.writeRegisterValue(140,userName));
        return("wtrite in plc value is "+userName);
    }



    @RequestMapping(value="/writeinplc")
    public String writeinplc()
    {
int value=345;
        //   request.getParameter("userName");
// int   j=Integer.parseInt(request.getParameter("userName"));
        //   System.out.println("j is"+j);

        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(modbusDevice -> modbusDevice.writeRegisterValue(140,value));
        return String.valueOf(value);
    }
    @RequestMapping(value = "/askMove")
    public String TestAskMove(int i)
    {
        String cardReaderKey;
        String robotCountKey;
        String barcodeListKey;
        String allowTrayMoveKey;
        if (i == 0) {
            //      System.out.println("index index is i=0");
            cardReaderKey = "Banka1.CardReader36";
            robotCountKey = "RobotPutCount1";
            allowTrayMoveKey = "AllowTrayMove1";
            //   barcodeListKey = RedisKey.A_LINE_BARCODE_LIST;
        } else {
            //     System.out.println("index index is i!=0");
            cardReaderKey = "Banka1.CardReader37";
            robotCountKey = "RobotPutCount2";
            allowTrayMoveKey = "AllowTrayMove2";
            //   barcodeListKey = RedisKey.B_LINE_BARCODE_LIST;
        }
        Integer qty = modbusService.getByDevice(STOCK_IN_PLC_READ).get().readHoldingRegisterValue(
                ModbusAddressMap.STOCK_IN_PLC_READ.get(robotCountKey));

        System.out.println("44444444444444444");
        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(
                m -> m.writeRegisterValue(
                        ModbusAddressMap.STOCK_IN_PLC_WRITE.get(allowTrayMoveKey), 1));
        return String.valueOf(i);

    }
    public void askTrayMove(int i) {
        String cardReaderKey;
        String robotCountKey;
        String barcodeListKey;
        String allowTrayMoveKey;
        if (i == 0) {
      //      System.out.println("index index is i=0");
            cardReaderKey = "Banka1.CardReader36";
            robotCountKey = "RobotPutCount1";
            allowTrayMoveKey = "AllowTrayMove1";
         //   barcodeListKey = RedisKey.A_LINE_BARCODE_LIST;
        } else {
       //     System.out.println("index index is i!=0");
            cardReaderKey = "Banka1.CardReader37";
            robotCountKey = "RobotPutCount2";
            allowTrayMoveKey = "AllowTrayMove2";
         //   barcodeListKey = RedisKey.B_LINE_BARCODE_LIST;
        }
     ////   System.out.println("okokokokokok");
        // 1. 读取托盘 RFID 与 机器人码垛数
     //   String orderNO = redisService.readObject(RedisKey.CURRENT_ORDER_NO).toString();
        //System.out.println("111111111111111");
//        String rfid = int2String(4, modbusService.getByDevice("Banka1").get().readHoldingRegisterValue(
//                ModbusAddressMap.BANKA.get(cardReaderKey)));
     //   System.out.println("2222222222222222");
        Integer qty = modbusService.getByDevice(STOCK_IN_PLC_READ).get().readHoldingRegisterValue(
                ModbusAddressMap.STOCK_IN_PLC_READ.get(robotCountKey));
      //  System.out.println("333333333333333");
        // 2. 取 redis 中 BarcodeList 的数据，并与 RFID 做绑定，存入redis中
      ///  List<Barcode> barcodes = (List<Barcode>) redisService.popFromHead(barcodeListKey, qty);
      //  LpnData.LpnReceipt receipt = new LpnData.LpnReceipt(orderNO, rfid, qty, barcodes);
      //  redisService.saveObject(RedisKey.BINDER_PREFIX_KEY + rfid, wmsService.createLpnData(receipt));

        // 3. 处理完毕，写放行信号
     //   System.out.println("44444444444444444");
        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(
                m -> m.writeRegisterValue(
                        ModbusAddressMap.STOCK_IN_PLC_WRITE.get(allowTrayMoveKey), 1));
       System.out.println("5555555555555555555555");
    }


    @Async
    public void clearTrayData(int i) {
        String allowTrayMoveKey;
        if (i == 0) {
            allowTrayMoveKey = "AllowTrayMove1";
        } else {
            allowTrayMoveKey = "AllowTrayMove2";
        }
        modbusService.getByDevice(STOCK_IN_PLC_WRITE).ifPresent(
                m -> m.writeRegisterValue(
                        ModbusAddressMap.STOCK_IN_PLC_WRITE.get(allowTrayMoveKey), 0));
    }
    public List<ChangeIndex> getChangeIndex(Object preValue, Object postValue, boolean isRisingEdge) {
        List<ChangeIndex> changeIndices = Lists.newArrayList();
        List<Integer> preValues = Lists.newArrayList();
        List<Integer> postValues = Lists.newArrayList();
        if (preValue instanceof List) {
            preValues = (List<Integer>) preValue;
            postValues = (List<Integer>) postValue;
        } else if (preValue instanceof Integer) {
            preValues.add((Integer) preValue);
            postValues.add((Integer) postValue);
        }
        for (int i = 0; i < preValues.size(); i++) {
            if (preValues.get(i).intValue() != postValues.get(i).intValue()) {
                if (isRisingEdge) {
                    // 从 0 到 1 的变化
                    if (postValues.get(i) == 1) {
                        ChangeIndex index = new ChangeIndex();
                        index.setIndex(i);
                        changeIndices.add(index);
                    }
                } else {
                    ChangeIndex index = new ChangeIndex();
                    index.setIndex(i);
                    changeIndices.add(index);
                }
            }
        }
        return changeIndices;
    }


    private int getTyreHeightWrite2PLC(int height) {
        int value = 0;
        if (height >= 135 && height <= 166)
            value = 1;
        else if (height >= 167 && height <= 186)
            value = 2;
        else if (height >= 187 && height <= 206)
            value = 3;
        else if (height >= 207 && height <= 226)
            value = 4;
        else if (height >= 227 && height <= 246)
            value = 5;
        return value;
    }

    @Data
    public static class ChangeIndex {
        private int index;
        private int bitIndex;

        public ChangeIndex() {
        }

        public ChangeIndex(int index, int bitIndex) {
            this.index = index;
            this.bitIndex = bitIndex;
        }
    }
}

