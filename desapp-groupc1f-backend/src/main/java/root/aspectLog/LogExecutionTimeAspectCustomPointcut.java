package root.aspectLog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LogExecutionTimeAspectCustomPointcut  {

	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectCustomPointcut.class);
	
	/// CUSTOM  POINTCUT////
	@Pointcut("execution(* root.controller.AccountController.*(..))")
	public void methodsStarterServicePointcut() {
	}

}