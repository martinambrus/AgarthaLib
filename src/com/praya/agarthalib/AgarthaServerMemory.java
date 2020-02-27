// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib;

import com.praya.agarthalib.server.ServerWorldMemory;
import com.praya.agarthalib.server.ServerPlayerMemory;
import com.praya.agarthalib.manager.server.ServerWorldManager;
import com.praya.agarthalib.manager.server.ServerPlayerManager;
import com.praya.agarthalib.manager.server.ServerManager;

public final class AgarthaServerMemory extends ServerManager
{
    private final ServerPlayerManager serverPlayerManager;
    private final ServerWorldManager serverWorldManager;
    
    protected AgarthaServerMemory(final AgarthaLib plugin) {
        super(plugin);
        this.serverPlayerManager = ServerPlayerMemory.getInstance();
        this.serverWorldManager = ServerWorldMemory.getInstance();
    }
    
    @Override
    public ServerPlayerManager getServerPlayerManager() {
        return this.serverPlayerManager;
    }
    
    @Override
    public ServerWorldManager getServerWorldManager() {
        return this.serverWorldManager;
    }
}
