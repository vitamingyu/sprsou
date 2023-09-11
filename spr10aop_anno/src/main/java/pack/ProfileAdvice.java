package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 관심사항을 담은 클래스 : Aspect를 담은 advice용 클래스
@Component
@Aspect
public class ProfileAdvice {
	
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectAll())")
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		//String methodName = joinPoint.getSignature().toString();
		String methodName = joinPoint.getSignature().getName();  // 핵심로직 특정 메소드 이름 얻기
		System.out.println(methodName + "시작 전 작업....");
		
		Object object = joinPoint.proceed(); // 핵심로직 특정 메소드가 수행
		
		System.out.println(methodName + "처리 후 작업 .....");
		return object;
	}
}
