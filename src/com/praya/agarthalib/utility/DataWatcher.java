// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Arrays;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverQuery;
import java.util.Map;
import core.praya.agarthalib.enums.main.VersionNMS;
import javax.annotation.Nullable;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverMethod;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverField;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverConstructor;
import core.praya.agarthalib.builder.reflection.resolver.minecraft.MinecraftResolverNMS;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverClass;

public class DataWatcher
{
    private static final ResolverClass classResolver;
    private static final MinecraftResolverNMS nmsClassResolver;
    private static final Class<?> ItemStack;
    private static final Class<?> ChunkCoordinates;
    private static final Class<?> BlockPosition;
    private static final Class<?> Vector3f;
    private static final Class<?> DataWatcher;
    private static final Class<?> Entity;
    private static final Class<?> TIntObjectMap;
    private static final ResolverConstructor DataWacherConstructorResolver;
    private static final ResolverField DataWatcherFieldResolver;
    private static final ResolverMethod TIntObjectMapMethodResolver;
    private static final ResolverMethod DataWatcherMethodResolver;
    
    static {
        classResolver = new ResolverClass();
        nmsClassResolver = new MinecraftResolverNMS();
        ItemStack = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("ItemStack");
        ChunkCoordinates = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("ChunkCoordinates");
        BlockPosition = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("BlockPosition");
        Vector3f = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("Vector3f");
        DataWatcher = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("DataWatcher");
        Entity = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("Entity");
        TIntObjectMap = com.praya.agarthalib.utility.DataWatcher.classResolver.resolveSilent("gnu.trove.map.TIntObjectMap", "net.minecraft.util.gnu.trove.map.TIntObjectMap");
        DataWacherConstructorResolver = new ResolverConstructor(com.praya.agarthalib.utility.DataWatcher.DataWatcher);
        DataWatcherFieldResolver = new ResolverField(com.praya.agarthalib.utility.DataWatcher.DataWatcher);
        TIntObjectMapMethodResolver = new ResolverMethod(com.praya.agarthalib.utility.DataWatcher.TIntObjectMap);
        DataWatcherMethodResolver = new ResolverMethod(com.praya.agarthalib.utility.DataWatcher.DataWatcher);
    }
    
