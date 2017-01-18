package com.tjmj;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
@Data
@ConfigurationProperties(prefix = "modbus", ignoreUnknownFields = false)
public class ModbusProperties {

    private int maxRetryAttempt;     // 最大的连接尝试次数
    private List<ModbusField> modbusNodes = new ArrayList();

    @Data
    public static class ModbusField {
        private String device;
        private String host = "127.0.0.1";
        private int port = 502;
        private int slaveId = 24;
        private List<SubscribeNode> subscribeNodes = new ArrayList();

        @Data
        public static final class SubscribeNode {
            private String nodeName;               // 建议使用 device. + node
            private String dataType = "short";     // 这里以后可以优化, 目前的取值只有 String 和 short
            private int startAddress;
            private int length = 1;
        }
    }
}