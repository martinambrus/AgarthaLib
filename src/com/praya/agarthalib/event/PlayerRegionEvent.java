// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.entity.Player;

public class PlayerRegionEvent extends api.praya.agarthalib.builder.event.PlayerRegionEvent
{
    public PlayerRegionEvent(final Player player, final ProtectedRegion region) {
        super(player, region);
    }
}
