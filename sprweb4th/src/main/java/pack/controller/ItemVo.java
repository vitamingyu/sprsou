package pack.controller;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ItemVo {
	private String id,name;
	private int  price;
	private LocalDate regDate;
}
