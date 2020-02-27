// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.plugin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;

public class PluginTypePropertiesBuild
{
    private final String type;
    private final String version;
    private final String website;
    private final String priceSymbol;
    private final double priceValue;
    
    public PluginTypePropertiesBuild() {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        this.type = plugin.getPluginType();
        this.version = plugin.getPluginVersion();
        this.website = plugin.getPluginWebsite();
        this.priceSymbol = "\u20ac";
        this.priceValue = 0.0;
    }
    
    public PluginTypePropertiesBuild(final String type, final String version, final String website) {
        this(type, version, website, "\u20ac", 0.0);
    }
    
    public PluginTypePropertiesBuild(final String type, final String version, final String website, final String priceSymbol, final double priceValue) {
        this.type = type;
        this.version = version;
        this.website = website;
        this.priceSymbol = priceSymbol;
        this.priceValue = priceValue;
    }
    
    @Deprecated
    public PluginTypePropertiesBuild(final String version) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        this.type = plugin.getPluginType();
        this.version = version;
        this.website = plugin.getPluginWebsite();
        this.priceSymbol = "\u20ac";
        this.priceValue = 0.0;
    }
    
    @Deprecated
    public PluginTypePropertiesBuild(final String version, final List<String> announcement, final List<String> changelog) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        this.type = plugin.getPluginType();
        this.version = version;
        this.website = plugin.getPluginWebsite();
        this.priceSymbol = "\u20ac";
        this.priceValue = 0.0;
    }
    
    public final String getType() {
        return this.type;
    }
    
    public final String getVersion() {
        return this.version;
    }
    
    public final String getWebsite() {
        return this.website;
    }
    
    public final String getPriceSymbol() {
        return this.priceSymbol;
    }
    
    public final double getPriceValue() {
        return this.priceValue;
    }
    
    @Deprecated
    public final List<String> getAnnouncement() {
        return new ArrayList<String>();
    }
    
    @Deprecated
    public final List<String> getChangelog() {
        return new ArrayList<String>();
    }
}
