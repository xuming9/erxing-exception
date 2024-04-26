package cn.xuming.erxing.lessif.core;

import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 徐铭
 * @date: 2024-04-26 10:39:39
 **/
public class ErxingWarningAssertTest extends TestCase {

    public void testIsPositive() {
        System.out.println(CusWarning.ITEM_NOT_EXISTS.isPositive(null, "123"));
        System.out.println(CusWarning.ITEM_NOT_EXISTS.isPositive(0, "123"));
        System.out.println(CusWarning.ITEM_NOT_EXISTS.isPositive(1, "123"));
        System.out.println(CusWarning.ITEM_NOT_EXISTS.isPositive(-1, "123"));
        System.out.println(CusWarning.ITEM_NOT_EXISTS.isPositive(Double.valueOf(0.001), "123"));

    }

    @AllArgsConstructor
    @Getter
    public enum CusWarning implements ErxingWarningAssert {

        ACCOUNT_DB_NOT_EXISTS("W10001","账套编码(不区分大小写)【{0}】不存在"),
        ITEM_NOT_EXISTS("W10002","商品编码(不区分大小写)【{0}】不存在"),
        ;

        private final String code;
        private final String message;

    }
}