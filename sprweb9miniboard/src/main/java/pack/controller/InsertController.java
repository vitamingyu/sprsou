package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class InsertController {
	@Autowired
	private BoardDao boardDao;
	
	//@GetMapping("insert") 도 가능
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public String insert() {
		return "insform";
	}
	
	//RequestMapping(value="insert",method=RequestMethod.POST)
	@PostMapping("insert")
	public String insertSubmit(BoardBean bean) {
		//bean과 insform의 name이 같아서 여기까지 넘어올 수 있는거임
		boolean b = boardDao.insertData(bean);
		if(b) {
			return "redirect:/list";   // 추가 후 목록보기 포워드로 하면 새로운 샐렉트를 안 만남. 리다이렉트로 해야됨
		}else {
			return "error";
		}
	}
}
