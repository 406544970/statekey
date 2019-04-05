package com.lh.starkey.dto;

import com.lh.starkey.model.Order;
import java.util.Date;

/**
 * @author: 姊佹槉
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.model
 * @date:2019/4/4
 */
public class OrderAll extends Order {
    @Override
    public Integer getPkno() {
        return super.getPkno();
    }

    @Override
    public Order setPkno(Integer pkno) {
        return super.setPkno(pkno);
    }

    @Override
    public Date getCtime() {
        return super.getCtime();
    }

    @Override
    public Order setCtime(Date ctime) {
        return super.setCtime(ctime);
    }

    @Override
    public Date getMtime() {
        return super.getMtime();
    }

    @Override
    public Order setMtime(Date mtime) {
        return super.setMtime(mtime);
    }

    @Override
    public String getCuser() {
        return super.getCuser();
    }

    @Override
    public Order setCuser(String cuser) {
        return super.setCuser(cuser);
    }

    @Override
    public Integer getUseId() {
        return super.getUseId();
    }

    @Override
    public Order setUseId(Integer useId) {
        return super.setUseId(useId);
    }

    @Override
    public String getUseName() {
        return super.getUseName();
    }

    @Override
    public Order setUseName(String useName) {
        return super.setUseName(useName);
    }

    @Override
    public Integer getOilId() {
        return super.getOilId();
    }

    @Override
    public Order setOilId(Integer oilId) {
        return super.setOilId(oilId);
    }

    @Override
    public String getOilName() {
        return super.getOilName();
    }

    @Override
    public Order setOilName(String oilName) {
        return super.setOilName(oilName);
    }

    @Override
    public Integer getOilBaseId() {
        return super.getOilBaseId();
    }

    @Override
    public Order setOilBaseId(Integer oilBaseId) {
        return super.setOilBaseId(oilBaseId);
    }

    @Override
    public String getOilBaseName() {
        return super.getOilBaseName();
    }

    @Override
    public Order setOilBaseName(String oilBaseName) {
        return super.setOilBaseName(oilBaseName);
    }

    @Override
    public Float getOilCount() {
        return super.getOilCount();
    }

    @Override
    public Order setOilCount(Float oilCount) {
        return super.setOilCount(oilCount);
    }

    public Integer getUseType() {
        return useType;
    }

    public OrderAll setUseType(Integer useType) {
        this.useType = useType;
        return this;
    }

    public Float getUseAttribute1() {
        return useAttribute1;
    }

    public OrderAll setUseAttribute1(Float useAttribute1) {
        this.useAttribute1 = useAttribute1;
        return this;
    }

    public Float getUseAttribute2() {
        return useAttribute2;
    }

    public OrderAll setUseAttribute2(Float useAttribute2) {
        this.useAttribute2 = useAttribute2;
        return this;
    }

    public String getUseRemark() {
        return useRemark;
    }

    public OrderAll setUseRemark(String useRemark) {
        this.useRemark = useRemark;
        return this;
    }

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
    /**
     *  油品类型
     */
    private Integer oilType;
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

    public Integer getOilType() {
        return oilType;
    }

    public OrderAll setOilType(Integer oilType) {
        this.oilType = oilType;
        return this;
    }

    public Float getOilAttribute1() {
        return oilAttribute1;
    }

    public OrderAll setOilAttribute1(Float oilAttribute1) {
        this.oilAttribute1 = oilAttribute1;
        return this;
    }

    public Float getOilAttribute2() {
        return oilAttribute2;
    }

    public OrderAll setOilAttribute2(Float oilAttribute2) {
        this.oilAttribute2 = oilAttribute2;
        return this;
    }

    public String getOilRemark() {
        return oilRemark;
    }

    public OrderAll setOilRemark(String oilRemark) {
        this.oilRemark = oilRemark;
        return this;
    }


    public Integer getBaseType() {
        return baseType;
    }

    public OrderAll setBaseType(Integer baseType) {
        this.baseType = baseType;
        return this;
    }

    public Float getBaseAttribute1() {
        return baseAttribute1;
    }

    public OrderAll setBaseAttribute1(Float baseAttribute1) {
        this.baseAttribute1 = baseAttribute1;
        return this;
    }

    public Float getBaseAttribute2() {
        return baseAttribute2;
    }

    public OrderAll setBaseAttribute2(Float baseAttribute2) {
        this.baseAttribute2 = baseAttribute2;
        return this;
    }

    public String getBaseRemark() {
        return baseRemark;
    }

    public OrderAll setBaseRemark(String baseRemark) {
        this.baseRemark = baseRemark;
        return this;
    }
}
