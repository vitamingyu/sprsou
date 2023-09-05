package pack.controller;

import pack.model.DataDao;

public class BusinessServiceImpl implements BusinessService{
   private DataDao dataDao;
   
   public BusinessServiceImpl(){
   }
   
   public BusinessServiceImpl(DataDao dataDao) { //spring이 객체 알아서 만들거임(new)
	   //생성자를 통해 DB 처리용 영역 클래스의 객체 주소를 치환받음(injection)
	   this.dataDao = dataDao;
   }
   
   @Override
   public void selectProcess() {
      // DB와 연결해 자료를 읽는 DataDaoImpl 클래스의 selectData 메소드 실행용
      dataDao.selectData();  
   }
}