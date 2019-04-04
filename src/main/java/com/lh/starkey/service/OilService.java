package com.lh.starkey.service;

import com.lh.starkey.model.Oil;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:20
 * @function
 * @editLog
 */
public interface OilService {
    /**
     * 得到所有Oil对象列表
     *
     * @return 得到所有Oil对象列表
     */
    List<Oil> selectAllOil();
}
