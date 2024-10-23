package repet.ldh.project.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repet.ldh.project.board.dto.Board;
import repet.ldh.project.member.dto.Member;
import repet.ldh.project.mypage.mapper.MyPageMapper;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
	
	private final MyPageMapper mapper;

	// 게시글 리스트 조회
	@Override
	public List<Board> likeList(int memberNo) {
		return mapper.likeList(memberNo);
	}
	
	
	// 프로필 회원 조회
	@Override
	public Member memberList(int memberNo) {
		return mapper.memberList(memberNo);
	}

}
