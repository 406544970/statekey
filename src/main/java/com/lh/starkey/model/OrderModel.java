package com.lh.starkey.model;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.model
 * @date:2019/3/29
 */
public final class OrderModel {
    public OrderModel() {
        super();
        this.ascSign = true;
        this.orderSign = "ASC";
    }

    public String getOrderFieldName() {
        return orderFieldName;
    }

    public void setOrderFieldName(String orderFieldName) {
        this.orderFieldName = orderFieldName;
    }

    public boolean isAscSign() {
        return ascSign;
    }

    public void setAscSign(boolean ascSign) {
        this.ascSign = ascSign;
        this.orderSign = ascSign ? "ASC" : "DESC";
    }

    public String getOrderSign() {
        return orderSign;
    }

    private String orderFieldName;
    private boolean ascSign;
    private String orderSign;
}
