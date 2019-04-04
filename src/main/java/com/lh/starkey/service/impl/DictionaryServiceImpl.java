package com.lh.starkey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lh.starkey.dao.DictionaryMapper;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.model.Dictionary;
import com.lh.starkey.model.ResponseHashResult;
import com.lh.starkey.model.ResponseStatus;
import com.lh.starkey.myenum.ResultCode;
import com.lh.starkey.service.DictionaryService;
import com.lh.starkey.unit.QueryWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.service.impl
 * @date:2019/3/29
 */
@Service
public class DictionaryServiceImpl implements DictionaryService<Dictionary> {
    @Autowired
    DictionaryMapper dictionaryMapper;

    /**
     * @param commonQuery 前端传入规定的结构体
     * @return 返回字典数据集，且分页
     */
    @Override
    public ResponseHashResult selectByPage(CommonQuery commonQuery) {
        ResponseHashResult result;
        Integer pageNo = commonQuery.getPageNo();
        Integer pageSize = commonQuery.getPageSize();
        String condList = commonQuery.getCondList();
        String sortList = commonQuery.getSortList();
        IPage<Dictionary> page = new Page<>(pageNo.longValue(),pageSize.longValue());
        QueryWrapper<Dictionary> queryWrapper = (QueryWrapper<Dictionary>) QueryWrapperUtil.fillQueryWrapper(condList, sortList);
        IPage<Dictionary> dictionaryIPage = dictionaryMapper.selectPage(page,queryWrapper);

        HashMap<String, Object> temp = new HashMap<>();
        temp.put("list",dictionaryIPage.getRecords());
        temp.put("pageNo",dictionaryIPage.getCurrent());
        temp.put("total",dictionaryIPage.getTotal());
        result = new ResponseHashResult(new ResponseStatus(ResultCode.SUCCESS), temp);
        return result;
    }

    @Override
    public List<Dictionary> selectList(CommonQuery commonQuery) {
        Integer pageNo = commonQuery.getPageNo();
        Integer pageSize = commonQuery.getPageSize();
        String condList = commonQuery.getCondList();
        String sortList = commonQuery.getSortList();
        IPage<Dictionary> page = new Page<>(pageNo.longValue(),pageSize.longValue());
        QueryWrapper<Dictionary> queryWrapper = (QueryWrapper<Dictionary>) QueryWrapperUtil.fillQueryWrapper(condList, sortList);
        IPage<Dictionary> dictionaryList = dictionaryMapper.selectPage(page,queryWrapper);
        return dictionaryList.getRecords();
    }

    @Override
    public List<Dictionary> selectAll() {
        return null;
    }
}
