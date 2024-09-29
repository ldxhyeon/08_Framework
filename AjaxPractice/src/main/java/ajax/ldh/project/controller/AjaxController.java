package ajax.ldh.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ajax.ldh.project.dto.Todo;
import ajax.ldh.project.service.AjaxPracticeService;

@Controller
@RequestMapping("todo")
public class AjaxController {
	
	@Autowired
	AjaxPracticeService service;

	@ResponseBody
	// 단일 객체만 반환 가능하므로 여러개의 값을 못넘김.
	@PostMapping("add")
	public int todoAdd(
				@RequestBody Todo todo
			) {
		
		int result = service.todoAdd(todo);
		
		return result;
	}
	
	
	@ResponseBody
	@GetMapping("totalCount")
	public int totalCount() {
		return service.totalCount();
	}
	
	
	@ResponseBody
	@GetMapping("todoList")
	public List<Todo> getTodoList() {
		return service.getTodoList();
	}
	
	
	@ResponseBody
	@GetMapping("detail/{todoNo}")
	public Todo selectTodo(
				@PathVariable("todoNo") int todoNo
			) {
		return service.todoDetail(todoNo);
	}
	
	
	@ResponseBody
	@PutMapping("todoComplete")
	public int todoComplete(
				@RequestBody int todoNo
			) {
		
		return service.todoComplete(todoNo);
	}
	
	
	@ResponseBody
	@GetMapping("completeCount")
	public int completeCount() {
		return service.getCompleteCount();
	}
	
	
	@ResponseBody
	@DeleteMapping("todoDelete")
	public int todoDelete(
				@RequestBody int todoNo
			) {
		
		return service.todoDelete(todoNo);
	}
	
	@ResponseBody
	@PutMapping("todoUpdate")
	public int todoUpdate(
				@RequestBody Todo todo
			) {
		
		return service.todoUpdate(todo);
	}
	
	
}
