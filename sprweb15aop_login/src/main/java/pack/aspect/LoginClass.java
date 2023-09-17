package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component  //얘가 에스펙트로 등록이 되어야 로긴클래스를 호출해서 -> 로긴 컨트롤러에서 겟매핑 받아주고 그렇게 컨트롤러가 실행되는 거임
public class LoginClass {
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") == null) {
			response.sendRedirect("login");
			return true;
		}else {
			return false;
		}
	}
}
