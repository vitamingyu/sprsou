package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // 클라이언트의 요청을 처리할 클래스야 나는~
@RequestMapping("test9")
public class TestController2 {
	//@RequestMapping(value="test9", method=RequestMethod.GET )
	@RequestMapping(method=RequestMethod.GET )
	public String def(Model model) {
		model.addAttribute("msg","success get");
		return "list";   //forward방식. web-inf안에 있기 때문에 forward방식으로 부름. redirect로는 안됨
	}
	
	//@RequestMapping(value="test9", method=RequestMethod.POST )
	@RequestMapping(method=RequestMethod.POST )
	public String def2(Model model) {
		model.addAttribute("msg","success post");
		return "list";   
	}
}
