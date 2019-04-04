package com.lh.starkey.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.model
 * @date:2019/3/29
 */
@Data
@ToString
@ApiModel(description = "字符串返回类")
public class ResponseStringResult {

    @ApiModelProperty(value = "封装字符串数据")
    private String data;//封装数据
    @ApiModelProperty(value = "封装响应状态")
    private ResponseStatus status;//封装响应状态

    public ResponseStringResult() {
    }

    public ResponseStringResult(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStringResult(ResponseStatus status, String data) {
        this.data = data;
        this.status = status;
    }
}