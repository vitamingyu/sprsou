package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataDao;
import pack.model.JikwonDto;
@Controller
public class JikwonController {
	@Autowired
	private DataDao dao;
	
	@GetMapping("jikwonlist")
	public String jikProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
	ArrayList<JikwonDto> jlist = dao.jikwonListAll();
	model.addAttribute("list",jlist);
	return "show";
	}
}
