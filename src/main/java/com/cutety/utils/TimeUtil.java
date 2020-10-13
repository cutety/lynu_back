package com.cutety.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeUtil {
    public static DateFormat timeFormat(String pattern){
        return new SimpleDateFormat(pattern);
    }
}
