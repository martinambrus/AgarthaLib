// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import com.praya.agarthalib.event.PlayerRegionEvent;

public class PlayerRegionLeaveEvent extends PlayerRegionEvent
{
    private static final HandlerList handlers;
    
    static {
        handlers = new HandlerList();
    }
    
    public PlayerRegionLeaveEvent(final Player player, final ProtectedRegion region) {
        super(player, region);
    }
    
    @Override
    public HandlerList getHandlers() {
        return PlayerRegionLeaveEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PlayerRegionLeaveEvent.handlers;
    }
}
