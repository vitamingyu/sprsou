package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuController {
	
	@GetMapping("gugudan")
	public String getho() {
		return  "redirect:http://localhost/inputgugu.html";    
	}
	
	@PostMapping("gugudaninput")
	public String submit(@RequestParam(value = "su") int su, Model model) {
		String data="";
		for (int i = 1; i < 10; i++) {
			data += (su + "*"+i +"="+su*i + "<br/>");
		}

		model.addAttribute("sudata",data);
		return "gugudan";
	}
	
	
}