    public static final Object newDataWatcher(@Nullable final Object entity) throws ReflectiveOperationException {
        return com.praya.agarthalib.utility.DataWatcher.DataWacherConstructorResolver.resolve((Class<?>[][])new Class[][] { { com.praya.agarthalib.utility.DataWatcher.Entity } }).newInstance(entity);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
        return ServerUtil.isCompatible(VersionNMS.V1_9_R2) ? V1_9.setItem(dataWatcher, index, dataWatcherObject, value) : V1_8.setValue(dataWatcher, index, value);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final V1_9.ValueType type, final Object value) throws ReflectiveOperationException {
        return setValue(dataWatcher, index, type.getType(), value);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final Object value, final ResolverField dataWatcherObjectFieldResolver, final String... dataWatcherObjectFieldNames) throws ReflectiveOperationException {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final Object dataWatcherObject = dataWatcherObjectFieldResolver.resolve(dataWatcherObjectFieldNames).get(null);
            return V1_9.setItem(dataWatcher, index, dataWatcherObject, value);
        }
        return V1_8.setValue(dataWatcher, index, value);
    }
    
    public static final Object getValue(final DataWatcher dataWatcher, final int index) throws ReflectiveOperationException {
        return ServerUtil.isCompatible(VersionNMS.V1_9_R2) ? V1_9.getValue(dataWatcher, index) : V1_8.getValue(dataWatcher, index);
    }
    
    public static final int getValueType(final Object value) {
        int type = 0;
        if (value instanceof Number) {
            if (value instanceof Byte) {
                type = 0;
            }
            else if (value instanceof Short) {
                type = 1;
            }
            else if (value instanceof Integer) {
                type = 2;
            }
            else if (value instanceof Float) {
                type = 3;
            }
        }
        else if (value instanceof String) {
            type = 4;
        }
        else if (value != null && value.getClass().equals(com.praya.agarthalib.utility.DataWatcher.ItemStack)) {
            type = 5;
        }
        else if (value != null && (value.getClass().equals(com.praya.agarthalib.utility.DataWatcher.ChunkCoordinates) || value.getClass().equals(com.praya.agarthalib.utility.DataWatcher.BlockPosition))) {
            type = 6;
        }
        else if (value != null && value.getClass().equals(com.praya.agarthalib.utility.DataWatcher.Vector3f)) {
            type = 7;
        }
        return type;
    }
    
    public static class V1_9
    {
        private static final Class<?> DataWatcherItem;
        private static final Class<?> DataWatcherObject;
        private static ResolverConstructor DataWatcherItemConstructorResolver;
        private static ResolverField DataWatcherItemFieldResolver;
        private static ResolverField DataWatcherObjectFieldResolver;
        
        static {
            DataWatcherItem = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("DataWatcher$Item");
            DataWatcherObject = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("DataWatcherObject");
        }
        
        public static final Object newDataWatcherItem(final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
            if (V1_9.DataWatcherItemConstructorResolver == null) {
                V1_9.DataWatcherItemConstructorResolver = new ResolverConstructor(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemConstructorResolver.resolveFirstConstructor().newInstance(dataWatcherObject, value);
        }
        
        public static final Object setItem(final Object dataWatcher, final int index, final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
            return setItem(dataWatcher, index, newDataWatcherItem(dataWatcherObject, value));
        }
        
        public static final Object setItem(final Object dataWatcher, final int index, final Object dataWatcherItem) throws ReflectiveOperationException {
            final Map<Integer, Object> map = (Map<Integer, Object>)com.praya.agarthalib.utility.DataWatcher.DataWatcherFieldResolver.resolve("c").get(dataWatcher);
            map.put(index, dataWatcherItem);
            return dataWatcher;
        }
        
        public static final Object getItem(final Object dataWatcher, final Object dataWatcherObject) throws ReflectiveOperationException {
            return com.praya.agarthalib.utility.DataWatcher.DataWatcherMethodResolver.resolve(new ResolverQuery("c", (Class<?>[])new Class[] { V1_9.DataWatcherObject })).invoke(dataWatcher, dataWatcherObject);
        }
        
        public static final Object getValue(final Object dataWatcher, final Object dataWatcherObject) throws ReflectiveOperationException {
            return com.praya.agarthalib.utility.DataWatcher.DataWatcherMethodResolver.resolve("get").invoke(dataWatcher, dataWatcherObject);
        }
        
        public static final Object getValue(final Object dataWatcher, final ValueType type) throws ReflectiveOperationException {
            return getValue(dataWatcher, type.getType());
        }
        
        public static final Object getItemObject(final Object item) throws ReflectiveOperationException {
            if (V1_9.DataWatcherItemFieldResolver == null) {
                V1_9.DataWatcherItemFieldResolver = new ResolverField(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemFieldResolver.resolve("a").get(item);
        }
        
        public static final int getItemIndex(final Object dataWatcher, final Object item) throws ReflectiveOperationException {
            final Map<Integer, Object> map = (Map<Integer, Object>)com.praya.agarthalib.utility.DataWatcher.DataWatcherFieldResolver.resolve("c").get(dataWatcher);
            int index = -1;
            for (final Map.Entry<Integer, Object> entry : map.entrySet()) {
                if (entry.getValue().equals(item)) {
                    index = entry.getKey();
                    break;
                }
            }
            return index;
        }
        
        public static final Type getItemType(final Object item) throws ReflectiveOperationException {
            if (V1_9.DataWatcherObjectFieldResolver == null) {
                V1_9.DataWatcherObjectFieldResolver = new ResolverField(V1_9.DataWatcherObject);
            }
            final Object object = getItemObject(item);
            final Object serializer = V1_9.DataWatcherObjectFieldResolver.resolve("b").get(object);
            final Type[] genericInterfaces = serializer.getClass().getGenericInterfaces();
            if (genericInterfaces.length > 0) {
                final Type type = genericInterfaces[0];
                if (type instanceof ParameterizedType) {
                    final Type[] actualTypes = ((ParameterizedType)type).getActualTypeArguments();
                    if (actualTypes.length > 0) {
                        return actualTypes[0];
                    }
                }
            }
            return null;
        }
        
        public static final Object getItemValue(final Object item) throws ReflectiveOperationException {
            if (V1_9.DataWatcherItemFieldResolver == null) {
                V1_9.DataWatcherItemFieldResolver = new ResolverField(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemFieldResolver.resolve("b").get(item);
        }
        
        public static final void setItemValue(final Object item, final Object value) throws ReflectiveOperationException {
            V1_9.DataWatcherItemFieldResolver.resolve("b").set(item, value);
        }
        
        public enum ValueType
        {
            ENTITY_FLAG("ENTITY_FLAG", 0, "Entity", 57), 
            ENTITY_AIR_TICKS("ENTITY_AIR_TICKS", 1, "Entity", 58), 
            ENTITY_NAME("ENTITY_NAME", 2, "Entity", 59), 
            ENTITY_NAME_VISIBLE("ENTITY_NAME_VISIBLE", 3, "Entity", 60), 
            ENTITY_SILENT("ENTITY_SILENT", 4, "Entity", 61), 
            ENTITY_as("ENTITY_as", 5, "EntityLiving", 2), 
            ENTITY_LIVING_HEALTH("ENTITY_LIVING_HEALTH", 6, "EntityLiving", new String[] { "HEALTH" }), 
            ENTITY_LIVING_f("ENTITY_LIVING_f", 7, "EntityLiving", 2), 
            ENTITY_LIVING_g("ENTITY_LIVING_g", 8, "EntityLiving", 3), 
            ENTITY_LIVING_h("ENTITY_LIVING_h", 9, "EntityLiving", 4), 
            ENTITY_INSENTIENT_FLAG("ENTITY_INSENTIENT_FLAG", 10, "EntityInsentient", 0), 
            ENTITY_SLIME_SIZE("ENTITY_SLIME_SIZE", 11, "EntitySlime", 0), 
            ENTITY_WITHER_a("ENTITY_WITHER_a", 12, "EntityWither", 0), 
            ENTITY_WIHER_b("ENTITY_WIHER_b", 13, "EntityWither", 1), 
            ENTITY_WITHER_c("ENTITY_WITHER_c", 14, "EntityWither", 2), 
            ENTITY_WITHER_bv("ENTITY_WITHER_bv", 15, "EntityWither", 3), 
            ENTITY_WITHER_bw("ENTITY_WITHER_bw", 16, "EntityWither", 4), 
            ENTITY_HUMAN_ABSORPTION_HEARTS("ENTITY_HUMAN_ABSORPTION_HEARTS", 17, "EntityHuman", 0), 
            ENTITY_HUMAN_SCORE("ENTITY_HUMAN_SCORE", 18, "EntityHuman", 1), 
            ENTITY_HUMAN_SKIN_LAYERS("ENTITY_HUMAN_SKIN_LAYERS", 19, "EntityHuman", 2), 
            ENTITY_HUMAN_MAIN_HAND("ENTITY_HUMAN_MAIN_HAND", 20, "EntityHuman", 3);
            
            private Object type;
            
            private ValueType(final String name, final int ordinal, final String className, final String[] fieldNames) {
                try {
                    this.type = new ResolverField(com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolve(className)).resolve(fieldNames).get(null);
                }
                catch (Exception e) {
                    if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                        System.err.println("[ReflectionHelper] Failed to find DataWatcherObject for " + className + " " + Arrays.toString(fieldNames));
                    }
                }
            }
            
            private ValueType(final String name, final int ordinal, final String className, final int index) {
                try {
                    this.type = new ResolverField(com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolve(className)).resolveIndex(index).get(null);
                }
                catch (Exception e) {
                    if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                        System.err.println("[ReflectionHelper] Failed to find DataWatcherObject for " + className + " #" + index);
                    }
                }
            }
            
            public final boolean hasType() {
                return this.getType() != null;
            }
            
            public final Object getType() {
                return this.type;
            }
        }
    }
    
    public static class V1_8
    {
        private static final Class<?> WatchableObject;
        private static ResolverConstructor WatchableObjectConstructorResolver;
        private static ResolverField WatchableObjectFieldResolver;
        
        static {
            WatchableObject = com.praya.agarthalib.utility.DataWatcher.nmsClassResolver.resolveSilent("WatchableObject", "DataWatcher$WatchableObject");
        }
        
        public static final Object newWatchableObject(final int index, final Object value) throws ReflectiveOperationException {
            return newWatchableObject(com.praya.agarthalib.utility.DataWatcher.getValueType(value), index, value);
        }
        
        public static final Object newWatchableObject(final int type, final int index, final Object value) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectConstructorResolver == null) {
                V1_8.WatchableObjectConstructorResolver = new ResolverConstructor(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectConstructorResolver.resolve((Class<?>[][])new Class[][] { { Integer.TYPE, Integer.TYPE, Object.class } }).newInstance(type, index, value);
        }
        
        public static final Object setValue(final Object dataWatcher, final int index, final Object value) throws ReflectiveOperationException {
            final int type = com.praya.agarthalib.utility.DataWatcher.getValueType(value);
            final Object map = com.praya.agarthalib.utility.DataWatcher.DataWatcherFieldResolver.resolve("dataValues").get(dataWatcher);
            com.praya.agarthalib.utility.DataWatcher.TIntObjectMapMethodResolver.resolve(new ResolverQuery("put", (Class<?>[])new Class[] { Integer.TYPE, Object.class })).invoke(map, index, newWatchableObject(type, index, value));
            return dataWatcher;
        }
        
        public static final Object getValue(final Object dataWatcher, final int index) throws ReflectiveOperationException {
            final Object map = com.praya.agarthalib.utility.DataWatcher.DataWatcherFieldResolver.resolve("dataValues").get(dataWatcher);
            return com.praya.agarthalib.utility.DataWatcher.TIntObjectMapMethodResolver.resolve(new ResolverQuery("get", (Class<?>[])new Class[] { Integer.TYPE })).invoke(map, index);
        }
        
        public static final int getWatchableObjectIndex(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectFieldResolver == null) {
                V1_8.WatchableObjectFieldResolver = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectFieldResolver.resolve("b").getInt(object);
        }
        
        public static final int getWatchableObjectType(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectFieldResolver == null) {
                V1_8.WatchableObjectFieldResolver = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectFieldResolver.resolve("a").getInt(object);
        }
        
        public static final Object getWatchableObjectValue(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectFieldResolver == null) {
                V1_8.WatchableObjectFieldResolver = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectFieldResolver.resolve("c").get(object);
        }
    }
}
