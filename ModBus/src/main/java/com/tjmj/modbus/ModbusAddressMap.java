package com.tjmj.modbus;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuhusheng
 * @date 2016/11/29
 */
public final class ModbusAddressMap {

    /***
     * 板卡地址 Map
     ***/

    public static Map<String, Integer> BANKA = new HashMap<>();

    static {
        BANKA.put("Banka1.CardReader36", 1);
        BANKA.put("Banka1.CardReader37", 101);

        BANKA.put("Banka2.CardReader32", 1);
        BANKA.put("Banka2.CardReader2", 101);
        BANKA.put("Banka2.CardReader1", 201);

        BANKA.put("Banka3.CardReader3", 1);
        BANKA.put("Banka3.CardReader4", 101);
        BANKA.put("Banka3.CardReader6", 201);
        BANKA.put("Banka3.CardReader5", 301);

        BANKA.put("Banka4.CardReader17", 1);
        BANKA.put("Banka4.CardReader28", 101);
        BANKA.put("Banka4.CardReader27", 201);
        BANKA.put("Banka4.CardReader16", 301);

        BANKA.put("Banka5.CardReader15", 1);
        BANKA.put("Banka5.CardReader26", 101);
        BANKA.put("Banka5.CardReader25", 201);
        BANKA.put("Banka5.CardReader14", 301);

        BANKA.put("Banka6.CardReader13", 1);
        BANKA.put("Banka6.CardReader24", 101);
        BANKA.put("Banka6.CardReader23", 201);
        BANKA.put("Banka6.CardReader12", 301);

        BANKA.put("Banka7.CardReader11", 1);
        BANKA.put("Banka7.CardReader22", 101);
        BANKA.put("Banka7.CardReader21", 201);
        BANKA.put("Banka7.CardReader10", 301);

        BANKA.put("Banka8.CardReader9", 1);
        BANKA.put("Banka8.CardReader20", 101);
        BANKA.put("Banka8.CardReader19", 201);
        BANKA.put("Banka8.CardReader8", 301);

        BANKA.put("Banka9.CardReader7", 1);
        BANKA.put("Banka9.CardReader18", 101);
        BANKA.put("Banka9.CardReader33", 201);

        BANKA.put("Banka10.CardReader29", 1);

        BANKA.put("Banka11.CardReader30", 1);

        BANKA.put("Banka12.CardReader31", 1);
        BANKA.put("Banka12.CardReader34", 101);
        BANKA.put("Banka12.CardReader35", 201);
    }

    public static final Map<Integer, CardReaderAddress> CARD_READER_MAP = new HashMap<>();

    static {
        for (int i = 1; i < 38; i++) {
            CARD_READER_MAP.put(i, new CardReaderAddress(i));
        }
    }

    /***
     * 入库PLC 读 地址 Map
     ***/
    public static final Map<String, Integer> STOCK_IN_PLC_READ = new HashMap<>();

