// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.arrow;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Color;

public interface PacketArrowModification
{
    ItemStack createTippedArrow(final Color p0);
    
    ItemStack createTippedArrow(final int p0, final int p1, final int p2);
    
    ItemStack createSpectralArrow();
}
