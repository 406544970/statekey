package com.lh.starkey.model;

import java.util.Date;

/**
 * @author 梁昊
 * @create 2019-04-04 12:30
 * @function
 * @editLog
 */
public class Order  {

    /**
     * 标识
     */
    private Integer pkno;

    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
    /**
     * 创建人
     */
    private String cuser;
    /**
     * 用户主键
     */
    private Integer useId;
    /**
     * 用户姓名
     */
    private String useName;
    /**
     *  油品主键
     */
    private Integer oilId;
    /**
     * 油品名称
     */
    private String oilName;
    /**
     * 油库主键
     */
    private Integer oilBaseId;
    /**
     *  油库名称
     */
    private String oilBaseName;

    public Integer getPkno() {
        return pkno;
    }

    public Order setPkno(Integer pkno) {
        this.pkno = pkno;
        return this;
    }

    public Date getCtime() {
        return ctime;
    }

    public Order setCtime(Date ctime) {
        this.ctime = ctime;
        return this;
    }

    public Date getMtime() {
        return mtime;
    }

    public Order setMtime(Date mtime) {
        this.mtime = mtime;
        return this;
    }

    public String getCuser() {
        return cuser;
    }

    public Order setCuser(String cuser) {
        this.cuser = cuser;
        return this;
    }

    public Integer getUseId() {
        return useId;
    }

    public Order setUseId(Integer useId) {
        this.useId = useId;
        return this;
    }

    public String getUseName() {
        return useName;
    }

    public Order setUseName(String useName) {
        this.useName = useName;
        return this;
    }

    public Integer getOilId() {
        return oilId;
    }

    public Order setOilId(Integer oilId) {
        this.oilId = oilId;
        return this;
    }

    public String getOilName() {
        return oilName;
    }

    public Order setOilName(String oilName) {
        this.oilName = oilName;
        return this;
    }

    public Integer getOilBaseId() {
        return oilBaseId;
    }

    public Order setOilBaseId(Integer oilBaseId) {
        this.oilBaseId = oilBaseId;
        return this;
    }

    public String getOilBaseName() {
        return oilBaseName;
    }

    public Order setOilBaseName(String oilBaseName) {
        this.oilBaseName = oilBaseName;
        return this;
    }

    public Float getOilCount() {
        return oilCount;
    }

    public Order setOilCount(Float oilCount) {
        this.oilCount = oilCount;
        return this;
    }

    /**
     *  出油数量
     */
    private Float oilCount;
}
