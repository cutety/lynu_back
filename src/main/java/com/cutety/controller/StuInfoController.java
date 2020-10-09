package com.cutety.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
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

    @GetMapping("/male_and_female_amount/{year}")
    public Map<String, Integer> maleAndFemaleAmount(@PathVariable String year) {
        return stuInfoService.maleAndFemaleAmount(year);
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

    @GetMapping("/household_registry/{year}")
    public Object getStuHouseholdRegistry(@PathVariable String year) {
        List<Map<String, String>> stuHouseholdRegistry = stuInfoService.getStuHouseholdRegistry(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(stuHouseholdRegistry), Feature.OrderedField);
        return parse;
    }
    @GetMapping("/province/{year}")
    public Object getStuProvince(@PathVariable String year) {
        List<Map<String, String>> stuProvince = stuInfoService.getStuProvince(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(stuProvince), Feature.OrderedField);
        return parse;
    }

    @GetMapping("/firstname/{year}")
    public Object getFirstname(@PathVariable String year) {
        List<Map<String, String>> firstname = stuInfoService.getFirstname(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(firstname), Feature.OrderedField);
        return parse;
    }

    @GetMapping("/sameName/{year}")
    public Object getSameName(@PathVariable String year) {
        List<Map<String, String>> sameName = stuInfoService.getSameName(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(sameName), Feature.OrderedField);
        return parse;
    }

    @GetMapping("/sameBirthday/{year}")
    public Object getSameBirthday(@PathVariable String year) {
        List<Map<String, String>> sameBirthday = stuInfoService.getSameBirthday(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(sameBirthday), Feature.OrderedField);
        return parse;
    }
}
