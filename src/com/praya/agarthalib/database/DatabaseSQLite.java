// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import java.sql.SQLException;
import java.sql.DriverManager;
import com.praya.agarthalib.utility.FileUtil;
import java.sql.Connection;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class DatabaseSQLite extends DatabaseSQL
{
    private final File file;
    
    public DatabaseSQLite(final JavaPlugin plugin, final DatabaseSQLTable dbTable, final File file) {
        super(plugin, dbTable);
        if (file == null) {
            throw new IllegalArgumentException();
        }
        this.file = file;
    }
    
    public final File getFile() {
        return this.file;
    }
    
    @Override
    public final Connection getConnection() {
        if (!this.file.exists()) {
            FileUtil.createFileSilent(this.file);
        }
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                return this.connection;
            }
            Class.forName("org.sqlite.JDBC");
            return this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.file);
        }
        catch (SQLException exception) {
            final DatabaseError.DatabaseErrorType databaseErrorType = DatabaseError.DatabaseErrorType.CONNECTION_FAILED_RETRIEVE;
            this.throwError(exception, databaseErrorType);
        }
        catch (ClassNotFoundException exception2) {
            final DatabaseError.DatabaseErrorType databaseErrorType = DatabaseError.DatabaseErrorType.LIBRARY_NOT_EXISTS;
            this.throwError(exception2, databaseErrorType);
        }
        return null;
    }
}
