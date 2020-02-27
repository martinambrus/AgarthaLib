// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.inventory;

import java.util.Iterator;
import org.bukkit.entity.HumanEntity;
import net.minecraft.server.v1_10_R1.PlayerConnection;
import net.minecraft.server.v1_10_R1.Container;
import net.minecraft.server.v1_10_R1.EntityPlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import net.minecraft.server.v1_10_R1.Packet;
import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.PacketPlayOutOpenWindow;
import net.minecraft.server.v1_10_R1.ChatMessage;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.WindowTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketInventory_1_10_R1 extends HandlerPacket implements WindowTools
{
    public PacketInventory_1_10_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void setTitleWindow(final Player player, final String title) {
        if (player != null && title != null) {
            final InventoryView view = player.getOpenInventory();
            final Inventory topInventory = view.getTopInventory();
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final Container container = entityPlayer.activeContainer;
            final String name = "minecraft:chest";
            final int id = container.windowId;
            final int size = topInventory.getSize();
            final ChatMessage chatMessage = new ChatMessage(title, new Object[0]);
            final PlayerConnection connection = entityPlayer.playerConnection;
            final PacketPlayOutOpenWindow packet = new PacketPlayOutOpenWindow(id, "minecraft:chest", (IChatBaseComponent)chatMessage, size);
            connection.sendPacket((Packet)packet);
            entityPlayer.updateInventory(container);
        }
    }
    
    @Override
    public void setTitleWindow(final Inventory inventory, final String title) {
        if (inventory != null && title != null) {
            for (final HumanEntity human : inventory.getViewers()) {
                if (human instanceof Player) {
                    final Player player = (Player)human;
                    this.setTitleWindow(player, title);
                }
            }
        }
    }
}
