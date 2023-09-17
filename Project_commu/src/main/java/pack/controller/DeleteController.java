package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.CommuDao;

@Controller
public class DeleteController {
	@Autowired
	private CommuDao comDao;
	
	@GetMapping("delete")
	public String del(@RequestParam("num")String num,
			@RequestParam("page")String page) {
		// 사실 비번 삭제는 비밀번호 비교해야 함. 생략...
		if(comDao.delete(num))
			return "redirect:commu";
		else
			return "redirect:error";
	}
}
