package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataDao;
import pack.model.memberDto;

@Controller
public class SearchController {
	@Autowired
	private DataDao dataDao;
	
	@PostMapping("search")
	public String search(FormBean bean, Model model) {  //넘어가니까 Model 사용
		ArrayList<memberDto> slist = (ArrayList<memberDto>)dataDao.getDataSearch(bean);
		model.addAttribute("lists", slist);
		return "member";
	}
}
