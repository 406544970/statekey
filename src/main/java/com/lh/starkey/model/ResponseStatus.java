package com.lh.starkey.model;

import com.lh.starkey.myenum.ResultCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.model
 * @date:2019/3/29
 */
public class ResponseStatus {
    @ApiModelProperty(value = "是否成功")
    private boolean success;//是否成功
    @ApiModelProperty(value = "返回码")
    private Integer code;//返回码，如：200
    @ApiModelProperty(value = "返回信息")
    private String message;//返回信息，如："操作成功"，"操作失败"，"权限不足"
    @ApiModelProperty(value = "返回的token")
    private String new_token;

    public ResponseStatus() {
    }

    public ResponseStatus(ResultCode code) {
        this.success = code.success();
        this.code = code.code();
        this.message = code.message();

    }

    public ResponseStatus(ResultCode code,String new_token) {
        this.success = code.success();
        this.code = code.code();
        this.message = code.message();
        this.new_token = new_token;
    }

    public ResponseStatus(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNew_token() {
        return new_token;
    }

    public void setNew_token(String new_token) {
        this.new_token = new_token;
    }


}
