// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.lang.reflect.Method;
import org.bukkit.entity.Player;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Location;
import java.util.UUID;

public class PacketUtil
{
    public static final Object buildWitherSpawnPacket(final int id, final UUID uuid, final Location loc, final Object dataWatcher) throws Exception {
        final Object packet = NMSClassUtil.PacketPlayOutSpawnEntityLiving.newInstance();
        if (!ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("a")).set(packet, id);
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("b")).set(packet, 64);
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("c")).set(packet, (int)loc.getX());
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("d")).set(packet, floor(loc.getY() * 32.0));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("e")).set(packet, (int)loc.getZ());
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("i")).set(packet, (byte)d(loc.getYaw() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("j")).set(packet, (byte)d(loc.getPitch() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("k")).set(packet, (byte)d(loc.getPitch() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("l")).set(packet, dataWatcher);
        }
        else {
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("a")).set(packet, id);
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("b")).set(packet, uuid);
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("c")).set(packet, 64);
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("d")).set(packet, loc.getX());
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("e")).set(packet, loc.getY());
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("f")).set(packet, loc.getZ());
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("j")).set(packet, (byte)d(loc.getYaw() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("k")).set(packet, (byte)d(loc.getPitch() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("l")).set(packet, (byte)d(loc.getPitch() * 256.0f / 360.0f));
            AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("m")).set(packet, dataWatcher);
        }
        return packet;
    }
    
    public static final Object buildNameMetadataPacket(final int id, final Object dataWatcher, final int nameIndex, final int visibilityIndex, final String name) throws Exception {
        final boolean is1_9 = ServerUtil.isCompatible(VersionNMS.V1_9_R2);
        DataWatcher.setValue(dataWatcher, nameIndex, DataWatcher.V1_9.ValueType.ENTITY_NAME, (name != null) ? name : "");
        DataWatcher.setValue(dataWatcher, visibilityIndex, DataWatcher.V1_9.ValueType.ENTITY_NAME_VISIBLE, is1_9 ? Boolean.valueOf(name != null && !name.isEmpty()) : Byte.valueOf((byte)((name != null && !name.isEmpty()) ? 1 : 0)));
        final Object metaPacket = NMSClassUtil.PacketPlayOutEntityMetadata.getConstructor(Integer.TYPE, NMSClassUtil.DataWatcher, Boolean.TYPE).newInstance(id, dataWatcher, true);
        return metaPacket;
    }
    
    public static final Object updateEntityLocation(final Object entity, final Location loc) throws Exception {
        NMSClassUtil.Entity.getDeclaredField("locX").set(entity, loc.getX());
        NMSClassUtil.Entity.getDeclaredField("locY").set(entity, loc.getY());
        NMSClassUtil.Entity.getDeclaredField("locZ").set(entity, loc.getZ());
        return entity;
    }
    
    public static final Object buildArmorStandSpawnPacket(final Object armorStand) throws Exception {
        final Object spawnPacket = NMSClassUtil.PacketPlayOutSpawnEntityLiving.getConstructor(NMSClassUtil.EntityLiving).newInstance(armorStand);
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutSpawnEntityLiving.getDeclaredField("b")).setInt(spawnPacket, 30);
        return spawnPacket;
    }
    
    public static final Object buildTeleportPacket(final int id, final Location loc, final boolean onGround, final boolean heightCorrection) throws Exception {
        final Object packet = NMSClassUtil.PacketPlayOutEntityTeleport.newInstance();
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("a")).set(packet, id);
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("b")).set(packet, (int)(loc.getX() * 32.0));
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("c")).set(packet, (int)(loc.getY() * 32.0));
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("d")).set(packet, (int)(loc.getZ() * 32.0));
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("e")).set(packet, (byte)(loc.getYaw() * 256.0f / 360.0f));
        AccessUtil.setAccessible(NMSClassUtil.PacketPlayOutEntityTeleport.getDeclaredField("f")).set(packet, (byte)(loc.getPitch() * 256.0f / 360.0f));
        return packet;
    }
    
    public static final void sendPacket(final Player player, final Object packet) {
        if (player == null || packet == null) {
            throw new IllegalArgumentException("player and packet cannot be null");
        }
        try {
            final Object handle = ReflectionUtil.getHandle(player);
            final Object connection = ReflectionUtil.getField(handle.getClass(), "playerConnection").get(handle);
            final Method methodSendPacket = ReflectionUtil.getMethod(connection.getClass(), "sendPacket", ReflectionUtil.getNMSClass("Packet"));
            methodSendPacket.invoke(connection, packet);
        }
        catch (Exception ex) {}
    }
    
    private static final int floor(final double value) {
        final int i = (int)value;
        return (value >= i) ? i : (i - 1);
    }
    
    private static final int d(final float value) {
        final int i = (int)value;
        return (value >= i) ? i : (i - 1);
    }
}
