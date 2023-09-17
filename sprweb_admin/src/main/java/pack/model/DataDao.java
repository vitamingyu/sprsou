package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FormBean;

@Repository
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private DataMapperInterface dataMapper;

	public DataDao() {
		
	}
	
	// User 정보 출력 및 검색하기
	public List<memberDto> getDataAll(){
		List<memberDto> list = dataMapper.selectAll();  // sql문이 실행
		logger.info("datas : " + list.size() + "개");
		return list;
	}
	
	public List<memberDto> getDataSearch(FormBean bean){   // 검색용
		List<memberDto> list = (List<memberDto>)dataMapper.selectSearch(bean); // sql문이 실행
		logger.info("search datas : " + list.size() + "개");
		return list;
	}
	
	public List<memberDto> search(FormBean bean){
		List<memberDto> slist = dataMapper.selectSearch(bean);
		return slist;
	}
	
	// Supplier 정보 출력 및 검색하기
	public List<SupplierDto> getDataAll2(){
		List<SupplierDto> list2 = dataMapper.selectAll2();
		logger.info("datas2 : " + list2.size() + "개");
		return list2;
	}

}
