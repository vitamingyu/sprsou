package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import pack.resource.SqlMapConfig;

@Repository // 가독성을 위해서

// Spring 프레임워크에서 지원하는 JdbcDaoSupport룰 사용
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectList() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;

		try {
			//MyBatis xml 일 때
			//list = session.selectList("selectDataAll");
			
			//MyBatis Annotation 일 때
			SqlMapperInter inter = (SqlMapperInter)session.getMapper(SqlMapperInter.class);
			list = inter.selectList();
		} catch (Exception e) {
			System.out.println("selectList err : " + e);
		} finally {
			if (session != null) session.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectList2() {
		SqlSession session2 = factory.openSession();
		List<JikwonDto> list2 = null;

		try {
			//list2 = session2.selectList("selectDataBuser");
			
			//MyBatis Annotation 일 때
			SqlMapperInter inter = (SqlMapperInter)session2.getMapper(SqlMapperInter.class);
			list2 = inter.selectList2();
		} catch (Exception e) {
			System.out.println("selectList2 err : " + e);
		} finally {
			if (session2 != null) session2.close();
		}
		return list2;
	}
	
	@Override
	public List<JikwonDto> selectList3() {
		SqlSession session3 = factory.openSession();
		List<JikwonDto> list3 = null;

		try {
			//list3 = session3.selectList("selectMaxPay");
			
			//MyBatis Annotation 일 때
			SqlMapperInter inter = (SqlMapperInter)session3.getMapper(SqlMapperInter.class);
			list3 = inter.selectList3();
		} catch (Exception e) {
			System.out.println("selectList3 err : " + e);
		} finally {
			if (session3 != null) session3.close();
		}
		return list3;
	}
}