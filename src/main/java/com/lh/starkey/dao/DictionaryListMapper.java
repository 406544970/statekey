package com.lh.starkey.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lh.starkey.dto.DictionaryList;
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
public interface DictionaryListMapper extends BaseMapper<DictionaryList> {
    List<DictionaryList> selectAll();
}
