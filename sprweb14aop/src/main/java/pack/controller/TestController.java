package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MyModelInter;
@Controller
public class TestController {
	@Autowired
	private MyModelInter modelInter;
	
	@GetMapping("aoptest")
	public String abc(Model model) {
		String result1 = modelInter.processMsg();
		String result2 = modelInter.businessMsg();
		
		model.addAttribute("data1",result1);   //model이라 쓰지만 이걸 request라 읽어라
		model.addAttribute("data2",result2);
		return "list";  //포워딩으로 넘어감
	}
}
