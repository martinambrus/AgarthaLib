// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.wrapper;

public class WrapperClass<R> extends WrapperAbstract
{
    private final Class<R> clazz;
    
    public WrapperClass(final Class<R> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public boolean isExists() {
        return this.clazz != null;
    }
    
    public final Class<R> getClazz() {
        return this.clazz;
    }
    
    public final String getName() {
        return this.clazz.getName();
    }
    
    public final R newInstance() {
        try {
            return this.clazz.newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public R newInstanceSilent() {
        try {
            return this.clazz.newInstance();
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
        final WrapperClass<?> that = (WrapperClass<?>)object;
        final boolean sameClazz = (this.clazz != null) ? this.clazz.equals(that.clazz) : (that.clazz == null);
        return sameClazz;
    }
    
    @Override
    public int hashCode() {
        return (this.clazz != null) ? this.clazz.hashCode() : 0;
    }
}
