// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerMetrics extends Handler
{
    protected HandlerMetrics(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public static Collection<HandlerMetrics> getAllHandlerMetrics() {
        return Handler.getHandlers(HandlerMetrics.class);
    }
}
