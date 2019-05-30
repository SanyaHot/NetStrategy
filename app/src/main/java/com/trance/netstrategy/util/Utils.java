package com.trance.netstrategy.util;

import androidx.databinding.BindingConversion;

import com.trance.netstrategy.bean.SwordsMan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getName(SwordsMan swordsMan) {
        return swordsMan.getName();
    }

    /**
     * 此注解的用于DataBinding将源类型(Date)变换成目标类型(String)
     * (自动生成，无需显示使用)
     * @param date
     * @return
     */
    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
