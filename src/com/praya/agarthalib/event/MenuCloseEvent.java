// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;

public class MenuCloseEvent extends api.praya.agarthalib.builder.event.MenuCloseEvent
{
    public MenuCloseEvent(final Player player, final Menu menu) {
        super(player, menu);
    }
}
