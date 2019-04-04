package com.lh.starkey.model;

/**
 * @author 梁昊
 * @create 2019-04-04 14:56
 * @function
 * @editLog
 */
public class OilUse  {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public Float getUseAttribute1() {
        return useAttribute1;
    }

    public void setUseAttribute1(Float useAttribute1) {
        this.useAttribute1 = useAttribute1;
    }

    public Float getUseAttribute2() {
        return useAttribute2;
    }

    public void setUseAttribute2(Float useAttribute2) {
        this.useAttribute2 = useAttribute2;
    }

    public String getUseRemark() {
        return useRemark;
    }

    public void setUseRemark(String useRemark) {
        this.useRemark = useRemark;
    }

    /**
     *  主键
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String useName;
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
