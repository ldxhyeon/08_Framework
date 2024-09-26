package chat.ldh.project.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import chat.ldh.project.dto.ChatDto;

public class ChatController {
	@MessageMapping("/chat/message") // 클라이언트에서 /pub/chat/message로 전송된 메시지 처리
  @SendTo("/sub/chat/room/1") // 메시지를 /sub/chat/room/1로 전송
  public ChatDto sendMessage(ChatDto message) {
      return message; // 클라이언트로 메시지를 반환
  }
}
