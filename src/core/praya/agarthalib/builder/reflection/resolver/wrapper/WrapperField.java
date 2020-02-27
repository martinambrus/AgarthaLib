// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.wrapper;

import java.lang.reflect.Field;

public class WrapperField<R> extends WrapperAbstract
{
    private final Field field;
    
    public WrapperField(final Field field) {
        this.field = field;
    }
    
    @Override
    public boolean isExists() {
        return this.field != null;
    }
    
    public final Field getField() {
        return this.field;
    }
    
    public final String getName() {
        return this.field.getName();
    }
    
    public R get(final Object object) {
        try {
            return (R)this.field.get(object);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public final R getSilent(final Object object) {
        try {
            return (R)this.field.get(object);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final void set(final Object object, final R value) {
        try {
            this.field.set(object, value);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public final void setSilent(final Object object, final R value) {
        try {
            this.field.set(object, value);
        }
        catch (Exception ex) {}
    }
    
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        final WrapperField<?> that = (WrapperField<?>)object;
        return (this.field != null) ? this.field.equals(that.field) : (that.field == null);
    }
    
    @Override
    public int hashCode() {
        return (this.field != null) ? this.field.hashCode() : 0;
    }
}
