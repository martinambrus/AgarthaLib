// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.minecraft;

import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.builder.reflection.resolver.main.*;
import core.praya.agarthalib.builder.reflection.resolver.minecraft.MinecraftResolverNMS;
import core.praya.agarthalib.enums.main.VersionNMS;

import javax.annotation.Nullable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

public class MinecraftDataWatcher
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
    private static final ResolverConstructor DataWacherResolverConstructor;
    private static final ResolverField DataWatcherResolverField;
    private static final ResolverMethod TIntObjectMapResolverMethod;
    private static final ResolverMethod DataWatcherResolverMethod;
    
    static {
        classResolver = new ResolverClass();
        nmsClassResolver = new MinecraftResolverNMS();
        ItemStack = MinecraftDataWatcher.nmsClassResolver.resolveSilent("ItemStack");
        ChunkCoordinates = MinecraftDataWatcher.nmsClassResolver.resolveSilent("ChunkCoordinates");
        BlockPosition = MinecraftDataWatcher.nmsClassResolver.resolveSilent("BlockPosition");
        Vector3f = MinecraftDataWatcher.nmsClassResolver.resolveSilent("Vector3f");
        DataWatcher = MinecraftDataWatcher.nmsClassResolver.resolveSilent("DataWatcher");
        Entity = MinecraftDataWatcher.nmsClassResolver.resolveSilent("Entity");
        TIntObjectMap = MinecraftDataWatcher.classResolver.resolveSilent("gnu.trove.map.TIntObjectMap", "net.minecraft.util.gnu.trove.map.TIntObjectMap");
        DataWacherResolverConstructor = new ResolverConstructor(MinecraftDataWatcher.DataWatcher);
        DataWatcherResolverField = new ResolverField(MinecraftDataWatcher.DataWatcher);
        TIntObjectMapResolverMethod = new ResolverMethod(MinecraftDataWatcher.TIntObjectMap);
        DataWatcherResolverMethod = new ResolverMethod(MinecraftDataWatcher.DataWatcher);
    }
    
    public static final Object newDataWatcher(@Nullable final Object entity) throws ReflectiveOperationException {
        return MinecraftDataWatcher.DataWacherResolverConstructor.resolve((Class<?>[][])new Class[][] { { MinecraftDataWatcher.Entity } }).newInstance(entity);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
        return ServerUtil.isCompatible(VersionNMS.V1_9_R2) ? V1_9.setItem(dataWatcher, index, dataWatcherObject, value) : V1_8.setValue(dataWatcher, index, value);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final V1_9.ValueType type, final Object value) throws ReflectiveOperationException {
        return setValue(dataWatcher, index, type.getType(), value);
    }
    
    public static final Object setValue(final Object dataWatcher, final int index, final Object value, final ResolverField dataWatcherObjectResolverField, final String... dataWatcherObjectFieldNames) throws ReflectiveOperationException {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final Object dataWatcherObject = dataWatcherObjectResolverField.resolve(dataWatcherObjectFieldNames).get(null);
            return V1_9.setItem(dataWatcher, index, dataWatcherObject, value);
        }
        return V1_8.setValue(dataWatcher, index, value);
    }
    
    public static final Object getValue(final MinecraftDataWatcher dataWatcher, final int index) throws ReflectiveOperationException {
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
        else if (value != null && value.getClass().equals(MinecraftDataWatcher.ItemStack)) {
            type = 5;
        }
        else if (value != null && (value.getClass().equals(MinecraftDataWatcher.ChunkCoordinates) || value.getClass().equals(MinecraftDataWatcher.BlockPosition))) {
            type = 6;
        }
        else if (value != null && value.getClass().equals(MinecraftDataWatcher.Vector3f)) {
            type = 7;
        }
        return type;
    }
    
    public static class V1_9
    {
        private static Class<?> DataWatcherItem;
        private static Class<?> DataWatcherObject;
        private static ResolverConstructor DataWatcherItemResolverConstructor;
        private static ResolverField DataWatcherItemResolverField;
        private static ResolverField DataWatcherObjectResolverField;
        
        static {
            V1_9.DataWatcherItem = (Class<?>)MinecraftDataWatcher.nmsClassResolver.resolveSilent("DataWatcher$Item");
            V1_9.DataWatcherObject = (Class<?>)MinecraftDataWatcher.nmsClassResolver.resolveSilent("DataWatcherObject");
        }
        
        public static final Object newDataWatcherItem(final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
            if (V1_9.DataWatcherItemResolverConstructor == null) {
                V1_9.DataWatcherItemResolverConstructor = new ResolverConstructor(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemResolverConstructor.resolveFirstConstructor().newInstance(dataWatcherObject, value);
        }
        
        public static final Object setItem(final Object dataWatcher, final int index, final Object dataWatcherObject, final Object value) throws ReflectiveOperationException {
            return setItem(dataWatcher, index, newDataWatcherItem(dataWatcherObject, value));
        }
        
        public static final Object setItem(final Object dataWatcher, final int index, final Object dataWatcherItem) throws ReflectiveOperationException {
            final Map<Integer, Object> map = (Map<Integer, Object>)MinecraftDataWatcher.DataWatcherResolverField.resolve("c").get(dataWatcher);
            map.put(index, dataWatcherItem);
            return dataWatcher;
        }
        
        public static final Object getItem(final Object dataWatcher, final Object dataWatcherObject) throws ReflectiveOperationException {
            return MinecraftDataWatcher.DataWatcherResolverMethod.resolve(new ResolverQuery("c", (Class<?>[])new Class[] { V1_9.DataWatcherObject })).invoke(dataWatcher, dataWatcherObject);
        }
        
        public static final Object getValue(final Object dataWatcher, final Object dataWatcherObject) throws ReflectiveOperationException {
            return MinecraftDataWatcher.DataWatcherResolverMethod.resolve("get").invoke(dataWatcher, dataWatcherObject);
        }
        
        public static final Object getValue(final Object dataWatcher, final ValueType type) throws ReflectiveOperationException {
            return getValue(dataWatcher, type.getType());
        }
        
        public static final Object getItemObject(final Object item) throws ReflectiveOperationException {
            if (V1_9.DataWatcherItemResolverField == null) {
                V1_9.DataWatcherItemResolverField = new ResolverField(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemResolverField.resolve("a").get(item);
        }
        
        public static final int getItemIndex(final Object dataWatcher, final Object item) throws ReflectiveOperationException {
            final Map<Integer, Object> map = (Map<Integer, Object>)MinecraftDataWatcher.DataWatcherResolverField.resolve("c").get(dataWatcher);
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
            if (V1_9.DataWatcherObjectResolverField == null) {
                V1_9.DataWatcherObjectResolverField = new ResolverField(V1_9.DataWatcherObject);
            }
            final Object object = getItemObject(item);
            final Object serializer = V1_9.DataWatcherObjectResolverField.resolve("b").get(object);
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
            if (V1_9.DataWatcherItemResolverField == null) {
                V1_9.DataWatcherItemResolverField = new ResolverField(V1_9.DataWatcherItem);
            }
            return V1_9.DataWatcherItemResolverField.resolve("b").get(item);
        }
        
        public static void setItemValue(final Object item, final Object value) throws ReflectiveOperationException {
            V1_9.DataWatcherItemResolverField.resolve("b").set(item, value);
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
                    this.type = new ResolverField(MinecraftDataWatcher.nmsClassResolver.resolve(className)).resolve(fieldNames).get(null);
                }
                catch (Exception e) {
                    if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                        final String message = "[ReflectionHelper] Failed to find DataWatcherObject for " + className + " " + Arrays.toString(fieldNames);
                        System.err.println(message);
                    }
                }
            }
            
            private ValueType(final String name, final int ordinal, final String className, final int index) {
                try {
                    this.type = new ResolverField(MinecraftDataWatcher.nmsClassResolver.resolve(className)).resolveIndex(index).get(null);
                }
                catch (Exception e) {
                    if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                        final String message = "[ReflectionHelper] Failed to find DataWatcherObject for " + className + " #" + index;
                        System.err.println(message);
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
        private static Class<?> WatchableObject;
        private static ResolverConstructor WatchableObjectResolverConstructor;
        private static ResolverField WatchableObjectResolverField;
        
        static {
            V1_8.WatchableObject = (Class<?>)MinecraftDataWatcher.nmsClassResolver.resolveSilent("WatchableObject", "DataWatcher$WatchableObject");
        }
        
        public static final Object newWatchableObject(final int index, final Object value) throws ReflectiveOperationException {
            return newWatchableObject(MinecraftDataWatcher.getValueType(value), index, value);
        }
        
        public static final Object newWatchableObject(final int type, final int index, final Object value) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectResolverConstructor == null) {
                V1_8.WatchableObjectResolverConstructor = new ResolverConstructor(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectResolverConstructor.resolve((Class<?>[][])new Class[][] { { Integer.TYPE, Integer.TYPE, Object.class } }).newInstance(type, index, value);
        }
        
        public static final Object setValue(final Object dataWatcher, final int index, final Object value) throws ReflectiveOperationException {
            final int type = MinecraftDataWatcher.getValueType(value);
            final Object map = MinecraftDataWatcher.DataWatcherResolverField.resolve("dataValues").get(dataWatcher);
            MinecraftDataWatcher.TIntObjectMapResolverMethod.resolve(new ResolverQuery("put", (Class<?>[])new Class[] { Integer.TYPE, Object.class })).invoke(map, index, newWatchableObject(type, index, value));
            return dataWatcher;
        }
        
        public static final Object getValue(final Object dataWatcher, final int index) throws ReflectiveOperationException {
            final Object map = MinecraftDataWatcher.DataWatcherResolverField.resolve("dataValues").get(dataWatcher);
            return MinecraftDataWatcher.TIntObjectMapResolverMethod.resolve(new ResolverQuery("get", (Class<?>[])new Class[] { Integer.TYPE })).invoke(map, index);
        }
        
        public static final int getWatchableObjectIndex(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectResolverField == null) {
                V1_8.WatchableObjectResolverField = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectResolverField.resolve("b").getInt(object);
        }
        
        public static final int getWatchableObjectType(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectResolverField == null) {
                V1_8.WatchableObjectResolverField = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectResolverField.resolve("a").getInt(object);
        }
        
        public static final Object getWatchableObjectValue(final Object object) throws ReflectiveOperationException {
            if (V1_8.WatchableObjectResolverField == null) {
                V1_8.WatchableObjectResolverField = new ResolverField(V1_8.WatchableObject);
            }
            return V1_8.WatchableObjectResolverField.resolve("c").get(object);
        }
    }
}
