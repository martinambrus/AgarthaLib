// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class AccessUtil
{
    public static final Field setAccessible(final Field field) throws ReflectiveOperationException {
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            final Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
            return field;
        }
        return null;
    }
    
    public static final Method setAccessible(final Method method) throws ReflectiveOperationException {
        if (method != null && !method.isAccessible()) {
            method.setAccessible(true);
        }
        return method;
    }
    
    public static final Constructor setAccessible(final Constructor constructor) throws ReflectiveOperationException {
        if (constructor != null && !constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor;
    }
}
