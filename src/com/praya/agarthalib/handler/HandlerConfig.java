// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerConfig extends Handler
{
    protected HandlerConfig(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract void setup();
    
    public static Collection<HandlerConfig> getAllHandlerConfig() {
        return Handler.getHandlers(HandlerConfig.class);
    }
}
