package cn.xuming.erxing.lessif.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @Author: 徐铭
 * @Date: 2024-03-26 00:09
 */
@AllArgsConstructor
@Getter
@SuppressWarnings("all")
public enum ErxingExceptionAssertEnum implements ErxingExceptionAssert {


    USER_NOT_EXISTS("E1011", "登陆账号【{0}】不存在"),

    ;

    private final String code;
    private final String message;

}
