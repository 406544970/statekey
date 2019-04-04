package com.lh.starkey.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.model
 * @date:2019/3/29
 */
@Data
@ToString
@ApiModel(description = "Hash返回类")
public class ResponseHashResult {

    @ApiModelProperty(value = "封装Map数据")
    private Map<String,Object> data;//封装数据
    @ApiModelProperty(value = "封装响应状态")
    private ResponseStatus status;//封装响应状态

    public ResponseHashResult() {

    }

    public ResponseHashResult(ResponseStatus status) {
        this.status = status;
    }

    public ResponseHashResult(ResponseStatus status, Map data) {
        this.data = data;
        this.status = status;
    }
}
