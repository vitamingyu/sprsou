package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SupplierDto;
import pack.model.memberDto;

@Controller
public class TestController {
	@Autowired
	private DataDao dataDao; //model로 감
	
	@GetMapping("member") //dispathcher에서 위임받은 handlemapper가 ..
	public String listProcess(Model model) {
		ArrayList<memberDto> slist = (ArrayList<memberDto>)dataDao.getDataAll();
		model.addAttribute("lists", slist);
		return "member";
	}
	
	@GetMapping("supplier")
	public String listProcess2(Model model) {
		ArrayList<SupplierDto> slist2 = (ArrayList<SupplierDto>)dataDao.getDataAll2();
		model.addAttribute("list2", slist2);
		return "supplier";
	}

}
