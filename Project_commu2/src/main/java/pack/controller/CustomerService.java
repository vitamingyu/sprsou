package pack.controller;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.member.CustomerDto;
import pack.member.CustomerEntity;
import pack.member.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	// 회원 정보를 데이터베이스에 저장
	public void save(CustomerDto customerDto) {
		CustomerEntity customerEntity = CustomerEntity.tocuCustomerEntity(customerDto);
		customerRepository.save(customerEntity);

	}
	
	// 로그인 성공, 실패 기능 처리
	public CustomerDto login(CustomerDto customerDto) {
		 // 회원이 입력한 이메일로 DB에서 조회를 함
		 // DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
		Optional<CustomerEntity> byCustomerid = customerRepository.findByCustomerid(customerDto.getCustomerid());
		if(byCustomerid.isPresent()) {
			// 조회 결과가 있다
			CustomerEntity customerEntity = byCustomerid.get();
			if(customerEntity.getPasswordhash().equals(customerDto.getPasswordhash())) {
				// 비밀번호 일치
				// entity -> dto로 변환 후 리턴
				CustomerDto dto = CustomerDto.tocusCustomerDto(customerEntity);
				return dto;
			}else {
				// 비밀번호 불일치(로그인 실패)
				return null;
			}
			
		}else {
			// 조회 결과가 없다
			return null;
		}
		
	}
	
	 // 아이디 중복 검사  작업중
	 public String idCheck(String customerid) {
	        Optional<CustomerEntity> byCustomerid = customerRepository.findByCustomerid(customerid);
	        if (byCustomerid.isPresent()) {
	            // 조회결과가 있으니 사용 불가.
	            return null;
	        } else {
	            // 조회결과가 없으니 사용 가능.
	            return "ok";
	        }
	    }
	 // 아이디 중복 검사 
	 public String idCheck1(String customerid) {
		 Optional<CustomerEntity> byCustomerid = customerRepository.findByCustomerid(customerid);
		 if (byCustomerid.isPresent()) {
			 // 조회결과가 있으니 사용 불가.
			 return null;
		 } else {
			 // 조회결과가 없으니 사용 가능.
			 return "ok";
		 }
	 }

	 // 휴대전화 중복 검사 
	 public String phonenumberCheck(String phonenumber) {
		 Optional<CustomerEntity> byPhonenumber = customerRepository.findByPhonenumber(phonenumber);
		 if (byPhonenumber.isPresent()) {
			 // 조회결과가 있으니 사용 불가.
			 return null;
		 } else {
			 // 조회결과가 없으니 사용 가능.
			 return "ok";
		 }
	 }
	 // 휴대전화 중복 검사 
	 public String phonenumberCheck1(String phonenumber) {
		 Optional<CustomerEntity> byPhonenumber = customerRepository.findByPhonenumber(phonenumber);
		 if (byPhonenumber.isPresent()) {
			 // 조회결과가 있으니 사용 불가.
			 return null;
		 } else {
			 // 조회결과가 없으니 사용 가능.
			 return "ok";
		 }
	 }
	 
	
	// 이름과 휴대전화번호로 아이디를 찾는 메서드
	 public String findIdByNameAndPhonenumber(String customername, String phonenumber) {
	     CustomerEntity memberEntity = customerRepository.findByCustomernameAndPhonenumber(customername, phonenumber);
	     if (memberEntity != null) {
	         return memberEntity.getCustomerid();
	     }
	     return null;
	 }
	 

	// 닉네임, 이름, 이메일로 비밀번호를 찾는 메서드
	 public String findPassword(String customerid, String customername, String phonenumber) {
		    CustomerEntity memberEntity = customerRepository.findByCustomeridAndCustomernameAndPhonenumber(customerid, customername, phonenumber);

		    if (memberEntity != null) {
		        return memberEntity.getPasswordhash();
		    } else {
		        return null;
		    }
		}
	
}		

