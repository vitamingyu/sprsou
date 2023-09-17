package pack.model;

import lombok.Data;

@Data
public class CommentDto {
    private long postId;
    private String author;
    private String text;
}