// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.Location;
import core.praya.agarthalib.enums.branch.SoundEnum;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.main.ServerType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;

public class SenderUtil
{
    public static final boolean isPlayer(final CommandSender sender) {
        return sender != null && sender instanceof Player;
    }
    
    public static final void sendMessage(final CommandSender sender, final String message) {
        sendMessage(sender, message, false, true);
    }
    
    public static final void sendMessage(final CommandSender sender, final String message, final boolean allowEmpty) {
        sendMessage(sender, message, allowEmpty, true);
    }
    
    public static final void sendMessage(final CommandSender sender, String message, final boolean allowEmpty, boolean json) {
        final ServerType serverType = ServerUtil.getServerType();
        final boolean allowedSender = sender != null && (sender instanceof Player || sender instanceof ConsoleCommandSender);
        final boolean allowedMessage = message != null && (allowEmpty || !message.isEmpty());
        if (allowedSender && allowedMessage) {
            json = ((!serverType.equals(ServerType.FORGE) || !ServerUtil.isVersion_1_7()) && json);
            if (json && isPlayer(sender)) {
                final Player player = PlayerUtil.parse(sender);
                message = TextUtil.hookPlaceholderAPI(player, message);
                Bridge.getBridgeMessage().sendJson(player, message);
            }
            else {
                message = TextUtil.hookPlaceholderAPI(null, message);
                message = JsonUtil.clearJson(message);
                message = TextUtil.colorful(message);
                sender.sendMessage(message);
            }
        }
    }
    
    public static final void playSound(final CommandSender sender, final SoundEnum sound) {
        if (isPlayer(sender)) {
            final Player player = PlayerUtil.parse(sender);
            final Location loc = player.getLocation();
            Bridge.getBridgeSound().playSound(player, loc, sound, 1.0f, 1.0f);
        }
    }
    
    public static final boolean hasPermission(final CommandSender sender, final String permission) {
        if (sender != null && permission != null && sender instanceof Player) {
            final Player player = (Player)sender;
            if (!permission.isEmpty()) {
                return player.hasPermission(permission);
            }
        }
        return true;
    }
}
