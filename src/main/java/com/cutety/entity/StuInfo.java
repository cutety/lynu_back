package com.cutety.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuInfo {
    private Integer id;

    private String stuId;

    private String stuName;

    private String gender;

    private Date birthday;

    private String policalStatus;

    private String nation;

    private String candidateCategory;

    private String graduatedSchool;

    private String candidateCharacteristics;

    private String candidateHouseholdRegistry;

    private String address;

    private Integer candidateResult;

    private ApplyInfo applyInfo;
}