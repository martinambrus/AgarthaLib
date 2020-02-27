// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.particle;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import core.praya.agarthalib.builder.bridge.ParticleTools;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import core.praya.agarthalib.enums.branch.ParticleEnum;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_15_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class PacketParticle_1_15_R1 extends HandlerPacket implements ParticleTools
{
    public PacketParticle_1_15_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void packetPlayParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final float offsetX, final float offsetY, final float offsetZ, final float extra, final Object data) {
        if (players != null && particleEnum != null && location != null) {
            final ParticleParam particleParam = this.getParticleParam(particleEnum, data);
            if (particleParam != null) {
                final double x = location.getX();
                final double y = location.getY();
                final double z = location.getZ();
                final PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particleParam, false, (float)x, (float)y, (float)z, offsetX, offsetY, offsetZ, extra, count);
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
    
    private final ParticleParam getParticleParam(final ParticleEnum particleEnum, final Object data) {
        if (particleEnum != null) {
            final MinecraftKey minecraftKey = new MinecraftKey(particleEnum.getMinecraftKey());
            final Particle particle = (Particle)IRegistry.PARTICLE_TYPE.get(minecraftKey);
            if (particle != null) {
                if (data != null) {
                    final Class<?> dataType = particleEnum.getDataType();
                    if (dataType.isInstance(data)) {
                        if (dataType.equals(ItemStack.class)) {
                            final ItemStack item = (ItemStack)data;
                            return (ParticleParam)new ParticleParamItem(particle, CraftItemStack.asNMSCopy(item));
                        }
                        if (dataType.equals(MaterialEnum.class)) {
                            final MaterialEnum materialEnum = (MaterialEnum)data;
                            final Material material = materialEnum.getMaterial();
                            final BlockData blockData = Bukkit.createBlockData(material);
                            return (ParticleParam)new ParticleParamBlock(particle, ((CraftBlockData)blockData).getState());
                        }
                        if (dataType.equals(ParticleEnum.DustOptions.class)) {
                            final ParticleEnum.DustOptions dustOptions = (ParticleEnum.DustOptions)data;
                            final Color color = dustOptions.getColor();
                            final int red = color.getRed();
                            final int green = color.getGreen();
                            final int blue = color.getBlue();
                            final float size = dustOptions.getSize();
                            return (ParticleParam)new ParticleParamRedstone(red / 255.0f, green / 255.0f, blue / 255.0f, size);
                        }
                    }
                }
                return (ParticleParam)particle;
            }
        }
        return null;
    }
}
