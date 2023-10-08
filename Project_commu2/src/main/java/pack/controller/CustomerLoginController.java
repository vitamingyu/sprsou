package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pack.member.CustomerDto;

@Controller
@RequiredArgsConstructor
public class CustomerLoginController {

	private final CustomerService customerService;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// 로그인 페이지 표시
    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute CustomerDto customerDto, HttpSession session, Model model) {
    	CustomerDto loginResult = customerService.login(customerDto);
    	if(loginResult != null) {
    		// login 성공, 세션에 닉네임을 저장
			session.setAttribute("loginId", loginResult.getCustomerid());
			session.setAttribute("nickname", loginResult.getCustomernickname());
	
			String previousPage = (String) session.getAttribute("previousPage");

	        if (previousPage != null) {
	            // 이전 페이지로 Redirect
	            session.removeAttribute("previousPage"); // Redirect 후 세션에서 제거
	            return "redirect:" + previousPage;
	        } else {
	            // 이전 페이지 정보가 없을 경우 기본 페이지로 Redirect
	            return "redirect:/";
	        }
    	}else {
    		// 컨트롤러와 뷰의 데이터 전달 / 로그인 실패라는 값을 msg에 추가
    		model.addAttribute("msg","아이디나 비밀번호가 일치하지 않습니다");
    		return "login";
    	}
    }
    
    // 로그아웃 핸들러 메서드, 세션을 무효화하여 로그아웃 처리
    @GetMapping("logout")
    public String loggout(HttpSession session) {
    	String previousPage = (String) session.getAttribute("previousPage");
    	session.invalidate();

        if (previousPage != null) {
            // 이전 페이지로 Redirect
            session.removeAttribute("previousPage"); // Redirect 후 세션에서 제거
            return "redirect:" + previousPage;
        } else {
            // 이전 페이지 정보가 없을 경우 기본 페이지로 Redirect
            return "redirect:/";
        }
    //	return "redirect:/index.html";

    }
    
}
