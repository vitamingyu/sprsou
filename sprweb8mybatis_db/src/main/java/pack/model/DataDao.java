package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@Autowired
	private DataMapperInterface dataMapper;
	//HikariCP는 스프링부트에 기본으로 내장되어 있는 JDBC 데이터베이스 커넥션 풀링 프레임워크이다.
	
	public DataDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = dataMapper.selectAll();
		logger.info("datas: " + list.size()+"개");
		return list;
	}
	
	public List<SangpumDto> getDataSearch(String svalue){
		List<SangpumDto> list = dataMapper.selectSearch(svalue);
		logger.info("search datas: " + list.size()+"개");
		return list;
	}
}
