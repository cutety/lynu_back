package com.cutety.service;

import com.cutety.entity.ApplyInfo;
import com.cutety.mapper.ApplyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by cutety on 2020/9/24,12:58.
 **/
@Service
public class ApplyInfoService {
    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    public ApplyInfo getStudent(Integer id) {
        return applyInfoMapper.selectByPrimaryKey(id);
    }

    public List<Map<String,Integer>> getMajorRank(String year) {
        List<Map<String, Integer>> majorRank = applyInfoMapper.getMajorRank(year);
        return majorRank;
    }
}
