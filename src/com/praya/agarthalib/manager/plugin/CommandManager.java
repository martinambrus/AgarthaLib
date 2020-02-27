// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.plugin;

import java.util.Iterator;
import com.praya.agarthalib.utility.SenderUtil;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import java.util.List;
import core.praya.agarthalib.builder.command.CommandBuild;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class CommandManager extends HandlerManager
{
    protected CommandManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<String> getCommandIds();
    
    public abstract Collection<CommandBuild> getAllCommandBuild();
    
    public abstract CommandBuild getCommandBuild(final String p0);
    
    public final boolean isCommandExists(final String id) {
        return this.getCommandBuild(id) != null;
    }
    
    public final String getMain(final String id) {
        final CommandBuild commandBuild = this.getCommandBuild(id);
        return (commandBuild != null) ? commandBuild.getMain() : null;
    }
    
    public final String getPermission(final String id) {
        final CommandBuild commandBuild = this.getCommandBuild(id);
        return (commandBuild != null) ? commandBuild.getPermission() : null;
    }
    
    public final List<String> getAliases(final String id) {
        final CommandBuild commandBuild = this.getCommandBuild(id);
        return (commandBuild != null) ? commandBuild.getAliases() : new ArrayList<String>();
    }
    
    public final boolean checkPermission(final CommandSender sender, final String id) {
        final CommandBuild commandBuild = this.getCommandBuild(id);
        if (commandBuild != null) {
            final String permission = commandBuild.getPermission();
            return SenderUtil.hasPermission(sender, permission);
        }
        return false;
    }
    
    public final boolean checkCommand(final String arg, final String id) {
        final CommandBuild commandBuild = this.getCommandBuild(id);
        if (commandBuild != null) {
            final String main = commandBuild.getMain();
            if (main.equalsIgnoreCase(arg)) {
                return true;
            }
            for (final String aliases : commandBuild.getAliases()) {
                if (aliases.equalsIgnoreCase(arg)) {
                    return true;
                }
            }
        }
        return false;
    }
}
