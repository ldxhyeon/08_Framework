package edu.kh.practicelist.service;

import java.util.Map;

import edu.kh.practicelist.dto.Todo;

public interface TodoListService {
	
	Map<String, Object> selectTodoList();

	int todoAdd(Todo todo);

	Todo todoDetail(int todoNo);

	int todoComplete(int todoNo);

}
