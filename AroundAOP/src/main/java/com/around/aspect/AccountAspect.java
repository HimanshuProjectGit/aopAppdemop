package com.around.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountAspect {
	
	@Around("execution(* com.around.account.Account.deposit(..))")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		
		Object [] obj = jp.getArgs();
		List<Object> List = Arrays.asList(obj);
		String m = jp.getSignature().getName();
		System.out.println("Around advice before method : "+m+" and arguments: "+List);
		
		Object rvalue = jp.proceed();
		
		System.out.println("Method aroundAdvice after invocation of :"+m);
		System.out.println(rvalue+" is returned by "+m);
		
		if(rvalue==null || rvalue=="") {
			rvalue="failure";
			System.out.println("Return value is changed to failure by advice");
		}
		
	}

}
