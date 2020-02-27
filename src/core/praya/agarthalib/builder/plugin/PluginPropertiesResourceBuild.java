// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.plugin;

public class PluginPropertiesResourceBuild extends PluginPropertiesBuild
{
    private final String type;
    private final String version;
    
    public PluginPropertiesResourceBuild(final String name, final String company, final String author, final String website, final String type, final String version) {
        this(name, company, author, author, website, type, version);
    }
    
    public PluginPropertiesResourceBuild(final String name, final String company, final String author, final String owner, final String website, final String type, final String version) {
        super(name, company, author, owner, website);
        this.type = type;
        this.version = version;
    }
    
    public final String getType() {
        return this.type;
    }
    
    public final String getVersion() {
        return this.version;
    }
}
