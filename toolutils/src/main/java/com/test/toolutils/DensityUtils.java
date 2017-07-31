package com.test.toolutils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 单位转换
 */

public class DensityUtils {

    /**
     * px转换为dip或dp值，保证尺寸大小不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context,float pxValue){

        float scale = context.getResources().getDisplayMetrics().density;

        return (int)(pxValue / scale + 0.5f);

    }

    /**
     * 将dip转换为px值，保存尺寸大小不变
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context,float dipValue){

        float scale = context.getResources().getDisplayMetrics().density;

        return (int)(dipValue * scale + 0.5f);

    }

    /**
     * 将px转换为sp值，保证文字大小不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context,float pxValue){

        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int)(pxValue / fontScale + 0.5f);

    }

    /**
     * 将sp转换为px值，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context,float spValue){

        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int)(spValue * fontScale + 0.5f);

    }

    /**
     * 使用系统提供的TypedValue将dp转换为px值
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context,int dp){

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());

    }

    /**
     * 使用系统提供的TypedValue将sp转换为px值
     * @param context
     * @param sp
     * @return
     */
    public static int sp2px(Context context,int sp){

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,context.getResources().getDisplayMetrics());

    }

}
