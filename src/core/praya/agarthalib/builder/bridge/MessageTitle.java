// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.bridge;

import org.bukkit.entity.Player;
import java.util.Collection;

public interface MessageTitle
{
    void packetSendTitle(final Collection<Player> p0, final String p1, final int p2, final int p3, final int p4);
    
    void packetSendSubtitle(final Collection<Player> p0, final String p1, final int p2, final int p3, final int p4);
}
