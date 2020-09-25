package com.cutety.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyInfo {
    private Integer id;

    private String stuId;

    private Integer applyPreference;

    private String admissionMajor;

    private String region;

    private String majorPreferenceFirst;

    private String majorPreferenceSecond;

    private String majorPreferenceThird;

    private String majorPreferenceForth;

    private String majorPreferenceFifth;

}