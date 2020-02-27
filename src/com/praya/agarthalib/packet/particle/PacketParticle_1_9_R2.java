// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.particle;

import org.bukkit.Material;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import org.bukkit.inventory.ItemStack;
import net.minecraft.server.v1_9_R2.PlayerConnection;
import java.util.Iterator;
import net.minecraft.server.v1_9_R2.EnumParticle;
import net.minecraft.server.v1_9_R2.Packet;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import net.minecraft.server.v1_9_R2.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import core.praya.agarthalib.enums.branch.ParticleEnum;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.ParticleTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketParticle_1_9_R2 extends HandlerPacket implements ParticleTools
{
    public PacketParticle_1_9_R2(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void packetPlayParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final float offsetX, final float offsetY, final float offsetZ, final float extra, final Object data) {
        if (players != null && particleEnum != null && location != null) {
            final EnumParticle particle = this.getEnumParticle(particleEnum);
            if (particle != null) {
                final double x = location.getX();
                final double y = location.getY();
                final double z = location.getZ();
                final int[] dataParticle = this.getDataParticle(particleEnum, data);
                final PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, false, (float)x, (float)y, (float)z, offsetX, offsetY, offsetZ, extra, count, dataParticle);
                for (final Player player : players) {
                    final CraftPlayer craftPlayer = (CraftPlayer)player;
                    final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
                    playerConnection.sendPacket((Packet)packet);
                }
            }
        }
    }
    
    @Override
    public void packetPlayParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float extra) {
        this.packetPlayParticle(players, particleEnum, location, count, (float)offsetX, (float)offsetY, (float)offsetZ, extra, null);
    }
    
    private final int[] getDataParticle(final ParticleEnum particleEnum, final Object data) {
        if (particleEnum != null) {
            final Class<?> dataType = particleEnum.getDataType();
            if (dataType.equals(ItemStack.class)) {
                if (data != null && data instanceof ItemStack) {
                    final ItemStack item = (ItemStack)data;
                    final Material material = item.getType();
                    final int id = material.getId();
                    final int durability = item.getDurability();
                    return new int[] { id, durability };
                }
                return new int[2];
            }
            else if (dataType.equals(MaterialEnum.class)) {
                if (data == null || !(data instanceof MaterialEnum)) {
                    return new int[1];
                }
                final MaterialEnum materialEnum = (MaterialEnum)data;
                final Material material = materialEnum.getMaterial();
                if (material != null) {
                    final int id = material.getId();
                    final int dataLegacy = materialEnum.getDataLegacy();
                    return new int[] { id + (dataLegacy << 12) };
                }
            }
        }
        return new int[0];
    }
    
    private final EnumParticle getEnumParticle(final ParticleEnum particleEnum) {
        for (int index = 0; index < 2; ++index) {
            final String name = (index == 0) ? particleEnum.toString() : particleEnum.getReplacement();
            if (name != null) {
                EnumParticle[] values;
                for (int length = (values = EnumParticle.values()).length, i = 0; i < length; ++i) {
                    final EnumParticle key = values[i];
                    if (key.toString().equalsIgnoreCase(name)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
}
