// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.player;

import org.bukkit.scheduler.BukkitRunnable;
import java.util.List;
import javax.annotation.Nonnull;
import core.praya.agarthalib.builder.message.BossBarEntity;
import org.bukkit.plugin.Plugin;
import core.praya.agarthalib.builder.message.BossBarTimer;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.utility.TextUtil;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import core.praya.agarthalib.builder.message.BossBarPacket;
import java.util.Iterator;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.concurrent.ConcurrentHashMap;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.message.BossBar;
import java.util.Collection;
import java.util.UUID;
import java.util.Map;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerBossBarManager extends HandlerManager
{
    private final Map<UUID, Collection<BossBar>> barMap;
    
    public PlayerBossBarManager(final AgarthaLib plugin) {
        super(plugin);
        this.barMap = new ConcurrentHashMap<UUID, Collection<BossBar>>();
    }
    
    public final BossBar getBossBarPlayerByID(final Player player, final String id) {
        final Collection<BossBar> bossBars = new ArrayList<BossBar>(this.getBossBars(player));
        for (final BossBar bossBar : bossBars) {
            if (bossBar.getID().equalsIgnoreCase(id)) {
                return bossBar;
            }
        }
        return null;
    }
    
    public final boolean isBossBarPlayerIDExists(final Player player, final String id) {
        return this.getBossBarPlayerByID(player, id) != null;
    }
    
    public final void removeBossBarPlayerByID(final Player player, final String id) {
        final BossBar bossBar = this.getBossBarPlayerByID(player, id);
        if (bossBar != null) {
            this.removeBarForPlayer(player, bossBar);
        }
    }
    
    public final BossBar addBar(final Collection<Player> players, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        return this.addBar(players, message, "Default", 0, color, style, progress, properties);
    }
    
    public final BossBar addBar(final Collection<Player> players, final String message, final String id, final int priority, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.validateNewVersion();
        final BossBar bossBar = new BossBarPacket(message, id, priority, color, style, progress, properties);
        for (final Player player : players) {
            final BossBar playerBossBar = this.getBossBarPlayerByID(player, id);
            if (playerBossBar != null) {
                playerBossBar.copyData(bossBar);
            }
            else {
                this.addBarForPlayer(player, bossBar);
            }
        }
        return bossBar;
    }
    
    public final BossBar addBar(final Collection<Player> players, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        return this.addBar(players, message, "Default", 0, color, style, progress, timeout, interval, properties);
    }
    
    public final BossBar addBar(final Collection<Player> players, final String message, final String id, final int priority, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        this.validateNewVersion();
        final BossBar bossBar = this.addBar(players, message, id, priority, color, style, progress, properties);
        final BossBarPacket bossBarPacket = (BossBarPacket)bossBar;
        this.setBossBarTimer(bossBarPacket, progress, timeout, interval);
        return bossBar;
    }
    
    public final BossBar addBar(final Player player, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        return this.addBar(player, message, "Default", 0, color, style, progress, properties);
    }
    
    public final BossBar addBar(final Player player, String message, final String id, final int priority, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final BossBar bossBar = new BossBarPacket(message, id, priority, color, style, progress, properties);
            final BossBar playerBossBar = this.getBossBarPlayerByID(player, id);
            if (playerBossBar != null) {
                playerBossBar.copyData(bossBar);
            }
            else {
                this.addBarForPlayer(player, bossBar);
            }
            return bossBar;
        }
        message = TextUtil.colorful(message);
        this.setMessage(player, message, id, priority, progress * 100.0f, 0, 100.0f);
        return this.getBossBar(player);
    }
    
    public final BossBar addBar(final Player player, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        return this.addBar(player, message, "Default", 0, color, style, progress, timeout, interval, properties);
    }
    
    public final BossBar addBar(final Player player, final String message, final String id, final int priority, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final BossBar bossBar = this.addBar(player, message, id, priority, color, style, progress, properties);
            final BossBarPacket bossBarPacket = (BossBarPacket)bossBar;
            new BossBarTimer(bossBarPacket, progress, timeout).runTaskTimer((Plugin)plugin, interval, interval);
            return bossBar;
        }
        this.setMessage(player, message, id, priority, progress * 100.0f, timeout, 100.0f);
        return this.getBossBar(player);
    }
    
    public final BossBar createBar(final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        return this.createBar(message, "Default", 0, color, style, progress, properties);
    }
    
    public final BossBar createBar(final String message, final String id, final int priority, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.validateNewVersion();
        final BossBar bossBar = new BossBarPacket(message, id, priority, color, style, progress, properties);
        return bossBar;
    }
    
    public final Collection<BossBar> getBossBars(final Player player) {
        final UUID playerID = player.getUniqueId();
        return this.barMap.containsKey(playerID) ? this.barMap.get(playerID) : new ArrayList<BossBar>();
    }
    
    public final void addBarForPlayer(final Player player, final BossBar bossBar) {
        final UUID playerID = player.getUniqueId();
        final Collection<BossBar> bossBars = this.getBossBars(player);
        if (!bossBar.getPlayers().contains(player)) {
            bossBar.addPlayer(player);
            bossBars.add(bossBar);
            this.barMap.put(playerID, bossBars);
        }
    }
    
    public final void removeBarForPlayer(final Player player, final BossBar bossBar) {
        final UUID playerID = player.getUniqueId();
        final Collection<BossBar> bossBars = this.getBossBars(player);
        if (!bossBars.isEmpty() && bossBars.contains(bossBar)) {
            bossBar.removePlayer(player);
            bossBars.remove(bossBar);
            if (!bossBars.isEmpty()) {
                this.barMap.put(playerID, bossBars);
            }
            else {
                this.barMap.remove(playerID);
            }
        }
    }
    
    public final void removeAllBars(final Player player) {
        final Collection<BossBar> bossBars = new ArrayList<BossBar>(this.getBossBars(player));
        for (final BossBar bossBar : bossBars) {
            this.removeBarForPlayer(player, bossBar);
        }
    }
    
    @Deprecated
    public final void setMessage(final Player player, final String message) {
        this.setMessage(player, message, 100.0f);
    }
    
    @Deprecated
    public final void setMessage(final Player player, final String message, final float percentage) {
        this.setMessage(player, message, percentage, 0);
    }
    
    @Deprecated
    public final void setMessage(final Player player, final String message, final float percentage, final int timeout) {
        this.setMessage(player, message, percentage, timeout, 100.0f);
    }
    
    @Deprecated
    public final void setMessage(final Player player, final String message, final float percentage, final int timeout, final float minHealth) {
        this.setMessage(player, message, "Default", 0, percentage, timeout, 100.0f);
    }
    
    @Deprecated
    public final void setMessage(final Player player, final String message, final String id, final int priority, final float percentage, final int timeout, final float minHealth) {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            this.removeAllBars(player);
            this.addBar(player, message, id, priority, BossBar.Color.PURPLE, BossBar.Style.PROGRESS, percentage / 100.0f, new BossBar.Property[0]);
        }
        else {
            final UUID playerID = player.getUniqueId();
            if (!this.barMap.containsKey(playerID)) {
                final ArrayList<BossBar> list = new ArrayList<BossBar>();
                final BossBarEntity bossBarEntity = new BossBarEntity(player, message, id, priority, percentage, timeout, minHealth);
                list.add(bossBarEntity);
                this.barMap.put(playerID, list);
            }
            final BossBar bar = this.getBossBar(player);
            final float newHealth = percentage / 100.0f * bar.getMaxHealth();
            if (!bar.getMessage().equals(message)) {
                bar.setMessage(message);
            }
            if (bar.getHealth() != newHealth) {
                bar.setHealth(percentage);
            }
            if (!bar.isVisible()) {
                bar.setVisible(true);
            }
        }
    }
    
    @Deprecated
    public final String getMessage(final Player player) {
        final BossBar bar = this.getBossBar(player);
        return (bar != null) ? bar.getMessage() : null;
    }
    
    @Deprecated
    public final boolean hasBar(final Player player) {
        final UUID playerID = player.getUniqueId();
        return this.barMap.containsKey(playerID);
    }
    
    @Deprecated
    public final void removeBar(final Player player) {
        final BossBar bar = this.getBossBar(player);
        if (bar != null) {
            bar.setVisible(false);
        }
        this.removeAllBars(player);
    }
    
    @Deprecated
    public final void setHealth(final Player player, final float percentage) {
        final BossBar bar = this.getBossBar(player);
        if (bar != null) {
            bar.setHealth(percentage);
        }
    }
    
    @Deprecated
    public final float getHealth(@Nonnull final Player player) {
        final BossBar bar = this.getBossBar(player);
        return (bar != null) ? bar.getHealth() : -1.0f;
    }
    
    @Deprecated
    public final BossBar getBossBar(final Player player) {
        final UUID playerID = player.getUniqueId();
        if (this.barMap.containsKey(playerID)) {
            final Iterator<BossBar> iterator = this.barMap.get(playerID).iterator();
            if (iterator.hasNext()) {
                final BossBar bossBar = iterator.next();
                return bossBar;
            }
        }
        return null;
    }
    
    @Deprecated
    public final Collection<BossBar> getBossBars() {
        final List<BossBar> list = new ArrayList<BossBar>();
        for (final Collection<BossBar> collection : this.barMap.values()) {
            list.addAll(collection);
        }
        return list;
    }
    
    public final void handlePlayerTeleport(final Player player) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (!ServerUtil.isCompatible(VersionNMS.V1_9_R2) && this.hasBar(player)) {
            final BossBar bar = this.getBossBar(player);
            bar.setVisible(false);
            new BukkitRunnable() {
                public void run() {
                    bar.setVisible(true);
                }
            }.runTaskLater((Plugin)plugin, 2L);
        }
    }
    
    private final void validateNewVersion() {
        if (!ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This method is not compatible with versions < 1.9");
            throw new RuntimeException(unsupportedOperationException);
        }
    }
    
    private final void setBossBarTimer(final BossBarPacket bossBarPacket, final float progress, final int timeout, final long interval) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final BukkitRunnable taskBossBarTimer = new BossBarTimer(bossBarPacket, progress, timeout);
        taskBossBarTimer.runTaskTimer((Plugin)plugin, interval, interval);
    }
}
