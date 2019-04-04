package com.lh.starkey.service;

import com.lh.starkey.model.OilBase;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:29
 * @function
 * @editLog
 */
public interface OilBaseService {
    /**
     * 查询所有油库信息
     *
     * @return 得到所有油库对象列表
     */
    List<OilBase> selectAllOilBase();
}

