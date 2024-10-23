package repet.ldh.project.mypage.service;

import java.util.List;

import repet.ldh.project.board.dto.Board;
import repet.ldh.project.member.dto.Member;

public interface MyPageService {

	// 게시글 좋아요 조회
	List<Board> likeList(int memberNo);

	// 프로필 회원 조회
	Member memberList(int memberNo);

}
