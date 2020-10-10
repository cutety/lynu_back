package com.cutety.lynu_back;

import com.cutety.entity.StuInfo;
import com.cutety.mapper.ApplyInfoMapper;
import com.cutety.service.ApplyInfoService;
import com.cutety.service.StuInfoService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
class LynuBackApplicationTests {

    @Autowired
    private ApplyInfoService applyInfoService;
    @Autowired
    private StuInfoService stuInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void getInfo() {
        System.out.println(applyInfoService.getStudent(1));
    }

    @Test
    void getMaleFemaleRatio() {
        System.out.println(stuInfoService.maleAndFemaleAmount("17"));
    }

    @Test
    void getStudentAmount() {
        System.out.println(stuInfoService.getStuAmount("17"));
    }

    @Test
    void getMajorRank() {
        System.out.println(applyInfoService.getMajorRank("19"));
    }

    @Test
    void getAgeDistribution() {
        System.out.println(stuInfoService.getAgeDistribution("19"));
    }

    @Test
    void getStuInfoTable() {
        System.out.println(stuInfoService.getStuInfoTable("19"));
    }

    @Test
    void getStuHouseholdRegistry() {
        System.out.println(stuInfoService.getStuHouseholdRegistry("19"));
    }
}
