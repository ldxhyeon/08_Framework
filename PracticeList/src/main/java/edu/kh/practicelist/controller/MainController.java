package edu.kh.practicelist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.practicelist.dto.Todo;
import edu.kh.practicelist.service.TodoListService;

@Controller
public class MainController {
	
	@Autowired
	TodoListService service;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		
		Map<String, Object> map = service.selectTodoList();

		List<Todo> todoList = (List<Todo>)map.get("todoList");
		
		int completeCount = (int)map.get("completeCount");
		
		model.addAttribute("todoList", todoList);
		model.addAttribute("completeCount", completeCount);
		
		return "common/main";
	}
	
}
