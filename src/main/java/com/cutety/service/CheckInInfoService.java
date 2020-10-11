package com.cutety.service;

import com.cutety.entity.CheckInInfo;
import com.cutety.mapper.CheckInInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * Created by cutety on 2020/9/24,13:07.
 **/
@Service
@Component
@Transactional
public class CheckInInfoService {
    @Autowired
    private CheckInInfoMapper checkInInfoMapper;
    public int update(CheckInInfo record) {
        return checkInInfoMapper.updateByPrimaryKeySelective(record);
    }
    public int getCheckInAmount() {
        return checkInInfoMapper.getCheckInAmount();
    }
}
