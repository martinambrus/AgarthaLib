// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.player;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.AgarthaLibConfig;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.utility.PlayerUtil;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PacketPlayer_1_15_R1 extends HandlerPacket implements PacketPlayerProperties, PacketPlayerVisibility, PacketPlayerCombatPresent, PacketPlayerAbsorption
{
    public PacketPlayer_1_15_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public final String getLocale(final Player player) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        if (player != null) {
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            return entityPlayer.locale;
        }
        return mainConfig.getGeneralLocale();
    }
    
    @Override
    public final void hideEntity(final Player player, final Entity entity) {
        if (player != null && entity != null) {
            final int entityId = entity.getEntityId();
            final PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[] { entityId });
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final PlayerConnection playerConnection = entityPlayer.playerConnection;
            playerConnection.sendPacket((Packet)packetPlayOutEntityDestroy);
        }
    }
    
    @Override
    public final void hideEntity(final Collection<Player> players, final Entity entity) {
        if (players != null && entity != null) {
            final int entityId = entity.getEntityId();
            final PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[] { entityId });
            for (final Player player : players) {
                final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
                final PlayerConnection playerConnection = entityPlayer.playerConnection;
                playerConnection.sendPacket((Packet)packetPlayOutEntityDestroy);
            }
        }
    }
    
    @Override
    public final float getAbsorptionHearts(final Player player) {
        if (player != null) {
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            return entityPlayer.getAbsorptionHearts();
        }
        return 0.0f;
    }
    
    @Override
    public final void setAbsorptionHearts(final Player player, final float absorptionHearts) {
        if (player != null) {
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            entityPlayer.setAbsorptionHearts(absorptionHearts);
        }
    }
    
    @Override
    public final float getSwingDuration(final Player player) {
        if (player != null) {
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final float duration = entityPlayer.ex();
            return duration;
        }
        return 0.0f;
    }
    
    @Override
    public final float getSwingProgress(final Player player) {
        if (player != null) {
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final float progress = entityPlayer.s(0.0f);
            return progress;
        }
        return 1.0f;
    }
    
    @Override
    public final void playSwingOffHand(final Player player) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        if (player != null) {
            final Location location = player.getLocation();
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final PacketPlayOutAnimation packet = new PacketPlayOutAnimation((net.minecraft.server.v1_15_R1.Entity)entityPlayer, 3);
            final double effectRange = mainConfig.getEffectRange();
            for (final Player viewer : PlayerUtil.getNearbyPlayers(location, effectRange)) {
                final EntityPlayer entityViewer = ((CraftPlayer)viewer).getHandle();
                entityViewer.playerConnection.sendPacket((Packet)packet);
            }
        }
    }
    
    @Override
    public final void playSwingMainHand(final Player player) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        if (player != null) {
            final Location location = player.getLocation();
            final EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            final PacketPlayOutAnimation packet = new PacketPlayOutAnimation((net.minecraft.server.v1_15_R1.Entity)entityPlayer, 0);
            final double effectRange = mainConfig.getEffectRange();
            for (final Player viewer : PlayerUtil.getNearbyPlayers(location, effectRange)) {
                final EntityPlayer entityViewer = ((CraftPlayer)viewer).getHandle();
                entityViewer.playerConnection.sendPacket((Packet)packet);
            }
        }
    }
}
