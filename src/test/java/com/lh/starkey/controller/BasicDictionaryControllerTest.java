package com.lh.starkey.controller;

import com.google.gson.Gson;
import com.lh.starkey.DemoApplication;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dto.OrderAll;
import com.lh.starkey.model.*;
import com.lh.starkey.myenum.LogicEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.controller
 * @date:2019/3/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class BasicDictionaryControllerTest {
    @Autowired
    BasicDictionaryController basicDictionaryController;

    @Autowired
    OilUseController oilUseController;

    @Autowired
    Gson gson;

    @Test
    public void saveAllToRedis() {
        oilUseController.saveAllToRedis();
    }

    @Test
    public void selectAllOilUse() {
        System.out.println(gson.toJson(oilUseController.selectAllOilUse()));
    }

    @Test
    public void selectAllOilBase() {
        System.out.println(gson.toJson(oilUseController.selectAllOilBase()));
    }

    @Test
    public void selectAllOil() {
        System.out.println(gson.toJson(oilUseController.selectAllOil()));
    }

    @Test
    public void getVersion() {
        System.out.println(basicDictionaryController.getVersion());
    }


    private void getCreateConditionary(List<ConditionModel> conditionModels, StringBuilder condList, int index) {
        for (ConditionModel row : conditionModels
                ) {
            if (index > 0)
                condList.append(",");
            condList.append("[");
            condList.append(String.format("\"%s\"", row.getFieldName()));
            condList.append(String.format(",\"%s\"", row.getLogicOperator()));
            if (row.getConditionValue().size() > 1) {
                int count = 0;
                condList.append(",[");
                for (String condRow : row.getConditionValue()
                        ) {
                    if (count > 0)
                        condList.append(",");
//                    condList.append(String.format("%s", condRow));
                    condList.append(String.format("\"%s\"", condRow));
                    count++;
                }
                condList.append("]");
            } else {
                condList.append(String.format(",\"%s\"", row.getConditionValue().get(0)));
            }

            condList.append("]");
            index++;
        }
    }

    private String getMultSortString() {
        List<OrderModel> orderModels = new ArrayList<>();
        OrderModel orderModel = new OrderModel();
        orderModel.setAscSign(true);
        orderModel.setOrderFieldName("id");
        orderModels.add(orderModel);
        StringBuilder sortList = new StringBuilder();
        int index = 0;
        sortList.append("[");
        getCreateSortString(orderModels, sortList, index);
        sortList.append("]");
        return sortList.toString();
    }

    private void getCreateSortString(List<OrderModel> orderModels, StringBuilder sortList, int index) {
        for (OrderModel row : orderModels
                ) {
            if (index > 0)
                sortList.append(",");
            sortList.append("[");
            sortList.append(String.format("\"%s\"", row.getOrderFieldName()));
            sortList.append(String.format(",\"%s\"", row.getOrderSign()));
            sortList.append("]");
            index++;
        }
    }

    private String getSortString() {
        List<OrderModel> orderModels = new ArrayList<>();
        OrderModel orderModel = new OrderModel();
        orderModel.setAscSign(false);
        orderModel.setOrderFieldName("mtime");
        orderModels.add(orderModel);
        StringBuilder sortList = new StringBuilder();
        int index = 0;
        sortList.append("[");
        getCreateSortString(orderModels, sortList, index);
        sortList.append("]");
        return sortList.toString();
    }

    private String getMutlCondictionString() {
        List<String> list = new ArrayList<>();
        List<ConditionModel> conditionModels = new ArrayList<>();
        ConditionModel conditionModel = new ConditionModel();
        conditionModel.setFieldName("main.pkno");
        conditionModel.setLogicOperator(LogicEnum.Less);
        list.add("1000");
        conditionModel.setConditionValue(list);
        conditionModels.add(conditionModel);

        StringBuilder condList = new StringBuilder();
        int index = 0;
        condList.append("[");
        getCreateConditionary(conditionModels, condList, index);
        condList.append("]");
        return condList.toString();
    }

    private String getConditionString() {
        List<String> list = new ArrayList<>();
        List<ConditionModel> conditionModels = new ArrayList<>();
        ConditionModel conditionModel = new ConditionModel();
        conditionModel.setFieldName("pkno");
        conditionModel.setLogicOperator(LogicEnum.Between);
        list.add("4");
        list.add("10000");
        conditionModel.setConditionValue(list);
        conditionModels.add(conditionModel);

        List<String> list2 = new ArrayList<>();
        conditionModel = new ConditionModel();
        conditionModel.setFieldName("cuser");
        list2.add("test");
        conditionModel.setConditionValue(list2);
        conditionModel.setLogicOperator(LogicEnum.Equal);
        conditionModels.add(conditionModel);

        StringBuilder condList = new StringBuilder();
        int index = 0;
        condList.append("[");
        getCreateConditionary(conditionModels, condList, index);
        condList.append("]");
        System.out.println(condList.toString());
        return condList.toString();
    }

    @Test
    public void geList() {
        int pageNo = 1;
        int pageSize = 8;
        CommonQuery commonQuery = new CommonQuery(pageNo, pageSize, getConditionString(), getSortString());
        ResponseHashResult responseHashResult = basicDictionaryController.geList(commonQuery);
        System.out.println(responseHashResult.toString());
    }

    private <M, O> M getKeyAndValueByT(M myObject, O outObject) throws IllegalAccessException {
        List<FieldModel> outObjectFieldAllInfo = getFieldAllInfo(outObject);
        if (outObjectFieldAllInfo != null && outObjectFieldAllInfo.size() > 0) {
            Class myObjectClass = myObject.getClass();
            for (Field field : myObjectClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object o = field.get(myObject);
                if (o == null) {
                    List<FieldModel> collect = outObjectFieldAllInfo.stream()
                            .filter(item -> item.getFieldName().equals(field.getName())
                                    && item.getFieldType().equals(field.getType().toString()))
                            .collect(Collectors.toList());
                    if (collect != null && collect.size() == 1) {
                        field.set(myObject, collect.get(0).getFieldValue());
                    }
                }
            }
        }
        return myObject;
    }

    private List<FieldModel> getFieldAllInfo(Object obj) throws IllegalAccessException {
        List<FieldModel> fieldModelList = new ArrayList<>();
        Class myObjectClass = obj.getClass();
        for (Field field : myObjectClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object o = field.get(obj);
            if (o != null) {
                FieldModel fieldModel = new FieldModel();
                fieldModel.setFieldName(field.getName());
                fieldModel.setFieldType(field.getType().toString());
                fieldModel.setFieldValue(field.get(obj));
                fieldModelList.add(fieldModel);
            }
        }
        return fieldModelList;
    }

    /**
     * 根据原始列表，对指定属性去掉重复
     *
     * @param kList         原列表
     * @param keyMethodName 得到值的方法名，如：getName
     * @param kClass        原列表中对象类
     * @param <T>           返回对象类
     * @param <K>           原列表中对象类
     * @return 去重复后的列表
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private <T, K> List<T> clearRepetition(List<K> kList, String keyMethodName, Class<K> kClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (kList == null || kList.isEmpty())
            return null;
        List<T> list = new ArrayList();
        Method method = kClass.getMethod(keyMethodName);
        for (K row : kList
                ) {
            @SuppressWarnings("unchecked")
            T key = (T) method.invoke(row);
            if (list.indexOf(key) < 0)
                list.add(key);
        }
        return list;
    }

    /**
     * 根据指定属性的值，在原始列表中，找出等于该属性值的对象
     *
     * @param tList         原始列表
     * @param keyMethodName 得到属性值的方法名称
     * @param valueList     值列表
     * @param tClass        原始列表对象类
     * @param <T>           原始类泛型
     * @param <K>           值类泛型
     * @return 返回符合该属性值的原始对象列表
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private <T, K> List<T> getKeyList(List<T> tList, String keyMethodName, List<K> valueList, Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (tList == null || tList.isEmpty())
            return null;
        List<T> list = new ArrayList();
        Method method = tClass.getMethod(keyMethodName);
        for (T row : tList
                ) {
            @SuppressWarnings("unchecked")
            K key = (K) method.invoke(row);
            if (valueList.indexOf(key) < 0)
                list.add(row);
        }
        return list;
    }

    @Test
    public void getAllLinkList() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<String> list = new ArrayList<>();
        List<ConditionModel> conditionModels = new ArrayList<>();
        ConditionModel conditionModel = new ConditionModel();
        conditionModel.setFieldName("pkno");
        conditionModel.setLogicOperator(LogicEnum.Between);
        list.add("1");
        list.add("10000");
        conditionModel.setConditionValue(list);
        conditionModels.add(conditionModel);

        StringBuilder condList = new StringBuilder();
        int index = 0;
        condList.append("[");
        getCreateConditionary(conditionModels, condList, index);
        condList.append("]");

        List<OrderModel> orderModels = new ArrayList<>();
        OrderModel orderModel = new OrderModel();
        orderModel.setAscSign(true);
        orderModel.setOrderFieldName("oil_count");
        orderModels.add(orderModel);
        StringBuilder sortList = new StringBuilder();
        sortList.append("[");
        getCreateSortString(orderModels, sortList, index);
        sortList.append("]");

        CommonQuery commonQuery = new CommonQuery(2, 10, condList.toString(), sortList.toString());
        List<OrderAll> allLinkList = oilUseController.getAllLinkList(commonQuery);
        List<OilUse> oilUses = oilUseController.selectAllOilUse();
//        for (OrderAll orderAll : allLinkList
//                ) {
//            orderAll = getKeyAndValueByT(orderAll, oilUses.get(0));
//        }
        List<Integer> getOilId = clearRepetition(allLinkList, "getOilId", OrderAll.class);
        System.out.println(gson.toJson(getOilId));
    }

    @Test
    public void selectAllOrderList() {
        List<String> list = new ArrayList<>();
        List<ConditionModel> conditionModels = new ArrayList<>();
        ConditionModel conditionModel = new ConditionModel();
        conditionModel.setFieldName("pkno");
        conditionModel.setLogicOperator(LogicEnum.Between);
        list.add("1");
        list.add("10000");
        conditionModel.setConditionValue(list);
        conditionModels.add(conditionModel);

        StringBuilder condList = new StringBuilder();
        int index = 0;
        condList.append("[");
        getCreateConditionary(conditionModels, condList, index);
        condList.append("]");

        List<OrderModel> orderModels = new ArrayList<>();
        OrderModel orderModel = new OrderModel();
        orderModel.setAscSign(true);
        orderModel.setOrderFieldName("oil_count");
        orderModels.add(orderModel);
        StringBuilder sortList = new StringBuilder();
        sortList.append("[");
        getCreateSortString(orderModels, sortList, index);
        sortList.append("]");

        CommonQuery commonQuery = new CommonQuery(2, 10, condList.toString(), sortList.toString());
        List<Order> orderList = basicDictionaryController.selectAllOrderList(commonQuery);
        System.out.println(gson.toJson(orderList));
    }

    @Test
    public void getDictionaryList() {
        int pageNo = 1;
        int pageSize = 7;
        CommonQuery commonQuery = new CommonQuery(pageNo, pageSize, getConditionString(), getSortString());
        List<Dictionary> dictionaryList = basicDictionaryController.getDictionaryList(commonQuery);
        System.out.println(dictionaryList);
    }

    @Test
    public void geDictionaryName() {
        int pageNo = 1;
        int pageSize = 8;
        String c = null;
        String s = getMultSortString();

        CommonQuery commonQuery = new CommonQuery(pageNo, pageSize, c, s);
        ResponseHashResult responseHashResult = basicDictionaryController.geDictionaryName(commonQuery);
        System.out.println(responseHashResult.toString());
    }
}