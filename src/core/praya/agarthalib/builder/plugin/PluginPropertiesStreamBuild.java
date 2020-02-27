// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.plugin;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PluginPropertiesStreamBuild extends PluginPropertiesBuild
{
    private final boolean activated;
    private final List<String> developer;
    private final HashMap<String, PluginTypePropertiesBuild> typeProperties;
    
    public PluginPropertiesStreamBuild() {
        this.activated = true;
        this.developer = new ArrayList<String>();
        this.typeProperties = new HashMap<String, PluginTypePropertiesBuild>();
    }
    
    public PluginPropertiesStreamBuild(final boolean activated, final String name, final String company, final String author, final String owner, final String website, final List<String> developer, final HashMap<String, PluginTypePropertiesBuild> typeProperties) {
        super(name, company, author, owner, website);
        this.activated = activated;
        this.developer = developer;
        this.typeProperties = typeProperties;
    }
    
    @Deprecated
    public PluginPropertiesStreamBuild(final boolean activated, final String name, final String company, final String author, final String website, final List<String> developer, final HashMap<String, PluginTypePropertiesBuild> typeProperties, final HashMap<String, PluginBannedPropertiesBuild> bannedProperties) {
        this(activated, name, company, author, author, website, developer, typeProperties, bannedProperties);
    }
    
    @Deprecated
    public PluginPropertiesStreamBuild(final boolean activated, final String name, final String company, final String author, final String owner, final String website, final List<String> developer, final HashMap<String, PluginTypePropertiesBuild> typeProperties, final HashMap<String, PluginBannedPropertiesBuild> bannedProperties) {
        super(name, company, author, owner, website);
        this.activated = activated;
        this.developer = developer;
        this.typeProperties = typeProperties;
    }
    
    public final boolean isActivated() {
        return this.activated;
    }
    
    public final List<String> getDevelopers() {
        return this.developer;
    }
    
    public final Collection<String> getTypeIDs() {
        return this.typeProperties.keySet();
    }
    
    public final Collection<PluginTypePropertiesBuild> getAllTypeProperties() {
        return this.typeProperties.values();
    }
    
    public final PluginTypePropertiesBuild getTypeProperties(final String type) {
        if (type != null) {
            for (final String key : this.getTypeIDs()) {
                if (key.equalsIgnoreCase(type)) {
                    return this.typeProperties.get(key);
                }
            }
        }
        return null;
    }
    
    public final boolean isTypeExists(final String type) {
        return this.getTypeProperties(type) != null;
    }
    
    @Deprecated
    public final HashMap<String, PluginTypePropertiesBuild> getTypeProperties() {
        return this.typeProperties;
    }
    
    @Deprecated
    public final HashMap<String, PluginBannedPropertiesBuild> getBannedProperties() {
        return new HashMap<String, PluginBannedPropertiesBuild>();
    }
}
