// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import core.praya.agarthalib.builder.reflection.resolver.wrapper.WrapperAbstract;
import java.lang.reflect.Member;

public abstract class ResolverMember<T extends Member> extends ResolverAbstract<T>
{
    protected Class<?> clazz;
    
    public ResolverMember(final Class<?> clazz) {
        if (clazz != null) {
            this.clazz = clazz;
            return;
        }
        throw new IllegalArgumentException("class cannot be null");
    }
    
    public ResolverMember(final String className) throws ClassNotFoundException {
        this(new ResolverClass().resolve(className));
    }
    
    public abstract T resolveIndex(final int p0) throws IndexOutOfBoundsException, ReflectiveOperationException;
    
    public abstract T resolveIndexSilent(final int p0);
    
    public abstract WrapperAbstract resolveIndexWrapper(final int p0);
}
