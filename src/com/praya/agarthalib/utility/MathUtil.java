// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.apache.commons.lang.math.NumberUtils;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;

public class MathUtil
{
    public static final boolean chanceOf(final double value) {
        return chanceOf(value, 100.0);
    }
    
    public static final boolean chanceOf(final double value, final double check) {
        return Math.random() * check <= value;
    }
    
    public static final double negative(final double number) {
        return (number < 0.0) ? number : (number * -1.0);
    }
    
    public static final double positive(final double number) {
        return (number > 0.0) ? number : (number * -1.0);
    }
    
    @Deprecated
    public static final String romanNumber(int input) {
        if (input < 1 || input > 3999) {
            return String.valueOf(input);
        }
        String s = "";
        while (input >= 1000) {
            s = String.valueOf(s) + "M";
            input -= 1000;
        }
        while (input >= 900) {
            s = String.valueOf(s) + "CM";
            input -= 900;
        }
        while (input >= 500) {
            s = String.valueOf(s) + "D";
            input -= 500;
        }
        while (input >= 400) {
            s = String.valueOf(s) + "CD";
            input -= 400;
        }
        while (input >= 100) {
            s = String.valueOf(s) + "C";
            input -= 100;
        }
        while (input >= 90) {
            s = String.valueOf(s) + "XC";
            input -= 90;
        }
        while (input >= 50) {
            s = String.valueOf(s) + "L";
            input -= 50;
        }
        while (input >= 40) {
            s = String.valueOf(s) + "XL";
            input -= 40;
        }
        while (input >= 10) {
            s = String.valueOf(s) + "X";
            input -= 10;
        }
        while (input >= 9) {
            s = String.valueOf(s) + "IX";
            input -= 9;
        }
        while (input >= 5) {
            s = String.valueOf(s) + "V";
            input -= 5;
        }
        while (input >= 4) {
            s = String.valueOf(s) + "IV";
            input -= 4;
        }
        while (input >= 1) {
            s = String.valueOf(s) + "I";
            --input;
        }
        return s;
    }
    
    @Deprecated
    public static final int romanConvert(final String romanNumber) {
        final String romanNumeral = romanNumber.toUpperCase();
        int decimal = 0;
        int lastNumber = 0;
        for (int x = romanNumeral.length() - 1; x >= 0; --x) {
            final char convertToDecimal = romanNumeral.charAt(x);
            switch (convertToDecimal) {
                case 'M': {
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;
                }
                case 'D': {
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;
                }
                case 'C': {
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                }
                case 'L': {
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                }
                case 'X': {
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                }
                case 'V': {
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                }
                case 'I': {
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
                }
            }
        }
        return decimal;
    }
    
    @Deprecated
    public static final int processDecimal(final int decimal, final int lastNumber, final int lastDecimal) {
        return (lastNumber > decimal) ? (lastDecimal - decimal) : (lastDecimal + decimal);
    }
    
    public static final double roundNumber(final double value) {
        return roundNumber(value, 2);
    }
    
    public static final double roundNumber(final double value, final int round) {
        final double exponent = exponent(10.0, round);
        final double newValue = value * exponent;
        final int roundValue = (int)newValue;
        return (newValue < roundValue + 0.5) ? (roundValue / exponent) : ((roundValue + 1) / exponent);
    }
    
    public static final double exponent(final double value, final int round) {
        double newValue = 1.0;
        if (round < 0) {
            for (int i = 0; i < -round; ++i) {
                newValue /= value;
            }
        }
        else {
            for (int i = 0; i < round; ++i) {
                newValue *= value;
            }
        }
        return newValue;
    }
    
    @Deprecated
    public static final String getTime(final long milis) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        double leftTime = (double)milis;
        leftTime /= 1000.0;
        final int days = (int)(leftTime / 86400.0);
        leftTime -= days * 86400;
        final int hours = (int)(leftTime / 3600.0);
        leftTime -= hours * 3600;
        final int minutes = (int)(leftTime / 60.0);
        leftTime -= minutes * 60;
        final double seconds = roundNumber(leftTime, 2);
        String time;
        if (days > 0) {
            time = String.valueOf(days) + " " + lang.getText("Time_Days") + hours + " " + lang.getText("Time_Hours") + " " + minutes + " " + lang.getText("Time_Minutes") + " " + seconds + " " + lang.getText("Time_Seconds");
        }
        else if (hours > 0) {
            time = String.valueOf(hours) + " " + lang.getText("Time_Hours") + " " + minutes + " " + lang.getText("Time_Minutes") + " " + seconds + " " + lang.getText("Time_Seconds");
        }
        else if (minutes > 0) {
            time = String.valueOf(minutes) + " " + lang.getText("Time_Minutes") + " " + seconds + " " + lang.getText("Time_Seconds");
        }
        else {
            time = String.valueOf(seconds) + " " + lang.getText("Time_Seconds");
        }
        return time;
    }
    
    public static final short limitShort(final short value, final short min, final short max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
    
    public static final double limitDouble(final double value, final double min, final double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
    
    public static final int limitInteger(final int value, final int min, final int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
    
    public static final boolean isNumber(final String text) {
        return NumberUtils.isNumber(text);
    }
    
    public static final long convertTickToMilis(final int tick) {
        final long milis = tick * 50;
        return milis;
    }
    
    public static final long convertSecondsToMilis(final double seconds) {
        final long milis = (long)(seconds * 1000.0);
        return milis;
    }
    
    public static final int convertSecondsToTicks(final double seconds) {
        final int ticks = (int)(seconds * 20.0);
        return ticks;
    }
    
    public static final int convertMilisToTicks(final long milis) {
        final int ticks = (int)(milis / 50L);
        return ticks;
    }
    
    public static final boolean isDividedBy(final double value, final double divider) {
        final double divideValue = value / divider;
        final int roundValue = (int)divideValue;
        return divideValue == roundValue;
    }
    
    public static final int parseInteger(final String text) {
        return (int)parseDouble(text);
    }
    
    public static final short parseShort(final String text) {
        return (short)parseDouble(text);
    }
    
    public static final double parseDouble(final String text) {
        return (text != null) ? (isNumber(text) ? Double.valueOf(text) : 0.0) : 0.0;
    }
    
    public static final double random(final double max) {
        return Math.random() * max;
    }
    
    public static final int random(final int max) {
        return (int)(Math.random() * max);
    }
    
    public static final double valueBetween(final double value1, final double value2) {
        return valueBetween(value1, value2, 2);
    }
    
    public static final double valueBetween(final double value1, final double value2, final int round) {
        final double diff = value2 - value1;
        final double rawValue = value1 + random(diff);
        final double roundValue = roundNumber(rawValue, round);
        return roundValue;
    }
}
