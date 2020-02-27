// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.entity.Player;

public class PlayerRegionEnterEvent extends api.praya.agarthalib.builder.event.PlayerRegionEnterEvent
{
    public PlayerRegionEnterEvent(final Player player, final ProtectedRegion region) {
        super(player, region);
    }
}
