package com.lh.starkey.model;

/**
 * @author 梁昊
 * @create 2019-04-04 15:20
 * @function
 * @editLog
 */
public class Oil  {
    /**
     *  主键
     */
    private Integer id;
    /**
     *  油品名称
     */
    private String oilName;
    /**
     *  油品类型
     */
    private Integer oilType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOilName() {
        return oilName;
    }

    public void setOilName(String oilName) {
        this.oilName = oilName;
    }

    public Integer getOilType() {
        return oilType;
    }

    public void setOilType(Integer oilType) {
        this.oilType = oilType;
    }

    public Float getOilAttribute1() {
        return oilAttribute1;
    }

    public void setOilAttribute1(Float oilAttribute1) {
        this.oilAttribute1 = oilAttribute1;
    }

    public Float getOilAttribute2() {
        return oilAttribute2;
    }

    public void setOilAttribute2(Float oilAttribute2) {
        this.oilAttribute2 = oilAttribute2;
    }

    public String getOilRemark() {
        return oilRemark;
    }

    public void setOilRemark(String oilRemark) {
        this.oilRemark = oilRemark;
    }

    /**
     *  油品属性一
     */
    private Float oilAttribute1;
    /**
     *  油品属性二
     */
    private Float oilAttribute2;
    /**
     * 油品备注
     */
    private String oilRemark;
}
