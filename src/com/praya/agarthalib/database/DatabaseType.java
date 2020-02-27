// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

public enum DatabaseType
{
    SQLite("SQLite", 0, true), 
    MySQL("MySQL", 1, false);
    
    private final boolean local;
    
    private DatabaseType(final String name, final int ordinal, final boolean local) {
        this.local = local;
    }
    
    public final boolean isLocal() {
        return this.local;
    }
    
    public static final DatabaseType getDatabaseType(final String type) {
        if (type != null) {
            DatabaseType[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final DatabaseType key = values[i];
                if (key.toString().equalsIgnoreCase(type)) {
                    return key;
                }
            }
        }
        return null;
    }
}
