// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.Connection;

public abstract class DatabaseSQL extends Database
{
    protected final DatabaseSQLTable dbTable;
    protected Connection connection;
    
    protected DatabaseSQL(final JavaPlugin plugin, final DatabaseSQLTable dbTable) {
        super(plugin);
        if (dbTable == null) {
            throw new IllegalArgumentException();
        }
        this.dbTable = dbTable;
    }
    
    public abstract Connection getConnection();
    
    public final DatabaseSQLTable getDatabaseTable() {
        return this.dbTable;
    }
    
    @Override
    public final void initialize() {
        try {
            final Connection connection = this.getConnection();
            final Statement statement = connection.createStatement();
            final String statementTable = this.getDatabaseTable().getFormatTable();
            statement.executeUpdate(statementTable);
            statement.close();
        }
        catch (SQLException exception) {
            final DatabaseError.DatabaseErrorType databaseErrorType = DatabaseError.DatabaseErrorType.STATEMENT_FAILED_EXECUTE;
            this.throwError(exception, databaseErrorType);
        }
    }
    
    @Override
    public final void close() {
        try {
            final Connection connection = this.getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        catch (SQLException exception) {
            final DatabaseError.DatabaseErrorType databaseErrorType = DatabaseError.DatabaseErrorType.CONNECTION_FAILED_CLOSE;
            this.throwError(exception, databaseErrorType);
        }
    }
    
    public final void close(final PreparedStatement preparedStatement) {
        this.close(preparedStatement, null);
    }
    
    public final void close(final PreparedStatement preparedStatement, final ResultSet resultSet) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        catch (SQLException exception) {
            final DatabaseError.DatabaseErrorType databaseErrorType = DatabaseError.DatabaseErrorType.CONNECTION_FAILED_CLOSE;
            this.throwError(exception, databaseErrorType);
        }
    }
}