    static {
        // signal add/removed @zhengxun
        STOCK_IN_PLC_READ.put("TransferAsk1.0-0", 0);
        STOCK_IN_PLC_READ.put("TransferAsk2.0-1", 0);
        STOCK_IN_PLC_READ.put("TransferAsk3.0-2", 0);
        STOCK_IN_PLC_READ.put("TransferAsk4.0-3", 0);
        STOCK_IN_PLC_READ.put("TransferAsk5.0-4", 0);
        STOCK_IN_PLC_READ.put("TransferAsk6.0-5", 0);
        STOCK_IN_PLC_READ.put("TransferAsk7.0-6", 0);
        STOCK_IN_PLC_READ.put("TransferAsk8.0-7", 0);
        STOCK_IN_PLC_READ.put("TransferAsk9.0-8", 0);
        STOCK_IN_PLC_READ.put("TransferAsk10.0-9", 0);
        STOCK_IN_PLC_READ.put("TransferAsk11.0-10", 0);
        STOCK_IN_PLC_READ.put("TransferAsk12.0-11", 0);
        STOCK_IN_PLC_READ.put("TransferAsk13.0-12", 0);
        STOCK_IN_PLC_READ.put("TransferAsk14.0-13", 0);
        STOCK_IN_PLC_READ.put("TransferAsk15.0-14", 0);
        STOCK_IN_PLC_READ.put("TransferAsk16.0-15", 0);
        STOCK_IN_PLC_READ.put("TransferAsk17.1-0", 1);
        STOCK_IN_PLC_READ.put("TransferAsk18.1-1", 1);
        STOCK_IN_PLC_READ.put("TransferAsk19.1-2", 1);
        STOCK_IN_PLC_READ.put("TransferAsk20.1-3", 1);
        STOCK_IN_PLC_READ.put("TransferAsk21.1-4", 1);
        STOCK_IN_PLC_READ.put("TransferAsk22.1-5", 1);
        STOCK_IN_PLC_READ.put("TransferAsk23.1-6", 1);
        STOCK_IN_PLC_READ.put("TransferAsk24.1-7", 1);
        STOCK_IN_PLC_READ.put("TransferAsk25.1-8", 1);
        STOCK_IN_PLC_READ.put("TransferAsk26.1-9", 1);
        STOCK_IN_PLC_READ.put("TransferAsk27.1-10", 1);
        STOCK_IN_PLC_READ.put("TransferAsk28.1-11", 1);
//        STOCK_IN_PLC_READ.put("TransferAsk29.1-12", 1);
//        STOCK_IN_PLC_READ.put("TransferAsk30.1-13", 1);
//        STOCK_IN_PLC_READ.put("TransferAsk31.1-14", 1);
        STOCK_IN_PLC_READ.put("TransferAsk32.1-15", 1);
        STOCK_IN_PLC_READ.put("TransferAsk33.2-0", 2);
//        STOCK_IN_PLC_READ.put("TransferAsk34.2-1",  2);
//        STOCK_IN_PLC_READ.put("TransferAsk35.2-2",  2);
//        STOCK_IN_PLC_READ.put("TransferAsk36.2-3",  2);
//        STOCK_IN_PLC_READ.put("TransferAsk37.2-4",  2);

        //RFID得到数据OK
        //3    ==  6.0 ~ 7.7
        //4    ==  8.0 ~ 9.7
        //5    ==  10.0~11.7
        STOCK_IN_PLC_READ.put("TransferClear1.3-0", 3);
        STOCK_IN_PLC_READ.put("TransferClear2.3-1", 3);
        STOCK_IN_PLC_READ.put("TransferClear3.3-2", 3);
        STOCK_IN_PLC_READ.put("TransferClear4.3-3", 3);
        STOCK_IN_PLC_READ.put("TransferClear5.3-4", 3);
        STOCK_IN_PLC_READ.put("TransferClear6.3-5", 3);
        STOCK_IN_PLC_READ.put("TransferClear7.3-6", 3);
        STOCK_IN_PLC_READ.put("TransferClear8.3-7", 3);
        STOCK_IN_PLC_READ.put("TransferClear9.3-8", 3);
        STOCK_IN_PLC_READ.put("TransferClear10.3-9", 3);
        STOCK_IN_PLC_READ.put("TransferClear11.3-10", 3);
        STOCK_IN_PLC_READ.put("TransferClear12.3-11", 3);
        STOCK_IN_PLC_READ.put("TransferClear13.3-12", 3);
        STOCK_IN_PLC_READ.put("TransferClear14.3-13", 3);
        STOCK_IN_PLC_READ.put("TransferClear15.3-14", 3);
        STOCK_IN_PLC_READ.put("TransferClear16.3-15", 3);
        STOCK_IN_PLC_READ.put("TransferClear17.4-0", 4);
        STOCK_IN_PLC_READ.put("TransferClear18.4-1", 4);
        STOCK_IN_PLC_READ.put("TransferClear19.4-2", 4);
        STOCK_IN_PLC_READ.put("TransferClear20.4-3", 4);
        STOCK_IN_PLC_READ.put("TransferClear21.4-4", 4);
        STOCK_IN_PLC_READ.put("TransferClear22.4-5", 4);
        STOCK_IN_PLC_READ.put("TransferClear23.4-6", 4);
        STOCK_IN_PLC_READ.put("TransferClear24.4-7", 4);
        STOCK_IN_PLC_READ.put("TransferClear25.4-8", 4);
        STOCK_IN_PLC_READ.put("TransferClear26.4-9", 4);
        STOCK_IN_PLC_READ.put("TransferClear27.4-10", 4);
        STOCK_IN_PLC_READ.put("TransferClear28.4-11", 4);
//        STOCK_IN_PLC_READ.put("TransferClear29.4-12", 4);
//        STOCK_IN_PLC_READ.put("TransferClear30.4-13", 4);
//        STOCK_IN_PLC_READ.put("TransferClear31.4-14", 4);
        STOCK_IN_PLC_READ.put("TransferClear32.4-15", 4);
        STOCK_IN_PLC_READ.put("TransferClear33.5-0", 5);
//        STOCK_IN_PLC_READ.put("TransferClear34.5-1",  5);
//        STOCK_IN_PLC_READ.put("TransferClear35.5-2",  5);
//        STOCK_IN_PLC_READ.put("TransferClear36.5-3",  5);
//        STOCK_IN_PLC_READ.put("TransferClear37.5-4",  5);

        //出库顶升移载准备OK DB7
        //6   ==  12.0~13.7
        //7   ==  14.0~15.7
        STOCK_IN_PLC_READ.put("TransferOutReady1.8-0", 8);
        STOCK_IN_PLC_READ.put("TransferOutReady2.8-1", 8);
        STOCK_IN_PLC_READ.put("TransferOutReady3.8-2", 8);
        STOCK_IN_PLC_READ.put("TransferOutReady4.8-3", 8);
        STOCK_IN_PLC_READ.put("TransferOutReady5.8-4", 8);
        STOCK_IN_PLC_READ.put("TransferOutReady6.8-5", 8);

        // 出库移载接料完成
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK1.9-0", 9);
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK2.9-1", 9);
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK3.9-2", 9);
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK4.9-3", 9);
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK5.9-4", 9);
        STOCK_IN_PLC_READ.put("TransferOutReceiveOK6.9-5", 9);

        // 移载切除信号
        STOCK_IN_PLC_READ.put("TransferBad1.10-0", 10);
        STOCK_IN_PLC_READ.put("TransferBad2.10-1", 10);
        STOCK_IN_PLC_READ.put("TransferBad3.10-2", 10);
        STOCK_IN_PLC_READ.put("TransferBad4.10-3", 10);
        STOCK_IN_PLC_READ.put("TransferBad5.10-4", 10);
        STOCK_IN_PLC_READ.put("TransferBad6.10-5", 10);
        STOCK_IN_PLC_READ.put("TransferBad7.10-6", 10);
        STOCK_IN_PLC_READ.put("TransferBad8.10-7", 10);
        STOCK_IN_PLC_READ.put("TransferBad9.10-8", 10);
        STOCK_IN_PLC_READ.put("TransferBad10.10-9", 10);
        STOCK_IN_PLC_READ.put("TransferBad11.10-10", 10);
        STOCK_IN_PLC_READ.put("TransferBad12.10-11", 10);
        STOCK_IN_PLC_READ.put("TransferBad13.10-12", 10);
        STOCK_IN_PLC_READ.put("TransferBad14.10-13", 10);
        STOCK_IN_PLC_READ.put("TransferBad15.10-14", 10);
        STOCK_IN_PLC_READ.put("TransferBad16.10-15", 10);
        STOCK_IN_PLC_READ.put("TransferBad17.11-0", 11);
        STOCK_IN_PLC_READ.put("TransferBad18.11-1", 11);
        STOCK_IN_PLC_READ.put("TransferBad19.11-2", 11);
        STOCK_IN_PLC_READ.put("TransferBad20.11-3", 11);
        STOCK_IN_PLC_READ.put("TransferBad21.11-4", 11);
        STOCK_IN_PLC_READ.put("TransferBad22.11-5", 11);
        STOCK_IN_PLC_READ.put("TransferBad23.11-6", 11);
        STOCK_IN_PLC_READ.put("TransferBad24.11-7", 11);
        STOCK_IN_PLC_READ.put("TransferBad25.11-8", 11);
        STOCK_IN_PLC_READ.put("TransferBad26.11-9", 11);
        STOCK_IN_PLC_READ.put("TransferBad27.11-10", 11);
        STOCK_IN_PLC_READ.put("TransferBad28.11-11", 11);

        // 机器人抓取计数
        STOCK_IN_PLC_READ.put("RobotPutCount1", 12);
        STOCK_IN_PLC_READ.put("RobotPutCount2", 13);

        // 托盘请求离开信号
        STOCK_IN_PLC_READ.put("AskTrayMove1", 14);
        STOCK_IN_PLC_READ.put("AskTrayMove2", 15);

        // 托盘离开信号
        STOCK_IN_PLC_READ.put("TrayDataClear1", 17);
        STOCK_IN_PLC_READ.put("TrayDataClear2", 18);

        //心跳信号 DB7
        STOCK_IN_PLC_READ.put("Heartbeat", 16);
    }

