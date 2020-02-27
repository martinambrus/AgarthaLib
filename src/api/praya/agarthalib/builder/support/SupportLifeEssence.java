// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import api.praya.lifeessence.manager.player.PlayerManagerAPI;
import api.praya.lifeessence.main.LifeEssenceAPI;
import api.praya.lifeessence.manager.player.PlayerHealthManagerAPI;
import org.bukkit.entity.Player;
import api.praya.lifeessence.builder.main.PlayerHealthBuild;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportLifeEssence extends Support
{
    public SupportLifeEssence(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final PlayerHealthBuild getPlayerHealthBuild(final OfflinePlayer player) {
        return this.getPlayerHealthManager().getPlayerHealthBuild(player);
    }
    
    public final void updateMaxHealth(final OfflinePlayer player) {
        this.getPlayerHealthManager().updateMaxHealth(player);
    }
    
    public final void updateHealthScale(final OfflinePlayer player) {
        this.getPlayerHealthManager().updateHealthScale(player);
    }
    
    public final void updateHealthRegen(final OfflinePlayer player) {
        this.getPlayerHealthManager().updateHealthRegen(player);
    }
    
    public final void updateAllPlayers() {
        this.getPlayerHealthManager().updateAllPlayers();
    }
    
    public final void setHealth(final Player player, final double health) {
        this.getPlayerHealthManager().setHealth(player, health);
    }
    
    public final void addHealth(final Player player, final double health) {
        this.getPlayerHealthManager().addHealth(player, health);
    }
    
    public final void removeHealth(final Player player, final double health) {
        this.getPlayerHealthManager().removeHealth(player, health);
    }
    
    public final void setMaxHealthBase(final Player player, final double maxHealth) {
        this.getPlayerHealthManager().setMaxHealthBase(player, maxHealth);
    }
    
    public final void setHealthScaleBase(final Player player, final double healthScale) {
        this.getPlayerHealthManager().setHealthScaleBase(player, healthScale);
    }
    
    public final void setHealthRegenBase(final Player player, final double healthRegen) {
        this.getPlayerHealthManager().setHealthRegenBase(player, healthRegen);
    }
    
    public final void resetMaxHealthBase(final Player player) {
        this.getPlayerHealthManager().resetMaxHealthBase(player);
    }
    
    public final void resetHealthScaleBase(final Player player) {
        this.getPlayerHealthManager().resetHealthScaleBase(player);
    }
    
    public final void resetHealthRegenBase(final Player player) {
        this.getPlayerHealthManager().resetHealthRegenBase(player);
    }
    
    private final PlayerHealthManagerAPI getPlayerHealthManager() {
        final PlayerManagerAPI playerManagerAPI = LifeEssenceAPI.getInstance().getPlayerManagerAPI();
        final PlayerHealthManagerAPI playerHealthManagerAPI = playerManagerAPI.getPlayerHealthManagerAPI();
        return playerHealthManagerAPI;
    }
}
