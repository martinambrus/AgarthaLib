// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.menu.MenuExecutor;

public abstract class HandlerMenu extends Handler
{
    private final MenuExecutor menuExecutor;
    
    protected HandlerMenu(final AgarthaLib plugin, final MenuExecutor menuExecutor) {
        super(plugin);
        this.menuExecutor = menuExecutor;
    }
    
    public final MenuExecutor getMenuExecutor() {
        return this.menuExecutor;
    }
    
    public static Collection<HandlerMenu> getAllHandlerMenu() {
        return Handler.getHandlers(HandlerMenu.class);
    }
}
