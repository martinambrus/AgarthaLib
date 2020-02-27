// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.reflection.resolver.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ResolverQuery
{
    private final String name;
    private final Class<?>[] types;
    
    public ResolverQuery(final String name) {
        this.name = name;
        this.types = (Class<?>[])new Class[0];
    }
    
    public ResolverQuery(final Class<?>... types) {
        this.name = null;
        this.types = types;
    }
    
    public ResolverQuery(final String name, final Class<?>... types) {
        this.name = name;
        this.types = types;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final Class<?>[] getTypes() {
        return this.types;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ResolverQuery that = (ResolverQuery)o;
        final boolean sameName = (this.name != null) ? this.name.equals(that.name) : (that.name == null);
        final boolean sameArrays = Arrays.equals(this.types, that.types);
        return sameName && sameArrays;
    }
    
    @Override
    public int hashCode() {
        final int hashName = (this.name != null) ? (31 * this.name.hashCode()) : 0;
        final int hashArrays = (this.types != null) ? Arrays.hashCode(this.types) : 0;
        final int result = hashName + hashArrays;
        return result;
    }
    
    @Override
    public String toString() {
        return "ResolverQuery{name='" + this.name + '\'' + ", types=" + Arrays.toString(this.types) + '}';
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder
    {
        private List<ResolverQuery> queryList;
        
        private Builder() {
            this.queryList = new ArrayList<ResolverQuery>();
        }
        
        public final Builder with(final String name, final Class<?>[] types) {
            this.queryList.add(new ResolverQuery(name, types));
            return this;
        }
        
        public final Builder with(final String name) {
            this.queryList.add(new ResolverQuery(name));
            return this;
        }
        
        public final Builder with(final Class<?>[] types) {
            this.queryList.add(new ResolverQuery(types));
            return this;
        }
        
        public final ResolverQuery[] build() {
            return this.queryList.toArray(new ResolverQuery[this.queryList.size()]);
        }
    }
}
