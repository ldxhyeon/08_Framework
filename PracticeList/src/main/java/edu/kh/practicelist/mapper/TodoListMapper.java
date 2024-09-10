package edu.kh.practicelist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.practicelist.dto.Todo;

@Mapper
public interface TodoListMapper {

	public List<Todo> selectTodoList();

	public int selectCompleteCount();

	public int todoAdd(Todo todo);

	public Todo todoDetail(int todoNo);

	public int todoComplete(int todoNo);

}
