// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerMenuExecutor extends Handler
{
    protected HandlerMenuExecutor(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public static Collection<HandlerMenuExecutor> getAllHandlerMenuExecutor() {
        return Handler.getHandlers(HandlerMenuExecutor.class);
    }
}
