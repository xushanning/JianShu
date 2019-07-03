package com.xu.commonlib.utlis;

/**
 * @author 言吾許
 */
public class TimeUtil {
    private static final int METER_10 = 10;
    private static final int METER_1000 = 1000;
    private static final int MINUTE_60 = 60;
    private static final int MINUTE_10 = 10;
    private static final int SECOND_10 = 10;
    private static final int SECOND_60 = 60;
    private static final int SECOND_3600 = 3600;
    private static final int HOUR_99 = 99;
    private static final int HOUR_10 = 10;

    public static String getTime(long second) {
        if (second < SECOND_10) {
            return "00:00:0" + second;
        }
        if (second < SECOND_60) {
            return "00:00:" + second;
        }
        if (second < SECOND_3600) {
            long minute = second / 60;
            second = second - minute * 60;
            if (minute < MINUTE_10) {
                if (second < SECOND_10) {
                    return "00:0" + minute + ":0" + second;
                }
                return "00:0" + minute + ":" + second;
            }
            if (second < SECOND_10) {
                return "00:" + minute + ":0" + second;
            }
            return "00:" + minute + ":" + second;
        }
        long hour = second / 3600;
        long minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        if (hour < HOUR_10) {
            if (minute < MINUTE_10) {
                if (second < SECOND_10) {
                    return "0" + hour + ":0" + minute + ":0" + second;
                }
                return "0" + hour + ":0" + minute + ":" + second;
            }
            if (second < SECOND_10) {
                return "0" + hour + ":" + minute + ":0" + second;
            }
            return "0" + hour + ":" + minute + ":" + second;
        }
        if (minute < MINUTE_10) {
            if (second < SECOND_10) {
                return hour + ":0" + minute + ":0" + second;
            }
            return hour + ":0" + minute + ":" + second;
        }
        if (second < SECOND_10) {
            return hour + ":" + minute + ":0" + second;
        }
        return hour + ":" + minute + ":" + second;
    }

}
