package com.cutety.service;

import com.cutety.entity.CheckInInfo;
import com.cutety.mapper.CheckInInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by cutety on 2020/9/24,13:07.
 **/
@Service
public class CheckInInfoService {
    @Autowired
    private CheckInInfoMapper checkInInfoMapper;

    public int insert(CheckInInfo record) {
        return checkInInfoMapper.insert(record);
    }
    public int update(CheckInInfo record) {
        return checkInInfoMapper.updateByPrimaryKeySelective(record);
    }
}
