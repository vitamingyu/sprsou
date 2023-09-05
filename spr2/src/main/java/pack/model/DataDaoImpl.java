package pack.model;

public class DataDaoImpl implements DataDao{
	//지금 파라미터 없는 생성자가 생략되어 있는 상태임
	
	@Override
	public void selectData() {
		System.out.println("db와 연결한 후 selectData 수행"); //여기서 DB의 자료를 읽음 그리고 비즈니스서비스로 보냄
	}
}
