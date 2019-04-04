package com.lh.starkey.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.lh.starkey.model.Dictionary;
import com.lh.starkey.model.DictionaryName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.dto
 * @date:2019/4/1
 */
@Data
@ToString
public class DictionaryList implements Serializable {
    private static final long serialVersionUID = -8491897524000909345L;

    public Long getPkno() {
        return pkno;
    }

    public void setPkno(Long pkno) {
        this.pkno = pkno;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public List<DictionaryName> getDictionaryNameList() {
        return dictionaryNameList;
    }

    public void setDictionaryNameList(List<DictionaryName> dictionaryNameList) {
        this.dictionaryNameList = dictionaryNameList;
    }

    @TableId
    private Long pkno;
    private Date ctime;
    private List<DictionaryName> dictionaryNameList = new ArrayList<>();
}
