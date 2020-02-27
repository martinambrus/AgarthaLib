// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import com.praya.agarthalib.utility.MathUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import com.praya.agarthalib.event.PlayerHealthEvent;

public class PlayerHealthMaxChangeEvent extends PlayerHealthEvent
{
    private static final HandlerList handlers;
    private double maxHealth;
    
    static {
        handlers = new HandlerList();
    }
    
    public PlayerHealthMaxChangeEvent(final Player player, final double maxHealth) {
        super(player);
        this.maxHealth = MathUtil.limitDouble(maxHealth, 1.0, maxHealth);
    }
    
    public final double getMaxHealth() {
        return this.maxHealth;
    }
    
    public final void setMaxHealth(final double maxHealth) {
        this.maxHealth = MathUtil.limitDouble(maxHealth, 1.0, maxHealth);
    }
    
    @Override
    public HandlerList getHandlers() {
        return PlayerHealthMaxChangeEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PlayerHealthMaxChangeEvent.handlers;
    }
}
