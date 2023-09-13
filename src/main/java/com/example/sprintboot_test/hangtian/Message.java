package com.example.sprintboot_test.hangtian;

import lombok.Data;

@Data
public class Message {
        private String company;//公司

        private String Factory;//工厂

        private String plant;//设备id

        private String channel;//测点ID

        private float valuePeak;//all

        private float valueRms;//one

        private String waveData;//波形数据

        private String datetime;//时间

        private int rev;//转速

}
