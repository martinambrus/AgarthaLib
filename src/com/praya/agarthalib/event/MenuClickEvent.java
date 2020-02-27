// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import core.praya.agarthalib.builder.menu.MenuSlotAction;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;

public class MenuClickEvent extends api.praya.agarthalib.builder.event.MenuClickEvent
{
    public MenuClickEvent(final Player player, final Menu menu, final MenuSlotAction.ActionType actionType, final int slot) {
        super(player, menu, actionType, slot);
    }
}
