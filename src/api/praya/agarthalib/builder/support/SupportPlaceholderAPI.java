// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import org.bukkit.entity.Player;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportPlaceholder;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportPlaceholderAPI extends Support implements SupportPlaceholder
{
    public SupportPlaceholderAPI(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public String setPlaceholders(final OfflinePlayer player, final String text) {
        final Player onlinePlayer = (player != null && player.isOnline()) ? player.getPlayer() : null;
        final String placeholder = (text != null) ? PlaceholderAPI.setPlaceholders(onlinePlayer, text) : null;
        return (placeholder != null) ? placeholder : text;
    }
}
