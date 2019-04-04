package com.lh.starkey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dao.DictionaryMapper;
import com.lh.starkey.dao.DictionaryNameMapper;
import com.lh.starkey.model.Dictionary;
import com.lh.starkey.model.DictionaryName;
import com.lh.starkey.model.ResponseHashResult;
import com.lh.starkey.model.ResponseStatus;
import com.lh.starkey.myenum.ResultCode;
import com.lh.starkey.service.DictionaryNameService;
import com.lh.starkey.unit.QueryWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.service.impl
 * @date:2019/4/1
 */
@Service
public class DictionaryNameServiceImpl implements DictionaryNameService<DictionaryName> {
    @Autowired
    DictionaryNameMapper dictionaryNameMapper;

    @Override
    public ResponseHashResult selectByPageMultTable(CommonQuery commonQuery) {
        ResponseHashResult result;
        Integer pageNo = commonQuery.getPageNo();
        Integer pageSize = commonQuery.getPageSize();
        String condList = commonQuery.getCondList();
        String sortList = commonQuery.getSortList();
        IPage<DictionaryName> page = new Page<>(pageNo.longValue(),pageSize.longValue());
        QueryWrapper<DictionaryName> queryWrapper = (QueryWrapper<DictionaryName>) QueryWrapperUtil.fillQueryWrapper(condList, sortList);
        IPage<DictionaryName> dictionaryIPage = dictionaryNameMapper.selectPage(page,queryWrapper);

        HashMap<String, Object> temp = new HashMap<>();
        temp.put("list",dictionaryIPage.getRecords());
        temp.put("pageNo",dictionaryIPage.getCurrent());
        temp.put("total",dictionaryIPage.getTotal());
        result = new ResponseHashResult(new ResponseStatus(ResultCode.SUCCESS), temp);
        return result;
    }

    @Override
    public List<DictionaryName> selectList(CommonQuery commonQuery) {
        Integer pageNo = commonQuery.getPageNo();
        Integer pageSize = commonQuery.getPageSize();
        String condList = commonQuery.getCondList();
        String sortList = commonQuery.getSortList();
        IPage<DictionaryName> page = new Page<>(pageNo.longValue(),pageSize.longValue());
        QueryWrapper<DictionaryName> queryWrapper = (QueryWrapper<DictionaryName>) QueryWrapperUtil.fillQueryWrapper(condList, sortList);

        List<DictionaryName> dictionaryNames = dictionaryNameMapper.selectList(queryWrapper);
        return dictionaryNames;
    }


    @Override
    public List<DictionaryName> selectAll() {
        return null;
    }

}
