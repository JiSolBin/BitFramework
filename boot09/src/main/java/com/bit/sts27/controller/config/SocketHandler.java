package com.bit.sts27.controller.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler {

	List<WebSocketSession> list = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// socket.connected 시 호출되는 메서드
		list.add(session);
		System.out.println("webSocket:"+session.getId());
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// socket.send() 시 호출되는 메서드
		System.out.println(message);
		for(WebSocketSession sock : list)
			sock.sendMessage(message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// socket.close, 창을 벗어날 때 호출되는 메서드
		list.remove(session);
	}

}
