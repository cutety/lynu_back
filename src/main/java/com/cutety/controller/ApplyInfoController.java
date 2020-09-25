package com.cutety.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cutety.service.ApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by cutety on 2020/9/24,16:36.
 **/
@RestController
@RequestMapping("/apply_info")
public class ApplyInfoController {
    @Autowired
    private ApplyInfoService applyInfoService;

    @GetMapping("/major_rank/{year}")
    public JSONArray getMajorRank(@PathVariable String year) {
        List<Map<String, Integer>> majorRank = applyInfoService.getMajorRank(year);
        JSONArray objects = JSONArray.parseArray(JSONObject.toJSONString(majorRank));
        return objects;
    }
}
