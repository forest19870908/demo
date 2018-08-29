package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Aspect
@Configuration
public class AspectService {
    /*
     * 定义一个切入点
     */
    // @Pointcut("execution (* findById*(..))")
    @Pointcut("execution(* com.example.demo.service.StudentService.*(..))")
    public void excudeService(){}
    /*
     * 通过连接点切入
     */
    @Before("execution(* findById*(..)) && args(id,..)")
    public void twiceAsOld1(Integer id){
        System.err.println ("切面before执行了。。。。id=="+id);

    }

    @Before("excudeService()")
    public void twiceAsOld3(){
        System.err.println ("切面before执行了。。。。id==");

    }

    @Around("excudeService()")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint){
        System.err.println ("切面执行了。。。。"+thisJoinPoint.getArgs()[1]);
        try {
            Map thing = (Map) thisJoinPoint.proceed ();
            thing.put ("name",thing.get ("name") + "=========");
            return thing;
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        return null;
    }
}
