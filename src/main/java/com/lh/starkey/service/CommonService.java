package com.lh.starkey.service;

import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.service
 * @date:2019/3/29
 */
public interface CommonService <T>{
    /**
     * 查询数据库所有SupplierInfo列表
     * @return SupplierInfo列表
     */
    List<T> selectAll();

//    /**
//     * 同步数据至redis
//     * @param data 新增或编辑的data
//     */
//    void syncData(T data);
//
//    /**
//     * 删除redis中的一条数据
//     * @param hashKey 键对应的hash的key
//     */
//    void deleteData(String hashKey);
//
//    /**
//     * 查询数据库
//     * @param pkno 主键
//     * @return 一条查询结构
//     */
//    T selectById(Long pkno);
//
//    /**
//     * 查询数据库
//     * @param pknos 主键
//     * @return 一条查询结构
//     */
//    List<T> selectByIds(List<Long> pknos);
//
//    /**
//     * redis查询数据
//     * @param hashKey
//     * @return
//     */
//    T selectData(String hashKey);

}
