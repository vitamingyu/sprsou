package pack.commu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.commu.model.CommuDao;
import pack.commu.model.CommuDto;

@Controller
public class CommuDeleteController {
	@Autowired
	private CommuDao comDao;

	@GetMapping("commudelete")
	public String edit(@RequestParam("num") String num, HttpSession session) {
		CommuDto dto = comDao.detail(num);
		String loginId = (String) session.getAttribute("loginId");
		String customerid = dto.getCustomerid();

		if (customerid.equals(loginId)) {
			boolean b = comDao.delete(num);
			if (b) {
				return "redirect:commu";
			} else {
				return "redirect:error";
			}
		} else {
			return "redirect:/commu";
		}
	}
}
