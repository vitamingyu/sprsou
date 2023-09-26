package pack.commu.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import pack.commu.model.CommuDao;
import pack.commu.model.CommuDto;

@Controller
public class UpdateController {
	@Autowired
	private CommuDao comDao;

	@GetMapping("update")
	public String edit(@RequestParam("num") String num, @RequestParam("page") String page, Model model) {
		// 수정 대상 자료 읽기
		CommuDto dto = comDao.detail(num);

		model.addAttribute("list", dto);
		model.addAttribute("page", page);

		return "update";
	}

	@PostMapping("update")
	public String editProcess(CommuBean bean, @RequestParam("page") String page, BindingResult result,
			UploadFile uploadfile, HttpSession session, Model model, @RequestParam("filename") String orifilename) {
		// 비밀번호 확인을 위해 DB에서 비밀번호 읽기
		// String pass = comDao.selectPass(Integer.toString(bean.getNum()));
		// System.out.println("bean.getPass(입력한 비번) :" + bean.getPass() + " pass(서버비번) :
		// " + pass);
		// bean.getPass().equals(pass) || bean.getPass()==pass
		// 업로드 파일 초기화
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// 업로드될 파일 검사
		MultipartFile file = uploadfile.getFile();

		if (result.hasErrors()) {
			return "err"; // 에러 발생 (파일을 선택하지 않은 경우)시 수행
		}

		if (file != null && !file.isEmpty()) {
			if (true) { // 아이디비교
				String uuid = UUID.randomUUID().toString();
				String filename = uuid + file.getOriginalFilename();

				try {
					inputStream = file.getInputStream();
					File newFile = new File(
							"C:\\Users\\MINGYU\\Desktop\\Project_commu2\\src\\main\\resources\\static\\upload\\"
									+ filename); // 절대경로로 찍기
					if (!newFile.exists()) {
						newFile.createNewFile();
					}
					outputStream = new FileOutputStream(newFile);
					int read = 0;
					byte[] bytes = new byte[1024];
					// -1 끝을 의미
					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read); // 업로드된 파일의 데이터가 읽혀서 새로운 파일(newFile)에 저장되는 과정
					}
					bean.setFilename(filename); // 파일명 bean에 저장
					// 파일 업로드 과정 끝

					boolean b = comDao.update(bean);
					if (b) {
						// 상세보기로 이동
						model.addAttribute("msg", "수정성공");
						return "redirect:detail?num=" + bean.getNum() + "&page=" + page;
					} else {
						return "redirect:err";
					}
				} catch (Exception e) {
					System.out.println("file submit err : " + e);
					return "err";
				} finally {
					try {
						inputStream.close();
						outputStream.close();
					} catch (Exception e2) {
					}
				}

			} else {
				model.addAttribute("msg", "아이디 불일치~");
				return "redirect:commu";
			}
		} else { // 파일업로드 안 했을시
			if (true) { // 아이디비교
				bean.setFilename(orifilename);
				boolean b = comDao.update(bean);
				if (b) {
					// 상세보기로 이동
					model.addAttribute("msg", "수정성공");
					return "redirect:detail?num=" + bean.getNum() + "&page=" + page;
				} else {
					return "redirect:err";
				}
			} else {
				model.addAttribute("msg", "아이디 불일치~");
				return "redirect:commu";
			}
		}
	}
}
