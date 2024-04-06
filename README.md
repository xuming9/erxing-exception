# erxing-exception



后续自定义枚举
```java

/**
 *
 * @Author: 徐铭
 * @Date: 2024-03-26 00:09
 */
@AllArgsConstructor
@Getter
public enum CustomExceptionAssertEnum implements ErxingExceptionAssert {
    /**
     * 自定义异常
     */
//    USER_NOT_EXISTS(1011, "登陆账号【{0}】不存在"),
//    USER_EXISTS(1012, "登陆账号【{0}】已存在"),
//    USER_TEL_EXISTS(1013, "登陆账号手机【{0}】已存在"),
//    USERNAME_EMPTY(1014, "登陆账号不能为空"),
//    PASSWORD_EXPIRED(1015, "登陆账号【{0}】密码已过期，请修改密码后登陆"),
//    PASSWORD_EMPTY(1016, "密码不能为空."),
//    PASSWORD_LENGTH(1017, "密码长度不够"),

    ACCOUNT_DB_NOT_EXISTS("E10001","账套编码(不区分大小写)【{0}】不存在"),

    ;

    private final String code;
    private final String message;

}

```


自动注入请求返回值
```java

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class ControllerAspect {

    @Around("execution(* cn.xuming.erp.jdekis.controller.*.*(..)))")
    public Object injectResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        return modifyReturnValue(joinPoint);

    }

    @Around(" @annotation(org.springframework.web.bind.annotation.ExceptionHandler) ")
    public Object injectException(ProceedingJoinPoint joinPoint) throws Throwable {
        return modifyReturnValue(joinPoint);

    }

    private Object modifyReturnValue(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (result instanceof R) {
            R<?> r = (R<?>) result;
            r.setTimestamp(LocalDateTime.now());
            r.setElapsed("耗时:" + DateUtils.betweenTime(start));
            // 修改返回值并返回
            return r;
        }
        return result;
    }
}
```