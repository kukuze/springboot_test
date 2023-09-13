package com.example.sprintboot_test.hangtian;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SendDataServiceImp {


    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\"dailyEquipCount\":{\"2023-09-08\":{\"电控箱\":2,\"设备\":3},\"2023-09-07\":{\"电控箱\":3},\"2023-07-14\":{\"发射装置换热送风组件\":1,\"设备\":3},\"2023-07-13\":{\"发射装置换热送风组件\":8}}}");
        List<String> dateList = Arrays.asList("2023-09-08", "2023-09-07", "2023-07-14", "2023-07-13");
        JSONObject dailyEquipCount = jsonObject.getJSONObject("dailyEquipCount");
        Map<String, JSONArray> resultMap = new HashMap<>();
        for (String date : dailyEquipCount.keySet()) {
            JSONObject dailyData = dailyEquipCount.getJSONObject(date);
            for (String equipment : dailyData.keySet()) {
                if (!resultMap.containsKey(equipment)) {
                    resultMap.put(equipment, new JSONArray());
                }
                JSONObject dailyCount = new JSONObject();
                int dateIndex = dateList.indexOf(date);
                dailyCount.put(String.valueOf(dateIndex), dailyData.getInteger(equipment));
                resultMap.get(equipment).add(dailyCount);
            }
        }
        JSONObject res = new JSONObject(new HashMap<>(resultMap));
        JSONObject end = new JSONObject();
        res.forEach((k,v)->{
            JSONArray objects = JSONArray.parseArray(v.toString());
            List<Object> resultList = new ArrayList<>();
            for (int i = 0; i < objects.size(); i++) {
                JSONObject jsonObject1 = objects.getJSONObject(i);
                for (String key : jsonObject1.keySet()) {
                    int index = Integer.parseInt(key);
                    ensureCapacity(resultList, index + 1);
                    resultList.set(index, jsonObject1.get(key));
                }
            }
            end.put(k,resultList);
        });
        System.out.println(end);

    }

    private static void ensureCapacity(List<Object> list, int size) {
        while (list.size() < size) {
            list.add(null);
        }
    }
}
