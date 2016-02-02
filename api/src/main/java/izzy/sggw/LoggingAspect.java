package izzy.sggw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Around("execution( * izzy.sggw.films.* (..) )")
    public Object callDurationAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        String argList = Arrays.toString(args);
        System.out.println(signature.getDeclaringTypeName() +
                "." + signature.getName() + "(" + argList + ") started");
        long s = System.nanoTime();
        Object proceed = pjp.proceed(args);
        long e = System.nanoTime();
        System.out.println(signature.getDeclaringTypeName() +
                "." + signature.getName() + "(" + argList + ") ended after " +
                ((double)(e-s)/1000000) + " ms");
        return proceed;
    }
}