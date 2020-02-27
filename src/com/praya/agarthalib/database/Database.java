// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Database
{
    protected final JavaPlugin plugin;
    
    protected Database(final JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public abstract void initialize();
    
    public abstract void close();
    
    public final void throwError(final Exception exception, final DatabaseError.DatabaseErrorType databaseErrorType) {
        this.throwError(exception, databaseErrorType, Level.SEVERE);
    }
    
    public final void throwError(final Exception exception, final DatabaseError.DatabaseErrorType databaseErrorType, final Level level) {
        final Logger logger = this.plugin.getLogger();
        if (exception != null && databaseErrorType != null && level != null) {
            final String message = databaseErrorType.getErrorMessage();
            logger.log(level, message, exception);
        }
    }
}
