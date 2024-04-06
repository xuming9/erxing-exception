package cn.xuming.erxing.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.MessageFormat;

/**
 * @Author: 徐铭
 * @Date: 2024-03-26 00:09
 */

@AllArgsConstructor
@Data
public class ErxingException extends RuntimeException{

    /**
     * 具体异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String message;

    public ErxingException(ErxingExceptionAssertEnum exceptionAssertEnum, Object... objs){
        super(MessageFormat.format(exceptionAssertEnum.getMessage(),objs));
        this.code=exceptionAssertEnum.getCode();
        this.message=MessageFormat.format(exceptionAssertEnum.getMessage(),objs);

    }

}
