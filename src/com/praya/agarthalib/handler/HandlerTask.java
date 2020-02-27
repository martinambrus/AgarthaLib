// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerTask extends Handler
{
    protected HandlerTask(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public static Collection<HandlerTask> getAllHandlerTask() {
        return Handler.getHandlers(HandlerTask.class);
    }
}
