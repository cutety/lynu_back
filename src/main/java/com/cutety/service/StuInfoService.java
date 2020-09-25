package com.cutety.service;

import com.cutety.mapper.StuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StuInfoService {
    @Autowired
    private StuInfoMapper stuInfoMapper;

    public Map<String,Integer> maleAndFemaleAmount() {
        int male = stuInfoMapper.getAmountByGender("男");
        int female = stuInfoMapper.getAmountByGender("女");
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

}
