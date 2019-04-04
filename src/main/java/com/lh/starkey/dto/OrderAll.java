package com.lh.starkey.dto;

import com.lh.starkey.model.Order;

/**
 * @author: 姊佹槉
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.model
 * @date:2019/4/4
 */
public class OrderAll extends Order {

    /**
     * 用户类型
     */
    private Integer useType;
    /**
     * 用户属性一
     */
    private Float useAttribute1;
    /**
     * 用户属性二
     */
    private Float useAttribute2;
    /**
     * 用户备注
     */
    private String useRemark;

}
