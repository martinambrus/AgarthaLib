// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.bridge;

import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import java.util.Collection;

public interface MessageJson
{
    void packetSendJson(final Collection<Player> p0, final String p1);
    
    String packetGetJsonItem(final ItemStack p0);
}
