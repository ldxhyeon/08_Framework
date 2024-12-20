package edu.kh.project.chatting.service;

import java.util.List;

import edu.kh.project.chatting.dto.ChattingRoom;
import edu.kh.project.chatting.dto.Message;
import edu.kh.project.member.dto.Member;

public interface ChattingService {

	
	/** 채팅 상대 검색
	 * @param query : 상태 닉네임 또는 이메일
	 * @param loginMember : 로그인한 회원 정보
	 * @return : 검색 결과
	 */
	List<Member> selectTarget(String query, int memberNo);

	
	/** 
	 * 채팅방 입장
	 * @param targetNo
	 * @param memberNo
	 * @return
	 */
	int chattingEnter(int targetNo, int memberNo);


	
	/** 
	 * 로그인한 회원이 참여한 채팅방 목록 조회
	 * @param loginMember
	 * @return
	 */
	List<ChattingRoom> selectRoomList(int memberNo);


	
	/** 
	 * 특정 채팅방의 메시지 모두 조회
	 * @param chattingNo
	 * @param memberNo
	 * @return messageList
	 */
	List<Message> selectMessage(int chattingNo, int memberNo);


	/**
	 * 채팅 읽음 표시
	 * @param chattingNo
	 * @param memberNo
	 * @return
	 */
	int updateReadFlag(int chattingNo, int memberNo);


	/**
	 * 메시지 삽입
	 * @param msg
	 * @return result
	 */
	int insertMessage(Message msg);

}

