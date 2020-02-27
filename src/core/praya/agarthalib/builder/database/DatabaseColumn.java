// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.database;

@Deprecated
public class DatabaseColumn
{
    private final String key;
    private final Class clazz;
    private final boolean nullable;
    
    public DatabaseColumn(final String key, final Class clazz) {
        this(key, clazz, false);
    }
    
    public DatabaseColumn(final String key, final Class clazz, final boolean nullable) {
        this.key = key;
        this.clazz = clazz;
        this.nullable = nullable;
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
    
    public final String getTypeString(final int... data) {
        final int typeID = this.getTypeID();
        if (typeID == 0) {
            final int length = (data.length > 0) ? data[0] : 32;
            final String result = "varchar(" + length + ")";
            return result;
        }
        if (typeID == 1) {
            final String result2 = "boolean";
            return "boolean";
        }
        if (typeID == 2) {
            final int precision = (data.length > 0) ? data[0] : 10;
            final String result = "integer(" + precision + ")";
            return result;
        }
        if (typeID == 3) {
            final int precision = (data.length > 0) ? data[0] : 5;
            final int scale = (data.length > 1) ? data[1] : 2;
            final String result3 = "decimal(" + precision + "," + scale + ")";
            return result3;
        }
        if (typeID == 4) {
            final int precision = (data.length > 0) ? data[0] : 16;
            final String result = "float(" + precision + ")";
            return result;
        }
        return null;
    }
    
    public final boolean isNullable() {
        return this.nullable;
    }
}
