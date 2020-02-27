// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.main;

import java.util.List;

public class DataBuild
{
    private final String id;
    private final List<String> listPath;
    
    public DataBuild(final String id, final List<String> listPath) {
        this.id = id;
        this.listPath = listPath;
    }
    
    public final String getID() {
        return this.id;
    }
    
    public final List<String> getListPath() {
        return this.listPath;
    }
    
    public final String getPath() {
        return this.listPath.isEmpty() ? "" : this.listPath.get(0);
    }
}
