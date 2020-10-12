package com.cutety.utils;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/** * @Author cutety 
* @Description //TODO 这个类的主要功能是为了跟前端进行消息推送，如果有人进行了报到可以通知前端页面对数据进行更新。 
* @Date 16:58 2020/10/12 * @Param  
* @return  
**/
@Component
@ServerEndpoint("/websocket/{shopId}")
//此注解相当于设置访问URL
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="shopId")String shopId) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(shopId, session);
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(String shopId, String message) {
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}