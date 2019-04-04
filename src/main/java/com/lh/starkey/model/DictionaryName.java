package com.lh.starkey.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.model
 * @date:2019/4/1
 */
@Data
@ToString
public class DictionaryName implements Serializable {
    private static final long serialVersionUID = -8491897524000909845L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer pkno;
    private String ctime;
}