    /***
     * 入库PLC 写 地址 Map
     ***/
    public static final Map<String, Integer> STOCK_IN_PLC_WRITE = new HashMap<>();

    static {
        // signal add/remove @zhengxun
        //接收数据区
        //DB8
        STOCK_IN_PLC_WRITE.put("TransferNumData1", 0);
        STOCK_IN_PLC_WRITE.put("TransferNumData2", 1);
        STOCK_IN_PLC_WRITE.put("TransferNumData3", 2);
        STOCK_IN_PLC_WRITE.put("TransferNumData4", 3);
        STOCK_IN_PLC_WRITE.put("TransferNumData5", 4);
        STOCK_IN_PLC_WRITE.put("TransferNumData6", 5);
        STOCK_IN_PLC_WRITE.put("TransferNumData7", 6);
        STOCK_IN_PLC_WRITE.put("TransferNumData8", 7);
        STOCK_IN_PLC_WRITE.put("TransferNumData9", 8);
        STOCK_IN_PLC_WRITE.put("TransferNumData10", 9);
        STOCK_IN_PLC_WRITE.put("TransferNumData11", 10);
        STOCK_IN_PLC_WRITE.put("TransferNumData12", 11);
        STOCK_IN_PLC_WRITE.put("TransferNumData13", 12);
        STOCK_IN_PLC_WRITE.put("TransferNumData14", 13);
        STOCK_IN_PLC_WRITE.put("TransferNumData15", 14);
        STOCK_IN_PLC_WRITE.put("TransferNumData16", 15);
        STOCK_IN_PLC_WRITE.put("TransferNumData17", 16);
        STOCK_IN_PLC_WRITE.put("TransferNumData18", 17);
        STOCK_IN_PLC_WRITE.put("TransferNumData19", 18);
        STOCK_IN_PLC_WRITE.put("TransferNumData20", 19);
        STOCK_IN_PLC_WRITE.put("TransferNumData21", 20);
        STOCK_IN_PLC_WRITE.put("TransferNumData22", 21);
        STOCK_IN_PLC_WRITE.put("TransferNumData23", 22);
        STOCK_IN_PLC_WRITE.put("TransferNumData24", 23);
        STOCK_IN_PLC_WRITE.put("TransferNumData25", 24);
        STOCK_IN_PLC_WRITE.put("TransferNumData26", 25);
        STOCK_IN_PLC_WRITE.put("TransferNumData27", 26);
        STOCK_IN_PLC_WRITE.put("TransferNumData28", 27);
//        STOCK_IN_PLC_WRITE.put("TransferNumData29", 28);
//        STOCK_IN_PLC_WRITE.put("TransferNumData30", 29);
//        STOCK_IN_PLC_WRITE.put("TransferNumData31", 30);
        STOCK_IN_PLC_WRITE.put("TransferNumData32", 31);    // xTODO: 走快速通道的直接写100
        STOCK_IN_PLC_WRITE.put("TransferNumData33", 32);    // TODO: 走快速通道的直接写100
//        STOCK_IN_PLC_WRITE.put("TransferNumData34", 33);
//        STOCK_IN_PLC_WRITE.put("TransferNumData35", 34);
//        STOCK_IN_PLC_WRITE.put("TransferNumData36", 35);
//        STOCK_IN_PLC_WRITE.put("TransferNumData37", 36);

        //入库母车到位
        //64   ==  128.0~129.7
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady1.64-0", 64);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady2.64-1", 64);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady3.64-2", 64);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady4.64-3", 64);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady5.64-4", 64);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady6.64-5", 64);
        //65   ==  130.0~131.7  TransferInLoader
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady7.65-0", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady8.65-1", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady9.65-2", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady10.65-3", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady11.65-4", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady12.65-5", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady13.65-6", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady14.65-7", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady15.65-8", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady16.65-9", 65);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady17.65-10", 65);
        //66   ==  132.0~133.2  TransferInLoader
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady18.66-0", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady19.66-1", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady20.66-2", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady21.66-3", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady22.66-4", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady23.66-5", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady24.66-6", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady25.66-7", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady26.66-8", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady27.66-9", 66);
        STOCK_IN_PLC_WRITE.put("TransferInLoaderReady28.66-10", 66);

        //母车接货完成 DB8
        //67   ==  134.0~135.7
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady1.67-0", 67);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady2.67-1", 67);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady3.67-2", 67);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady4.67-3", 67);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady5.67-4", 67);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady6.67-5", 67);
        //68   ==  136.0~137.7  TransferLoaderReceive
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady7.68-0", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady8.68-1", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady9.68-2", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady10.68-3", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady11.68-4", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady12.68-5", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady13.68-6", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady14.68-7", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady15.68-8", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady16.68-9", 68);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady17.68-10", 68);
        //69   ==  138.0~139.7  TransferLoaderReceive
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady18.69-0", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady19.69-1", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady20.69-2", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady21.69-3", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady22.69-4", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady23.69-5", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady24.69-6", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady25.69-7", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady26.69-8", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady27.69-9", 69);
        STOCK_IN_PLC_WRITE.put("TransferLoaderReceiveReady28.69-10", 69);

        // 出库母车到位
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady1.71-0", 71);
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady2.71-1", 71);
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady3.71-2", 71);
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady4.71-3", 71);
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady5.71-4", 71);
        STOCK_IN_PLC_WRITE.put("TransferOutLoaderReady6.71-5", 71);

        // CCD1检测数据（NG件流向）DB8
        STOCK_IN_PLC_WRITE.put("NgFlowEnable", 72);

        // 轮胎高度 DB8
        STOCK_IN_PLC_WRITE.put("TyreHeight", 73);

        // 满载托盘数 DB8
        STOCK_IN_PLC_WRITE.put("NumPerTray", 74);

        // 允许托盘离开 DB8
        STOCK_IN_PLC_WRITE.put("AllowTrayMove1", 75);
        STOCK_IN_PLC_WRITE.put("AllowTrayMove2", 76);

        // 换型信号，停线  DB8
        STOCK_IN_PLC_WRITE.put("ChangeType", 77);

        // 心跳信号 DB8   0 ~ 1 / 5s
        STOCK_IN_PLC_WRITE.put("Heartbeat", 78);

        // 尾数模式
        STOCK_IN_PLC_WRITE.put("TailMode", 79);

        // 退货
        STOCK_IN_PLC_WRITE.put("ReturnStart", 80);
        STOCK_IN_PLC_WRITE.put("ReturnFlowEnable", 81);

        // 连续两个移载切除时，写停线信号
        // 1 -- 一楼一层 / 2 -- 一楼二层 / 3 -- 二楼一层 / 4 --二楼二层
        STOCK_IN_PLC_WRITE.put("DoubleTransferBad", 82);
    }

    /***
     * 出库PLC 地址 Map
     ***/
    public static final Map<String, Integer> TEST_STOCK_IN_PLC_WRITE = new HashMap<>();

  static {
        TEST_STOCK_IN_PLC_WRITE.put("TestAskTrayMove",0);
}


    public static final Map<String, Integer> STOCK_OUT_PLC_READ = new HashMap<>();

    static {
        // signal add/remove @zhengxun
        //出库移载准备OK信号
        STOCK_OUT_PLC_READ.put("TransferOutReady38", 0);
        STOCK_OUT_PLC_READ.put("TransferOutReady39", 1);
        STOCK_OUT_PLC_READ.put("TransferOutReady40", 2);
        STOCK_OUT_PLC_READ.put("TransferOutReady41", 3);
        STOCK_OUT_PLC_READ.put("TransferOutReady42", 4);
        STOCK_OUT_PLC_READ.put("TransferOutReady43", 5);
        STOCK_OUT_PLC_READ.put("TransferOutReady44", 6);
        STOCK_OUT_PLC_READ.put("TransferOutReady45", 7);
        STOCK_OUT_PLC_READ.put("TransferOutReady46", 8);
        STOCK_OUT_PLC_READ.put("TransferOutReady47", 9);
        STOCK_OUT_PLC_READ.put("TransferOutReady48", 10);
        STOCK_OUT_PLC_READ.put("TransferOutReady49", 11);
        STOCK_OUT_PLC_READ.put("TransferOutReady50", 12);
        STOCK_OUT_PLC_READ.put("TransferOutReady51", 13);
        STOCK_OUT_PLC_READ.put("TransferOutReady52", 14);
        STOCK_OUT_PLC_READ.put("TransferOutReady53", 15);
        STOCK_OUT_PLC_READ.put("TransferOutReady54", 16);
        STOCK_OUT_PLC_READ.put("TransferOutReady55", 17);
        STOCK_OUT_PLC_READ.put("TransferOutReady56", 18);
        STOCK_OUT_PLC_READ.put("TransferOutReady57", 19);

        //移载数据区清除信号
        STOCK_OUT_PLC_READ.put("TransferClear38", 20);
        STOCK_OUT_PLC_READ.put("TransferClear39", 21);
        STOCK_OUT_PLC_READ.put("TransferClear40", 22);
        STOCK_OUT_PLC_READ.put("TransferClear41", 23);
        STOCK_OUT_PLC_READ.put("TransferClear42", 24);
        STOCK_OUT_PLC_READ.put("TransferClear43", 25);
        STOCK_OUT_PLC_READ.put("TransferClear44", 26);
        STOCK_OUT_PLC_READ.put("TransferClear45", 27);
        STOCK_OUT_PLC_READ.put("TransferClear46", 28);
        STOCK_OUT_PLC_READ.put("TransferClear47", 29);
        STOCK_OUT_PLC_READ.put("TransferClear48", 30);
        STOCK_OUT_PLC_READ.put("TransferClear49", 31);
        STOCK_OUT_PLC_READ.put("TransferClear50", 32);
        STOCK_OUT_PLC_READ.put("TransferClear51", 33);
        STOCK_OUT_PLC_READ.put("TransferClear52", 34);
        STOCK_OUT_PLC_READ.put("TransferClear53", 35);
        STOCK_OUT_PLC_READ.put("TransferClear54", 36);
        STOCK_OUT_PLC_READ.put("TransferClear55", 37);
        STOCK_OUT_PLC_READ.put("TransferClear56", 38);
        STOCK_OUT_PLC_READ.put("TransferClear57", 39);

        //请求写出货信号
        STOCK_OUT_PLC_READ.put("TransferAsk29", 80);
        STOCK_OUT_PLC_READ.put("TransferAsk30", 81);
        STOCK_OUT_PLC_READ.put("TransferAsk31", 82);
        STOCK_OUT_PLC_READ.put("TransferAsk34", 83);
        STOCK_OUT_PLC_READ.put("TransferAsk35", 84);

        //出货口数据清除信号
        STOCK_OUT_PLC_READ.put("TransferClearOutlet29", 90);
        STOCK_OUT_PLC_READ.put("TransferClearOutlet30", 91);
        STOCK_OUT_PLC_READ.put("TransferClearOutlet31", 92);
        STOCK_OUT_PLC_READ.put("TransferClearOutlet34", 93);
        STOCK_OUT_PLC_READ.put("TransferClearOutlet35", 94);

        //出库PLC心跳
        STOCK_OUT_PLC_READ.put("Heartbeat", 104);

        //出货口满载信号
        STOCK_OUT_PLC_READ.put("OutletEnough1", 106);
        STOCK_OUT_PLC_READ.put("OutletEnough2", 107);
        STOCK_OUT_PLC_READ.put("OutletEnough3", 108);

    }


    /***
     * 出库PLC 写 地址 Map
     ***/
    public static final Map<String, Integer> STOCK_OUT_PLC_WRITE = new HashMap<>();

    static {
        //出库母车到位信号
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady38", 40);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady39", 41);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady40", 42);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady41", 43);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady42", 44);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady43", 45);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady44", 46);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady45", 47);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady46", 48);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady47", 49);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady48", 50);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady49", 51);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady50", 52);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady51", 53);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady52", 54);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady53", 55);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady54", 56);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady55", 57);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady56", 58);
        STOCK_OUT_PLC_WRITE.put("TransferOutLoaderReady57", 59);

