package workshop.spring.boot.workshopspringboot.log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect2 {

	@Around("execution(* workshop.spring.boot.workshopspringboot.controllers..*(..))")
	@Order(4)
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("The method " + joinPoint.getSignature().getName() + "() begins with "
				+ Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			System.out.println("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
			return result;
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}

}
