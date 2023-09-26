package pack.commu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.commu.model.CommuDao;
import pack.commu.model.CommuDto;

@Controller
public class CommuDeleteController {
	@Autowired
	private CommuDao comDao;

	@GetMapping("delete")
	public String edit(@RequestParam("num")String num, Model model) {
		CommuDto dto = comDao.detail(num);
		model.addAttribute("list", dto);
		return "delete";
	}
   
	@PostMapping("delete")
	public String del(@RequestParam("num") String num,CommuBean bean,HttpSession session) {
		//String customerid = (String) session.getAttribute("customerid");
		//(String) session.getAttribute("idkey");
		//customerid.equals(idkey
		if (true) { 
			boolean b = comDao.delete(num);
			if (b) {
					return "redirect:commu";
			}else {
					return "redirect:error";
			}
		}else{
			return"redirect:commu";
		}
	}
}
