package com.lh.starkey.dao;

import com.lh.starkey.model.OilBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:29
 * @function
 * @editLog
 */
@Mapper
public interface OilBaseMapper {
    /**
     * 查询所有油库信息
     *
     * @return 得到所有油库对象列表
     */
    List<OilBase> selectAllOilBase();
}
