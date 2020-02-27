// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

public class DataUtil
{
    public static final String keyGen(final String format, final String key) {
        return keyGen(format, key, "§");
    }
    
    public static final String keyGen(final String format, final String key, final String identifier) {
        if (format == null || key == null || identifier == null) {
            return "";
        }
        final String[] builder = format.split(key);
        final String text = builder[0];
        return colorGen(text, identifier);
    }
    
    public static final String colorGen(final String text) {
        return colorGen(text, "§");
    }
    
    public static final String colorGen(final String text, final String identifier) {
        if (text == null || identifier == null) {
            return "";
        }
        String keyGen = "";
        if (text.contains(identifier)) {
            final String[] buildColor = text.split(identifier);
            final int length = buildColor.length;
            int index = length - 1;
            if (length > 2) {
                for (int t = length - 2; t > 0; --t) {
                    final String detect = buildColor[t];
                    if (detect.length() != 1) {
                        break;
                    }
                    index = t;
                }
            }
            for (int t = index; t < buildColor.length; ++t) {
                final String build = buildColor[t];
                if (build.length() > 0) {
                    keyGen = String.valueOf(keyGen) + identifier + build.charAt(0);
                }
            }
        }
        return TextUtil.colorful(keyGen);
    }
}
