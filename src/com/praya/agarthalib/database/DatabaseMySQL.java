// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import org.bukkit.plugin.java.JavaPlugin;

public class DatabaseMySQL extends DatabaseSQL
{
    private final DatabaseClient databaseClient;
    
    public DatabaseMySQL(final JavaPlugin plugin, final DatabaseSQLTable dbTable, final DatabaseClient databaseClient) {
        super(plugin, dbTable);
        if (databaseClient == null) {
            throw new IllegalArgumentException();
        }
        this.databaseClient = databaseClient;
    }
    
    public final DatabaseClient getDatabaseClient() {
        return this.databaseClient;
    }
    
    @Override
    public final Connection getConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                return this.connection;
            }
            final DatabaseClient databaseClient = this.getDatabaseClient();
            final String clientHost = databaseClient.getHost();
            final int clientPort = databaseClient.getPort();
            final String clientDatabase = databaseClient.getDatabase();
            final String clientUsername = databaseClient.getUsername();
            final String clientPassword = databaseClient.getPassword();
            final String url = "jdbc:mysql://" + clientHost + ":" + clientPort + "/" + clientDatabase;
            Class.forName("com.mysql.jdbc.Driver");
            return this.connection = DriverManager.getConnection(url, clientUsername, clientPassword);
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
