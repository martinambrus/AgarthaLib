// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import org.bukkit.entity.Player;

public class PlayerHealthChangeEvent extends api.praya.agarthalib.builder.event.PlayerHealthChangeEvent
{
    public PlayerHealthChangeEvent(final Player player, final double health) {
        super(player, health);
    }
}
