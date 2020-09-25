package com.cutety.mapper;

import com.cutety.entity.StuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface StuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);

    @Select("select count(*) from stu_info where gender = #{gender}")
    int getAmountByGender(String gender);

    @Select("select count(*) from stu_info where grade = #{year}")
    int getAmountByYear(String year);

    @Select("select count(*) from stu_info")
    int getAmountAll();

    List<Map<Integer, Integer>> getAgeDistribution(String year);

    List<Map<String, String>> getStuInfoTable(String year);
}