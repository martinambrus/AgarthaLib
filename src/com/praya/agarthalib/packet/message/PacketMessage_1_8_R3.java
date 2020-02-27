// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.message;

import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.utility.JsonUtil;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import java.util.Iterator;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.MessageTitle;
import core.praya.agarthalib.builder.bridge.MessageJson;
import core.praya.agarthalib.builder.bridge.MessageActionbar;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketMessage_1_8_R3 extends HandlerPacket implements MessageActionbar, MessageJson, MessageTitle
{
    public PacketMessage_1_8_R3(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void packetSendActionbar(final Collection<Player> players, final String message) {
        if (players != null && message != null) {
            final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
            final PacketPlayOutChat packet = new PacketPlayOutChat(icbc, (byte)2);
            for (final Player player : players) {
                final CraftPlayer craftPlayer = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
    
    @Override
    public void packetSendJson(final Collection<Player> players, final String message) {
        if (players != null && message != null) {
            final String fullChatJson = JsonUtil.getJsonText(message);
            final IChatBaseComponent comp = IChatBaseComponent.ChatSerializer.a(fullChatJson);
            final PacketPlayOutChat packet = new PacketPlayOutChat(comp);
            for (final Player player : players) {
                final CraftPlayer craftPlayer = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
    
    @Override
    public String packetGetJsonItem(final ItemStack item) {
        if (item != null) {
            final net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(item);
            final NBTTagCompound compound = nmsItemStack.save(new NBTTagCompound());
            final String jsonString = compound.toString().replaceAll("\"", "");
            return jsonString;
        }
        return null;
    }
    
    @Override
    public final void packetSendTitle(final Collection<Player> players, final String message, final int fadeIn, final int stay, final int fadeOut) {
        if (players != null && message != null) {
            final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
            final PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, icbc, fadeIn, stay, fadeOut);
            for (final Player player : players) {
                final CraftPlayer craftPlayer = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
    
    @Override
    public final void packetSendSubtitle(final Collection<Player> players, final String message, final int fadeIn, final int stay, final int fadeOut) {
        if (players != null && message != null) {
            final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
            final PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, icbc, fadeIn, stay, fadeOut);
            for (final Player player : players) {
                final CraftPlayer craftPlayer = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
}
