package pack.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.qna.model.QnaDaoImpl;

@Controller
public class QnaDeleteController {
	@Autowired
	private QnaDaoImpl daoImpl;
	
	@GetMapping("qdelete")
	public String del(@RequestParam("num")String num,
			@RequestParam("page")String page) {
		if(daoImpl.delete(num))
			return "redirect:qlist?page=" + page;
		else
			return "redirect:error";
	}
}
