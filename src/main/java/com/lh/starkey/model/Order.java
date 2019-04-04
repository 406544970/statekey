package com.lh.starkey.model;

import java.util.Date;

/**
 * @author 梁昊
 * @create 2019-04-04 12:30
 * @function
 * @editLog
 */
public class Order  {

    protected Integer getPkno() {
        return pkno;
    }

    protected void setPkno(Integer pkno) {
        this.pkno = pkno;
    }

    protected Date getCtime() {
        return ctime;
    }

    protected void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    protected Date getMtime() {
        return mtime;
    }

    protected void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    protected String getCuser() {
        return cuser;
    }

    protected void setCuser(String cuser) {
        this.cuser = cuser;
    }

    protected Integer getUseId() {
        return useId;
    }

    protected void setUseId(Integer useId) {
        this.useId = useId;
    }

    protected String getUseName() {
        return useName;
    }

    protected void setUseName(String useName) {
        this.useName = useName;
    }

    protected Integer getOilId() {
        return oilId;
    }

    protected void setOilId(Integer oilId) {
        this.oilId = oilId;
    }

    protected String getOilName() {
        return oilName;
    }

    protected void setOilName(String oilName) {
        this.oilName = oilName;
    }

    protected Integer getOilBaseId() {
        return oilBaseId;
    }

    protected void setOilBaseId(Integer oilBaseId) {
        this.oilBaseId = oilBaseId;
    }

    protected String getOilBaseName() {
        return oilBaseName;
    }

    protected void setOilBaseName(String oilBaseName) {
        this.oilBaseName = oilBaseName;
    }

    protected Float getOilCount() {
        return oilCount;
    }

    protected void setOilCount(Float oilCount) {
        this.oilCount = oilCount;
    }

    /**
     * 标识
     */
    protected Integer pkno;

    /**
     * 创建时间
     */
    protected Date ctime;
    /**
     * 修改时间
     */
    protected Date mtime;
    /**
     * 创建人
     */
    protected String cuser;
    /**
     * 用户主键
     */
    protected Integer useId;
    /**
     * 用户姓名
     */
    protected String useName;
    /**
     *  油品主键
     */
    protected Integer oilId;
    /**
     * 油品名称
     */
    protected String oilName;
    /**
     * 油库主键
     */
    protected Integer oilBaseId;
    /**
     *  油库名称
     */
    protected String oilBaseName;
    /**
     *  出油数量
     */
    protected Float oilCount;
}
