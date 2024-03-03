package net.cctv3.chnqoodiaryservice.constants;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class StringUtils {
    public static boolean isEmpty(String s) {
        return s == null || s.matches("\\s*");
    }

    public static String buildRandomNumbers(int n) {
        String result = "";
        for(int i=0;i<n;i++) {
            result += (int)(Math.random() * 10);
        }
        return result;
    }

    public static String currentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}