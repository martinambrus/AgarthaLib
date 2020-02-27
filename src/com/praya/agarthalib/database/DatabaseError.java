// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.command.CommandSender;

public class DatabaseError
{
    public enum DatabaseErrorType
    {
        CONNECTION_FAILED_RETRIEVE("CONNECTION_FAILED_RETRIEVE", 0), 
        CONNECTION_FAILED_CLOSE("CONNECTION_FAILED_CLOSE", 1), 
        STATEMENT_FAILED_EXECUTE("STATEMENT_FAILED_EXECUTE", 2), 
        LIBRARY_NOT_EXISTS("LIBRARY_NOT_EXISTS", 3), 
        SQL_TABLE_NOT_EXISTS("SQL_TABLE_NOT_EXISTS", 4);
        
        private DatabaseErrorType(final String name, final int ordinal) {
        }
        
        public static final DatabaseErrorType getDatabaseErrorType(final String type) {
            if (type != null) {
                DatabaseErrorType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final DatabaseErrorType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
        
        public final String getErrorMessage() {
            return this.getErrorMessage(null);
        }
        
        public final String getErrorMessage(final CommandSender sender) {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final PluginManager pluginManager = plugin.getPluginManager();
            final LanguageManager lang = pluginManager.getLanguageManager();
            switch (this) {
                case CONNECTION_FAILED_RETRIEVE: {
                    return lang.getText(sender, "Database_Connection_Failed_Retrieve");
                }
                case CONNECTION_FAILED_CLOSE: {
                    return lang.getText(sender, "Database_Connection_Failed_Close");
                }
                case STATEMENT_FAILED_EXECUTE: {
                    return lang.getText(sender, "Database_Statement_Failed_Execute");
                }
                case LIBRARY_NOT_EXISTS: {
                    return lang.getText(sender, "Database_Library_Not_Exists");
                }
                case SQL_TABLE_NOT_EXISTS: {
                    return lang.getText(sender, "Database_SQL_Table_Not_Exists");
                }
                default: {
                    return "";
                }
            }
        }
    }
}
