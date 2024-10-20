package repet.ldh.project.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("myPage")
public class MyPageController {
	
	@GetMapping("info")
	public String myPage() {
		return "myPage/myPage-info";
	}
	
	
	@GetMapping("changeInfo")
	public String changeInfo() {
		return "myPage/myPage-changeInfo";
	}
	
	
	@GetMapping("board")
	public String myBoard() {
		return "myPage/myPage-board";
	}
	
	
	@GetMapping("delete")
	public String delete() {
		return "myPage/myPage-delete";
	}

}
