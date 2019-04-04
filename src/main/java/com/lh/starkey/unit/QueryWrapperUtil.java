package com.lh.starkey.unit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import java.util.Collection;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.unit
 * @date:2019/3/29
 */
public class QueryWrapperUtil {
    public static QueryWrapper<?> fillQueryWrapper(String condList, String sortList) {
        QueryWrapper<?> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(condList)) {
            // 解析条件参数字符串
            JSONArray condArray = JSONObject.parseArray(condList);
            for (int i = 0; i < condArray.size(); i ++) {
                // 将驼峰属性转换为数据库下划线形式
                String field = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, ((JSONArray) condArray.get(i)).get(0).toString());
                Object operator = ((JSONArray) condArray.get(i)).get(1).toString().toUpperCase();
                if (operator.equals("EQ")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.eq(field, fieldValue);
                } else if (operator.equals("NE")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.ne(field, fieldValue);
                } else if (operator.equals("GT")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.gt(field, fieldValue);
                } else if (operator.equals("LT")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.lt(field, fieldValue);
                } else if (operator.equals("GE")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.ge(field, fieldValue);
                } else if (operator.equals("LE")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.le(field, fieldValue);
                } else if (operator.equals("BT")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    JSONArray array = (JSONArray) fieldValue;
                    queryWrapper.between(field, array.getString(0), array.getString(1));
                } else if (operator.equals("NB")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    JSONArray array = (JSONArray) fieldValue;
                    queryWrapper.notBetween(field, array.getString(0), array.getString(1));
                } else if (operator.equals("IN")) {
                    Collection<?> fieldValue = (Collection<?>) ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.in(field, fieldValue);
                } else if (operator.equals("NI")) {
                    Collection<?> fieldValue = (Collection<?>) ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.notIn(field, fieldValue);
                } else if (operator.equals("LK")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.like(field, fieldValue);
                } else if (operator.equals("NL")) {
                    Object fieldValue = ((JSONArray) condArray.get(i)).get(2);
                    queryWrapper.notLike(field, fieldValue);
                } else if (operator.equals("NU")) {
                    queryWrapper.isNull(field);
                }
            }
        }
        if (StringUtils.isNotEmpty(sortList)) {
            // 解析排序参数字符串
            JSONArray sortArray = JSONObject.parseArray(sortList);
            for (int i = 0; i < sortArray.size(); i ++) {
                // 将驼峰属性转换为数据库下划线形式
                String field = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, ((JSONArray) sortArray.get(i)).get(0).toString());
                Object order = ((JSONArray) sortArray.get(i)).get(1);
                if (order.equals("ASC")) {
                    queryWrapper.orderByAsc(field);
                }else if (order.equals("DESC")){
                    queryWrapper.orderByDesc(field);
                }
            }
        }
        return queryWrapper;
    }

}
