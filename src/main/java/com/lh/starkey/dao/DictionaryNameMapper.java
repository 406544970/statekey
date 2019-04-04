package com.lh.starkey.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lh.starkey.model.DictionaryName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.dao
 * @date:2019/4/1
 */
@Mapper
@Repository
public interface DictionaryNameMapper extends BaseMapper<DictionaryName> {
    /**
     * 查询全部
     * @return Dictionary列表
     */
    List<DictionaryName> selectAll();

//    @Override
//    IPage<DictionaryName> selectPage(IPage<DictionaryName> iPage, Wrapper<DictionaryName> wrapper);
}
