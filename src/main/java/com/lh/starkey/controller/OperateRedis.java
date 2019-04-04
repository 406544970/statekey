package com.lh.starkey.controller;

import com.lh.starkey.myenum.DictionaryType;
import com.lh.starkey.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.statekey.demo.controller
 * @date:2019/3/28
 */
@RestController
public class OperateRedis {
    @Autowired(required = false)
    StringRedisTemplate stringRedisTemplate;

    /**
     * @return
     */
    @GetMapping("/getVersion")
    public String getVersion() {
        return String.format("Version:%s", "1.0.0.1");
    }

    /**
     * 保存油品信息
     *
     *
     * @param key   ID
     * @param value Name
     */
    @PostMapping("/saveOil")
    public void saveOil(String key, String value) {
        key = DictionaryType.IS_OIL.toString() + ":" + key;
        this.saveString(key, value);
    }

    /**
     * 根据key油品信息
     *
     * @param key ID
     */
    @PostMapping("/getOil")
    public String getOil(String key) {
        key = DictionaryType.IS_OIL.toString() + ":" + key;
        return this.getString(key);
    }

    /**
     * @param key 键列表
     * @return 键值列表
     */
    @PostMapping("/getOilByList")
    public List<Model> getOilByList(List<String> key) {
        return this.getString(DictionaryType.IS_OIL.toString(), key);
    }

    /**
     * 从redis中删除油品
     *
     * @param key ID
     */
    @PostMapping("/deleteOil")
    public void deleteOil(String key) {
        key = DictionaryType.IS_OIL.toString() + ":" + key;
        this.delete(key);
    }

    /**
     * 保存车辆信息
     *
     * @param key   ID
     * @param value Name
     */
    @PostMapping("/saveCar")
    public void saveCar(String key, String value) {
        key = DictionaryType.IS_CAR.toString() + ":" + key;
        this.saveString(key, value);
    }

    /**
     * 根据key获取车辆信息
     *
     * @param key ID
     */
    @PostMapping("/getCar")
    public String getCar(String key) {
        key = DictionaryType.IS_CAR.toString() + ":" + key;
        return this.getString(key);
    }

    /**
     * 从redis中删除车辆
     *
     * @param key ID
     */
    @PostMapping("/deleteCar")
    public void deleteCar(String key) {
        key = DictionaryType.IS_CAR.toString() + ":" + key;
        this.delete(key);
    }

    /**
     * 保存用户信息
     *
     * @param key   ID
     * @param value Name
     */
    @PostMapping("/saveUse")
    public void saveUse(String key, String value) {
        key = DictionaryType.IS_USE.toString() + ":" + key;
        this.saveString(key, value);
    }

    /**
     * 根据key获取用户信息
     *
     * @param key ID
     */
    @PostMapping("/getUse")
    public String getUse(String key) {
        key = DictionaryType.IS_USE.toString() + ":" + key;
        return this.getString(key);
    }

    /**
     * 从redis中删除用户信息
     *
     * @param key ID
     */
    @PostMapping("/deleteUse")
    public void deleteUse(String key) {
        key = DictionaryType.IS_USE.toString() + ":" + key;
        this.delete(key);
    }

    /**
     * 保存指定键值
     *
     * @param key   键
     * @param value 值
     */
    private void saveString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 返回指定命名空间的键值
     *
     * @param nameSpaceName 命名空间
     * @param keyList       键列表
     * @return 键值列表
     */
    private List<Model> getString(String nameSpaceName, List<String> keyList) {
        if ((keyList != null) && (keyList.size() > 0)) {
            for (int i = 0; i < keyList.size() - 1; i++) {
                for (int j = keyList.size() - 1; j > i; j--) {
                    if (keyList.get(j).equals(keyList.get(i))) {
                        keyList.remove(j);
                    }
                }
            }
            List<Model> list = new ArrayList<>();
            for (String e : keyList
                    ) {
                String value = this.getString(nameSpaceName + ":" + e);
                if (value != null) {
                    Model model = new Model();
                    model.setKey(e);
                    model.setValue(value);
                    list.add(model);
                }
            }
            return list;
        } else
            return null;
    }

    private String getString(String key) {
        if (key != null)
            return stringRedisTemplate.opsForValue().get(key);
        else
            return null;
    }

    private void delete(String key) {
        stringRedisTemplate.delete(key);
    }


}
