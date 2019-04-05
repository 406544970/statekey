package com.lh.starkey.unit;

/**
 * @author 梁昊
 * @date 2019/4/5
 * @function 常用工具类
 * @editLog
 */
public class ComToolClass {
    /**
     * 根据属性值，得到get方法名
     *
     * @param key 属性值
     * @return get方法名
     */
    public static String getCamelGetMethodName(String key) {
        return getCamelMethodName(key, true);
    }

    /**
     * 根据属性值，得到set方法名
     *
     * @param key 属性值
     * @return set方法名
     */
    public static String getCamelSetMethodName(String key) {
        return getCamelMethodName(key, false);
    }

    /**
     * 得到驼峰命名法的方法名
     * 如：输入useId，返回:getUseId或setUseId
     *
     * @param key     属性名
     * @param getSign true:get方法；false:set方法
     * @return 驼峰命名法的方法名，若key为null，返回为：null
     */
    private static String getCamelMethodName(String key, boolean getSign) {
        if (key == null || key.trim().isEmpty())
            return null;
        key = key.substring(0, 1).toUpperCase() + key.substring(1);
        return getSign ? String.format("get%s", key) : String.format("set%s", key);
    }

}
