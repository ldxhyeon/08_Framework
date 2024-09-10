package edu.kh.todolist.service;

import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;

public interface TodoListService {

	/** 할 일 목록 조회 + 완료된 할 일 개수
	 * @return map
	 */
	Map<String, Object> selectTodoList();

	
	/** 할 일 추가
	 * @param todo
	 * @return result
	 */
	int todoAdd(Todo todo);


	/** 할 일 상세 조회
	 * @param todoNo
	 * @return
	 */
	Todo todoDetail(int todoNo);


	
	/** 완료여부 변경
	 * @param todoNo
	 * @return
	 */
	int todoComplete(int todoNo);


	
	/** 수정 완료
	 * @param todoNo
	 * @return
	 */
	int todoUpdate(Todo todo);


	/** 할 일 삭제
	 * @param todoNo
	 * @return
	 */
	int todoDelete(int todoNo);


	/**
	 * @param todoNo
	 * @return
	 */
	String searchTitle(int todoNo);
	
	
	/** 전체 할 일 개수 조회
	 * @return totalCount
	 */
	int getTotalCount();



	/** 완료된 할 일 개수 조회
	 * @return completeCount
	 */
	int getCompleteCount();


	
	/** 
	 * @return
	 */
	List<Todo> getTodoList();

	

}


