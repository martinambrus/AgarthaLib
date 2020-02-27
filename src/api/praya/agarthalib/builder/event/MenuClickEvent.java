// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import core.praya.agarthalib.builder.menu.MenuSlotAction;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class MenuClickEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final Player player;
    private final Menu menu;
    private final MenuSlotAction.ActionType actionType;
    private final int slot;
    private boolean cancel;
    
    static {
        handlers = new HandlerList();
    }
    
    public MenuClickEvent(final Player player, final Menu menu, final MenuSlotAction.ActionType actionType, final int slot) {
        this.cancel = false;
        this.player = player;
        this.menu = menu;
        this.actionType = actionType;
        this.slot = slot;
    }
    
    public final Player getPlayer() {
        return this.player;
    }
    
    public final Menu getMenu() {
        return this.menu;
    }
    
    public final MenuSlotAction.ActionType getActionType() {
        return this.actionType;
    }
    
    public final int getSlot() {
        return this.slot;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
    
    public HandlerList getHandlers() {
        return MenuClickEvent.handlers;
    }
    
    public static final HandlerList getHandlerList() {
        return MenuClickEvent.handlers;
    }
}
