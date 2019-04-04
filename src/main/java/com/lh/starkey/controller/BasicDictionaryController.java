package com.lh.starkey.controller;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[statekey]: com.lh.starkey.demo.controller
 * @date:2019/3/29
 */

import com.lh.starkey.common.CommonQuery;
import com.lh.starkey.dto.DictionaryList;
import com.lh.starkey.model.*;
import com.lh.starkey.model.ResponseStatus;
import com.lh.starkey.myenum.ResultCode;
import com.lh.starkey.service.DictionaryNameService;
import com.lh.starkey.service.DictionaryService;
import com.lh.starkey.service.OrderService;
import com.lh.starkey.unit.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/basicDictionary")
public class BasicDictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    DictionaryNameService dictionaryNameService;

    @Autowired
    OrderService orderService;

    /**
     * 查询所有油订单
     *
     * @return SubTwo方法返回值
     */
    @PostMapping("/selectAllOrderList")
    public List<Order> selectAllOrderList(CommonQuery commonQuery) {
        return orderService.selectList(commonQuery);
    }

    @GetMapping("/getVersion")
    public String getVersion() {
        return String.format("Version:%s", "1.3.3.1");
    }

    @PostMapping("/geDictionaryName")
    public ResponseHashResult geDictionaryName(@RequestBody CommonQuery commonQuery) {
        ResponseHashResult result;
        try {
            result = dictionaryNameService.selectByPageMultTable(commonQuery);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseHashResult(new ResponseStatus(ResultCode.INTERFACE_CALL_FAILED));
        }
        return result;
    }

    @PostMapping("/getMultList")
    public ResponseHashResult getMultList(@RequestBody List<CommonQuery> commonQueryList) {
        ResponseHashResult result;
        try {
            List<Dictionary> list1 = dictionaryService.selectList(commonQueryList.get(0));
            List<DictionaryList> dictionaryListList = new ArrayList<>();
            for (Dictionary row : list1
                    ) {
                List<DictionaryName> list = dictionaryNameService.selectList(commonQueryList.get(1));
                DictionaryList dictionaryList = new DictionaryList();

                dictionaryList.setPkno(row.getPkno());
                dictionaryList.setCtime(row.getCtime());
                if (list != null && list.size() > 0) {
                    dictionaryList.setDictionaryNameList(list);
                }
                dictionaryListList.add(dictionaryList);
            }
            HashMap<String, Object> temp = new HashMap<>();
            temp.put("list", dictionaryListList);
            temp.put("pageNo", commonQueryList.get(0).getPageNo());
            temp.put("total", dictionaryListList.size());
            result = new ResponseHashResult(new ResponseStatus(ResultCode.SUCCESS), temp);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseHashResult(new ResponseStatus(ResultCode.INTERFACE_CALL_FAILED));
        }
        return result;
    }

    @PostMapping("/getDictionaryList")
    public List<Dictionary> getDictionaryList(@RequestBody CommonQuery commonQuery) {
        List<Dictionary> result;
        try {
            result = dictionaryService.selectList(commonQuery);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    @PostMapping("/geList")
    public ResponseHashResult geList(@RequestBody CommonQuery commonQuery) {
        ResponseHashResult result;
        try {
            result = dictionaryService.selectByPage(commonQuery);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseHashResult(new ResponseStatus(ResultCode.INTERFACE_CALL_FAILED));
        }
        return result;
    }

}
