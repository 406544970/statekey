package com.lh.starkey.service.impl;

import com.lh.starkey.dao.OilMapper;
import com.lh.starkey.model.Oil;
import com.lh.starkey.service.OilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:20
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OilServiceImpl implements OilService {
    @Autowired
    OilMapper oilMapper;
    /**
     * 得到所有Oil对象列表
     *
     * @return 得到所有Oil对象列表
     */
    @Override
    public List<Oil> selectAllOil() {
        return oilMapper.selectAllOil();
    }
}
