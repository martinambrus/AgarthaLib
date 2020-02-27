// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.wrapper;

import java.lang.reflect.Method;

public class WrapperMethod<R> extends WrapperAbstract
{
    private final Method method;
    
    public WrapperMethod(final Method method) {
        this.method = method;
    }
    
    @Override
    public boolean isExists() {
        return this.method != null;
    }
    
    public final Method getMethod() {
        return this.method;
    }
    
    public final String getName() {
        return this.method.getName();
    }
    
    public final R invoke(final Object object, final Object... args) {
        try {
            return (R)this.method.invoke(object, args);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public final R invokeSilent(final Object object, final Object... args) {
        try {
            return (R)this.method.invoke(object, args);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        final WrapperMethod<?> that = (WrapperMethod<?>)object;
        return (this.method != null) ? this.method.equals(that.method) : (that.method == null);
    }
    
    @Override
    public int hashCode() {
        return (this.method != null) ? this.method.hashCode() : 0;
    }
}
