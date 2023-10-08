package pack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CustomerFindController {
    // 서비스 생성자 주입
    private final CustomerService customerService;
    
    
    
    // 아이디 찾기 페이지
    @GetMapping("/id_search")
    public String IdSearch() {
    	return "id_search";
    }
    
    @GetMapping("/findIdByPhone")
    public String findIdByPhone(@RequestParam("customername") String customername, @RequestParam("phonenumber") String phonenumber, Model model) {
        // 입력된 이름과 휴대전화번호를 가지고 아이디를 찾는 서비스 메서드 호출
        String foundId = customerService.findIdByNameAndPhonenumber(customername, phonenumber);

        if (foundId != null) {
            model.addAttribute("foundId", foundId);
            return "id"; 
        } else {
            return "일치하는 정보가 없습니다"; 
        }
    }
    
    // 비밀번호 찾기 페이지
    @GetMapping("/passwd_search")
    public String PasswdSearch() {
    	return "passwd_search";
    }
    
    // 이것도 똑같이 비밀번호 찾기 페이지에서 닉네임, 이름, 이메일을 받아 비밀번호를 찾는 엔드포인트
    @GetMapping("/findPasswd")
    public String findPassword(@RequestParam("customerid") String customerid, @RequestParam("customername") String customername, @RequestParam("phonenumber") String phonenumber, Model model) {
        // customerid, customername 및 phonenumber를 사용하여 비밀번호를 찾음
        String foundPassword = customerService.findPassword(customerid, customername, phonenumber);

        if (foundPassword != null) {
        	model.addAttribute("foundPassword", foundPassword);
            return "id";
        } else {
            return "일치하는 정보가 없습니다.";
        }
    }
}