package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.CommuDao;
import pack.model.CommuDto;

@Controller
public class UpdateController {
	@Autowired
	private CommuDao comDao;
	
	@GetMapping("update")
	public String edit(@RequestParam("num")String num, 
			@RequestParam("page")String page,
			Model model) {
		// 수정 대상 자료 읽기
		CommuDto dto = comDao.detail(num);
		
		model.addAttribute("list", dto);
		model.addAttribute("page", page);
		
		return "update";
	}
	
	@PostMapping("update")
	public String editProcess(CommuBean bean, 
			@RequestParam("page") String page, 
			Model model) {
		// 비밀번호 확인을 위해 DB에서 비밀번호 읽기
		String pass = comDao.selectPass(Integer.toString(bean.getNum()));
		System.out.println("bean.getPass(입력한 비번) :" + bean.getPass() + " pass(서버비번0 : " + pass);
		if(bean.getPass().equals(pass) || bean.getPass()==pass) {  // 비밀번호 비교 
			boolean b = comDao.update(bean);
			if(b) {
				// 상세보기로 이동
				//return "redirect:detail?num=" + bean.getNum() + "&page=" + page;
				
				// 목록보기로 이동
				return "redirect:commu?page=" + page;
			}else {
				return "redirect:commu";
			}
		}else{
			model.addAttribute("msg", "비밀번호 불일치~");
			model.addAttribute("page", page);
			return "redirect:commu";
		}
	}
}
