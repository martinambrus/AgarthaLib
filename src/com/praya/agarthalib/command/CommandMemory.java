// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.command;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Iterator;
import core.praya.agarthalib.builder.command.CommandBuild;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.manager.plugin.CommandManager;

public class CommandMemory extends CommandManager
{
    private final CommandConfig commandConfig;
    
    private CommandMemory(final AgarthaLib plugin) {
        super(plugin);
        this.commandConfig = new CommandConfig(plugin);
    }
    
    public static final CommandMemory getInstance() {
        return CommandMemoryHelper.instance;
    }
    
    public final CommandConfig getCommandConfig() {
        return this.commandConfig;
    }
    
    @Override
    public final Collection<String> getCommandIds() {
        return this.getCommandConfig().mapCommandBuild.keySet();
    }
    
    @Override
    public final Collection<CommandBuild> getAllCommandBuild() {
        return this.getCommandConfig().mapCommandBuild.values();
    }
    
    @Override
    public final CommandBuild getCommandBuild(final String id) {
        for (final String key : this.getCommandIds()) {
            if (key.equalsIgnoreCase(id)) {
                return this.getCommandConfig().mapCommandBuild.get(key);
            }
        }
        return null;
    }
    
    private static class CommandMemoryHelper
    {
        private static final CommandMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new CommandMemory(plugin);
        }
    }
}
