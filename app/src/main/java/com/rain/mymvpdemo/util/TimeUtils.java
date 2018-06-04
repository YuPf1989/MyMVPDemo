package com.rain.mymvpdemo.util;

/**
 * Author:rain
 * Date:2018/6/4 11:09
 * Description:
 */
public class TimeUtils {
    public static String durationFormat(Long duration) {
        if (duration == null) {
            return "";
        }
        Long minute = duration / 60;
        Long second = duration % 60;
        if (minute <= 9) {
            if (second <= 9) {
                return "0" + minute + "0" + second;
            } else {
                return "0" + minute + second;
            }
        } else {
            if (second <= 9) {
                return minute + "0" + second;
            } else {
                return ""+minute + second;
            }
        }
    }
}
