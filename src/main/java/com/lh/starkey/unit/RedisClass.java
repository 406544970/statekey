package com.lh.starkey.unit;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/6
 * @function
 * @editLog
 */
@Component
public class RedisClass {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    Gson gson;

    private String nameSpace;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public <V> List<V> getValue(List<Object> keyList, Class<V> vClass) {
        if (keyList == null || keyList.isEmpty())
            return null;
        List<V> list = new ArrayList<>();
        for (Object object : keyList
                ) {
            list.add(getValue(object, vClass));
        }
        return list;
    }

    public <K> void deleteKeyAndValue(List<K> keyList) {
        if (keyList != null && !keyList.isEmpty())
            for (K k : keyList
                    ) {
                deleteKeyAndValue(k);
            }
    }

    public <K, V> void saveKeyAndValue(List<K> keyList, List<V> valueList) {
        if (keyList == null || keyList.isEmpty())
            return;
        if (valueList == null || valueList.isEmpty())
            return;
        if (keyList.size() != valueList.size())
            return;

        for (int i = 0; i < keyList.size(); i++) {
            saveKeyAndValue(keyList.get(i), valueList.get(i));
        }
    }

    public <V> V getValue(Object key, Class<V> vClass) {
        return get(key, vClass);
    }

    public <K> void deleteKeyAndValue(K key) {
        delete(key);
    }

    public <K, V> void saveKeyAndValue(K key, V value) {
        save(key, value);
    }

    /**
     * 增加或修改指定键值
     *
     * @param key   键
     * @param value 值
     */
    private <K, V> void save(K key, V value) {
        if (this.nameSpace != null && !this.nameSpace.isEmpty())
            stringRedisTemplate.opsForValue().set(this.nameSpace + ":" + gson.toJson(key), gson.toJson(value));
        else
            stringRedisTemplate.opsForValue().set(gson.toJson(key), gson.toJson(value));
    }

    private <K> void delete(K key) {
        if (this.nameSpace != null && !this.nameSpace.isEmpty())
            stringRedisTemplate.delete(this.nameSpace + ":" + gson.toJson(key));
        else
            stringRedisTemplate.delete(gson.toJson(key));
    }

    private <V> V get(Object key, Class<V> vClass) {
        if (this.nameSpace != null && !this.nameSpace.isEmpty())
            return gson.fromJson(stringRedisTemplate.opsForValue().get(this.nameSpace + ":" + key), vClass);
        else
            return gson.fromJson(stringRedisTemplate.opsForValue().get(key), vClass);
    }
}
