// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.manager.player;

import core.praya.agarthalib.builder.message.ActionbarBuild;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.message.ActionbarCooldownBuild;
import java.util.UUID;
import java.util.HashMap;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerActionbarManagerAPI extends HandlerManager
{
    private final HashMap<UUID, ActionbarCooldownBuild> mapPlayerActionbarCooldown;
    
    protected PlayerActionbarManagerAPI(final AgarthaLib plugin) {
        super(plugin);
        this.mapPlayerActionbarCooldown = new HashMap<UUID, ActionbarCooldownBuild>();
    }
    
    public final ActionbarCooldownBuild getPlayerActionbarCooldown(final Player player) {
        final UUID playerID = player.getUniqueId();
        return this.mapPlayerActionbarCooldown.containsKey(playerID) ? this.mapPlayerActionbarCooldown.get(playerID) : new ActionbarCooldownBuild();
    }
    
    public final void setActionbarCooldown(final Player player, final ActionbarBuild actionbar, final long cooldown) {
        if (actionbar != null) {
            final String id = actionbar.getID();
            final int priority = actionbar.getPriority();
            this.setActionbarCooldown(player, id, priority, cooldown);
        }
    }
    
    public final void setActionbarCooldown(final Player player, final String id, final int priority, final long cooldown) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final long expired = System.currentTimeMillis() + cooldown;
            final ActionbarCooldownBuild actionbarCooldown = new ActionbarCooldownBuild(id, priority, expired);
            this.mapPlayerActionbarCooldown.put(playerID, actionbarCooldown);
        }
    }
    
    public final boolean isPlayerActionbarAllowed(final Player player, final ActionbarBuild actionbar) {
        final String id = actionbar.getID();
        final int priority = actionbar.getPriority();
        return this.isPlayerActionbarAllowed(player, id, priority);
    }
    
    public final boolean isPlayerActionbarAllowed(final Player player, final String id, final int priority) {
        final ActionbarCooldownBuild actionbarCooldown = this.getPlayerActionbarCooldown(player);
        final String idCooldown = actionbarCooldown.getID();
        final int priorityCooldown = actionbarCooldown.getPriority();
        final boolean isCooldown = actionbarCooldown.isCooldown();
        if (priority > priorityCooldown) {
            return true;
        }
        if (priority < priorityCooldown) {
            return !isCooldown;
        }
        return id.equalsIgnoreCase(idCooldown) || !isCooldown;
    }
}
