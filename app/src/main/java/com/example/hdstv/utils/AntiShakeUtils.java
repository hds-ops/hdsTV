//package com.example.hdstv.utils;
//
//import android.view.View;
//
//
//
//public class AntiShakeUtils {
//
//    private final static long INTERNAL_TIME = 1000;
//
//    public static boolean isInvalidClick(View target) {
//        return isInvalidClick(target, INTERNAL_TIME);
//    }
//
//    public static boolean isInvalidClick(View target, long internalTime) {
//        long curTimeStamp = System.currentTimeMillis();
//        long lastClickTimeStamp;
//
//        Object o = target.getTag(R.id.last_click_time);
//        if (o == null) {
//            target.setTag(R.id.last_click_time, curTimeStamp);
//            return false;
//        }
//
//        lastClickTimeStamp = (Long) o;
//        boolean isInvalid = curTimeStamp - lastClickTimeStamp < internalTime;
//        if (!isInvalid) {
//            target.setTag(R.id.last_click_time, curTimeStamp);
//        }
//        return isInvalid;
//    }
//
//}
