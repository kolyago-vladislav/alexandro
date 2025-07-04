package by.pilipuk.user.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    @After("execution(* by.pilipuk.user.service.UserService.get*(..))")
    public void logBeforeGetMethod() {
        System.out.println("Log: getMethod was called");
    }
}