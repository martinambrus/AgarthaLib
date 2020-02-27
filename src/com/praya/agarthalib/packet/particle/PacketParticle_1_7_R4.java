// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.particle;

import net.minecraft.server.v1_7_R4.PlayerConnection;
import java.util.Iterator;
import net.minecraft.server.v1_7_R4.Packet;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import core.praya.agarthalib.enums.branch.ParticleEnum;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.ParticleTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketParticle_1_7_R4 extends HandlerPacket implements ParticleTools
{
    public PacketParticle_1_7_R4(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void packetPlayParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final float offsetX, final float offsetY, final float offsetZ, final float extra, final Object data) {
        if (players != null && particleEnum != null && location != null) {
            final String nameLegacy = particleEnum.getNameLegacy();
            if (nameLegacy != null) {
                final double x = location.getX();
                final double y = location.getY();
                final double z = location.getZ();
                final PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(nameLegacy, (float)x, (float)y, (float)z, offsetX, offsetY, offsetZ, extra, count);
                for (final Player player : players) {
                    final CraftPlayer craftPlayer = (CraftPlayer)player;
                    final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                    playerConnection.sendPacket((Packet)packet);
                }
            }
        }
    }
    
    @Override
    public void packetPlayParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float data) {
        this.packetPlayParticle(players, particleEnum, location, count, (float)offsetX, (float)offsetY, (float)offsetZ, data, null);
    }
}
