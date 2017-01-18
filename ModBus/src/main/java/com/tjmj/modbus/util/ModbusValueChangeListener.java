package com.tjmj.modbus.util;

/**
 * @author zhuhusheng
 * @date 2016/11/11
 */
public interface ModbusValueChangeListener {
    void onDataChange(String nodeName, Object preValue, Object newValue);
}
