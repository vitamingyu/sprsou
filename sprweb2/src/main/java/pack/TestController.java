package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

//주로 사용자의 요청을 처리 한 후 (처리했다? = 모델을 경유했다) 지정된 뷰에 모델 객체를 전달하는 역할. 클라이언트와 데이터 입출력을 제어하는 클래스
@Controller
public class TestController {
	@RequestMapping("test1") // DispatcherServlet으로부터 위임받은 HandlerMapping에 의해 처리
	// get과 post 모두를 받겠다. abc메소드와 매핑할거야
	public ModelAndView abc() { // abc메소드는 BL처리 또는 모델영역을 수행하는 역할
		System.out.println("abc 처리");
		
		// Model 인터페이스는 처리한 데이터를 뷰에 표시하기 위한 데이터를 전달. 내부적으로 HttpServletRequest 객체를 사용함
		
		//HttpServletRequest request = new httpservletRequest();
		//	request.setAttribute("msg","나이스")와 같은 말
		return new ModelAndView("list","msg","나이스"); // 뷰파일명, 키, 벨류(메세지,데이터) 순
		// DispatcherServlet으로 부터 위임받은 ViewResolver에 의해 처리
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET)     //value={"test2","hi","hello"}로 쓰면 name값 3개주는 그건가
	public ModelAndView abc2() {
		return new ModelAndView("list","msg","나이스2");
	}
	
	@GetMapping("test3")  // 새로 생긴 어노테이션. get 요청 처리용 전용 어노테이션
	public ModelAndView abc3() {
		return new ModelAndView("list","msg","나이스3");
	}
	
	@GetMapping("test4")
	public String abc4(Model model) { // 요즘엔 또 위 방법보다 이 방법을 더 많이씀
		model.addAttribute("msg","나이스4");
		return "list"; // list는 뷰파일명이고 이건 모델을 달고 가
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)    
	public ModelAndView abc5() {
		return new ModelAndView("list","msg","post 요청성공 5");
	}
	
	@PostMapping("test6")  // post 요청 처리용 전용 어노테이션
	public ModelAndView abc6() {
		return new ModelAndView("list","msg","post요청 성공 6");
	}
	
	@PostMapping("test7")
	public String abc7(Model model) { 
		model.addAttribute("msg","post 요청 성공 7");
		return "list"; 
	}
	
	@GetMapping("test8")
	@ResponseBody
	public String abc8() {
		String value = "일반적인 데이터(String, map,json 등을 전달)"; // 여기선 문자출력으로만 함
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() { 
		DataDto dto = new DataDto();
		dto.setCode(5);
		dto.setName("신기해");
		return dto;  // JSON형태로 반환(jakson 라이브러리가 자동 지원)
	}
	
}
