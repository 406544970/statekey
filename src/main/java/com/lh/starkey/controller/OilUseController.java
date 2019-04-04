package com.lh.starkey.controller;

import com.google.gson.Gson;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dto.OrderAll;
import com.lh.starkey.model.*;
import com.lh.starkey.service.OilBaseService;
import com.lh.starkey.service.OilService;
import com.lh.starkey.service.OilUseService;
import com.lh.starkey.service.OrderService;
import com.lh.starkey.unit.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:03
 * @function
 * @editLog
 */
@RestController
public class OilUseController {
    @Autowired
    OrderService orderService;

    @Autowired
    OilUseService oilUseService;

    @Autowired
    OilService oilService;

    @Autowired
    OilBaseService oilBaseService;

    @Autowired
    RedisOperator redisOperator;

    @Autowired
    Gson gson;

    @PostMapping("/getAllLinkList")
    public List<OrderAll> getAllLinkList(CommonQuery commonQuery) {
        List<OrderAll> orderAllList = new ArrayList<>();
        List<Order> selectList = orderService.selectList(commonQuery);
        for (Order order : selectList) {
            OrderAll orderAll = gson.fromJson(gson.toJson(order), OrderAll.class);
            orderAllList.add(orderAll);

        }
        return orderAllList;
    }

    /**
     * 将Use,Oil,OilBase这三张表保存到Redis
     * 键名规则：数据库名 + "_" + 表名
     * 值内容：整条数据的序列化字符串
     */
    @PostMapping("/saveAllToRedis")
    public void saveAllToRedis() {
        String keyName = String.format("%s_basic_%s", "test01", "use");
        redisOperator.setNameSpace(keyName);
        for (OilUse row : oilUseService.selectAllOilUse()) {
            redisOperator.saveToRedis(row.getId().toString(), gson.toJson(row));
        }
        keyName = String.format("%s_basic_%s", "test01", "oil");
        redisOperator.setNameSpace(keyName);
        for (Oil row : oilService.selectAllOil()) {
            redisOperator.saveToRedis(row.getId().toString(), gson.toJson(row));
        }
        keyName = String.format("%s_basic_%s", "test01", "oil_base");
        redisOperator.setNameSpace(keyName);
        for (OilBase row : oilBaseService.selectAllOilBase()) {
            redisOperator.saveToRedis(row.getId().toString(), gson.toJson(row));
        }
    }

    /**
     * 主键查询OilUse对象列表
     *
     * @return 主键查询OilUse对象列表
     */
    @PostMapping("/selectAllOilUse")
    public List<OilUse> selectAllOilUse() {
//      请在这里写逻辑代码
        return oilUseService.selectAllOilUse();
    }

    /**
     * 得到所有Oil对象列表
     *
     * @return 得到所有Oil对象列表
     */
    @PostMapping("/selectAllOil")
    public List<Oil> selectAllOil() {
//      请在这里写逻辑代码
        return oilService.selectAllOil();
    }

    /**
     * 查询所有油库信息
     *
     * @return 得到所有油库对象列表
     */
    @PostMapping("/selectAllOilBase")
    public List<OilBase> selectAllOilBase() {
//      请在这里写逻辑代码
        return oilBaseService.selectAllOilBase();
    }
}

