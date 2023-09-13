package com.example.sprintboot_test.utils;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yjz
 * @date 2023/4/26$ 18:35$
 * @description:
 */
public class lastExecutionTime {
    public static void main(String[] args) throws ParseException {
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setCronExpression("0 0 8 ? ? *");
        List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, 20);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dateFormat.format(dates.get(i)));
        }

    }
}
