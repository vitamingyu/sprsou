package pack.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@GetMapping("login")
	public String login(HttpSession session) {
		if (session.getAttribute("idkey") == null) {
			return "redirect:/login.html";
		} else {
			return "redirect:/buser.html";
		}
	}

	@PostMapping("login")
	public String login(HttpSession session, 
			@RequestParam("id")String id,
			@RequestParam("pwd")String pwd) {
		if(id.equals("aa")&&pwd.equals("11")) {
			session.setAttribute("idkey", id);
			return "redirect:/buserlist";
		}else {
			return "redirect:/err.html";
		}
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("idkey");
		//session.invalidate();  클라이언트가 갖고 있는 모든 세션을 날려버림 ㄷㄷ
		return "redirect:/";    // 스프링은 포워드가 기본이라 리다이렉트라고 써줘야됨
	}
}
