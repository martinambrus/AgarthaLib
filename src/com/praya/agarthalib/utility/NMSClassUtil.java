// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.lang.reflect.Field;

public class NMSClassUtil
{
    private static boolean initialized;
    public static Class<?> Entity;
    public static Class<?> EntityLiving;
    public static Class<?> EntityInsentient;
    public static Class<?> EntityAgeable;
    public static Class<?> EntityHorse;
    public static Class<?> EntityArmorStand;
    public static Class<?> EntityWither;
    public static Class<?> EntityWitherSkull;
    public static Class<?> EntitySlime;
    public static Class<?> World;
    public static Class<?> PacketPlayOutSpawnEntityLiving;
    public static Class<?> PacketPlayOutSpawnEntity;
    public static Class<?> PacketPlayOutEntityDestroy;
    public static Class<?> PacketPlayOutAttachEntity;
    public static Class<?> PacketPlayOutEntityTeleport;
    public static Class<?> PacketPlayOutEntityMetadata;
    public static Class<?> DataWatcher;
    public static Class<?> WatchableObject;
    public static Class<?> ItemStack;
    public static Class<?> ChunkCoordinates;
    public static Class<?> BlockPosition;
    public static Class<?> Vector3f;
    public static Class<?> EnumEntityUseAction;
    
    static {
        if (!NMSClassUtil.initialized) {
            Field[] declaredFields;
            for (int length = (declaredFields = NMSClassUtil.class.getDeclaredFields()).length, i = 0; i < length; ++i) {
                final Field field = declaredFields[i];
                if (field.getType().equals(Class.class)) {
                    try {
                        field.set(null, ReflectionUtil.getNMSClassWithException(field.getName()));
                    }
                    catch (Exception e2) {
                        if (field.getName().equals("WatchableObject")) {
                            try {
                                field.set(null, ReflectionUtil.getNMSClassWithException("DataWatcher$WatchableObject"));
                            }
                            catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
