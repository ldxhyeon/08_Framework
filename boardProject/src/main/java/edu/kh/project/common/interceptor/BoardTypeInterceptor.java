package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.kh.project.board.service.BoardService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/* [Interceptor]
 * 
 * - 요청/응답을 가로채는 객체 (Spring 지원)
 * 
 * Client <-> Filter <-> Dispatcher Servlet 
 *         <-> Interceptor <-> Controller ....
 * 
 * 
 * - HandlerInterceptor 인터페이스 상속 필요
 * 
 * - 제공 메서드 중 필요한 메서드 오버라이딩
 * 
 * 1) preHandle() - 전처리
 *  Dispathcher Servlet -> Controller 
 *  사이에 요청/응답을 가로채서 수행
 * 
 * 2) postHandle() - 후처리
 *  Controller -> Dispathcher Servlet  
 *  사이에 요청/응답을 가로채서 수행
 * 
 * 3) afterCompletion() - forward된 뷰 완성 후
 *   View Resolver -> Dispatcher Servlet 사이 수행
 */


@Slf4j
public class BoardTypeInterceptor implements HandlerInterceptor {

	@Autowired // 의존성 주입(DI)
	private BoardService service;
	
	// 전처리
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
	
		// log.info("------ BoardTypeInterceptor 전처리 메서드 실행 ------");
		
		// 어떤 요청이 와도
		// header에 출력되는 게시판 메뉴를 DB에서 조회해
		// Application Scope에 세팅
		
		// 1) application scope 객체 얻어오기
		ServletContext application = request.getServletContext();
		
		// 2) application 객체에 "boardTypeList"가 없을 경우
		if(application.getAttribute("boardTypeList") == null) {
			
			 log.info("----- boardTypeList 조회 -----");
			 
			 // DB에서 모든 게시판 종류를 조회하는 서비스 호출
			 // ex) "boardCode": "1", "boardName": "공지사항"
			 List<Map<String, String>> boardTypeList
			 	= service.selectBoardTypeList();
			 
			 System.out.println(boardTypeList);
			 log.debug(boardTypeList.toString());
			 
			 
			 /// [{boardCode=1, boardName=공지 사항}, {boardCode=2, boardName=자유 게시판}, {boardCode=3, boardName=정보 게시판}, {boardCode=4, boardName=테스트}]
			 // [{CATEGORY_NAME=생활가전, CATEGORY_NO=1}, {CATEGORY_NAME=편의품, CATEGORY_NO=2}, {CATEGORY_NAME=식료품, CATEGORY_NO=3}]
			 
			 // 조회 결과를 application 객체에 세팅
			 // String Object 타입으로
			 application.setAttribute("boardTypeList", boardTypeList);
		}
		
		
		
		// return이 true이면 다음 interceptor 실행
		// false이면 중단
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	
	
	
	// 후처리 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	
	// view 완성 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
}
