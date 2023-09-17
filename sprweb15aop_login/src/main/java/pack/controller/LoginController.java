package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class LoginController {
	@Autowired
	private DataDao dao;
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("login")  //로긴클래스에서는 클라이언트로 부터 받아오는? 세션이 아니기 때문에 선언해주고 쓰지만 여기선 받아오는지 바로 씀
	public String loginProcess(HttpSession session,
		@RequestParam("no")String no,
		@RequestParam("name")String name){
		JikwonDto jikwonDto = dao.jikwonLogin(no);  // 여기서 no주면 ~하하가가~ 셀렉트에서 no를 jikwon_no에 넣어서 값을 주고 그걸 맨 앞에 있는 
		//JikwonDto가 받아 그걸 이 파일로 또 받아와서 최종 리턴까지..
		if(jikwonDto != null) {
			String returnName=jikwonDto.getJikwon_name();
			if(returnName.equals(name)) {  //내가 읽은 name이랑 db에서 읽어온 db랑 같냐
				session.setAttribute("name", returnName);
			}
		}
		return "redirect:/jikwonlist";
	}
	
	@GetMapping("logout")
	public String logoutProcess(HttpSession session) {  //getmapping이기 때문에 가능하다
		session.removeAttribute("name");
		return "redirect:/";
	}
}
