package com.lh.starkey.service.impl;

import com.lh.starkey.dao.OilUseMapper;
import com.lh.starkey.model.OilUse;
import com.lh.starkey.service.OilUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 14:56
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OilUseServiceImpl implements OilUseService {
    @Autowired
    OilUseMapper oilUseMapper;
    /**
     * 主键查询OilUse对象列表
     *
     * @return 主键查询OilUse对象列表
     */
    @Override
    public List<OilUse> selectAllOilUse() {
        return oilUseMapper.selectAllOilUse();
    }
}
