package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectClass {
	@Autowired    // 클래스 '포함'관계. 약결합
	private SecurityClass class1;
	
	@Around("execution(public String businessMsg()) or execution(public String processMsg())")
	public Object aspProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		class1.mySecurity();
		
		Object object = joinPoint.proceed();    // 핵심 메소드 수행
		
		return object;    //object이 null이되면 핵심메소드 수행 안함
	}
}
