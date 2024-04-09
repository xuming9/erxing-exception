package cn.xuming.erxing.lessif;

import cn.xuming.erxing.lessif.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 通用请求响应
 *
 * @author : 徐铭
 * @since: 2024-03-26 00:09
 **/
@Data
@AllArgsConstructor
public class R<T> implements Serializable {

    /**
     * 返回时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime timestamp;
    /**
     * 消耗时间
     */
    private String elapsed;
    /**
     * 接口成功标志
     */
    private boolean success;
    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误提示，用户可阅读
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public R() {
    }

    public R(T data) {
        this.data = data;
    }

    public R(boolean success, String msg, T data) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public R(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public R(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public static R<Void> ok() {
        return new R<>(true, CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MSG);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(true, CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MSG, data);
    }

    /**
     * 如果返回对象为集合，则 msg =请求成功,数据共{0}行
     *
     * @param data 返回集合
     * @param <T> 集合对象
     * @return 请求响应对象
     */
    public static <T> R<List<T>> okList(List<T> data) {
        return R.ok(MessageFormat.format(CommonConstants.SUCCESS_LIST_MSG, (null == data ? 0 : data.size())), data);
    }

    public static <T> R<T> ok(String msg, T data) {
        return new R<>(true, CommonConstants.SUCCESS_CODE, msg, data);
    }

    public static R<Void> fail() {
        return new R<>(false, CommonConstants.ERROR_CODE, CommonConstants.ERROR_MSG);
    }

    public static <T> R<T> fail(T t) {
        return new R<>(false, CommonConstants.ERROR_CODE, CommonConstants.ERROR_MSG, t);
    }

    public static R<Void> fail(String msg) {
        return new R<>(false, CommonConstants.ERROR_MSG, msg);
    }

    public static R<Void> fail(String code, String msg) {
        return new R<>(false, code, msg);
    }
}
