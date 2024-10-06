package repet.ldh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import repet.ldh.project.main.service.MainService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainService service;
	
	@GetMapping("/")
	public String Main() {
		
		return "common/main";
	}
	
}
