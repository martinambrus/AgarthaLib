// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportPlaceholder;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportMVdWPlaceholderAPI extends Support implements SupportPlaceholder
{
    public SupportMVdWPlaceholderAPI(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public String setPlaceholders(final OfflinePlayer player, final String text) {
        final String placeholder = (text != null) ? PlaceholderAPI.replacePlaceholders(player, text) : null;
        return (placeholder != null) ? placeholder : text;
    }
}
