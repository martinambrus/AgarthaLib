// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.message;

import net.minecraft.server.v1_7_R4.NBTTagCompound;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import java.util.Iterator;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.Packet;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import com.praya.agarthalib.utility.JsonUtil;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.MessageJson;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketMessage_1_7_R4 extends HandlerPacket implements MessageJson
{
    public PacketMessage_1_7_R4(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void packetSendJson(final Collection<Player> players, final String message) {
        if (players != null && message != null) {
            final String fullChatJson = JsonUtil.getJsonText(message);
            final IChatBaseComponent comp = ChatSerializer.a(fullChatJson);
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
            final net.minecraft.server.v1_7_R4.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(item);
            final NBTTagCompound compound = nmsItemStack.save(new NBTTagCompound());
            final String jsonString = compound.toString().replaceAll("\"", "");
            return jsonString;
        }
        return null;
    }
}
