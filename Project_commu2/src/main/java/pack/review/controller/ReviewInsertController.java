package pack.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pack.review.model.ReviewDao;

@Controller
public class ReviewInsertController {
	@Autowired
	private ReviewDao reviewDao;

	@GetMapping("reviewinsert")
	public String insert(@RequestParam("productid") int productid, Model model) {
		model.addAttribute("productid", productid);
		return "reviewinsert";
	}

	@PostMapping("reviewinsert")
	public String insertProcess (@RequestParam("productid") int productid, ReviewBean bean, BindingResult result, Model model) throws Exception {
		bean.setReviewdate();
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    
	    // 이름중복을 방지하기 위해 난수 발생시킴
	    String uuid=UUID.randomUUID().toString(); 
        MultipartFile file = bean.getRimagePath();
        String filename = uuid+file.getOriginalFilename();
	    
	    // 유효성 검사 결과 확인
	    if (result.hasErrors()) {
	        return "err";
	    }

	    try {
	        inputStream = file.getInputStream();
	        File newFile = new File("C:\\work\\sprsou\\team_project\\team_pro\\src\\main\\resources\\static\\upload\\" + filename);
	        if (!newFile.exists()) {
	            newFile.createNewFile();
	        }
	        outputStream = new FileOutputStream(newFile);
	        int read = 0;
	        byte[] bytes = new byte[1024];  // -1 끝을 의미
	        while ((read = inputStream.read(bytes)) != -1) {
	            outputStream.write(bytes, 0, read);
	        }
	        bean.setProductid(productid);
	        bean.setRimage(filename);
	    } catch (Exception e) {
	        System.out.println("file submit err : " + e);
	    } finally {
	        try {
	            inputStream.close();
	            outputStream.close();
	        } catch (Exception e2) {
	            // 예외 처리 코드
	        }
	    }
	   
        
       
        boolean b =  reviewDao.reviewinsert(bean);
        if(b) {
        	return "redirect:reviewlist";
        } else {
        	return "redirect:error";
        }
	  
	    
	}

}
