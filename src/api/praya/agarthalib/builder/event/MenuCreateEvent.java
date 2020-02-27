// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Event;

public class MenuCreateEvent extends Event
{
    private static final HandlerList handlers;
    private final Menu menu;
    
    static {
        handlers = new HandlerList();
    }
    
    public MenuCreateEvent(final Menu menu) {
        this.menu = menu;
    }
    
    public final Menu getMenu() {
        return this.menu;
    }
    
    public HandlerList getHandlers() {
        return MenuCreateEvent.handlers;
    }
    
    public static final HandlerList getHandlerList() {
        return MenuCreateEvent.handlers;
    }
}
