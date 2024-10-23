package repet.ldh.project.mypage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import repet.ldh.project.board.dto.Board;
import repet.ldh.project.member.dto.Member;
import repet.ldh.project.mypage.service.MyPageService;

@Controller
@RequestMapping("myPage")
@RequiredArgsConstructor
public class MyPageController {

	private final MyPageService service;

	// 좋아요 리스트 조회
	@GetMapping("info")
	public String likeList(
				@RequestParam("memberNo") int memberNo,
				Model model
			) {

		// 좋아요 누른 게시물 리스트 조회
		List<Board> likeList = service.likeList(memberNo);
		
		System.out.println(likeList);
		
		Member member = service.memberList(memberNo);
		
		System.out.println(member);
		
		model.addAttribute("likeList", likeList);
		model.addAttribute("member", member);

		return "myPage/myPage-info";
	}
	
	
	
	
	

	@GetMapping("board")
	public String myBoard() {
		return "myPage/myPage-board";
	}

}
