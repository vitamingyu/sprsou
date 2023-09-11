package pack;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.bridge.CountingMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.resource.SqlMapConfig;
import pack.resource.SqlMapperInter;

@Service
public class BusinessImpl implements BusinessInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Autowired
	private BusinessInter businessInter;

	@Override
	public void dataShow() {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) businessInter.selectDataAll();
		System.out.println("\n직원자료");
		
		for (JikwonDto s : list) {
		System.out.println(s.getJikwon_no()+" " + s.getJikwon_name() +" " +s.getBuser_name() + " " +s.getIb());
		}
	}

	@Override
	public void buser() {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) businessInter.buserMax();
		System.out.println("\n부서별 최대 급여자");
		for (JikwonDto s : list) {
			System.out.println(s.getBuser_name()+" : "+ s.getJikwon_name() + "("+s.getJikwon_pay() +")");
		}
	}
	
	@Override
	public void count() {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) businessInter.countIn();
		System.out.println("\n부서별 인원수");
		
		for (JikwonDto s : list) {
			System.out.println(s.getBuser_name()+" "+ s.getInwon());
		}
		
	}
	@Override
	public List<JikwonDto> countIn() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			// xml일 때 : list = session.selectList("selectDataAll");
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = inter.countIn();
		} catch (Exception e) {
			System.out.println("countIn err : " + e.getMessage());
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = inter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e.getMessage());
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return list;

	}
	
	@Override
	public List<JikwonDto> buserMax() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = inter.buserMax();
		} catch (Exception e) {
			System.out.println("buserMax err : " + e.getMessage());
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return list;

	}
	
	
	

}
