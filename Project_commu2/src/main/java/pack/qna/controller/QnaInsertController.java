package pack.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pack.qna.model.QnaDaoImpl;

@Controller
public class QnaInsertController {
	@Autowired
	private QnaDaoImpl daoImpl;
	
	@GetMapping("qinsert")
	public String insertform() {
		return "qinsform";
	}
	
	@PostMapping("qinsert")
	public String insertProcess(QnaBean bean) {
		bean.setBdate();
		int newNum = daoImpl.currentNum() + 1;  // 새글 번호
		bean.setNum(newNum);
		bean.setGnum(newNum);
		
		boolean b = daoImpl.insert(bean);
		if(b) {
			return "redirect:/qlist?page=1";  // 추가 후 목록 보기
		}else {
			return "redirect:/error";
		}
	}
}
