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
@ApiModel(description = "通用新增、更新接口入参类")
@Data
public class CommonEdit {

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @ApiModelProperty(value = "实体类json格式数据")
    private String data;//

}
