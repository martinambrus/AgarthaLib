// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.player;

import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import core.praya.agarthalib.builder.message.BossBar;
import core.praya.agarthalib.builder.message.ActionbarBuild;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.message.MessageCooldownBuild;
import java.util.UUID;
import java.util.HashMap;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerMessageManager extends HandlerManager
{
    private final HashMap<UUID, MessageCooldownBuild> mapPlayerActionbarCooldown;
    private final HashMap<UUID, MessageCooldownBuild> mapPlayerBossBarCooldown;
    
    protected PlayerMessageManager(final AgarthaLib plugin) {
        super(plugin);
        this.mapPlayerActionbarCooldown = new HashMap<UUID, MessageCooldownBuild>();
        this.mapPlayerBossBarCooldown = new HashMap<UUID, MessageCooldownBuild>();
    }
    
    public final MessageCooldownBuild getPlayerActionbarCooldown(final Player player) {
        final UUID playerID = player.getUniqueId();
        return this.mapPlayerActionbarCooldown.containsKey(playerID) ? this.mapPlayerActionbarCooldown.get(playerID) : new MessageCooldownBuild();
    }
    
    public final MessageCooldownBuild getPlayerBossBarCooldown(final Player player) {
        final UUID playerID = player.getUniqueId();
        return this.mapPlayerBossBarCooldown.containsKey(playerID) ? this.mapPlayerBossBarCooldown.get(playerID) : new MessageCooldownBuild();
    }
    
    public final void setActionbarCooldown(final Player player, final ActionbarBuild actionbar, final long cooldown) {
        if (actionbar != null) {
            final String id = actionbar.getID();
            final int priority = actionbar.getPriority();
            this.setActionbarCooldown(player, id, priority, cooldown);
        }
    }
    
    public final void setBossBarCooldown(final Player player, final BossBar bossBar, final long cooldown) {
        if (bossBar != null) {
            final String id = bossBar.getID();
            final int priority = bossBar.getPriority();
            this.setBossBarCooldown(player, id, priority, cooldown);
        }
    }
    
    public final void setActionbarCooldown(final Player player, final String id, final int priority, final long cooldown) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final long expired = System.currentTimeMillis() + cooldown;
            final MessageCooldownBuild actionbarCooldown = new MessageCooldownBuild(id, priority, expired);
            this.mapPlayerActionbarCooldown.put(playerID, actionbarCooldown);
        }
    }
    
    public final void setBossBarCooldown(final Player player, final String id, final int priority, final long cooldown) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final long expired = System.currentTimeMillis() + cooldown;
            final MessageCooldownBuild actionbarCooldown = new MessageCooldownBuild(id, priority, expired);
            this.mapPlayerBossBarCooldown.put(playerID, actionbarCooldown);
        }
    }
    
    public final boolean isPlayerActionbarAllowed(final Player player, final ActionbarBuild actionbar) {
        final String id = actionbar.getID();
        final int priority = actionbar.getPriority();
        return this.isPlayerActionbarAllowed(player, id, priority);
    }
    
    public final boolean isPlayerBossBarAllowed(final Player player, final BossBar bossBar) {
        final String id = bossBar.getID();
        final int priority = bossBar.getPriority();
        return this.isPlayerBossBarAllowed(player, id, priority);
    }
    
    public final boolean isPlayerActionbarAllowed(final Player player, final String id, final int priority) {
        final MessageCooldownBuild actionbarCooldown = this.getPlayerActionbarCooldown(player);
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
    
    public final boolean isPlayerBossBarAllowed(final Player player, final String id, final int priority) {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            return true;
        }
        final MessageCooldownBuild actionbarCooldown = this.getPlayerBossBarCooldown(player);
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
