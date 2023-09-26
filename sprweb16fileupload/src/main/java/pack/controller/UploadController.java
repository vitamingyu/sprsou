package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UploadController {
	
   @GetMapping("upload")
   public String abc(UploadFile uploadFile) {
      return "uploadform";
   }
   
   @PostMapping("upload")
   public String submit(UploadFile uploadFile, Model model, BindingResult result) { // BindingResult - 오류검사
      InputStream inputStream = null;
      OutputStream outputStream = null;
      
      // 업로드될 파일 검사
      MultipartFile file = uploadFile.getFile();
      String filename = file.getOriginalFilename();
      if(result.hasErrors()) {
         return "err"; // 에러 발생 (파일을 선택하지 않은 경우)시 수행
      }
      
      try {
         inputStream = file.getInputStream();
         File newFile = new File("C:/work/sprsou/sprweb16fileupload/src/main/resources/static/upload/" + filename); // 절대경로로 찍기
         if(!newFile.exists()) {
            newFile.createNewFile();
         }
         outputStream = new FileOutputStream(newFile);
         int read = 0;
         byte[] bytes = new byte[1024];
         // -1 끝을 의미
         while((read = inputStream.read(bytes))!=-1) {
            outputStream.write(bytes,0,read);  // 업로드된 파일의 데이터가 읽혀서 새로운 파일(newFile)에 저장되는 과정
         }
      } catch (Exception e) {
         System.out.println("file submit err : "+e);
         return "err";
      } finally {
         try {
            inputStream.close();
            outputStream.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      model.addAttribute("filename",filename);
      return "uploadfile";
   }
   
}
