package com.liubz.androidtea.immersive;

import android.os.Build;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:28 PM
 */
public class ImmersiveFactory {
    private static final String MEIZU = "meizu";
    private static final String MIUI = "xiaomi";

    public static ImmersiveCreator create() {
        if (MEIZU.equalsIgnoreCase(Build.BRAND)) {
            return new MeizuImmersiveCreator();
        } else if (MIUI.equalsIgnoreCase(Build.BRAND)) {
            return new XiaomiImmersiveCreator();
        } else {
            return new CommonImmersiveCreator();
        }
    }
}
