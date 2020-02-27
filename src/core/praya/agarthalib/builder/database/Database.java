// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.database;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Connection;
import org.bukkit.plugin.java.JavaPlugin;

@Deprecated
public abstract class Database
{
    protected final JavaPlugin plugin;
    protected final DatabaseTable dbTable;
    protected Connection connection;
    
    public Database(final JavaPlugin plugin, final DatabaseTable dbTable) {
        this.plugin = plugin;
        this.dbTable = dbTable;
    }
    
    public abstract Connection getSQLConnection();
    
    public abstract void load();
    
    public final DatabaseTable getDatabaseTable() {
        return this.dbTable;
    }
    
    public final void initialize() {
        this.connection = this.getSQLConnection();
        try {
            final String table = this.dbTable.getTable();
            final PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM " + table);
            final ResultSet rs = ps.executeQuery();
            this.close(ps, rs);
        }
        catch (SQLException ex) {
            final DatabaseError.DatabaseErrorType errorType = DatabaseError.DatabaseErrorType.SQL_CONNECTION_INITIALIZE;
            this.plugin.getLogger().log(Level.SEVERE, DatabaseError.getErrorMessage(errorType), ex);
        }
    }
    
    public final void close(final PreparedStatement ps, final ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        catch (SQLException ex) {
            final DatabaseError.DatabaseErrorType errorType = DatabaseError.DatabaseErrorType.SQL_CONNECTION_CLOSE;
            this.plugin.getLogger().log(Level.SEVERE, DatabaseError.getErrorMessage(errorType), ex);
        }
    }
    
    public enum DatabaseType
    {
        SQLite("SQLite", 0), 
        MySQL("MySQL", 1);
        
        private DatabaseType(final String name, final int ordinal) {
        }
    }
}
