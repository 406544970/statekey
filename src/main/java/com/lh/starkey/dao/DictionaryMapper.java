package com.lh.starkey.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.model.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lilinwei
 */
@Mapper
@Repository
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    /**
     * 查询全部
     * @return Dictionary列表
     */
    List<Dictionary> selectAll();
}
