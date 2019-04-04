package com.lh.starkey.service;

import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.model.DictionaryName;
import com.lh.starkey.model.ResponseHashResult;

import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.service
 * @date:2019/4/1
 */
public interface DictionaryNameService <T> extends CommonService<T> {
//    List<Dictionary> selectDatas(String hashKey);
//
//    ResponseStringResult geCreate(CommonEdit commonEdit);
//
//    ResponseStringResult geDelete(CommonDelete commonDelete);
//
//    ResponseStringResult geUpdate(CommonEdit commonEdit);

    /**
     * @param commonQuery 前端传入规定的结构体
     * @return 返回单表查询，且分页
     */
    ResponseHashResult selectByPageMultTable(CommonQuery commonQuery);

    List<DictionaryName> selectList(CommonQuery commonQuery);
}
