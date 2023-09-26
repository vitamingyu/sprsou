package pack.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.qna.model.QnaDaoImpl;

@Controller
public class QnaReplyController {
	@Autowired
	private QnaDaoImpl daoImpl;
	
	@GetMapping("qreply")
	public String reply(@RequestParam("num")String num, 
			@RequestParam("page")String page,
			Model model) {
		model.addAttribute("data", daoImpl.detail(num));
		model.addAttribute("page", page);
		return "qreply";
	}
	
	@PostMapping("qreply")
	public String replyProcess(QnaBean bean, @RequestParam("page")String page){
		// onum 갱신
		bean.setOnum(bean.getOnum() + 1);
		daoImpl.updateOnum(bean);
		
		// 답글 저장
		bean.setBdate();
		bean.setNum(daoImpl.currentNum() + 1);
		bean.setNested(bean.getNested() + 1);
		
		if(daoImpl.insertReply(bean)) {
			return "redirect:qlist?page=" + page;
		}else{
			return "redirect:error";
		}
	}
}
