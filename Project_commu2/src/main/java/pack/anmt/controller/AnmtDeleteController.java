package pack.anmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.anmt.model.AnmtDao;
import pack.anmt.model.AnmtDto;
import pack.commu.model.CommuDao;
import pack.commu.model.CommuDto;

@Controller
public class AnmtDeleteController {
	@Autowired
	private AnmtDao dao;

	@GetMapping("Adelete")
	public String edit(@RequestParam("num")String num, Model model) {
		AnmtDto dto = dao.detail(num);
		model.addAttribute("list", dto);
		return "anmtdelete";
	}
   
	@PostMapping("Adelete")
	public String del(@RequestParam("num") String num,AnmtBean bean,HttpSession session) {
		//String customerid = (String) session.getAttribute("customernickname");
		//(String) session.getAttribute("idkey");
		//customerid.equals(idkey
		if (true) { 
			boolean b = dao.delete(num);
			if (b) {
					return "redirect:anmt";
			}else {
					return "redirect:error";
			}
		}else{
			return"redirect:anmt";
		}
	}
}
