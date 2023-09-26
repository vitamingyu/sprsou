package pack.commu.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.comment.model.CmmDao;
import pack.comment.model.CommentDto;
import pack.commu.model.CommuDao;


@Controller
public class DetailController {
	@Autowired
	private CommuDao comDao;
	@Autowired
	private CmmDao cmDao;
	
	@GetMapping("detail")
    public String detailProcess(@RequestParam("num") String num,
                                @RequestParam("page") String page,Model model) {
        // 조회수 증가 선행
        comDao.updateReadcnt(num);

        model.addAttribute("list", comDao.detail(num));
        model.addAttribute("page", page);
        
        // 댓글 조회 
        ArrayList<CommentDto> comments = cmDao.selectCommentsByNum(Integer.parseInt(num));
       model.addAttribute("comments", comments);

        return "detail";
    }
	
}
