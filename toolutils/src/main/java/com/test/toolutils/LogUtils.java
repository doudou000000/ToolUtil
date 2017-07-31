package com.test.toolutils;

import android.util.Log;

/**
 * log日志管理类
 */

public class LogUtils {

    public static  boolean isDebug = true;

    public static final String TAG = "LogUtils";

    /**
     * 使用默认tag
     * @param msg
     */
    public static void i(String msg){

        if(isDebug){
            Log.i(TAG,msg);
        }

    }

    /**
     * 使用默认tag
     * @param msg
     */
    public static void d(String msg){

        if(isDebug){
            Log.d(TAG,msg);
        }

    }

    /**
     * 使用默认tag
     * @param msg
     */
    public static void e(String msg){

        if(isDebug){
            Log.e(TAG,msg);
        }

    }

    /**
     * 使用默认tag
     * @param msg
     */
    public static void v(String msg){

        if(isDebug){
            Log.v(TAG,msg);
        }

    }

    /**
     * 使用自定义tag
     * @param msg
     */
    public static void i(String tag,String msg){

        if(isDebug){
            Log.i(tag,msg);
        }

    }

    /**
     * 使用自定义tag
     * @param msg
     */
    public static void d(String tag,String msg){

        if(isDebug){
            Log.d(tag,msg);
        }

    }

    /**
     * 使用自定义tag
     * @param msg
     */
    public static void e(String tag,String msg){

        if(isDebug){
            Log.e(tag,msg);
        }

    }

    /**
     * 使用自定义tag
     * @param msg
     */
    public static void v(String tag,String msg){

        if(isDebug){
            Log.v(tag,msg);
        }

    }

}
