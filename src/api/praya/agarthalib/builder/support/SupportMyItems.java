// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import api.praya.myitems.manager.player.PlayerManagerAPI;
import api.praya.myitems.main.MyItemsAPI;
import api.praya.myitems.manager.game.GameManagerAPI;
import api.praya.myitems.builder.lorestats.LoreStatsOption;
import api.praya.myitems.manager.game.LoreStatsManagerAPI;
import api.praya.myitems.builder.lorestats.LoreStatsEnum;
import org.bukkit.inventory.ItemStack;
import api.praya.myitems.builder.item.ItemStatsArmor;
import api.praya.myitems.manager.player.PlayerItemStatsManagerAPI;
import api.praya.myitems.builder.item.ItemStatsWeapon;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportMyItems extends Support
{
    public SupportMyItems(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final ItemStatsWeapon getItemStatsWeapon(final Player player) {
        final PlayerItemStatsManagerAPI playerItemStatsManagerAPI = this.getPlayerManagerAPI().getPlayerItemStatsManagerAPI();
        return playerItemStatsManagerAPI.getItemStatsWeapon(player);
    }
    
    public final ItemStatsArmor getItemStatsArmor(final Player player) {
        final PlayerItemStatsManagerAPI playerItemStatsManagerAPI = this.getPlayerManagerAPI().getPlayerItemStatsManagerAPI();
        return playerItemStatsManagerAPI.getItemStatsArmor(player);
    }
    
    public final boolean hasLoreStats(final ItemStack item, final String loreStats) {
        final LoreStatsEnum loreStatsEnum = this.getLoreStats(loreStats);
        return loreStatsEnum != null && this.hasLoreStats(item, loreStatsEnum);
    }
    
    public final boolean hasLoreStats(final ItemStack item, final LoreStatsEnum loreStats) {
        final LoreStatsManagerAPI loreStatsManagerAPI = this.getGameManagerAPI().getLoreStatsManagerAPI();
        return item != null && loreStatsManagerAPI.hasLoreStats(item, loreStats);
    }
    
    public final double getStatsValue(final ItemStack item, final String loreStats) {
        final LoreStatsEnum loreStatsEnum = this.getLoreStats(loreStats);
        return (loreStatsEnum != null) ? this.getStatsValue(item, loreStatsEnum) : 0.0;
    }
    
    public final double getStatsValue(final ItemStack item, final String loreStats, final String option) {
        final LoreStatsEnum loreStatsEnum = this.getLoreStats(loreStats);
        final LoreStatsOption optionStatsEnum = this.getOptionStats(option);
        return (loreStatsEnum != null && optionStatsEnum != null) ? this.getStatsValue(item, loreStatsEnum, optionStatsEnum) : 0.0;
    }
    
    public final double getStatsValue(final ItemStack item, final LoreStatsEnum loreStats) {
        return this.getStatsValue(item, loreStats, LoreStatsOption.CURRENT);
    }
    
    public final double getStatsValue(final ItemStack item, final LoreStatsEnum loreStats, final LoreStatsOption option) {
        final LoreStatsManagerAPI loreStatsManagerAPI = this.getGameManagerAPI().getLoreStatsManagerAPI();
        return loreStatsManagerAPI.getLoreValue(item, loreStats, option);
    }
    
    private final LoreStatsEnum getLoreStats(final String loreStats) {
        return (loreStats != null) ? LoreStatsEnum.get(loreStats) : null;
    }
    
    private final LoreStatsOption getOptionStats(final String option) {
        return (option != null) ? LoreStatsOption.get(option) : null;
    }
    
    private final GameManagerAPI getGameManagerAPI() {
        final MyItemsAPI myItemsAPI = MyItemsAPI.getInstance();
        final GameManagerAPI gameManagerAPI = myItemsAPI.getGameManagerAPI();
        return gameManagerAPI;
    }
    
    private final PlayerManagerAPI getPlayerManagerAPI() {
        final MyItemsAPI myItemsAPI = MyItemsAPI.getInstance();
        final PlayerManagerAPI playerManagerAPI = myItemsAPI.getPlayerManagerAPI();
        return playerManagerAPI;
    }
}
