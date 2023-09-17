package pack.controller;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CommuBean {
	private int num, readcnt, gnum, onum, nested;
	private String name, pass, mail, title, cont, cip, cdate;
	private String searchName, searchValue;
	
	public void setCdate() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		this.cdate = year + "-" + month + "-" + day;	
	}
}
