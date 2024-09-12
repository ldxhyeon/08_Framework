package edu.kh.practicelist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.practicelist.dto.Todo;
import edu.kh.practicelist.mapper.TodoListMapper;

@Service
public class TodoListServiceImpl implements TodoListService{
	
	@Autowired
	TodoListMapper mapper;
	
	@Override
	public Map<String, Object> selectTodoList() {
		
		List<Todo> todoList = mapper.selectTodoList();
		
		int completeCount = mapper.selectCompleteCount();
		
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
	public Todo todoDetail(int todoNo) {
		return mapper.todoDetail(todoNo);
	}
	
	
	@Override
	public int todoComplete(int todoNo) {
		return mapper.todoComplete(todoNo);
	}
	
	
	@Override
	public int deleteList(int todoNo) {
		return mapper.deleteList(todoNo);
	}
	
	
	@Override
	public int updateContent(Todo todo) {
		return mapper.updateContent(todo);
	}

}
