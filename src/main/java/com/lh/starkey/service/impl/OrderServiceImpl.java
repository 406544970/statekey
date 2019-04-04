package com.lh.starkey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dao.OrderMapper;
import com.lh.starkey.model.Dictionary;
import com.lh.starkey.model.Order;
import com.lh.starkey.model.ResponseHashResult;
import com.lh.starkey.service.OrderService;
import com.lh.starkey.unit.QueryWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 姊佹槉
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.service.impl
 * @date:2019/4/4
 */
@Service
public class OrderServiceImpl implements OrderService<Order> {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResponseHashResult selectByPage(CommonQuery commonQuery) {
        return null;
    }

    @Override
    public List<Order> selectList(CommonQuery commonQuery) {
        Integer pageNo = commonQuery.getPageNo();
        Integer pageSize = commonQuery.getPageSize();
        String condList = commonQuery.getCondList();
        String sortList = commonQuery.getSortList();
        IPage<Order> page = new Page<>(pageNo.longValue(),pageSize.longValue());
        QueryWrapper<Order> queryWrapper = (QueryWrapper<Order>) QueryWrapperUtil.fillQueryWrapper(condList, sortList);
        IPage<Order> dictionaryList = orderMapper.selectPage(page,queryWrapper);
        return dictionaryList.getRecords();
    }

    @Override
    public List<Order> selectAll() {
        return null;
    }
}
