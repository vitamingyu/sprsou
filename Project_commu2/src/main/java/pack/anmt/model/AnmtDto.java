package pack.anmt.model;

import lombok.Data;

@Data
public class AnmtDto {
    private int num;
    private String adminname, title, content, filename, cdate;
}
