package edu.kh.project.chatting.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class ChattingRoom {
	
  private int chattingRoomNo;
  private String lastMessage;
  private String sendTime;
  private int targetNo;
  private String targetNickname;
  private String targetProfile;
  private int notReadCount;
  private int maxMessageNo;
  
}
