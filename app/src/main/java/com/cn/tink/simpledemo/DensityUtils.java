package com.cn.tink.simpledemo;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2018/5/14.
 */

public class DensityUtils {

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
}
