package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	// Logger이란 프로그램 개발 중이나 완료 후 프로그램 상태를 모니터링 하기 위해 필요한 정보(로그)를 기록하는 것
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitcall() {
		return "redirect:http://localhost/login.html";      // redirect방식
	}
	
	// 방법1 : 전통적 방법 사용하여
	/*
	@GetMapping("loginget")
	public String submit(HttpServletRequest request, Model model) {   // 위에@해줘야 이 줄 오류 안남
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("console로 출력 " +id+" "+pwd);  // 프로그램 진행 중 값 확인하기
		logger.info("진행 도중 로그정보를 출력"+id+ " " +pwd); // 로그 레벨 trace > info > warn > error
		
		String data ="";
		if(id.equals("aa") && pwd.equals("11"))
			data = "로그인 성공";
		else
			data = "로그인 실패";
		
		model.addAttribute("data",data);
		return "result";
	}
	*/
	
	//방법 2 : spring의 방법을 써보자
	@GetMapping("loginget")
	public String submit(@RequestParam(value="id")String id,
										@RequestParam("pwd")String pwd,  // 애는 value생략 가능
										Model model) {
		String data ="";
		if(id.equals("aa") && pwd.equals("11"))
			data = "와우 로그인 성공";
		else
			data = "ㅠ 로그인 실패";
		
		model.addAttribute("data",data);
		return "result";
	}
	
}
