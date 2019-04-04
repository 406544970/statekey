package com.lh.starkey.myenum;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.statekey.demo.myenum
 * @date:2019/3/28
 */
public enum DictionaryType {
    IS_OIL("oil"),
    IS_CAR("car"),
    IS_USE("use");

    private String text;

    DictionaryType(String _context) {
        this.text = _context;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
