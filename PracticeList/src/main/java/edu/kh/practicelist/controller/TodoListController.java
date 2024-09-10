package edu.kh.practicelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.practicelist.dto.Todo;
import edu.kh.practicelist.service.TodoListService;

@Controller
@RequestMapping("todo")
public class TodoListController {

	@Autowired
	TodoListService service;
	
	@PostMapping("add") 
	public String todoAdd(
				@ModelAttribute Todo todo,
				RedirectAttributes ra
			) {
		
		String message = null;
		int result = service.todoAdd(todo);
		
		if(result > 0) {
			message = "할 일 추가 성공.";
		}else {
			message = "추가 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:/";
	}
	
	
	
	/** 완료 여부 변경
	 * @param todoNo : 쿼리스트링으로 전달된 todoNo 값
	 * @param rq 
	 * @return
	 */
	@GetMapping("detail/{todoNo}")
	public String todoDetail(
				@PathVariable("todoNo") int todoNo,
				Model model,
				RedirectAttributes ra
			) {
		
		Todo todo = service.todoDetail(todoNo);
		
		if(todo == null) {
			ra.addFlashAttribute("message", "할 일이 존재하지 않습니다.");
			return "redirect:/";
		}
		
		model.addAttribute("todo", todo);
		
		return "todo/detail";
	}
	
	
	@GetMapping("complete")
	public String todoComplete(
				@PathVariable("todoNo") int todoNo,
				RedirectAttributes ra
			) {
		
		int result = service.todoComplete(todoNo);
		
		
		String message = null;
		String path = null;
		if(result > 0) {
			message = "변경 되었습니다.";
			path = "redirect:/";
		}else {
			message = "변경 실패.";
			path = "redirect:/";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
	
}
