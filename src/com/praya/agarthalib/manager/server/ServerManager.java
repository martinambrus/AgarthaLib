// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.server;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class ServerManager extends HandlerManager
{
    protected ServerManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract ServerPlayerManager getServerPlayerManager();
    
    public abstract ServerWorldManager getServerWorldManager();
}
