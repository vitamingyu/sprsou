package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pack.model.CommentDao;
import pack.model.CommentDto;

import java.util.List;
@Controller
public class CommentController {
    
    @Autowired
    private CommentDao commentService; // CommentService는 댓글 관련 비즈니스 로직을 처리합니다.
    
    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("newComment") CommentDto newComment, @RequestParam("postId") Long postId, Model model) {
        // 댓글 추가 로직
        commentService.addComment(newComment); // CommentDto 객체를 전달
        
        // 다시 댓글 목록을 가져오는 로직
        List<CommentDto> commentList = commentService.getCommentsByPostId(postId);
        
        // 모델에 newComment와 commentList를 추가
        model.addAttribute("newComment", new CommentDto()); // 빈 댓글 객체를 다시 생성하여 폼을 초기화
        model.addAttribute("comments", commentList);
        
        return "detail"; // 상세 페이지로 이동
    }
    
    // 다른 컨트롤러 메서드들...
}
