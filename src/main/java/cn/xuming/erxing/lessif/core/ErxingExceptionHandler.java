package cn.xuming.erxing.lessif.core;

import cn.xuming.erxing.lessif.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 仅处理customerException
 *
 * @Author: 徐铭
 * @Date: 2024-03-26 00:09
 */
@Slf4j
@RestControllerAdvice
public class ErxingExceptionHandler {

    /**
     * 自定义异常
     */
    @ExceptionHandler(ErxingException.class)
    public R<Void> handleCustomException(ErxingException e) {
        log.error(e.getMessage(), e);
        return R.fail(e.getCode(), e.getMessage());
    }

}
