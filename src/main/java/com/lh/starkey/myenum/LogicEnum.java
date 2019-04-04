package com.lh.starkey.myenum;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.myenum
 * @date:2019/3/29
 */
public enum LogicEnum {
    /**
     * 等于
     */
    Equal("EQ"),
    /**
     * 大于
     */
    Greater("GT"),
    /**
     * 小于
     */
    Less("LT"),
    /**
     * Between
     */
    Between("bt");

    private String text;

    LogicEnum(String _context) {
        this.text = _context;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
