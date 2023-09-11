package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymetest")
	public String sijak(Model model) {
		model.addAttribute("msg","타임리프 만세");   //model갔다와야하는데 아직 안갈래 => 그래서 문자만 준듯?
		model.addAttribute("msg2","홍길동");
		
		//DTO를 출력
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("마우스");
		sangpum.setPrice("5000");
		model.addAttribute("sangpum",sangpum);
		
		
		//Collection을 출력
		ArrayList<Sangpum> list = new ArrayList<>();
		list.add(sangpum);
		Sangpum sangpum2 = new Sangpum();
		sangpum2.setCode("20");
		sangpum2.setSang("모니터");
		sangpum2.setPrice("7000");
		list.add(sangpum2);
		model.addAttribute("sangpums",list);
		
		return "list1";     // 여기선 templates 폴더에 있는 list1.html을 찾아감
	}
}
