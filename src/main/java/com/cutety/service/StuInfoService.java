package com.cutety.service;

import com.cutety.mapper.StuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by cutety on 2020/9/24,13:07.
 **/
@Service
@Component
public class StuInfoService {
    @Autowired
    private StuInfoMapper stuInfoMapper;

    public Map<String,Integer> maleAndFemaleAmount(String year) {
        int male = stuInfoMapper.getAmountByGender("男",year);
        int female = stuInfoMapper.getAmountByGender("女",year);
        Map<String, Integer> res = new HashMap<>();
        res.put("male", male);
        res.put("female", female);
        return res;
    }

    public Integer getStuAmount(String year) {
        if("all".equals(year)) {
            return stuInfoMapper.getAmountAll();
        }
        return stuInfoMapper.getAmountByYear(year);
    }

    public List<Map<Integer, Integer>> getAgeDistribution(String year) {
        List<Map<Integer, Integer>> ageDistribution = stuInfoMapper.getAgeDistribution(year);
        return ageDistribution;
    }


    public List<Map<String, String>> getStuInfoTable(String year) {
        List<Map<String, String>> map = stuInfoMapper.getStuInfoTable(year);
        return map;
    }

    public List<Map<String, String>> getStuHouseholdRegistry(String year) {
        List<Map<String, String>> stuHouseholdRegistry = stuInfoMapper.getStuHouseholdRegistry(year);
        return stuHouseholdRegistry;
    }

    public List<Map<String, String>> getStuProvince(String year) {
        List<Map<String, String>> stuProvince = stuInfoMapper.getStuProvince(year);
        return stuProvince;
    }

    public List<Map<String, String>> getFirstname(String year) {
        List<Map<String, String>> firstname = stuInfoMapper.getFirstname(year);
        return firstname;
    }
    public List<Map<String, String>> getSameName(String year) {
        List<Map<String, String>> sameName = stuInfoMapper.getSameName(year);
        return sameName;
    }
    public List<Map<String, String>> getSameBirthday(String year) {
        List<Map<String, String>> sameBirthday = stuInfoMapper.getSameBirthday(year);
        return sameBirthday;
    }
}
