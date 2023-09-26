package pack.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.qna.model.QnaDaoImpl;

@Controller
public class QnaDetailController {
	@Autowired
	private QnaDaoImpl daoImpl;
	
	@GetMapping("qdetail")
	public String detailProcess(@RequestParam("num") String num,
			@RequestParam("page") String page, Model model) {
		// 조회수 증가 선행
		daoImpl.updateReadcnt(num);
		
		model.addAttribute("data", daoImpl.detail(num));
		model.addAttribute("page", page);
		
		return "qdetail";
	}
}
