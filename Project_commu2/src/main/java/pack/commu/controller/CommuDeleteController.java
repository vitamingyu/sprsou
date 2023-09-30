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

	@GetMapping("commudelete")
	public String edit(@RequestParam("num") String num, Model model, HttpSession session) {
		CommuDto dto = comDao.detail(num);
		String loginId = (String) session.getAttribute("loginId");
		String customerid = dto.getCustomerid();

		if (customerid.equals(loginId)) {
			model.addAttribute("list", dto);
			return "commudelete";
		} else {
			return "redirect:/commu";
		}
	}

	@PostMapping("commudelete")
	public String del(@RequestParam("num") String num, CommuBean bean, HttpSession session) {
		boolean b = comDao.delete(num);
		if (b) {
			return "redirect:commu";
		} else {
			return "redirect:error";
		}
	}
}
