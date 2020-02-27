// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.database;

import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;

@Deprecated
public class DatabaseError
{
    public static final String getErrorMessage(final DatabaseErrorType type) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = plugin.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        switch (type) {
            case NO_SQL_CONNECTION: {
                return lang.getText("Exception_Database_No_SQL_Connection");
            }
            case NO_SQLITE_LIBRARY: {
                return lang.getText("Exception_Database_No_SQLite_Library");
            }
            case NO_TABLE: {
                return lang.getText("Exception_Database_No_Table");
            }
            case SQL_CONNECTION_CLOSE: {
                return lang.getText("Exception_Database_SQL_Connection_Close");
            }
            case SQL_CONNECTION_EXECUTE: {
                return lang.getText("Exception_Database_SQL_Connection_Execute");
            }
            case SQL_CONNECTION_INITIALIZE: {
                return lang.getText("Exception_Database_SQL_Connection_Initialize");
            }
            default: {
                return "";
            }
        }
    }
    
    public enum DatabaseErrorType
    {
        SQL_CONNECTION_INITIALIZE("SQL_CONNECTION_INITIALIZE", 0), 
        SQL_CONNECTION_EXECUTE("SQL_CONNECTION_EXECUTE", 1), 
        SQL_CONNECTION_CLOSE("SQL_CONNECTION_CLOSE", 2), 
        NO_SQL_CONNECTION("NO_SQL_CONNECTION", 3), 
        NO_SQLITE_LIBRARY("NO_SQLITE_LIBRARY", 4), 
        NO_TABLE("NO_TABLE", 5);
        
        private DatabaseErrorType(final String name, final int ordinal) {
        }
    }
}
