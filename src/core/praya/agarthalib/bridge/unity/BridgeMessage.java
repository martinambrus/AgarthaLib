// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import api.praya.agarthalib.main.AgarthaLibAPI;
import api.praya.agarthalib.manager.player.PlayerActionbarManagerAPI;
import api.praya.agarthalib.manager.player.PlayerManagerAPI;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.Handler;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.manager.player.PlayerBossBarManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import com.praya.agarthalib.manager.player.PlayerMessageManager;
import com.praya.agarthalib.packet.message.*;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.utility.ServerUtil;
import com.praya.agarthalib.utility.TextUtil;
import core.praya.agarthalib.builder.bridge.MessageActionbar;
import core.praya.agarthalib.builder.bridge.MessageJson;
import core.praya.agarthalib.builder.bridge.MessageTitle;
import core.praya.agarthalib.builder.message.BossBar;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class BridgeMessage extends Handler
{
    final HandlerPacket handler;
    
    protected BridgeMessage(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    public static final BridgeMessage getInstance() {
        return BridgeMessageHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final MessageActionbar getMessageActionBar() {
        return (this.isSet() && this.getHandler() instanceof MessageActionbar) ? ((MessageActionbar)this.getHandler()) : null;
    }
    
    public final MessageJson getMessageJson() {
        return (this.isSet() && this.getHandler() instanceof MessageJson) ? ((MessageJson)this.getHandler()) : null;
    }
    
    public final MessageTitle getMessageTitle() {
        return (this.isSet() && this.getHandler() instanceof MessageTitle) ? ((MessageTitle)this.getHandler()) : null;
    }
    
    public final boolean isImplementMessageActionbar() {
        return this.getMessageActionBar() != null;
    }
    
    public final boolean isImplementMessageJson() {
        return this.getMessageJson() != null;
    }
    
    public final boolean isImplementMessageTitle() {
        return this.getMessageTitle() != null;
    }
    
    public final void sendActionbar(final Player player, final String message) {
        if (player != null) {
            this.sendActionbar(PlayerUtil.toCollection(player), message);
        }
    }
    
    public final void sendActionbar(final Collection<Player> players, final String message) {
        final MessageActionbar messageActionbar = this.getMessageActionBar();
        if (messageActionbar != null) {
            messageActionbar.packetSendActionbar(players, TextUtil.colorful(message));
        }
    }
    
    public final void sendProtectedActionbar(final Player player, final String message, final String id, final int priority) {
        this.sendProtectedActionbar(player, message, id, priority, 3000L, false);
    }
    
    public final void sendProtectedActionbar(final Player player, final String message, final String id, final int priority, final long cooldown) {
        this.sendProtectedActionbar(player, message, id, priority, cooldown, false);
    }
    
    public final void sendProtectedActionbar(final Player player, final String message, final String id, final int priority, final long cooldown, final boolean bypass) {
        final AgarthaLibAPI agarthaLibAPI = AgarthaLibAPI.getInstance();
        final PlayerManagerAPI playerManagerAPI = agarthaLibAPI.getPlayerManagerAPI();
        final PlayerActionbarManagerAPI playerActionbarManagerAPI = playerManagerAPI.getPlayerActionbarManager();
        if (player != null && message != null && (bypass || playerActionbarManagerAPI.isPlayerActionbarAllowed(player, id, priority))) {
            playerActionbarManagerAPI.setActionbarCooldown(player, id, priority, cooldown);
            this.sendActionbar(player, message);
        }
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players, final String message, final String id, final int priority) {
        this.sendProtectedActionbar(players, message, id, priority, 3000L, false);
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players, final String message, final String id, final int priority, final long cooldown) {
        this.sendProtectedActionbar(players, message, id, priority, cooldown, false);
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players, final String message, final String id, final int priority, final long cooldown, final boolean bypass) {
        final AgarthaLibAPI agarthaLibAPI = AgarthaLibAPI.getInstance();
        final PlayerManagerAPI playerManagerAPI = agarthaLibAPI.getPlayerManagerAPI();
        final PlayerActionbarManagerAPI playerActionbarManagerAPI = playerManagerAPI.getPlayerActionbarManager();
        final Collection<Player> allowedPlayers = new ArrayList<Player>();
        if (players != null && message != null) {
            for (final Player player : players) {
                if (bypass || playerActionbarManagerAPI.isPlayerActionbarAllowed(player, id, priority)) {
                    allowedPlayers.add(player);
                    playerActionbarManagerAPI.setActionbarCooldown(player, id, priority, cooldown);
                }
            }
        }
        this.sendActionbar(allowedPlayers, message);
    }
    
    public final void sendJson(final Player player, final String message) {
        this.sendJson(PlayerUtil.toCollection(player), message);
    }
    
    public final void sendJson(final Collection<Player> players, final String message) {
        final MessageJson messageJson = this.getMessageJson();
        if (messageJson != null) {
            messageJson.packetSendJson(players, message);
        }
    }
    
    public final String getJsonItem(final ItemStack item) {
        return this.isImplementMessageJson() ? this.getMessageJson().packetGetJsonItem(item) : null;
    }
    
    public final void sendTitle(final Player player, final String message, final int fadeIn, final int stay, final int fadeOut) {
        this.sendTitle(PlayerUtil.toCollection(player), message, fadeIn, stay, fadeOut);
    }
    
    public final void sendTitle(final Collection<Player> players, final String message, final int fadeIn, final int stay, final int fadeOut) {
        final MessageTitle messageTitle = this.getMessageTitle();
        if (messageTitle != null) {
            messageTitle.packetSendTitle(players, message, fadeIn, stay, fadeOut);
        }
    }
    
    public final void sendSubtitle(final Player player, final String message, final int fadeIn, final int stay, final int fadeOut) {
        this.sendSubtitle(PlayerUtil.toCollection(player), message, fadeIn, stay, fadeOut);
    }
    
    public final void sendSubtitle(final Collection<Player> players, final String message, final int fadeIn, final int stay, final int fadeOut) {
        final MessageTitle messageTitle = this.getMessageTitle();
        if (messageTitle != null) {
            messageTitle.packetSendSubtitle(players, message, fadeIn, stay, fadeOut);
        }
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.sendProtectedBossBar(players, message, "Default", 0, 3000L, color, style, progress, properties);
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, final String message, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.sendProtectedBossBar(players, message, "Default", 0, cooldown, color, style, progress, properties);
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, String message, final String id, final int priority, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final PlayerMessageManager playerMessageManager = playerManager.getPlayerMessageManager();
        if (ServerUtil.isCompatible(VersionNMS.V1_13_R2)) {
            message = TextUtil.firstSolidCharacter(message);
        }
        if (players != null && message != null) {
            for (final Player player : players) {
                if (playerMessageManager.isPlayerBossBarAllowed(player, id, priority)) {
                    playerBossBarManager.addBar(player, message, id, priority, color, style, progress, properties);
                    playerMessageManager.setBossBarCooldown(player, id, priority, cooldown);
                }
            }
        }
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        this.sendProtectedBossBar(players, message, "Default", 0, 3000L, color, style, progress, timeout, interval, properties);
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, final String message, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        this.sendProtectedBossBar(players, message, "Default", 0, cooldown, color, style, progress, timeout, interval, properties);
    }
    
    public final void sendProtectedBossBar(final Collection<Player> players, String message, final String id, final int priority, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final PlayerMessageManager playerMessageManager = playerManager.getPlayerMessageManager();
        if (ServerUtil.isCompatible(VersionNMS.V1_13_R2)) {
            message = TextUtil.firstSolidCharacter(message);
        }
        if (players != null && message != null) {
            for (final Player player : players) {
                if (playerMessageManager.isPlayerBossBarAllowed(player, id, priority)) {
                    playerBossBarManager.addBar(player, message, id, priority, color, style, progress, timeout, interval, properties);
                    playerMessageManager.setBossBarCooldown(player, id, priority, cooldown);
                }
            }
        }
    }
    
    public final void sendProtectedBossBar(final Player player, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.sendProtectedBossBar(player, message, "Default", 0, 3000L, color, style, progress, properties);
    }
    
    public final void sendProtectedBossBar(final Player player, final String message, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        this.sendProtectedBossBar(player, message, "Default", 0, cooldown, color, style, progress, properties);
    }
    
    public final void sendProtectedBossBar(final Player player, String message, final String id, final int priority, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final BossBar.Property... properties) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final PlayerMessageManager playerMessageManager = playerManager.getPlayerMessageManager();
        if (ServerUtil.isCompatible(VersionNMS.V1_13_R2)) {
            message = TextUtil.firstSolidCharacter(message);
        }
        if (player != null && message != null && playerMessageManager.isPlayerBossBarAllowed(player, id, priority)) {
            playerBossBarManager.addBar(player, message, id, priority, color, style, progress, properties);
            playerMessageManager.setBossBarCooldown(player, id, priority, cooldown);
        }
    }
    
    public final void sendProtectedBossBar(final Player player, final String message, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        this.sendProtectedBossBar(player, message, "Default", 0, 3000L, color, style, progress, timeout, interval, properties);
    }
    
    public final void sendProtectedBossBar(final Player player, final String message, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        this.sendProtectedBossBar(player, message, "Default", 0, cooldown, color, style, progress, timeout, interval, properties);
    }
    
    public final void sendProtectedBossBar(final Player player, String message, final String id, final int priority, final long cooldown, final BossBar.Color color, final BossBar.Style style, final float progress, final int timeout, final long interval, final BossBar.Property... properties) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final PlayerMessageManager playerMessageManager = playerManager.getPlayerMessageManager();
        if (ServerUtil.isCompatible(VersionNMS.V1_13_R2)) {
            message = TextUtil.firstSolidCharacter(message);
        }
        if (player != null && message != null && playerMessageManager.isPlayerBossBarAllowed(player, id, priority)) {
            playerBossBarManager.addBar(player, message, id, priority, color, style, progress, timeout, interval, properties);
            playerMessageManager.setBossBarCooldown(player, id, priority, cooldown);
        }
    }
    
    public final boolean isBossBarPlayerIDExists(final Player player, final String id) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        return playerBossBarManager.isBossBarPlayerIDExists(player, id);
    }
    
    public final void removeBossBar(final Player player, final String id) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        playerBossBarManager.removeBossBarPlayerByID(player, id);
    }
    
    public final void removeBossBar(final Player player, final BossBar bossBar) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        playerBossBarManager.removeBarForPlayer(player, bossBar);
    }
    
    public final void removeAllBossBar(final Player player) {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        playerBossBarManager.removeAllBars(player);
    }
    
    private static class BridgeMessageHelper
    {
        private static final BridgeMessage instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketMessage_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketMessage_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketMessage_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketMessage_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketMessage_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketMessage_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketMessage_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketMessage_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketMessage_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeMessage(plugin, handler);
        }
    }
}
