// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import be.maximvdw.featherboard.api.FeatherBoardAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportFeatherBoard extends Support
{
    public SupportFeatherBoard(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final boolean getPlayerScoreboardToggle(final Player player) {
        return player != null && FeatherBoardAPI.isToggled(player);
    }
    
    public final void setPlayerScoreboardToggle(final Player player, final boolean toggle) {
        this.setPlayerScoreboardToggle(player, toggle, false);
    }
    
    public final void setPlayerScoreboardToggle(final Player player, final boolean toggle, final boolean silent) {
        if (player != null) {
            final boolean playerToggle = this.getPlayerScoreboardToggle(player);
            if (playerToggle != toggle) {
                FeatherBoardAPI.toggle(player, silent);
            }
        }
    }
    
    public final void resetDefaultScoreboard(final Player player) {
        if (player != null) {
            FeatherBoardAPI.resetDefaultScoreboard(player);
        }
    }
    
    public final void removePlayerScoreboard(final Player player, final String scoreboard) {
        if (player != null && scoreboard != null) {
            FeatherBoardAPI.removeScoreboardOverride(player, scoreboard);
        }
    }
    
    public final void showPlayerScoreboard(final Player player, final String scoreboard) {
        if (player != null && scoreboard != null) {
            FeatherBoardAPI.showScoreboard(player, scoreboard);
        }
    }
}
