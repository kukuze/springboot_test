package com.example.sprintboot_test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class  GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 异常处理方法 @ExceptionHandler 来指定拦截的是那一类型的异常。
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception ex){
//        // 打印异常信息 例如 ： Duplicate entry '666' for key 'idx_username'
//        log.error(ex.getMessage());
//        // 判断异常信息是否包括
//        if(ex.getMessage().contains("Duplicate entry")){
//            // 异常信息有空格，所以我们可以通过空格进行截取 获得一个数组
//            String[] split = ex.getMessage().split(" ");
//            String msg = split[2] + "已存在";
//            // 返回异常处理信息
//            return R.error(msg);
//        }

        logger.error(ex.getMessage()+"全局异常",ex);
//        System.out.println("全局异常处理");
        return R.error("未知错误");
    }
}