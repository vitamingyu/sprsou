package pack.resource;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	public static SqlSessionFactory sessionFactory; // DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.

	static {
		String resource = "pack/resource/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();

			// MyBatis annotation 사용할 경우 추가 코드. 배열로 줌
			Class[] mappers = { SqlMapperInter.class }; // 뒤에 ,주고 .class로 계속 줄 수 있음
			for (Class m : mappers) { // 지금은 매퍼인터 1개 줬지만 뒤에 더 올 수 있으니 for로 여러개 받을거임, 타입은 Class로 받음
				// SqlSessionFactory에 mapper를 등록
				sessionFactory.getConfiguration().addMapper(m); // 점이 두개 나왔다(?) 뭐 포함관계
			}
		} catch (Exception e) {
			System.out.println("SqlMapConfig 오류 : " + e);
		}
	}

	public static SqlSessionFactory getSqlSession() {
		return sessionFactory;
	}
}