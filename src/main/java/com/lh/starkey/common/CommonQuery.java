package com.lh.starkey.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.common
 * @date:2019/3/29
 */

@ApiModel(description = "通用查询接口入参类")
@Data
public final class CommonQuery {
    @ApiModelProperty(value = "当前页码")
    private Integer pageNo;//主键集合
    @ApiModelProperty(value = "记录数")
    private Integer pageSize;
    @ApiModelProperty(value = "条件列表")
    private String condList;
    @ApiModelProperty(value = "排序列表")
    private String sortList;//

    /**
     * 默认不分页构造函数内部方法，当前页数为10000
     * @param condList Where条件
     * @param sortList Order By
     */
    private void _CommonQuery(String condList, String sortList) {
        setPageNo(1);
        setPageSize(10);
        setCondList(condList);
        setSortList(sortList);
    }

    /**
     * 全信息构造函数
     * @param pageNo   当前页数
     * @param pageSize 记录数
     * @param condList Where条件
     * @param sortList Order By
     */
    public CommonQuery(int pageNo, int pageSize, String condList, String sortList) {
        _CommonQuery(condList, sortList);
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    /**
     * 默认第一页构造函数
     * @param condList Where条件
     * @param sortList Order By
     */
    public CommonQuery(String condList, String sortList) {
        _CommonQuery(condList, sortList);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCondList() {
        return condList;
    }

    public void setCondList(String condList) {
        this.condList = condList;
    }

    public String getSortList() {
        return sortList;
    }

    public void setSortList(String sortList) {
        this.sortList = sortList;
    }

}
