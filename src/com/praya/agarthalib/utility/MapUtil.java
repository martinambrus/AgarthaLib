// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import java.util.HashMap;

public class MapUtil
{
    public static final String getRandomIdByDouble(final HashMap<String, Double> map) {
        if (map != null) {
            final HashMap<String, Double> minPossibility = new HashMap<String, Double>();
            final HashMap<String, Double> maxPossibility = new HashMap<String, Double>();
            double sum = 0.0;
            for (final String key : map.keySet()) {
                final double possibility = map.get(key);
                minPossibility.put(key, sum);
                sum += possibility;
                maxPossibility.put(key, sum);
            }
            final double number = Math.random() * sum;
            for (final String key2 : map.keySet()) {
                if (number >= minPossibility.get(key2) && number <= maxPossibility.get(key2)) {
                    return key2;
                }
            }
        }
        return null;
    }
    
    public static final String getRandomIdByInteger(final HashMap<String, Integer> map) {
        if (map != null) {
            final HashMap<String, Integer> minPossibility = new HashMap<String, Integer>();
            final HashMap<String, Integer> maxPossibility = new HashMap<String, Integer>();
            int sum = 0;
            for (final String key : map.keySet()) {
                final int possibility = map.get(key);
                minPossibility.put(key, sum);
                sum += possibility;
                maxPossibility.put(key, sum);
            }
            final double number = Math.random() * sum;
            for (final String key2 : map.keySet()) {
                if (number >= minPossibility.get(key2) && number <= maxPossibility.get(key2)) {
                    return key2;
                }
            }
        }
        return null;
    }
    
    @Deprecated
    public static final String getRandom(final HashMap<String, Integer> map) {
        return getRandomIdByInteger(map);
    }
}
