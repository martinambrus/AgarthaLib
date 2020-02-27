// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.core;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public class CoreManager extends HandlerManager
{
    private final CoreMenuManager coreMenuManager;
    
    public CoreManager(final AgarthaLib plugin) {
        super(plugin);
        this.coreMenuManager = new CoreMenuManager(plugin);
    }
    
    public final CoreMenuManager getCoreMenuManager() {
        return this.coreMenuManager;
    }
}
