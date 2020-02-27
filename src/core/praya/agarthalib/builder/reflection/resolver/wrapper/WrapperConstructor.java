// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.wrapper;

import java.lang.reflect.Constructor;

public class WrapperConstructor<R> extends WrapperAbstract
{
    private final Constructor<R> constructor;
    
    public WrapperConstructor(final Constructor<R> constructor) {
        this.constructor = constructor;
    }
    
    @Override
    public boolean isExists() {
        return this.constructor != null;
    }
    
    public final Constructor<R> getConstructor() {
        return this.constructor;
    }
    
    public final R newInstance(final Object... args) {
        try {
            return this.constructor.newInstance(args);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public final R newInstanceSilent(final Object... args) {
        try {
            return this.constructor.newInstance(args);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final Class<?>[] getParameterTypes() {
        return this.constructor.getParameterTypes();
    }
    
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        final WrapperConstructor<?> that = (WrapperConstructor<?>)object;
        final boolean sameConstructor = (this.constructor != null) ? this.constructor.equals(that.constructor) : (that.constructor == null);
        return sameConstructor;
    }
    
    @Override
    public int hashCode() {
        return (this.constructor != null) ? this.constructor.hashCode() : 0;
    }
}
