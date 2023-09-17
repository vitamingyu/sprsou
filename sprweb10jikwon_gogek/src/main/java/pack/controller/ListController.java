package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.GogekDto;
import pack.model.JikwonDto;
import pack.model.JikwonGogekDao;

@Controller
public class ListController {
	@Autowired
	private JikwonGogekDao jikwonGogekDao;
	
	@GetMapping("list")
	public String showList(Model model) {
		List<JikwonDto> jlist = jikwonGogekDao.selectAll();
		model.addAttribute("jikwons",jlist);  // 머릿속에선 request.setattribute라 생각
		return "list";
	}
	
	@GetMapping("showgogek")
	public String showGogek(@RequestParam("jikwon_no")String jikwon_no,
			@RequestParam("jikwon_name")String jikwon_name, Model model) {
		List<GogekDto> glist = jikwonGogekDao.selectGogek(jikwon_no);
		model.addAttribute("jikwon_name",jikwon_name);  // 머릿속에선 request.setattribute라 생각
		model.addAttribute("gogeks",glist);
		model.addAttribute("count",glist.size());
		return "gogeklist";
	}
}
