package pack.commu.controller;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CommuBean {
	private int num, readcnt, gnum, onum,commentcount;
	private String customerid, title, cont, filename, cdate;
	private String searchName, searchValue;
	
	public void setCdate() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		this.cdate = year + "-" + month + "-" + day;	
	}
}
