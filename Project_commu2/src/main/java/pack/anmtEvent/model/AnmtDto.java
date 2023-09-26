package pack.anmtEvent.model;

import lombok.Data;

@Data
public class AnmtDto {
    private int num;
    private String username, title, content, filename, cdate;
}
