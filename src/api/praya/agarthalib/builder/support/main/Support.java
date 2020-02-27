// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;

public class Support
{
    protected final AgarthaLib plugin;
    protected final Plugin source;
    
    public Support(final AgarthaLib plugin, final Plugin source) {
        this.plugin = plugin;
        this.source = source;
    }
    
    public final Plugin getSource() {
        return this.source;
    }
}
