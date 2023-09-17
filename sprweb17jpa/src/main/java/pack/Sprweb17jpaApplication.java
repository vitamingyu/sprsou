package pack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb17jpaApplication {

   public static void main(String[] args) {
      SpringApplication.run(Sprweb17jpaApplication.class, args).getBean(Sprweb17jpaApplication.class).myExecute();
   }
   
   @Autowired
   ProductCrudRepository repository;
   
   private void myExecute() {
      System.out.println("독립 프로그램으로 실행");
      
       //insertData();
      
      //deleteData(); 
      
      selectData(); 
      
   }
   
   private void insertData() {
      //   엔티티 생성
      ProductVo productVo = new ProductVo();
      productVo.setSang("차카니");
      productVo.setSu(60);
      productVo.setDan(500);
      productVo = repository.save(productVo);      // insert
      System.out.println("등록 데이터 : " + productVo);
      
      productVo.setCode(5);
      productVo.setSang("색연필");
      productVo.setSu(10);
      productVo.setDan(5500);
      productVo = repository.save(productVo);      // update
      System.out.println("수정 데이터 : " + productVo);
      
   }
   private void deleteData() {
      repository.deleteById(6);
      
   }
   
   
   private void selectData() {
      System.out.println("전체레코드 읽기");
      List<ProductVo> list = repository.findAll();
      
      for(ProductVo vo:list) {
         System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
      }
      
//      System.out.println("특정 레코드 한 개 읽기");
//      ProductVo vo = repository.findById(1).get();
//      System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
      
      System.out.println("-------JQLP:(Java Persistence Query Language)--------");
      List<ProductVo> list2 = repository.findAllData();
      for(ProductVo vo:list2) {
         System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
      }
      ProductVo vo2 = repository.findByCode(2);
      
      System.out.println();
      List<ProductVo> list3 = repository.findData(2,"우산");
      for(ProductVo vo4:list3) {
         System.out.println(vo4.getCode() + " " + vo4.getSang() + " " + vo4.getSu() + " " + vo4.getDan());
      }
   }
   
   
}