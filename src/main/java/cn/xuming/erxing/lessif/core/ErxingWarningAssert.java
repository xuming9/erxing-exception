package cn.xuming.erxing.core;


import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author: 徐铭
 * @Date: 2024-03-26 00:09
 */
public interface ErxingWarningAssert {

    Logger logger = Logger.getLogger(cn.xuming.erxing.core.ErxingWarningAssert.class.getName());

    /**
     * 获取异常状态码
     *
     * @return code
     */
    String getCode();

    /**
     * 获取异常提示信息
     *
     * @return message
     */
    String getMessage();

    /**
     * 创建异常
     *
     * @param args 提示信息
     */
    default void print(Object... args) {
        logger.warning(MessageFormat.format(getMessage(), args));
    }

    /**
     * <p>断言表达式<code>expression</code>为TRUE。如果对象<code>expression</code>为FALSE，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param expression 待判断对象
     * @return true验证通过, false验证不通过
     */
    default boolean isTrue(boolean expression, Object... args) {
        if (!expression) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言表达式<code>expression</code>为FALSE。如果对象<code>expression</code>为TRUE，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param expression 待判断对象
     * @return true验证通过, false验证不通过
     */
    default boolean isFalse(boolean expression, Object... args) {
        if (expression) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言对象<code>obj</code>为空。如果对象<code>obj</code>非空，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj  待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNull(Object obj, Object... args) {
        if (obj != null) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj  待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNotNull(Object obj, Object... args) {
        if (obj == null) {
            print(args);
            return false;
        }
        return true;
    }


    /**
     * <p>断言字符串<code>text</code>非空字符串。如果字符串<code>text<</code>为空或空字符串，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text 待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNotEmpty(String text, Object... args) {
        if (text == null || text.length() == 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言数组<code>array</code>非空数组。如果数组<code>array</code>为空数组，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param array 待判断数组
     * @param args  message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNotEmpty(Object[] array, Object... args) {
        if (array == null || array.length == 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言集合<code>collection</code>非空集合。如果集合<code>collection</code>为空集合，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param collection 待判断集合
     * @param args       message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNotEmpty(Collection<?> collection, Object... args) {
        if (collection == null || collection.size() == 0) {
            print(args);
            return false;
        }
        return true;
    }


    /**
     * <p>断言Map<code>map</code>非空Map。如果Map<code>map</code>为空Map，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param map  待判断Map
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isNotEmpty(Map<?, ?> map, Object... args) {
        if (map == null || map.size() == 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串<code>text</code>为空或空字符串。如果字符串<code>text<</code>为非空字符串，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text 待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isEmpty(String text, Object... args) {
        if (text != null && text.length() > 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言数组<code>array</code>为空数组。如果数组<code>array</code>为非空数组，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param array 待判断数组
     * @param args  message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isEmpty(Object[] array, Object... args) {
        if (array != null && array.length > 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言集合<code>collection</code>为空集合。如果集合<code>collection</code>为非空集合，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param collection 待判断集合
     * @param args       message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isEmpty(Collection<?> collection, Object... args) {
        if (collection != null && collection.size() > 0) {
            print(args);
            return false;
        }
        return true;
    }


    /**
     * <p>断言Map<code>map</code>为空Map。如果Map<code>map</code>为非空Map，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param map  待判断Map
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean isEmpty(Map<?, ?> map, Object... args) {
        if (map != null && map.size() > 0) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串<code>text</code>包含<code>subText</code>。如果字符串<code>text</code>不包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>subText</code>任意一个字符串为NULL，则直接判定不包含,抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text    待判断对象
     * @param subText 待判断对象
     * @param args    message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean contain(String text, String subText, Object... args) {
        if (text == null || subText == null || !text.contains(subText)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串<code>text</code>不包含<code>subText</code>。如果字符串<code>text</code>包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>subText</code>任意一个字符串为NULL，则直接判定不包含,断言通过
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text    待判断对象
     * @param subText 待判断对象
     * @param args    message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean notContain(String text, String subText, Object... args) {
        if (text != null && subText != null && text.contains(subText)) {
            print(args);
            return false;
        }
        return true;
    }


    /**
     * <p>断言字符串数组<code>array</code>包含<code>subText</code>。如果字符串数组<code>array</code>不包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>array</code>任意一个字符串为NULL，则直接判定不包含,抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text  待判断对象
     * @param array 待判断对象
     * @param args  message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean contain(String text, String[] array, Object... args) {
        if (text == null || array == null || !Arrays.asList(array).contains(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串数组<code>array</code>不包含<code>subText</code>。如果字符串数组<code>array</code>包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>array</code>任意一个字符串为NULL，则直接判定不包含
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text  待判断对象
     * @param array 待判断对象
     * @param args  message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean notContain(String text, String[] array, Object... args) {
        if (text != null && array != null && Arrays.asList(array).contains(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串数组<code>collection</code>包含<code>subText</code>。如果字符串数组<code>collection</code>不包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>collection</code>任意一个字符串为NULL，则直接判定不包含,抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text       待判断对象
     * @param collection 待判断对象
     * @param args       message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean contain(String text, Collection<String> collection, Object... args) {
        if (text == null || collection == null || !collection.contains(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言字符串数组<code>collection</code>不包含<code>subText</code>。如果字符串数组<code>collection</code>包含<code>subText</code>，则抛出异常
     * <code>text</code>,<code>collection</code>任意一个字符串为NULL，则直接判定不包含
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text       待判断对象
     * @param collection 待判断对象
     * @param args       message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean notContain(String text, Collection<String> collection, Object... args) {
        if (text != null && collection != null && collection.contains(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言MAP<code>map</code>中KEY包含<code>text</code>。如果字符串数组<code>map</code>不包含<code>text</code>，则抛出异常
     * <code>text</code>,<code>map</code>任意一个为NULL，则直接判定不包含,抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text 待判断对象
     * @param map  待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean contain(String text, Map<String, ?> map, Object... args) {
        if (text == null || map == null || !map.containsKey(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言MAP<code>map</code>中KEY不包含<code>text</code>。如果字符串数组<code>map</code>包含<code>text</code>，则抛出异常
     * <code>text</code>,<code>map</code>任意一个为NULL，则直接判定不包含
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param text 待判断对象
     * @param map  待判断对象
     * @param args message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean notContain(String text, Map<String, ?> map, Object... args) {
        if (text != null && map != null && map.containsKey(text)) {
            print(args);
            return false;
        }
        return true;
    }

    /**
     * <p>断言数组<code>array</code>所有元素都不为null。如果数组<code>array</code>自身或者有任意元素为null，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param array 待判断对象
     * @param args  message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean noNullElements(Object[] array, Object... args) {
        if (array == null) {
            print(args);
            return false;
        } else {
            for (Object o : array) {
                if (o == null) {
                    print(args);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * <p>断言集合<code>collection</code>所有元素都不为null。如果集合<code>collection</code>自身或者有任意元素为null，则抛出异常
     * <p>异常信息<code>args</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param collection 待判断对象
     * @param args       message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default boolean noNullElements(Collection<?> collection, Object... args) {
        if (collection == null) {
            print(args);
            return false;
        } else {
            for (Object o : collection) {
                if (o == null) {
                    print(args);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 断言比较2个对象,要求source和target必须已实现 {@link Comparable} 接口
     *
     * @param source 需要比较的值,一般为变量
     * @param target 比较值或者标准值,一般为常量或者固定值
     * @param csEnum 期望断言结果
     * @param args   message占位符对应的参数列表
     * @return true验证通过, false验证不通过
     */
    default <T extends Comparable<T>> boolean compare(T source, T target, CompareSymbolEnum csEnum, Object... args) {
        if (source == null) {
            print(args);
            return false;
        } else {
            switch (csEnum) {
                case EQ:
                    if (source.compareTo(target) != 0) {
                        print(args);
                        return false;
                    }
                    return true;
                case GE:
                    if (source.compareTo(target) < 0) {
                        print(args);
                        return false;
                    }
                    return true;
                case GT:
                    if (source.compareTo(target) <= 0) {
                        print(args);
                        return false;
                    }
                    return true;
                case LE:
                    if (source.compareTo(target) > 0) {
                        print(args);
                        return false;
                    }
                    return true;
                case LT:
                    if (source.compareTo(target) >= 0) {
                        print(args);
                        return false;
                    }
                    return true;
                case NE:
                    if (source.compareTo(target) == 0) {
                        print(args);
                        return false;
                    }
                    return true;
                default:
                    return true;
            }
        }
    }

    /**
     * 比较符号枚举<p>
     * - EQ 等于     =<p>
     * - NE 不等于   <><p>
     * - GT 大于     ><p>
     * - GE 大于等于 >=<p>
     * - LT 小于     <<p>
     * - LE 小于等于 <=
     */
    enum CompareSymbolEnum {
        LT, LE, EQ, NE, GE, GT;
    }

}
