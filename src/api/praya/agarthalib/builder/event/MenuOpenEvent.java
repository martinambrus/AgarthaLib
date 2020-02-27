// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class MenuOpenEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final Player player;
    private final Menu menu;
    private boolean cancel;
    
    static {
        handlers = new HandlerList();
    }
    
    public MenuOpenEvent(final Player player, final Menu menu) {
        this.cancel = false;
        this.player = player;
        this.menu = menu;
    }
    
    public final Player getPlayer() {
        return this.player;
    }
    
    public final Menu getMenu() {
        return this.menu;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
    
    public HandlerList getHandlers() {
        return MenuOpenEvent.handlers;
    }
    
    public static final HandlerList getHandlerList() {
        return MenuOpenEvent.handlers;
    }
}
