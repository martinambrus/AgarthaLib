// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.plugin;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class PluginBannedPropertiesBuild
{
    private final List<String> messages;
    private final List<String> servers;
    
    public PluginBannedPropertiesBuild() {
        this.messages = new ArrayList<String>();
        this.servers = new ArrayList<String>();
    }
    
    public PluginBannedPropertiesBuild(final List<String> messages, final List<String> servers) {
        this.messages = messages;
        this.servers = servers;
    }
    
    public final List<String> getMessages() {
        return this.messages;
    }
    
    public final List<String> getServers() {
        return this.servers;
    }
}
