// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerBridge extends Handler
{
    protected HandlerBridge(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public static Collection<HandlerBridge> getAllHandlerBridge() {
        return Handler.getHandlers(HandlerBridge.class);
    }
}
