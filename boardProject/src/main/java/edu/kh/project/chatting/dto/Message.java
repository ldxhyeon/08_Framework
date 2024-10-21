package edu.kh.project.chatting.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Service
@ToString
public class Message {
	
	 private int messageNo;
	  private String messageContent;
	  private String readFl;
	  private int senderNo;
	  private int targetNo;
	  private int chattingRoomNo;
	  private String sendTime;
	  
}
