package com.cutety.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInInfo {
    private Integer id;

    private String stuId;

    private Integer checkInStutas;

    private Date checkInTime;

}