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
    private static String[] reqCache = new String[10];
    private static Integer reqCacheCounter = 0;
    @Autowired
    private CheckInInfoService checkInInfoService;
    @Autowired
    private WebSocket webSocket;
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

    @ResponseBody
    @GetMapping("/checkInAmount")
    public Integer getCheckInAmount() {
        return checkInInfoService.getCheckInAmount();
    }
}
