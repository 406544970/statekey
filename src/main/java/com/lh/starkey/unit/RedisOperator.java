package com.lh.starkey.unit;

import com.lh.starkey.myenum.DictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.unit
 * @date:2019/4/3
 */
@Component
public class RedisOperator {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    private String nameSpace;

    public String getNameSpace() {
        return nameSpace;
    }

    public void saveToRedis(String key, String value) {
        key = nameSpace + ":" + key;
        this.saveString(key, value);
    }

    public String getFromRedis(String key) {
        return getString(key);
    }

    public List<String> getFromRedis(List<String> keys) {
        List<String> list = new ArrayList<>();
        if (keys != null && keys.size() > 0)
            for (String row : keys
                    ) {
                list.add(row);
            }
        return list;
    }

    public void deletel(List<String> keys) {
        if (keys != null && keys.size() > 0)
            for (String row : keys
                    ) {
                this.delete(nameSpace + ":" + row);
            }
    }

    public void deletel(String key) {
        key = nameSpace + ":" + key;
        this.delete(key);
    }

    /**
     * 增加或修改指定键值
     *
     * @param key   键
     * @param value 值
     */
    private void saveString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
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
