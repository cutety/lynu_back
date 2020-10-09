package com.cutety.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInInfo {
    private Integer id;

    private String stuId;

    private String stuName;

    private String major;

    private Integer checkInStatus;

    private LocalDateTime checkInTime;

}