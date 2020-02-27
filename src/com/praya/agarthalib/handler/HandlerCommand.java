// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;

public abstract class HandlerCommand extends Handler
{
    protected HandlerCommand(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public static Collection<HandlerCommand> getAllHandlerCommand() {
        return Handler.getHandlers(HandlerCommand.class);
    }
}
