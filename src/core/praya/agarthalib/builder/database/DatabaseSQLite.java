// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.database;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.DriverManager;
import com.praya.agarthalib.utility.FileUtil;
import java.sql.Connection;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

@Deprecated
public class DatabaseSQLite extends Database
{
    private final File file;
    
    public DatabaseSQLite(final JavaPlugin plugin, final File file, final DatabaseTable dbTable) {
        super(plugin, dbTable);
        this.file = file;
    }
    
    public final File getFile() {
        return this.file;
    }
    
    @Override
    public final Connection getSQLConnection() {
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
        catch (SQLException ex) {
            final DatabaseError.DatabaseErrorType errorType = DatabaseError.DatabaseErrorType.SQL_CONNECTION_INITIALIZE;
            this.plugin.getLogger().log(Level.SEVERE, DatabaseError.getErrorMessage(errorType), ex);
        }
        catch (ClassNotFoundException ex2) {
            final DatabaseError.DatabaseErrorType errorType = DatabaseError.DatabaseErrorType.NO_SQLITE_LIBRARY;
            this.plugin.getLogger().log(Level.SEVERE, DatabaseError.getErrorMessage(errorType), ex2);
        }
        return null;
    }
    
    @Override
    public final void load() {
        this.connection = this.getSQLConnection();
        try {
            final Statement statement = this.connection.createStatement();
            final String statementTable = this.getDatabaseTable().getFormatTable();
            statement.executeUpdate(statementTable);
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        this.initialize();
    }
}
