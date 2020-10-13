package com.cutety.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FastJsonUtil {
    public static List<List<Object>> getLists(List<Map<String, Object>> input) {
        List<List<Object>> list = new ArrayList<>();
        input.forEach(item -> {
            //List<String>
            List<Object> list1 = new ArrayList<>();
            //
            item.forEach((k, v) -> {
                if ("check_in_time".equals(k)) {
                    v = TimeUtil.timeFormat("MM-dd HH:mm:ss").format(v);
                }
                list1.add(v);
            });
            list.add(list1);
        });
        return list;
    }
}
