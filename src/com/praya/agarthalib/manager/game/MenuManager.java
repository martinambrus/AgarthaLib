// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import com.praya.agarthalib.menu.MenuAgarthaLib;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class MenuManager extends HandlerManager
{
    protected MenuManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract MenuAgarthaLib getMenuAgarthaLib();
}
