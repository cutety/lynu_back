package com.cutety.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cutety.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by cutety on 2020/9/24,13:21.
 **/
@RestController
@RequestMapping("/stu_info")
public class StuInfoController {
    @Autowired
    private StuInfoService stuInfoService;

    @GetMapping("/male_and_female_amount")
    public Map<String, Integer> maleAndFemaleAmount() {
        return stuInfoService.maleAndFemaleAmount();
    }

    @GetMapping("/amount/{year}")
    public Integer getAmountByYear(@PathVariable String year) {
        Integer amount = stuInfoService.getStuAmount(year);
        return amount;
    }

    @GetMapping("/age_distribution/{year}")
    public JSONArray getAgeDistribution(@PathVariable String year) {
        List<Map<Integer, Integer>> ageDistribution = stuInfoService.getAgeDistribution(year);
        JSONArray objects = JSONArray.parseArray(JSONObject.toJSONString(ageDistribution));
        return objects;
    }

    @GetMapping("/table/{year}")
    public List<List<String>> getStuInfoTable(@PathVariable String year) {
        List<Map<String, String>> stuInfoTable = stuInfoService.getStuInfoTable(year);
        List<List<String>> list = new ArrayList<>();
        stuInfoTable.forEach(item -> {
            //List<String>
            List<String> list1 = new ArrayList<>();
            item.forEach((k,v) -> list1.add(v));
            list.add(list1);
        });
        return list;
    }
}
