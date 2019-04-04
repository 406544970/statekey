package com.lh.starkey.model;

import java.util.Date;

/**
 * @author 梁昊
 * @create 2019-04-04 12:30
 * @function
 * @editLog
 */
public class Order  {

    public Integer getPkno() {
        return pkno;
    }

    public void setPkno(Integer pkno) {
        this.pkno = pkno;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public Integer getOilId() {
        return oilId;
    }

    public void setOilId(Integer oilId) {
        this.oilId = oilId;
    }

    public String getOilName() {
        return oilName;
    }

    public void setOilName(String oilName) {
        this.oilName = oilName;
    }

    public Integer getOilBaseId() {
        return oilBaseId;
    }

    public void setOilBaseId(Integer oilBaseId) {
        this.oilBaseId = oilBaseId;
    }

    public String getOilBaseName() {
        return oilBaseName;
    }

    public void setOilBaseName(String oilBaseName) {
        this.oilBaseName = oilBaseName;
    }

    public Float getOilCount() {
        return oilCount;
    }

    public void setOilCount(Float oilCount) {
        this.oilCount = oilCount;
    }

    /**
     * 标识
     */
    public Integer pkno;

    /**
     * 创建时间
     */
    public Date ctime;
    /**
     * 修改时间
     */
    public Date mtime;
    /**
     * 创建人
     */
    public String cuser;
    /**
     * 用户主键
     */
    public Integer useId;
    /**
     * 用户姓名
     */
    public String useName;
    /**
     *  油品主键
     */
    public Integer oilId;
    /**
     * 油品名称
     */
    public String oilName;
    /**
     * 油库主键
     */
    public Integer oilBaseId;
    /**
     *  油库名称
     */
    public String oilBaseName;
    /**
     *  出油数量
     */
    public Float oilCount;
}
