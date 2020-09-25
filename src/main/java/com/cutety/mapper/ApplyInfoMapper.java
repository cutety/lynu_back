package com.cutety.mapper;

import com.cutety.entity.ApplyInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ApplyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyInfo record);

    int insertSelective(ApplyInfo record);

    ApplyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyInfo record);

    int updateByPrimaryKey(ApplyInfo record);

    List<Map<String, Integer>> getMajorRank(String year);
}