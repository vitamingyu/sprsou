package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf")
public class NiceController {
	@GetMapping("/ex1")
	public String abc1(Model model) {
		ItemVo vo = new ItemVo();
		vo.setId("korea1");
		vo.setName("사과");
		vo.setPrice(5000);
		vo.setRegDate(LocalDate.now());

		model.addAttribute("vo", vo);
		return "show1";
	}

	@GetMapping("/ex2")
	public ModelAndView abc2() {
		List<ItemVo> list = new ArrayList<ItemVo>();
		for (int i = 1; i <= 5; i++) {
			ItemVo vo = new ItemVo();
			vo.setId("kor" + i);
			vo.setName("신상" + i);
			vo.setPrice(1000 * i);
			vo.setRegDate(LocalDate.now());
			list.add(vo);
		}
		ModelAndView andView = new ModelAndView("show2");
		andView.addObject("list", list);
		return andView;
	}

	@GetMapping("/ex3")
	public String abc3(Model model) {
		List<ItemVo> list = new ArrayList<ItemVo>();
		for (int i = 1; i <= 5; i++) {
			ItemVo vo = new ItemVo();
			vo.setId("ks" + i);
			vo.setName("신상품" + i);
			list.add(vo);
		}
		model.addAttribute("sanglist",list);
		return "show3";
	}
	
	@GetMapping("/ex4")
	public String abc4(Model model, String param1, String param2) {
		System.out.println(param1 + " "+param2);
		
		model.addAttribute("arg1",param1);
		model.addAttribute("arg2",param2);
		return "show4";
	}
	
	@GetMapping("/ex5")
	public String abc5() {
		return "show5";
	}
}
