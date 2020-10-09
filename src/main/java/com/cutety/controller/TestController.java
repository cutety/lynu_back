package com.cutety.controller;

import com.cutety.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/sendAllWebSocket")
    public String test() {
        webSocket.sendAllMessage("清晨起来打开窗，心情美美哒~");
        return "group！";
    }

    @RequestMapping("/sendOneWebSocket")
    public String sendOneWebSocket() {
        webSocket.sendOneMessage("DPS007", "只要你乖给你买条gai！");
        return "single";
    }
}