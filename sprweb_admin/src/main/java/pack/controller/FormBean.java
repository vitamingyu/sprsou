package pack.controller;

import lombok.Data;

@Data
public class FormBean {
	private String user_no, user_id, user_pwd, user_name,
	user_tel, user_addr, user_email, con_num;
	private String searchValue, selectSearch, svalue;
}