package cn.xuming.erxing.lessif.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.MessageFormat;

/**
 * 自定义异常
 *
 * @author : 徐铭
 * @since: 2024-03-26 00:09
 */

@AllArgsConstructor
@Data
public class ErxingException extends RuntimeException {

    /**
     * 具体异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String message;

    public ErxingException(ErxingExceptionAssert exceptionAssertEnum, Object... objs) {
        super(MessageFormat.format(exceptionAssertEnum.getMessage(), objs));
        this.code = exceptionAssertEnum.getCode();
        this.message = MessageFormat.format(exceptionAssertEnum.getMessage(), objs);

    }

}
