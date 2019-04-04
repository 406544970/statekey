package com.lh.starkey.model;

/**
 * @author 梁昊
 * @create 2019-04-04 15:29
 * @function
 * @editLog
 */
public class OilBase  {
    /**
     *  主键
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public Float getBaseAttribute1() {
        return baseAttribute1;
    }

    public void setBaseAttribute1(Float baseAttribute1) {
        this.baseAttribute1 = baseAttribute1;
    }

    public Float getBaseAttribute2() {
        return baseAttribute2;
    }

    public void setBaseAttribute2(Float baseAttribute2) {
        this.baseAttribute2 = baseAttribute2;
    }

    public String getBaseRemark() {
        return baseRemark;
    }

    public void setBaseRemark(String baseRemark) {
        this.baseRemark = baseRemark;
    }

    /**
     * 油库名称
     */
    private String baseName;
    /**
     * 油库类型
     */
    private Integer baseType;
    /**
     * 油库属性一
     */
    private Float baseAttribute1;
    /**
     * 油库属性二
     */
    private Float baseAttribute2;
    /**
     * 油库备注
     */
    private String baseRemark;
}
