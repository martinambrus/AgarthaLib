// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.block;

import net.minecraft.server.v1_7_R4.PlayerConnection;
import java.util.Iterator;
import net.minecraft.server.v1_7_R4.Packet;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutBlockBreakAnimation;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketBlock_1_7_R4 extends HandlerPacket implements PacketBlockAnimation
{
    public PacketBlock_1_7_R4(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void blockBreakAnimation(final int id, final Collection<Player> players, final int x, final int y, final int z, final int stage) {
        if (players != null) {
            final PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(id, x, y, z, stage);
            for (final Player player : players) {
                final CraftPlayer craftPlayer = (CraftPlayer)player;
                final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                playerConnection.sendPacket((Packet)packet);
            }
        }
    }
}
