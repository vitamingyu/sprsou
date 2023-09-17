package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDao {
    @Autowired
    private CommentMapper commentMapper;

    public void addComment(CommentDto comment) {
        commentMapper.insertComment(comment);
    }

    public List<CommentDto> getCommentsByPostId(Long postId) {
        return commentMapper.selsectCommentsByPostId(postId);
    }
}

