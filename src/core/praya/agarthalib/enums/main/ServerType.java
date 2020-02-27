// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import java.util.Iterator;
import org.bukkit.Bukkit;
import java.util.Arrays;
import java.util.List;

public enum ServerType
{
    BUKKIT(Arrays.asList("Bukkit", "CraftBukkit")), 
    SPIGOT(Arrays.asList("Spigot")), 
    PAPER_SPIGOT(Arrays.asList("PaperSpigot", "PaperClip")), 
    FORGE(Arrays.asList("Mod", "Forge")), 
    UNKNOWN(Arrays.asList("Unknown"));
    
    private final List<String> aliases;
    
    private ServerType(final List<String> aliases) {
        this.aliases = aliases;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public static final ServerType getServerType() {
        final String version = Bukkit.getServer().getVersion();
        final String[] parts = version.split("-");
        final int length = parts.length;
        return (length > 1) ? getServerType(parts[1]) : ServerType.FORGE;
    }
    
    public static final ServerType getServerType(final String serverType) {
        if (serverType == null) {
            return ServerType.UNKNOWN;
        }
        ServerType[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final ServerType key = values[i];
            for (final String aliase : key.getAliases()) {
                if (aliase.equalsIgnoreCase(serverType)) {
                    return key;
                }
            }
        }
        return ServerType.FORGE;
    }
}
