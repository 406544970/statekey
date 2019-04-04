package com.lh.starkey.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.model
 * @date:2019/3/29
 */
@ApiModel(description = "通用删除接口入参类")
@Data
public class CommonDelete {

    @ApiModelProperty(value = "主键json数组")
    private String pknos;//主键集合



}
