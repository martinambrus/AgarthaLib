// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSQLTable
{
    private final String table;
    private final String primaryKey;
    private final List<DatabaseSQLColumn> listColumn;
    
    public DatabaseSQLTable(final String table, final DatabaseSQLColumn column) {
        this(table, null, column);
    }
    
    public DatabaseSQLTable(final String table, final String primaryKey, final DatabaseSQLColumn column) {
        if (table == null || column == null) {
            throw new IllegalArgumentException();
        }
        final List<DatabaseSQLColumn> listColumn = new ArrayList<DatabaseSQLColumn>();
        listColumn.add(column);
        this.table = table;
        this.primaryKey = primaryKey;
        this.listColumn = listColumn;
    }
    
    public DatabaseSQLTable(final String table, final List<DatabaseSQLColumn> listColumn) {
        this(table, null, listColumn);
    }
    
    public DatabaseSQLTable(final String table, final String primaryKey, final List<DatabaseSQLColumn> listColumn) {
        if (table == null || listColumn == null || listColumn.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.table = table;
        this.primaryKey = primaryKey;
        this.listColumn = listColumn;
    }
    
    public final String getTable() {
        return this.table;
    }
    
    public final String getPrimaryKey() {
        if (this.primaryKey != null) {
            for (final DatabaseSQLColumn column : this.listColumn) {
                final String key = column.getKey();
                if (key.equalsIgnoreCase(this.primaryKey)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public final boolean hasPrimaryKey() {
        return this.getPrimaryKey() != null;
    }
    
    public final int getColumnSize() {
        return this.listColumn.size();
    }
    
    public final DatabaseSQLColumn getDatabaseColumn(final int index) {
        return (index < this.getColumnSize()) ? this.listColumn.get(index) : null;
    }
    
    public final String getKey(final int index) {
        final DatabaseSQLColumn databaseColumn = this.getDatabaseColumn(index);
        return (databaseColumn != null) ? databaseColumn.getKey() : null;
    }
    
    public final int getKeyTypeId(final int index) {
        final DatabaseSQLColumn databaseColumn = this.getDatabaseColumn(index);
        return (databaseColumn != null) ? databaseColumn.getTypeID() : -1;
    }
    
    public final int getKeyTypeID(final String key) {
        for (final DatabaseSQLColumn column : this.listColumn) {
            final String columnKey = column.getKey();
            if (columnKey.equals(key)) {
                final int id = column.getTypeID();
                return id;
            }
        }
        return -1;
    }
    
    public final boolean containsKey(final String key) {
        return this.getKeyTypeID(key) != -1;
    }
    
    public final String getFormatTable() {
        final int size = this.listColumn.size();
        String formatTable = "CREATE TABLE IF NOT EXISTS " + this.table + " (";
        String primary = null;
        if (this.hasPrimaryKey()) {
            for (final DatabaseSQLColumn column : this.listColumn) {
                final String key = column.getKey();
                if (key.equalsIgnoreCase(this.primaryKey)) {
                    primary = key;
                    break;
                }
            }
        }
        for (int index = 0; index < size; ++index) {
            final DatabaseSQLColumn column2 = this.listColumn.get(index);
            final String key = column2.getKey();
            final String type = column2.getTypeString();
            if (index > 0) {
                formatTable = String.valueOf(formatTable) + ", ";
            }
            if (!column2.isNullable()) {
                formatTable = String.valueOf(formatTable) + key + " " + type + " NOT NULL";
            }
            else {
                formatTable = String.valueOf(formatTable) + key + " " + type;
            }
        }
        if (primary != null) {
            formatTable = String.valueOf(formatTable) + ", PRIMARY KEY (" + primary + ")";
        }
        formatTable = String.valueOf(formatTable) + ");";
        return formatTable;
    }
    
    public final String getFormatStatement(final DatabaseStatement statement) {
        String format = "";
        if (statement.equals(DatabaseStatement.REPLACE_INTO)) {
            final int size = this.listColumn.size();
            format = String.valueOf(format) + "REPLACE INTO " + this.table + " (";
            for (int index = 0; index < size; ++index) {
                final DatabaseSQLColumn column = this.listColumn.get(index);
                final String key = column.getKey();
                if (index > 0) {
                    format = String.valueOf(format) + "," + key;
                }
                else {
                    format = String.valueOf(format) + key;
                }
            }
            format = String.valueOf(format) + ") VALUES(";
            for (int index = 0; index < size; ++index) {
                if (index > 0) {
                    format = String.valueOf(format) + ",?";
                }
                else {
                    format = String.valueOf(format) + "?";
                }
            }
            format = String.valueOf(format) + ");";
            return format;
        }
        return null;
    }
    
    public enum DatabaseStatement
    {
        REPLACE_INTO("REPLACE_INTO", 0);
        
        private DatabaseStatement(final String name, final int ordinal) {
        }
    }
}
