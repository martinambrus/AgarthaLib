// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.player;

import java.util.Collection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface PacketPlayerVisibility
{
    void hideEntity(final Player p0, final Entity p1);
    
    void hideEntity(final Collection<Player> p0, final Entity p1);
}
