// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.server;

import org.bukkit.World;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class ServerWorldManager extends HandlerManager
{
    protected ServerWorldManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<String> getWorldNames();
    
    public abstract Collection<World> getAllWorld();
    
    public abstract World getWorld(final String p0);
    
    public final boolean isWorldExists(final String worldName) {
        return this.getWorld(worldName) != null;
    }
}
