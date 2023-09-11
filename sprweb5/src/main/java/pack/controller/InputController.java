package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.SangpumBean;
import pack.model.SangpumModel;

@Controller
public class InputController {
	@Autowired
	private SangpumModel sangpumModel;
	
	@GetMapping("insdata")
	public String submitCall() {
		return "redirect:http://localhost/input.html";    //redirect
	}
	
	@PostMapping("insdata")
	public String submit(SangpumBean bean, Model model) {
		String imsi = sangpumModel.sangProcess(bean);
		model.addAttribute("sangdata",imsi);
		return "result2";   //forward
	}
	
}
