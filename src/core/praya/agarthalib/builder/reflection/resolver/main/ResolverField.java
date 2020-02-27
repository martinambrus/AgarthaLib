// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import com.praya.agarthalib.utility.AccessUtil;
import core.praya.agarthalib.builder.reflection.resolver.wrapper.WrapperField;

import java.lang.reflect.Field;

public class ResolverField extends ResolverMember<Field>
{
    public ResolverField(final Class<?> clazz) {
        super(clazz);
    }
    
    public ResolverField(final String className) throws ClassNotFoundException {
        super(className);
    }
    
    @Override
    public Field resolveIndex(final int index) throws IndexOutOfBoundsException, ReflectiveOperationException {
        return AccessUtil.setAccessible(this.clazz.getDeclaredFields()[index]);
    }
    
    @Override
    public Field resolveIndexSilent(final int index) {
        try {
            return this.resolveIndex(index);
        }
        catch (IndexOutOfBoundsException | ReflectiveOperationException ex3) {
            return null;
        }
    }
    
    @Override
    public WrapperField resolveIndexWrapper(final int index) {
        return new WrapperField(this.resolveIndexSilent(index));
    }
    
    @Override
    protected Field resolveObject(final ResolverQuery query) throws ReflectiveOperationException {
        if (query.getTypes() == null || query.getTypes().length == 0) {
            return AccessUtil.setAccessible(this.clazz.getDeclaredField(query.getName()));
        }
        Field[] declaredFields;
        for (int length = (declaredFields = this.clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
            final Field field = declaredFields[i];
            if (field.getName().equals(query.getName())) {
                Class<?>[] types;
                for (int length2 = (types = query.getTypes()).length, j = 0; j < length2; ++j) {
                    final Class type = types[j];
                    if (field.getType().equals(type)) {
                        return field;
                    }
                }
            }
        }
        return null;
    }
    
    public Field resolve(final ResolverQuery... queries) throws NoSuchFieldException {
        try {
            return super.resolve(queries);
        }
        catch (ReflectiveOperationException e) {
            throw (NoSuchFieldException)e;
        }
    }
    
    public Field resolveSilent(final ResolverQuery... queries) {
        try {
            return this.resolve(queries);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final WrapperField resolveWrapper(final String... names) {
        return new WrapperField(this.resolveSilent(names));
    }
    
    public final Field resolveSilent(final String... names) {
        try {
            return this.resolve(names);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final Field resolve(final String... names) throws NoSuchFieldException {
        final ResolverQuery.Builder builder = ResolverQuery.builder();
        for (final String name : names) {
            builder.with(name);
        }
        try {
            return super.resolve(builder.build());
        }
        catch (ReflectiveOperationException e) {
            throw (NoSuchFieldException)e;
        }
    }
    
    public final Field resolveByFirstType(final Class<?> type) throws ReflectiveOperationException {
        Field[] declaredFields;
        for (int length = (declaredFields = this.clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
            final Field field = declaredFields[i];
            if (field.getType().equals(type)) {
                return AccessUtil.setAccessible(field);
            }
        }
        throw new NoSuchFieldException("Could not resolve field of type '" + type.toString() + "' in class " + this.clazz);
    }
    
    public final Field resolveByFirstTypeSilent(final Class<?> type) {
        try {
            return this.resolveByFirstType(type);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final Field resolveByLastType(final Class<?> type) throws ReflectiveOperationException {
        Field lastField = null;
        Field[] declaredFields;
        for (int length = (declaredFields = this.clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
            final Field field = declaredFields[i];
            if (field.getType().equals(type)) {
                lastField = field;
            }
        }
        if (lastField != null) {
            return AccessUtil.setAccessible(lastField);
        }
        throw new NoSuchFieldException("Could not resolve field of type '" + type.toString() + "' in class " + this.clazz);
    }
    
    public final Field resolveByLastTypeSilent(final Class<?> type) {
        try {
            return this.resolveByLastType(type);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    protected NoSuchFieldException notFoundException(final String joinedNames) {
        return new NoSuchFieldException("Could not resolve field for " + joinedNames + " in class " + this.clazz);
    }
}
