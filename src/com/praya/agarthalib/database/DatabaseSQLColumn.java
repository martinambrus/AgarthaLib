// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

public class DatabaseSQLColumn
{
    private final String key;
    private final Class clazz;
    private final boolean nullable;
    private final int[] data;
    
    public DatabaseSQLColumn(final String key, final Class clazz, final int... data) {
        this(key, clazz, false, data);
    }
    
    public DatabaseSQLColumn(final String key, final Class clazz, final boolean nullable) {
        this(key, clazz, nullable, (int[])null);
    }
    
    public DatabaseSQLColumn(final String key, final Class clazz, final boolean nullable, final int... data) {
        if (key == null || clazz == null) {
            throw new IllegalArgumentException();
        }
        this.key = key;
        this.clazz = clazz;
        this.nullable = nullable;
        this.data = ((data != null) ? data : new int[0]);
    }
    
    public final String getKey() {
        return this.key;
    }
    
    public final int getTypeID() {
        if (this.clazz.equals(String.class)) {
            return 0;
        }
        if (this.clazz.equals(Boolean.class)) {
            return 1;
        }
        if (this.clazz.equals(Integer.class)) {
            return 2;
        }
        if (this.clazz.equals(Double.class)) {
            return 3;
        }
        if (this.clazz.equals(Float.class)) {
            return 4;
        }
        return -1;
    }
    
    public final int[] getData() {
        return this.data;
    }
    
    public final String getTypeString() {
        final int typeID = this.getTypeID();
        if (typeID == 0) {
            final int length = (this.data.length > 0) ? this.data[0] : 255;
            final String result = (length > 255) ? "text" : ("varchar(" + length + ")");
            return result;
        }
        if (typeID == 1) {
            final String result2 = "boolean";
            return "boolean";
        }
        if (typeID == 2) {
            final int precision = (this.data.length > 0) ? this.data[0] : 10;
            final String result = "integer(" + precision + ")";
            return result;
        }
        if (typeID == 3) {
            final int precision = (this.data.length > 0) ? this.data[0] : 5;
            final int scale = (this.data.length > 1) ? this.data[1] : 2;
            final String result3 = "decimal(" + precision + "," + scale + ")";
            return result3;
        }
        if (typeID == 4) {
            final int precision = (this.data.length > 0) ? this.data[0] : 16;
            final String result = "float(" + precision + ")";
            return result;
        }
        return null;
    }
    
    public final boolean isNullable() {
        return this.nullable;
    }
}
