package pack.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class VO {
	private String fileName;
	private MultipartFile uploadFile;
}
