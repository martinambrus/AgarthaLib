// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.server;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.World;
import java.util.HashMap;
import com.praya.agarthalib.manager.server.ServerWorldManager;

public final class ServerWorldMemory extends ServerWorldManager
{
    private final HashMap<String, World> mapWorld;
    
    private ServerWorldMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapWorld = new HashMap<String, World>();
        this.loadAllWorld();
    }
    
    public static final ServerWorldMemory getInstance() {
        return ServerWorldMemorySingleton.INSTANCE;
    }
    
    @Override
    public Collection<String> getWorldNames() {
        return new ArrayList<String>(this.mapWorld.keySet());
    }
    
    @Override
    public Collection<World> getAllWorld() {
        return new ArrayList<World>(this.mapWorld.values());
    }
    
    @Override
    public World getWorld(final String world) {
        if (world != null) {
            for (final World key : this.mapWorld.values()) {
                if (key.getName().equals(world)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public final boolean register(final World world) {
        if (world != null) {
            final String worldName = world.getName();
            this.mapWorld.put(worldName, world);
            return true;
        }
        return false;
    }
    
    public final boolean unregister(final World world) {
        if (world != null) {
            final String worldName = world.getName();
            return this.mapWorld.remove(worldName, world);
        }
        return false;
    }
    
    private final void loadAllWorld() {
        for (final World world : Bukkit.getWorlds()) {
            this.register(world);
        }
    }
    
    private static class ServerWorldMemorySingleton
    {
        private static final ServerWorldMemory INSTANCE;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            INSTANCE = new ServerWorldMemory(plugin);
        }
    }
}