//        //母车卸料完成信号
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone38", 60);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone39", 61);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone40", 62);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone41", 63);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone42", 64);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone43", 65);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone44", 66);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone45", 67);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone46", 68);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone47", 69);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone48", 70);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone49", 71);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone50", 72);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone51", 73);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone52", 74);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone53", 75);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone54", 76);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone55", 77);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone56", 78);
//        STOCK_OUT_PLC_WRITE.put("TransferVehicleUnloadDone57", 79);

        //写出货口
        STOCK_OUT_PLC_WRITE.put("OutTyreNO29", 85);    // TODO: 退货的写5
        STOCK_OUT_PLC_WRITE.put("OutTyreNO30", 86);
        STOCK_OUT_PLC_WRITE.put("OutTyreNO31", 87);
        STOCK_OUT_PLC_WRITE.put("OutTyreNO34", 88);
        STOCK_OUT_PLC_WRITE.put("OutTyreNO35", 89);

        //机器人拆垛
        STOCK_OUT_PLC_WRITE.put("RobotPickNum1", 95);
        STOCK_OUT_PLC_WRITE.put("RobotPickNum2", 96);
        STOCK_OUT_PLC_WRITE.put("RobotPickNum3", 97);

        //出货口轮胎高度
        STOCK_OUT_PLC_WRITE.put("OutTyreHeight1", 98);
        STOCK_OUT_PLC_WRITE.put("OutTyreHeight2", 99);
        STOCK_OUT_PLC_WRITE.put("OutTyreHeight3", 100);

        //出货口NG件流向
        STOCK_OUT_PLC_WRITE.put("NgFlowEnable1", 101);
        STOCK_OUT_PLC_WRITE.put("NgFlowEnable2", 102);
        STOCK_OUT_PLC_WRITE.put("NgFlowEnable3", 103);

        //出库PLC心跳
        STOCK_OUT_PLC_WRITE.put("Heartbeat", 105);

        // 快速通道 0 不转， 1正转， 2反转
        STOCK_OUT_PLC_WRITE.put("FastTunnelStart", 109);
        // 0 ，1 出货口母车到位，2 入货口母车到位
        STOCK_OUT_PLC_WRITE.put("FastTunnelLoaderReady", 110);
    }

    public static final Map<Integer, TransferInAddress> TRANSFER_IN_MAP = new HashMap<>();

    static {
        for (int i = 1; i < 34; i++) {
            if(i == 29 || i == 30 || i == 31) continue;
            TRANSFER_IN_MAP.put(i, new TransferInAddress(i));
        }
    }

    public static final Map<Integer, TransferOutAddress> TRANSFER_OUT_MAP = new HashMap<>();

    static {
        for (int i = 29; i < 58; i++) {
            if(i == 32 || i == 33 || i == 36 || i == 37) continue;
            TRANSFER_OUT_MAP.put(i, new TransferOutAddress(i));
        }
    }

    @Data
    public static class CardReaderAddress {
        private int no;
        private String bankaNO;
        private int addr;

        public CardReaderAddress(int transferNO) {
            this.no = transferNO;
            switch (transferNO) {
                case 36:
                case 37:
                    this.bankaNO = "Banka1";
                    break;
                case 32:
                case 1:
                case 2:
                    this.bankaNO = "Banka2";
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.bankaNO = "Banka3";
                    break;
                case 17:
                case 28:
                case 27:
                case 16:
                    this.bankaNO = "Banka4";
                    break;
                case 15:
                case 26:
                case 25:
                case 14:
                    this.bankaNO = "Banka5";
                    break;
                case 13:
                case 24:
                case 23:
                case 12:
                    this.bankaNO = "Banka6";
                    break;
                case 11:
                case 22:
                case 21:
                case 10:
                    this.bankaNO = "Banka7";
                    break;
                case 9:
                case 20:
                case 19:
                case 8:
                    this.bankaNO = "Banka8";
                    break;
                case 7:
                case 18:
                case 33:
                    this.bankaNO = "Banka9";
                    break;
                case 29:
                    this.bankaNO = "Banka10";
                    break;
                case 30:
                    this.bankaNO = "Banka11";
                    break;
                case 31:
                case 34:
                case 35:
                    this.bankaNO = "Banka12";
                    break;
            }
            this.addr = BANKA.get(bankaNO + ".CardReader" + no);
        }
    }

    @Data
    public static class TransferInAddress {
        private int no;
        private int askAddr;            // 数据请求
        private int askBit;
        private int clearAddr;          // 数据清除
        private int clearBit;
        private int badAddr;            // 移载切除
        private int badBit;
        private int outReadyAddr;       // 顶伸出库准备ok
        private int outReadyBit;
        private int outReceiveOKAddr;   // 顶伸出库接货完成
        // write
        private int numDataAddr;        // 数据区
        private int inLoaderReadyAddr = -1;          // 入库母车到位
        private int inLoaderReadyBit = -1;
        private int loaderReceiveReadyAddr = -1;     // 母车接货完成
        private int loaderReceiveReadyBit = -1;
        private int outLoaderReadyAddr = -1;         // 出库母车到位
        private int outLoaderReadyBit = -1;

        public TransferInAddress(int transferNO) {
            this.no = transferNO;
            STOCK_IN_PLC_READ.forEach((k, v) -> {
                        if (k.split("\\.")[0].startsWith("Transfer") && k.split("\\.")[0].endsWith(transferNO + "")) {
                            if (k.startsWith("TransferAsk")) {
                                this.askAddr = v;
                                this.askBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                            } else if (k.startsWith("TransferClear")) {
                                this.clearAddr = v;
                                this.clearBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                            } else if (k.startsWith("TransferBad")) {
                                this.badAddr = v;
                                this.badBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                            } else if (k.startsWith("TransferOutReady")) {
                                this.outReadyAddr = v;
                                this.outReadyBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                            } else if (k.startsWith("TransferOutReceiveOK")) {
                                this.outReceiveOKAddr = v;
                            }
                        }
                    }
            );
            STOCK_IN_PLC_WRITE.forEach((k, v) -> {
                if (k.split("\\.")[0].startsWith("Transfer") && k.split("\\.")[0].endsWith(transferNO + "")) {
                    if (k.startsWith("TransferNumData")) {
                        this.numDataAddr = v;
                    } else if (k.startsWith("TransferInLoaderReady")) {
                        this.inLoaderReadyAddr = v;
                        this.inLoaderReadyBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                    } else if (k.startsWith("TransferLoaderReceiveReady")) {
                        this.loaderReceiveReadyAddr = v;
                        this.loaderReceiveReadyBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                    } else if (k.startsWith("TransferOutLoaderReady")) {
                        this.outLoaderReadyAddr = v;
                        this.outLoaderReadyBit = Integer.parseInt(k.charAt(k.length() - 1) + "");
                    }
                }
            });
        }
    }

    @Data
    public static class TransferOutAddress {
        private int no;
        private int askAddr = -1;             // 数据请求
        private int outReadyAddr = -1;        // 顶伸准备ok
        private int clearAddr;                // 数据清除
        private int outLoaderReadyAddr;       // 出库母车到位

        public TransferOutAddress(int transferNO) {
            this.no = transferNO;
            if(transferNO < 38) this.askAddr = STOCK_OUT_PLC_READ.get("TransferAsk" + transferNO);
            else {
                this.clearAddr = STOCK_OUT_PLC_READ.get("TransferClear" + transferNO);
                this.outReadyAddr = STOCK_OUT_PLC_READ.get("TransferOutReady" + transferNO);
                this.outLoaderReadyAddr = STOCK_OUT_PLC_WRITE.get("TransferOutLoaderReady" + transferNO);
            }
        }
    }

}
