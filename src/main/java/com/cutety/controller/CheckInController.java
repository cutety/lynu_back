package com.cutety.controller;

import com.cutety.entity.CheckInInfo;
import com.cutety.service.CheckInInfoService;
import com.cutety.utils.WebSocket;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/")
public class CheckInController {
    //创建一个数组里面存放当前提交的过人的id
    private static String[] reqCache = new String[10];
    //这个是个计数器，每次到10就会清零，让reqCache从头开始，主要作用是使前面的缓存失效
    private static Integer reqCacheCounter = 0;
    @Autowired
    private CheckInInfoService checkInInfoService;
    @Autowired
    private WebSocket webSocket;

    /** * @Author cutety
    * @Description //TODO 给前端结果，duplicate是重复提交，fail是数据库这边出问题了，一般情况下是输错了学号，suc就是插入成功
    * @Date 16:49 2020/10/12 * @Param [record]
    * @return java.lang.String
    **/
    @ResponseBody
    @GetMapping("/checkIn")
    public String checkIn(CheckInInfo record) {
        String stuId = record.getStuId();
        if(Arrays.asList(reqCache).contains(stuId)) {
            System.out.println("重复提交id:"+stuId);
            return "duplicate";
        }
        synchronized(this.getClass()) {
            //双重检查锁，DCl(Double Checked Locking)提高程序的执行效率
            if(Arrays.asList(reqCache).contains(stuId)) {
                System.out.println("重复提交id:"+stuId);
                return "duplicate";
            }
            if(reqCacheCounter >= reqCache.length) {
                reqCacheCounter = 0;
            }
            reqCache[reqCacheCounter] = stuId;
            reqCacheCounter++;
        }
        LocalDateTime now = LocalDateTime.now();
        record.setCheckInTime(now);
        record.setCheckInStatus(1);
        int res = checkInInfoService.update(record);
        if(res == 1) {
            webSocket.sendAllMessage("update");
            System.out.println("添加"+stuId+"成功");
            return "suc";
        } else {
            return "fail";
        }
    }

    /** * @Author cutety
    * @Description //TODO 获取报道人数
    * @Date 16:49 2020/10/12 * @Param []
    * @return java.lang.Integer
    **/
    @ResponseBody
    @GetMapping("/checkInAmount")
    public Integer getCheckInAmount() {
        return checkInInfoService.getCheckInAmount();
    }
}
