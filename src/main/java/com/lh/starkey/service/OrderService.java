package com.lh.starkey.service;

import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.model.Dictionary;
import com.lh.starkey.model.Order;
import com.lh.starkey.model.ResponseHashResult;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 13:37
 * @function
 * @editLog
 */
public interface OrderService<T> extends CommonService<T> {
    /**
     * 查询所有油订单
     *
     * @return SubTwo方法返回值
     */
    ResponseHashResult selectByPage(CommonQuery commonQuery);

    List<Order> selectList(CommonQuery commonQuery);
}

