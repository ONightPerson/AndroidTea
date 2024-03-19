package com.liubz.androidtea.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class SpannableStringBuilderUtil {

    public static void append(SpannableStringBuilder spannableStringBuilder, String text, boolean isHole, int color, ClickableSpan clickableSpan) {
        SpannableStringBuilder appendInfo = new SpannableStringBuilder();
        appendInfo.append(text);
        if (isHole) {
            setTextHole(appendInfo);
        }
        setTextColor(appendInfo, color);
        setTextLink(appendInfo, clickableSpan);
        spannableStringBuilder.append(appendInfo);
    }

    private static void setTextHole(SpannableStringBuilder text) {
        text.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //粗体
    }

    private static void setTextColor(SpannableStringBuilder text, int color) {
        text.setSpan(new ForegroundColorSpan(color), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private static void setTextLink(SpannableStringBuilder text, ClickableSpan clickableSpan) {
        text.setSpan(clickableSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
