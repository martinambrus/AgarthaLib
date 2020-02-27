// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public class PlayerHealthEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList handlers;
    private boolean cancel;
    
    static {
        handlers = new HandlerList();
    }
    
    public PlayerHealthEvent(final Player player) {
        super(player);
        this.cancel = false;
    }
    
    public HandlerList getHandlers() {
        return PlayerHealthEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PlayerHealthEvent.handlers;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
}
