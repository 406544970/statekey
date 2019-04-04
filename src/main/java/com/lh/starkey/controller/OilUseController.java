package com.lh.starkey.controller;

import com.lh.starkey.model.Oil;
import com.lh.starkey.model.OilBase;
import com.lh.starkey.model.OilUse;
import com.lh.starkey.service.OilBaseService;
import com.lh.starkey.service.OilService;
import com.lh.starkey.service.OilUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-04 15:03
 * @function
 * @editLog
 */
@RestController
public class OilUseController {
    @Autowired
    OilUseService oilUseService;

    /**
     * 主键查询OilUse对象列表
     *
     * @return 主键查询OilUse对象列表
     */
    @PostMapping("/selectAllOilUse")
    public List<OilUse> selectAllOilUse() {

//      请在这里写逻辑代码

        return oilUseService.selectAllOilUse();
    }
    @Autowired
    OilService oilService;

    /**
     * 得到所有Oil对象列表
     *
     * @return 得到所有Oil对象列表
     */
    @PostMapping("/selectAllOil")
    public List<Oil> selectAllOil() {
//      请在这里写逻辑代码
        return oilService.selectAllOil();
    }
    @Autowired
    OilBaseService oilBaseService;

    /**
     * 查询所有油库信息
     *
     * @return 得到所有油库对象列表
     */
    @PostMapping("/selectAllOilBase")
    public List<OilBase> selectAllOilBase() {

//      请在这里写逻辑代码

        return oilBaseService.selectAllOilBase();
    }
}

