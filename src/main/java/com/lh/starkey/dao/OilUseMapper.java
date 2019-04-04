package com.lh.starkey.dao;

import com.lh.starkey.model.OilUse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 14:56
 * @function
 * @editLog
 */
@Mapper
public interface OilUseMapper {
    /**
     * 主键查询OilUse对象列表
     *
     * @return 主键查询OilUse对象列表
     */
    List<OilUse> selectAllOilUse();
}
