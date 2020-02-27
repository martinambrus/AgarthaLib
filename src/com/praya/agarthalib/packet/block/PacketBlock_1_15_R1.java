// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.block;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import net.minecraft.server.v1_15_R1.BlockPosition;
import net.minecraft.server.v1_15_R1.Packet;
import net.minecraft.server.v1_15_R1.PacketPlayOutBlockBreakAnimation;
import net.minecraft.server.v1_15_R1.PlayerConnection;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PacketBlock_1_15_R1 extends HandlerPacket implements PacketBlockAnimation
{
    public PacketBlock_1_15_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void blockBreakAnimation(final int id, final Collection<Player> players, final int x, final int y, final int z, final int stage) {
        if (players != null) {
            final BlockPosition                    blockPosition = new BlockPosition(x, y, z);
            final PacketPlayOutBlockBreakAnimation packet        = new PacketPlayOutBlockBreakAnimation(id, blockPosition, stage);
            for (final Player player : players) {
                final CraftPlayer      craftPlayer      = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
}
