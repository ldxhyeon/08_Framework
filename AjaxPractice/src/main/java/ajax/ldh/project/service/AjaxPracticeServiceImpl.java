package ajax.ldh.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajax.ldh.project.dto.Todo;
import ajax.ldh.project.mapper.AjaxPracticeMapper;

@Service
public class AjaxPracticeServiceImpl implements AjaxPracticeService{
	
	@Autowired
	AjaxPracticeMapper mapper;
	
	
	@Override
	public Map<String, Object> selectTodoList() {
		
		List<Todo> todoList = mapper.selectTodoList();
		
		int completeCount = mapper.completeCount();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("todoList", todoList);
		
		map.put("completeCount", completeCount);
		
		return map;
	}
	
	
	
	@Override
	public int todoAdd(Todo todo) {
		return mapper.todoAdd(todo);
	}
	
	
	@Override
	public int totalCount() {
		return mapper.totalCount();
	}

	
	@Override
	public List<Todo> getTodoList() {
		return mapper.selectTodoList();
	}
	
	
	@Override
	public Todo todoDetail(int todoNo) {
		return mapper.todoDetail(todoNo);
	}
	
	
	
	@Override
	public int todoComplete(int todoNo) {
		return mapper.todoComplete(todoNo);
	}
	
	
	@Override
	public int getCompleteCount() {
		return mapper.completeCount();
	}
	
	
	@Override
	public int todoDelete(int todoNo) {
		return mapper.todoDelete(todoNo);
	}
	
	
	@Override
	public int todoUpdate(Todo todo) {
		return mapper.todoUpdate(todo);
	}

}
