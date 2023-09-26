package pack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import pack.model.MappingInterface;
import pack.model.ServiceImpl;
import pack.model.VO;

@Controller
public class FileController {
	@Autowired
	ServiceImpl serviceImpl;
	
	@GetMapping("upload")
    public String abc(@ModelAttribute("vo") VO vo) {
        return "uploadform";
    }
	
    @PostMapping("upload")
    public String submit(@ModelAttribute("vo") VO vo, Model model) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        // 업로드될 파일 검사
        MultipartFile file = vo.getUploadFile();
        String filename = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "err"; // 에러 발생 (파일을 선택하지 않은 경우)시 수행
        }

        try {
            inputStream = file.getInputStream();
            File newFile = new File("C:\\work\\sprsou\\team_file_ex\\src\\main\\resources\\static\\upload\\" + filename); // 파일 경로 수정
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            vo.setFileName(filename); // 파일명 설정
            serviceImpl.saveFile(vo); 
        } catch (Exception e) {
            System.out.println("file submit err: " + e);
            return "err";
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e2) {
                // 예외 처리
            }
        }
        model.addAttribute("filename", filename);
        return "uploadfile";
    }
}