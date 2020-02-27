// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

public enum RomanNumber
{
    M("M", 0, 1000, RomanNumberType.PRIMARY), 
    CM("CM", 1, 900, RomanNumberType.SECONDARY), 
    D("D", 2, 500, RomanNumberType.PRIMARY), 
    CD("CD", 3, 400, RomanNumberType.SECONDARY), 
    C("C", 4, 100, RomanNumberType.PRIMARY), 
    XC("XC", 5, 90, RomanNumberType.SECONDARY), 
    L("L", 6, 50, RomanNumberType.PRIMARY), 
    XL("XL", 7, 40, RomanNumberType.SECONDARY), 
    X("X", 8, 10, RomanNumberType.PRIMARY), 
    IX("IX", 9, 9, RomanNumberType.SECONDARY), 
    V("V", 10, 5, RomanNumberType.PRIMARY), 
    IV("IV", 11, 4, RomanNumberType.SECONDARY), 
    I("I", 12, 1, RomanNumberType.PRIMARY);
    
    private final int value;
    private final RomanNumberType type;
    
    private RomanNumber(final String name, final int ordinal, final int value, final RomanNumberType type) {
        this.value = value;
        this.type = type;
    }
    
    public final int getValue() {
        return this.value;
    }
    
    public final RomanNumberType getType() {
        return this.type;
    }
    
    public static final Collection<RomanNumber> getRomanNumbers(final RomanNumberType type) {
        if (type != null) {
            switch (type) {
                case PRIMARY: {
                    return RomanNumberHelper.primary;
                }
                case SECONDARY: {
                    return RomanNumberHelper.secondary;
                }
            }
        }
        return new ArrayList<RomanNumber>();
    }
    
    public static final RomanNumber getRomanNumber(final String romanNumber) {
        if (romanNumber != null) {
            RomanNumber[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final RomanNumber key = values[i];
                if (key.toString().equalsIgnoreCase(romanNumber)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final String getRomanNumber(int input) {
        if (input < 1 || input > 3999) {
            return String.valueOf(input);
        }
        String text = "";
        RomanNumber[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final RomanNumber roman = values[i];
            final int romanValue = roman.getValue();
            final String romanText = roman.toString();
            while (input >= romanValue) {
                text = String.valueOf(text) + romanText;
                input -= romanValue;
            }
        }
        return text;
    }
    
    public static final int romanConvert(final String romanNumber) {
        if (romanNumber == null) {
            return -1;
        }
        final String romanNumeral = romanNumber.toUpperCase();
        final Collection<RomanNumber> romanNumberPrimary = getRomanNumbers(RomanNumberType.PRIMARY);
        int decimal = 0;
        int lastNumber = 0;
        for (int x = romanNumeral.length() - 1; x >= 0; --x) {
            final char convertToDecimal = romanNumeral.charAt(x);
            final String convertText = String.valueOf(convertToDecimal);
            for (final RomanNumber roman : romanNumberPrimary) {
                final int romanValue = roman.getValue();
                final String romanText = roman.toString();
                if (romanText.equalsIgnoreCase(convertText)) {
                    decimal = processDecimal(romanValue, lastNumber, decimal);
                    lastNumber = romanValue;
                }
            }
        }
        return decimal;
    }
    
    private static final int processDecimal(final int decimal, final int lastNumber, final int lastDecimal) {
        return (lastNumber > decimal) ? (lastDecimal - decimal) : (lastDecimal + decimal);
    }
    
    public enum RomanNumberType
    {
        PRIMARY("PRIMARY", 0), 
        SECONDARY("SECONDARY", 1);
        
        private RomanNumberType(final String name, final int ordinal) {
        }
    }
    
    private static class RomanNumberHelper
    {
        private static final Collection<RomanNumber> primary;
        private static final Collection<RomanNumber> secondary;
        
        static {
            primary = new ArrayList<RomanNumber>();
            secondary = new ArrayList<RomanNumber>();
            RomanNumber[] values;
            for (int length = (values = RomanNumber.values()).length, i = 0; i < length; ++i) {
                final RomanNumber romanNumber = values[i];
                final RomanNumberType type = romanNumber.getType();
                switch (type) {
                    case PRIMARY: {
                        RomanNumberHelper.primary.add(romanNumber);
                        break;
                    }
                    case SECONDARY: {
                        RomanNumberHelper.secondary.add(romanNumber);
                        break;
                    }
                }
            }
        }
    }
}
