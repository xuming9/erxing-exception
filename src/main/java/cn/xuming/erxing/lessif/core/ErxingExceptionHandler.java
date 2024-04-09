package cn.xuming.erxing.lessif.core;

import cn.xuming.erxing.lessif.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 仅处理customerException
 *
 * @author : 徐铭
 * @since: 2024-03-26 00:09
 */
@Slf4j
@RestControllerAdvice
public class ErxingExceptionHandler {

    /**
     * 监听到自定义异常,则自动返回错误响应
     * @param e 自定义异常
     * @return 通用错误响应
     */
    @ExceptionHandler(ErxingException.class)
    public R<Void> handleCustomException(ErxingException e) {
        log.error(e.getMessage(), e);
        return R.fail(e.getCode(), e.getMessage());
    }

}
