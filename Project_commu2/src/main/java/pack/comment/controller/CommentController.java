package pack.comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import pack.comment.model.CmmDao;
import pack.comment.model.CommentDto;

@Controller
public class CommentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CmmDao cmmDao;
    
    @PostMapping("/detail/addComment")
    public String addComment(CommentDto commentDto, @RequestParam("num")String num ) {
    	cmmDao.insertComment(commentDto);
    	// 댓글 수 카운트
        cmmDao.countcomment(Integer.parseInt(num));
    	return "redirect:/detail?num=" + num + "&page=1";
    }
    
    @GetMapping("/detail/updateComment")
    public String edit(@RequestParam("commentId")String commentId, @RequestParam("cnum")int  cnum,
			HttpSession session,@RequestParam("page")String page, @RequestParam("num")String num,
			Model model) {
		// 수정 대상 자료 읽기
    	String idkey = "NoIdNow";
		//(String) session.getAttribute("idkey");
	    System.out.println("id(작성 아이디): " + commentId + " 세션 아이디: " + idkey +" 댓글 번호: "+ cnum);
		if (commentId.equals(idkey)) {
			CommentDto dto = cmmDao.selectCommentNum(cnum);
			model.addAttribute("list", dto);
			model.addAttribute("page", page);
			 	return "updateComment";
		}else {
			return "redirect:/detail?num=" + num + "&page=" + page;
		}
	}
    
    @PostMapping("/updateComment/updateCom")
    public String upCom(@RequestParam("content")String content,@RequestParam("page")String page,
    		@RequestParam("num")String num, @RequestParam("id")int id ,Model model) {
    	logger.info(num +" "+ id);
    	boolean b = cmmDao.updateCom(content,id);
		if(b) {
			// 상세보기로 이동
			return "redirect:/detail?num=" + num + "&page=" + page;
		}else {
			return "redirect:err";
		}
}
    
    
    @GetMapping("/detail/deleteComment")
	public String delo(@RequestParam("id")String id, @RequestParam("cnum")String  cnum,
			HttpSession session,@RequestParam("page")String page, @RequestParam("num")String num) {
		String idkey = "NoIdNow";
				//(String) session.getAttribute("idkey");
	    System.out.println("id(작성 아이디): " + id + " 세션 아이디: " + idkey +" 댓글 번호: "+ cnum);
		if (id.equals(idkey)) {
			cmmDao.deleteComm(cnum);
			 	return "redirect:/detail?num=" + num + "&page=" + page;
		}else {
			return "redirect:/detail?num=" + num + "&page=" + page;
		}
//		if (id.equals(idkey)) {
//			boolean b = comDao.deleteComm(idkey);
//			if (b) {
//					return "redirect:commu";
//			}else {
//					return "redirect:error";
//			}
//		}else{
//			String msg;
//			msg = "현재 로그인 한 id와 일치하지 않습니다";
//			return"redirect:/commu";
//		}
	}
	
//	@PostMapping("/detail/deleteComment")
//	public String delo(@RequestParam("commentId") String num) {

//		System.out.println(num);
//		String pass = comDao.selectPass(Integer.toString(bean.getNum()));
//		System.out.println("bean.getPass(입력한 비번) :" + bean.getPass() + " pass(서버비번) : " + pass);
//		if (bean.getPass().equals(pass) || bean.getPass() == pass) { // 비밀번호 비교
//			boolean b = comDao.delete(num);
//			if (b) {
//					return "redirect:commu";
//			}else {
//					return "redirect:error";
//			}
//		}else{
//		return"redirect:commu";
		//}
//	}
}
