// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import core.praya.agarthalib.builder.reflection.resolver.wrapper.WrapperClass;

public class ResolverClass extends ResolverAbstract<Class>
{
    public final WrapperClass resolveWrapper(final String... names) {
        return new WrapperClass(this.resolveSilent(names));
    }
    
    public final Class resolveSilent(final String... names) {
        try {
            return this.resolve(names);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public Class resolve(final String... names) throws ClassNotFoundException {
        final ResolverQuery.Builder builder = ResolverQuery.builder();
        for (final String name : names) {
            builder.with(name);
        }
        try {
            return super.resolve(builder.build());
        }
        catch (ReflectiveOperationException e) {
            throw (ClassNotFoundException)e;
        }
    }
    
    @Override
    protected Class resolveObject(final ResolverQuery query) throws ReflectiveOperationException {
        return Class.forName(query.getName());
    }
    
    @Override
    protected ClassNotFoundException notFoundException(final String joinedNames) {
        return new ClassNotFoundException("Could not resolve class for " + joinedNames);
    }
}
