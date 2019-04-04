package com.lh.starkey.model;

import com.lh.starkey.myenum.LogicEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.model
 * @date:2019/3/29
 */
public final class ConditionModel {
    public ConditionModel() {
        super();
        setLogicOperator(LogicEnum.Equal);
        this.conditionValue = new ArrayList<>();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.conditionValue.clear();
    }

    private String fieldName;
    private LogicEnum logicOperator;
    private List<String> conditionValue;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(List<String> conditionValue) {
        this.conditionValue = conditionValue;
    }

    public LogicEnum getLogicOperator() {
        return logicOperator;
    }

    public void setLogicOperator(LogicEnum logicOperator) {
        this.logicOperator = logicOperator;
    }
}
