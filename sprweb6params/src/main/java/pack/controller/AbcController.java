package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AbcController {
	@GetMapping(value="kbs/login",params="type=admin")
	public String kbs(Model model) {
		model.addAttribute("message","관리자");
		return "list";
	}
	
	@GetMapping(value="kbs/login",params="type=user")
	public String mbc(Model model) {
		model.addAttribute("message","일반 회원");
		return "list";
	}
	
	@GetMapping(value="kbs/login",params="!type")
	public String sbs(Model model) {
		model.addAttribute("message","type값 없음");
		return "list";
	}
	
	@PostMapping (value="kbs/login",params="type=user")
	public String ytn(Model model) {
		model.addAttribute("message","일반 회원입니다");
		return "list";
	}
	
	//action="mbc/usa" 현재 엑션이 이렇게 들어온 상태 + name="name"
	@GetMapping(value="mbc/{url}")
	public String aaa(@RequestParam("name")String name,
			@PathVariable String url,
			Model model) {
		model.addAttribute("message","이름은 : "+ name +", 국적은 "+url);
		return "list";
	}
	
	// 받아오는 값을 title이라 할게
	@GetMapping(value="ent/{co}/singer/{singer}")
	public String aaa(@RequestParam("title")String title,
			@PathVariable String co,
			@PathVariable String singer,
			Model model) {
		String ss = "소속사 : " + co + ", 가수 : " + singer +", 타이틀 송 : " + title;
		model.addAttribute("message",ss);
		return "list";
	}
	
}
