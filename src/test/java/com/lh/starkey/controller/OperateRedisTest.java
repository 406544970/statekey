package com.lh.starkey.controller;

import com.google.gson.Gson;
import com.lh.starkey.DemoApplication;
import com.lh.starkey.model.Model;
import com.lh.starkey.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.statekey.demo.controller
 * @date:2019/3/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class OperateRedisTest {
    @Autowired
    OperateRedis operateRedis;

    @Autowired
    Gson gson;

    @Test
    public void getVersion() {
        System.out.println(operateRedis.getVersion());
    }

    @Test
    public void getOilByList() {
        final int iniCount = 120;
        List<String> key = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            key.add("A" + (iniCount + i));
        }
        for (Model model : operateRedis.getOilByList(key)) {
            System.out.println(String.format("Key:%s,Value:%s;", model.getKey(), model.getValue()));
        }
    }

    @Test
    public void saveOil() {
        operateRedis.saveOil("A123", "A123Value lianghao add，please don't delete, thank you.");
        operateRedis.saveOil("A124", "A124Value lianghao add，please don't delete, thank you.");
        operateRedis.saveOil("A125", "A125Value lianghao add，please don't delete, thank you.");
        operateRedis.saveOil("A126", "A126Value lianghao add，please don't delete, thank you.");
        operateRedis.saveOil("A127", "A127Value lianghao add，please don't delete, thank you.");
        User user = new User();
        user.setId((long) 10);
        user.setName("name10");
        user.setPwd("pass10");
        user.setRoleId((long) 12);
        user.setUpdateTime(new Date());
        user.setCreateTime(user.getUpdateTime());
        operateRedis.saveOil("A128", gson.toJson(user));
    }

    @Test
    public void deleteOil() {
        operateRedis.deleteOil("A125");
    }

    @Test
    public void getOil() {
    }

    @Test
    public void getOilByList1() {
    }

    @Test
    public void saveCar() {
    }

    @Test
    public void getCar() {
    }

    @Test
    public void deleteCar() {
    }

    @Test
    public void saveUse() {
    }

    @Test
    public void getUse() {
    }

    @Test
    public void deleteUse() {
    }
}