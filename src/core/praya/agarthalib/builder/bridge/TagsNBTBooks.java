// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.bridge;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface TagsNBTBooks
{
    void openBook(final ItemStack p0, final Player p1);
    
    ItemStack createBook(final String p0, final int p1, final String p2, final String p3, final String... p4);
}
