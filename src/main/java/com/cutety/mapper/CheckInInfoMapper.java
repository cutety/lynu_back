package com.cutety.mapper;

import com.cutety.entity.CheckInInfo;
import org.springframework.stereotype.Component;

@Component
public interface CheckInInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckInInfo record);

    int insertSelective(CheckInInfo record);

    CheckInInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckInInfo record);

    int updateByPrimaryKey(CheckInInfo record);

    int getCheckInAmount();
}