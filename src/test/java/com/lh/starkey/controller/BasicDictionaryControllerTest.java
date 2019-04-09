package com.lh.starkey.controller;

import com.google.gson.Gson;
import com.lh.starkey.DemoApplication;
import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dto.OrderAll;
import com.lh.starkey.model.*;
import com.lh.starkey.myenum.LogicEnum;
import com.lh.starkey.unit.ComToolClass;
import com.lh.starkey.unit.ListToolClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Test
    public void getAllLinkList() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
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
        CommonQuery commonQuery = new CommonQuery(1, 1000, condList.toString(), sortList.toString());
        List<OrderAll> allLinkList = oilUseController.getAllLinkList(commonQuery);
//      开始做好关联前的准备工作
        List<OilUse> oilUses = oilUseController.selectAllOilUse();
        String mainOilUseKeyId = "useId";
        String linkOilUseKeyId = "id";
        List<OilUse> oilUsesFilter = ListToolClass.getFilterList(allLinkList, mainOilUseKeyId, OrderAll.class, Integer.class
                , oilUses, linkOilUseKeyId, OilUse.class);

        List<Oil> oils = oilUseController.selectAllOil();
        String mainOilKeyId = "oilId";
        String linkOilKeyId = linkOilUseKeyId;
        List<Oil> oilsFilter = ListToolClass.getFilterList(allLinkList, mainOilKeyId, OrderAll.class, Integer.class
                , oils, linkOilKeyId, Oil.class);

        List<OilBase> oilBases = oilUseController.selectAllOilBase();
        String mainOilBaseKeyId = "oilBaseId";
        String linkOilBaseKeyId = linkOilUseKeyId;
        List<OilBase> oilBasesFilter = ListToolClass.getFilterList(allLinkList, mainOilBaseKeyId, OrderAll.class, Integer.class
                , oilBases, linkOilBaseKeyId, OilBase.class);

        String outMessage = null;
        System.out.println("Begin:" + new Date());
        System.out.println(gson.toJson(allLinkList));
        for (OrderAll orderAll : allLinkList
                ) {
            if (outMessage == null)
                outMessage = ListToolClass.getValueByKeyName(orderAll, oilUsesFilter, mainOilUseKeyId, linkOilUseKeyId);
            if (outMessage == null)
                outMessage = ListToolClass.getValueByKeyName(orderAll, oilsFilter, mainOilKeyId, linkOilKeyId);
            if (outMessage == null)
                outMessage = ListToolClass.getValueByKeyName(orderAll, oilBasesFilter, mainOilBaseKeyId, linkOilBaseKeyId);
        }
        System.out.println(gson.toJson(allLinkList));
        System.out.println("End:" + new Date());
        System.out.println(outMessage);
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