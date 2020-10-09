package com.cutety.controller;

import com.cutety.entity.CheckInInfo;
import com.cutety.service.CheckInInfoService;
import com.cutety.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class CheckInController {
    @Autowired
    private CheckInInfoService checkInInfoService;
    @Autowired
    private WebSocket webSocket;

    @ResponseBody
    @PostMapping("/checkIn")
    public String checkIn(@RequestBody CheckInInfo record) {
        LocalDateTime now = LocalDateTime.now();
        record.setCheckInTime(now);
        record.setCheckInStatus(1);
        int res = checkInInfoService.update(record);
        if(res == 1) {
            webSocket.sendAllMessage("update");
            return "suc";
        } else {
            return "fail";
        }
    }
}
