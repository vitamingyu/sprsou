package etc;

import java.io.FileWriter;

public class OutDataImpl implements OutDataInter {
	private String filePath;
	
	public void setFilePath(String filePath) {  // 경로명 및 파일명은 외부에서 주입받음
		this.filePath = filePath;
	}
		
	@Override
	public void outFile(String msg) {
		// 메세지를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);
			writer.close();
			System.out.println("파일 저장 성공");
		} catch (Exception e) {
			System.out.println("outFile err : "+e.getMessage());
		}
	}

}
