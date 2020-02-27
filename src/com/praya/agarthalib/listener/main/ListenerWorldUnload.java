// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventHandler;
import org.bukkit.World;
import com.praya.agarthalib.server.ServerWorldMemory;
import org.bukkit.event.world.WorldUnloadEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerCommand;

public class ListenerWorldUnload extends HandlerCommand implements Listener
{
    public ListenerWorldUnload(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler
    public void unregisterWorld(final WorldUnloadEvent event) {
        final ServerWorldMemory serverWorldMemory = ServerWorldMemory.getInstance();
        final World world = event.getWorld();
        serverWorldMemory.unregister(world);
    }
}
