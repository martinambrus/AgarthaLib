// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import com.praya.agarthalib.utility.AccessUtil;
import core.praya.agarthalib.builder.reflection.resolver.wrapper.WrapperConstructor;

import java.lang.reflect.Constructor;

public class ResolverConstructor extends ResolverMember<Constructor>
{
    public ResolverConstructor(final Class<?> clazz) {
        super(clazz);
    }
    
    public ResolverConstructor(final String className) throws ClassNotFoundException {
        super(className);
    }
    
    @Override
    public Constructor resolveIndex(final int index) throws IndexOutOfBoundsException, ReflectiveOperationException {
        return AccessUtil.setAccessible(this.clazz.getDeclaredConstructors()[index]);
    }
    
    @Override
    public Constructor resolveIndexSilent(final int index) {
        try {
            return this.resolveIndex(index);
        }
        catch (IndexOutOfBoundsException | ReflectiveOperationException ex4) {
            return null;
        }
    }
    
    @Override
    public WrapperConstructor resolveIndexWrapper(final int index) {
        return new WrapperConstructor(this.resolveIndexSilent(index));
    }
    
    @Override
    protected Constructor resolveObject(final ResolverQuery query) throws ReflectiveOperationException {
        return AccessUtil.setAccessible(this.clazz.getDeclaredConstructor(query.getTypes()));
    }
    
    public final WrapperConstructor resolveWrapper(final Class<?>[]... types) {
        return new WrapperConstructor(this.resolveSilent(types));
    }
    
    public final Constructor resolveSilent(final Class<?>[]... types) {
        try {
            return this.resolve(types);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final Constructor resolve(final Class<?>[]... types) throws NoSuchMethodException {
        final ResolverQuery.Builder builder = ResolverQuery.builder();
        for (final Class[] type : types) {
            builder.with(type);
        }
        try {
            return super.resolve(builder.build());
        }
        catch (ReflectiveOperationException e) {
            throw (NoSuchMethodException)e;
        }
    }
    
    public final Constructor resolveFirstConstructor() throws ReflectiveOperationException {
        final Constructor[] declaredConstructors = this.clazz.getDeclaredConstructors();
        final int length = declaredConstructors.length;
        if (length > 0) {
            final Constructor constructor = declaredConstructors[0];
            return AccessUtil.setAccessible(constructor);
        }
        return null;
    }
    
    public final Constructor resolveFirstConstructorSilent() {
        try {
            return this.resolveFirstConstructor();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final Constructor resolveLastConstructor() throws ReflectiveOperationException {
        final Constructor[] declaredConstructors = this.clazz.getDeclaredConstructors();
        final int length = declaredConstructors.length;
        final Constructor constructor = declaredConstructors[length - 1];
        return (constructor != null) ? AccessUtil.setAccessible(constructor) : null;
    }
    
    public final Constructor resolveLastConstructorSilent() {
        try {
            return this.resolveLastConstructor();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    protected NoSuchMethodException notFoundException(final String joinedNames) {
        return new NoSuchMethodException("Could not resolve constructor for " + joinedNames + " in class " + this.clazz);
    }
}
