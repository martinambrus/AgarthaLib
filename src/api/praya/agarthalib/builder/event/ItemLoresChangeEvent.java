// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import java.util.Collection;
import com.praya.agarthalib.utility.TextUtil;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class ItemLoresChangeEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final ItemStack item;
    private final List<String> lores;
    private boolean cancel;
    
    static {
        handlers = new HandlerList();
    }
    
    public ItemLoresChangeEvent(final ItemStack item, final List<String> lores) {
        this.cancel = false;
        this.item = item;
        this.lores = lores;
    }
    
    public final ItemStack getItem() {
        return this.item;
    }
    
    public final List<String> getLores() {
        return this.lores;
    }
    
    public final void setLores(final List<String> lores) {
        this.lores.clear();
        if (lores != null) {
            this.lores.addAll(TextUtil.colorful(lores));
        }
    }
    
    public HandlerList getHandlers() {
        return ItemLoresChangeEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return ItemLoresChangeEvent.handlers;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
}
