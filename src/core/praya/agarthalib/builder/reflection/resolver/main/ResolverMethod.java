// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import com.praya.agarthalib.utility.AccessUtil;
import core.praya.agarthalib.builder.reflection.resolver.wrapper.WrapperMethod;

import java.lang.reflect.Method;

public class ResolverMethod extends ResolverMember<Method>
{
    public ResolverMethod(final Class<?> clazz) {
        super(clazz);
    }
    
    public ResolverMethod(final String className) throws ClassNotFoundException {
        super(className);
    }
    
    @Override
    public Method resolveIndex(final int index) throws IndexOutOfBoundsException, ReflectiveOperationException {
        return AccessUtil.setAccessible(this.clazz.getDeclaredMethods()[index]);
    }
    
    @Override
    public Method resolveIndexSilent(final int index) {
        try {
            return this.resolveIndex(index);
        }
        catch (IndexOutOfBoundsException | ReflectiveOperationException ex2) {
            return null;
        }
    }
    
    @Override
    public WrapperMethod resolveIndexWrapper(final int index) {
        return new WrapperMethod(this.resolveIndexSilent(index));
    }
    
    public WrapperMethod resolveWrapper(final String... names) {
        return new WrapperMethod(this.resolveSilent(names));
    }
    
    public WrapperMethod resolveWrapper(final ResolverQuery... queries) {
        return new WrapperMethod(this.resolveSilent(queries));
    }
    
    public Method resolveSilent(final String... names) {
        try {
            return this.resolve(names);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public Method resolveSilent(final ResolverQuery... queries) {
        return super.resolveSilent(queries);
    }
    
    public final Method resolve(final String... names) throws NoSuchMethodException {
        final ResolverQuery.Builder builder = ResolverQuery.builder();
        for (final String name : names) {
            builder.with(name);
        }
        return this.resolve(builder.build());
    }
    
    public Method resolve(final ResolverQuery... queries) throws NoSuchMethodException {
        try {
            return super.resolve(queries);
        }
        catch (ReflectiveOperationException e) {
            throw (NoSuchMethodException)e;
        }
    }
    
    @Override
    protected Method resolveObject(final ResolverQuery query) throws ReflectiveOperationException {
        Method[] declaredMethods;
        for (int length = (declaredMethods = this.clazz.getDeclaredMethods()).length, i = 0; i < length; ++i) {
            final Method method = declaredMethods[i];
            if (method.getName().equals(query.getName()) && (query.getTypes().length == 0 || ClassListEqual(query.getTypes(), method.getParameterTypes()))) {
                return AccessUtil.setAccessible(method);
            }
        }
        throw new NoSuchMethodException();
    }
    
    @Override
    protected NoSuchMethodException notFoundException(final String joinedNames) {
        return new NoSuchMethodException("Could not resolve method for " + joinedNames + " in class " + this.clazz);
    }
    
    private static final boolean ClassListEqual(final Class<?>[] l1, final Class<?>[] l2) {
        boolean equal = true;
        if (l1.length != l2.length) {
            return false;
        }
        for (int i = 0; i < l1.length; ++i) {
            if (l1[i] != l2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
}
