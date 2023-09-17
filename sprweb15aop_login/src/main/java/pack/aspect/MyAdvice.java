package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Aspect  // aop먹일려면 이거 필수
public class MyAdvice {
	@Autowired
	private LoginClass loginClass;
	
	@Around("execution(* jikProcess*(..))") // (..)파라미터 0개 이상. jikprocess수행중에 아래if문 읽는거
	private Object aopProcess(ProceedingJoinPoint joinPoint)throws Throwable{
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for(Object obj:joinPoint.getArgs()) {
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest)obj;    // 이순간 request가 null에서 벗어남
			}
			if(obj instanceof HttpServletResponse) {
				response = (HttpServletResponse)obj;    // 이순간 request가 null에서 벗어남
			}

		}
		if(loginClass.loginCheck(request, response)) {
			return null;
		}
			
		Object object = joinPoint.proceed();
		return object;
	}
}
