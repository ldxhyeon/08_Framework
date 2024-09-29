package ajax.ldh.project.service;

import java.util.List;
import java.util.Map;

import ajax.ldh.project.dto.Todo;

public interface AjaxPracticeService {

	Map<String, Object> selectTodoList();

	int todoAdd(Todo todo);

	int totalCount();

	List<Todo> getTodoList();

	Todo todoDetail(int todoNo);

	int todoComplete(int todoNo);

	int getCompleteCount();

	int todoDelete(int todoNo);

	int todoUpdate(Todo todo);

}
