// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import org.bukkit.entity.Player;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public class PlayerRegionEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList handlers;
    private final ProtectedRegion region;
    private boolean cancel;
    
    static {
        handlers = new HandlerList();
    }
    
    public PlayerRegionEvent(final Player player, final ProtectedRegion region) {
        super(player);
        this.cancel = false;
        this.region = region;
    }
    
    public final ProtectedRegion getRegion() {
        return this.region;
    }
    
    public HandlerList getHandlers() {
        return PlayerRegionEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PlayerRegionEvent.handlers;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
}
