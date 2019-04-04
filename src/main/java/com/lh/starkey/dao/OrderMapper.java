package com.lh.starkey.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lh.starkey.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 13:37
 * @function
 * @editLog
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 查询所有油订单
     *
     * @return SubTwo方法返回值
     */
    List<Order> selectAll();
}
