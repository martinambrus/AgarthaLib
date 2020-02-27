// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.player;

import org.bukkit.entity.Player;

public interface PacketPlayerCombatPresent extends PacketPlayerCombat
{
    float getSwingDuration(final Player p0);
    
    float getSwingProgress(final Player p0);
    
    void playSwingOffHand(final Player p0);
}
