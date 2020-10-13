package com.cutety.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.cutety.service.StuInfoService;
import com.cutety.utils.FastJsonUtil;
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
    /** * @Author cutety 
    * @Description //TODO 根据年级获取男生女生数量 
    * @Date 16:50 2020/10/12 * @Param [year] 
    * @return java.util.Map<java.lang.String,java.lang.Integer> 男生女生数量的map
    **/
    @GetMapping("/male_and_female_amount/{year}")
    public Map<String, Integer> maleAndFemaleAmount(@PathVariable String year) {
        return stuInfoService.maleAndFemaleAmount(year);
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取学生人数 
    * @Date 16:51 2020/10/12 * @Param [year] 
    * @return java.lang.Integer 
    **/
    @GetMapping("/amount/{year}")
    public Integer getAmountByYear(@PathVariable String year) {
        Integer amount = stuInfoService.getStuAmount(year);
        return amount;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取年龄分布 
    * @Date 16:51 2020/10/12 * @Param [year] 
    * @return com.alibaba.fastjson.JSONArray 
    **/
    @GetMapping("/age_distribution/{year}")
    public JSONArray getAgeDistribution(@PathVariable String year) {
        List<Map<Integer, Integer>> ageDistribution = stuInfoService.getAgeDistribution(year);
        JSONArray objects = JSONArray.parseArray(JSONObject.toJSONString(ageDistribution));
        return objects;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取学生信息 ，用于轮播表
    * @Date 16:52 2020/10/12 * @Param [year] 
    * @return java.util.List<java.util.List<java.lang.String>> 
    **/
    @GetMapping("/table/{year}")
    public List<List<Object>> getStuInfoTable(@PathVariable String year) {
        List<Map<String, Object>> stuInfoTable = stuInfoService.getStuInfoTable(year);
        return FastJsonUtil.getLists(stuInfoTable);
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取户口地址 
    * @Date 16:52 2020/10/12 * @Param [year] 
    * @return java.lang.Object 
    **/
    @GetMapping("/household_registry/{year}")
    public Object getStuHouseholdRegistry(@PathVariable String year) {
        List<Map<String, String>> stuHouseholdRegistry = stuInfoService.getStuHouseholdRegistry(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(stuHouseholdRegistry), Feature.OrderedField);
        return parse;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取省份（省份是按照身份证上的区号判断，并不是家庭住址） 
    * @Date 16:52 2020/10/12 * @Param [year] 
    * @return java.lang.Object 
    **/
    @GetMapping("/province/{year}")
    public Object getStuProvince(@PathVariable String year) {
        List<Map<String, String>> stuProvince = stuInfoService.getStuProvince(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(stuProvince), Feature.OrderedField);
        return parse;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取姓氏分布 
    * @Date 16:53 2020/10/12 * @Param [year] 
    * @return java.lang.Object 
    **/
    @GetMapping("/firstname/{year}")
    public Object getFirstname(@PathVariable String year) {
        List<Map<String, String>> firstname = stuInfoService.getFirstname(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(firstname), Feature.OrderedField);
        return parse;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取同名情况 
    * @Date 16:53 2020/10/12 * @Param [year] 
    * @return java.lang.Object 
    **/
    @GetMapping("/sameName/{year}")
    public Object getSameName(@PathVariable String year) {
        List<Map<String, String>> sameName = stuInfoService.getSameName(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(sameName), Feature.OrderedField);
        return parse;
    }
    /** * @Author cutety 
    * @Description //TODO 根据年级获取同生日情况 
    * @Date 16:53 2020/10/12 * @Param [year] 
    * @return java.lang.Object 
    **/
    @GetMapping("/sameBirthday/{year}")
    public Object getSameBirthday(@PathVariable String year) {
        List<Map<String, String>> sameBirthday = stuInfoService.getSameBirthday(year);
        Object parse = JSONObject.parse(JSONObject.toJSONString(sameBirthday), Feature.OrderedField);
        return parse;
    }
}
