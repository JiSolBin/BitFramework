package com.bit.sts28.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EchoController {

	@MessageMapping("/room1")
	@SendTo("/topic/msg1")
	public String func01(String msg) {
		return msg;
	}
}
