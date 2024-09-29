package ajax.ldh.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ajax.ldh.project.dto.Todo;

@Mapper
public interface AjaxPracticeMapper {

	List<Todo> mainPage();

	List<Todo> selectTodoList();

	int completeCount();

	int todoAdd(Todo todo);

	int totalCount();

	Todo todoDetail(int todoNo);

	int todoComplete(int todoNo);

	int todoDelete(int todoNo);

	int todoUpdate(Todo todo);


}
