package com.lh.starkey.service.impl;

import com.lh.starkey.dao.OilBaseMapper;
import com.lh.starkey.model.OilBase;
import com.lh.starkey.service.OilBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:29
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OilBaseServiceImpl implements OilBaseService {
    @Autowired
    OilBaseMapper oilBaseMapper;
    /**
     * 查询所有油库信息
     *
     * @return 得到所有油库对象列表
     */
    @Override
    public List<OilBase> selectAllOilBase() {
        return oilBaseMapper.selectAllOilBase();
    }
}
