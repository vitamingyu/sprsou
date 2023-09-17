package pack.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemDto;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;

	@GetMapping("list")
	public String listProcess(Model model) {
		ArrayList<MemDto> list = (ArrayList<MemDto>) dataProcess.getDataAll(); // JPA를 이용해 자료읽기

		model.addAttribute("datas", list);
		return "list";
	}

	@GetMapping("insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("insert")
	public String insert(MemBean bean, Model model) {
		String msg = dataProcess.insert(bean);

		if (msg.equals("success")) {
			// return "list"; // 포워딩
			return "redirect:http://localhost/list";
		} else {
			model.addAttribute("msg", msg);
			return "error.html";
		}
	}

	// 수정 준비
	@GetMapping("update")
	public String update(String num, Model model) {
		System.out.println("num : " + num);
		MemDto dto = (MemDto) dataProcess.getData(num);
		model.addAttribute("data", dto);
		return "update";
	}

	// 수정 처리
	@PostMapping("update")
	public String update(MemBean bean, Model model) {
		String msg = dataProcess.update(bean);

		if (msg.equals("success")) {
			// return "list"; // 포워딩
			return "redirect:http://localhost/list";
		} else {
			model.addAttribute("msg", msg);
			return "error.html";
		}
	}

	@GetMapping("delete")
	public String delete(@RequestParam("num") int num, Model model) {
		String msg = dataProcess.delete(num);

		if (msg.equals("success")) {
			// return "list"; // 포워딩
			return "redirect:list";
		} else {
			model.addAttribute("msg", msg);
			return "error.html";
		}
	}

}
