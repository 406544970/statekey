package com.lh.starkey.service;

import com.lh.starkey.model.OilUse;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 14:56
 * @function
 * @editLog
 */
public interface OilUseService {
    /**
     * 主键查询OilUse对象列表
     *
     * @return 主键查询OilUse对象列表
     */
    List<OilUse> selectAllOilUse();
}
