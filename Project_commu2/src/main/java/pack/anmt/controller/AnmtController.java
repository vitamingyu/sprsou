package pack.anmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AnmtController {
	   @PostMapping("/admin")
	    public String login(HttpSession session, @RequestParam String adminid, @RequestParam String adminpasswd, Model model) {
	        AdminEntity adminEntity = adminService.login(adminid, adminpasswd);
	        if (adminEntity != null) {
	           session.setAttribute("admin", adminEntity.getAdminname());
	           session.setAttribute("isAdmin", true); // 관리자로 로그인한 경우 "isAdmin"을 true로 설정
	            return "redirect:/adminmain"; 
	        } else {
	            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
	            return "adminlogin";
	        }
	    }
}
