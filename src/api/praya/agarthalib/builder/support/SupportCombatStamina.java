// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import api.praya.combatstamina.manager.player.PlayerManagerAPI;
import api.praya.combatstamina.main.CombatStaminaAPI;
import api.praya.combatstamina.manager.player.PlayerStaminaManagerAPI;
import api.praya.combatstamina.builder.event.PlayerStaminaRestoreEvent;
import api.praya.combatstamina.builder.event.PlayerStaminaConsumeEvent;
import org.bukkit.entity.Player;
import api.praya.combatstamina.builder.main.PlayerStaminaBuild;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportCombatStamina extends Support
{
    public SupportCombatStamina(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final PlayerStaminaBuild getPlayerStaminaBuild(final OfflinePlayer player) {
        return this.getPlayerStaminaManager().getPlayerStaminaBuild(player);
    }
    
    public final boolean getPlayerStaminaNotificationToggle(final OfflinePlayer player) {
        return this.getPlayerStaminaManager().getPlayerStaminaNotificationToggle(player);
    }
    
    public final void setPlayerStaminaNotificationToggle(final OfflinePlayer player, final boolean toggle) {
        this.getPlayerStaminaManager().setPlayerStaminaNotificationToggle(player, toggle);
    }
    
    public final void updateMaxStamina(final OfflinePlayer player) {
        this.getPlayerStaminaManager().updateMaxStamina(player);
    }
    
    public final void updateStaminaRegen(final OfflinePlayer player) {
        this.getPlayerStaminaManager().updateStaminaRegen(player);
    }
    
    public final PlayerStaminaConsumeEvent consumeStaminaPlayer(final Player player, final PlayerStaminaConsumeEvent.StaminaConsumeTypeEnum type) {
        return this.getPlayerStaminaManager().consumeStaminaPlayer(player, type);
    }
    
    public final PlayerStaminaConsumeEvent consumeStaminaPlayer(final Player player, final double consume) {
        return this.getPlayerStaminaManager().consumeStaminaPlayer(player, consume);
    }
    
    public final PlayerStaminaConsumeEvent consumeStaminaPlayer(final Player player, final double consume, final PlayerStaminaConsumeEvent.StaminaConsumeTypeEnum type) {
        return this.getPlayerStaminaManager().consumeStaminaPlayer(player, consume, type);
    }
    
    public final PlayerStaminaRestoreEvent restoreStaminaPlayer(final Player player, final PlayerStaminaRestoreEvent.StaminaRestoreTypeEnum type) {
        return this.getPlayerStaminaManager().restoreStaminaPlayer(player, type);
    }
    
    public final PlayerStaminaRestoreEvent restoreStaminaPlayer(final Player player, final double restore) {
        return this.getPlayerStaminaManager().restoreStaminaPlayer(player, restore);
    }
    
    public final PlayerStaminaRestoreEvent restoreStaminaPlayer(final Player player, final double restore, final PlayerStaminaRestoreEvent.StaminaRestoreTypeEnum type) {
        return this.getPlayerStaminaManager().restoreStaminaPlayer(player, restore, type);
    }
    
    public final void setStamina(final Player player, final double stamina) {
        this.getPlayerStaminaManager().setStamina(player, stamina);
    }
    
    public final void addStamina(final Player player, final double stamina) {
        this.getPlayerStaminaManager().addStamina(player, stamina);
    }
    
    public final void removeStamina(final Player player, final double stamina) {
        this.getPlayerStaminaManager().removeStamina(player, stamina);
    }
    
    public final void setMaxStaminaBase(final Player player, final double maxStamina) {
        this.getPlayerStaminaManager().setMaxStaminaBase(player, maxStamina);
    }
    
    public final void setStaminaRegenBase(final Player player, final double staminaRegen) {
        this.getPlayerStaminaManager().setStaminaRegenBase(player, staminaRegen);
    }
    
    public final void resetMaxStaminaBase(final Player player) {
        this.getPlayerStaminaManager().resetMaxStaminaBase(player);
    }
    
    public final void resetStaminaRegenBase(final Player player) {
        this.getPlayerStaminaManager().resetStaminaRegenBase(player);
    }
    
    private final PlayerStaminaManagerAPI getPlayerStaminaManager() {
        final PlayerManagerAPI playerManagerAPI = CombatStaminaAPI.getInstance().getPlayerManagerAPI();
        final PlayerStaminaManagerAPI playerStaminaManagerAPI = playerManagerAPI.getPlayerStaminaManagerAPI();
        return playerStaminaManagerAPI;
    }
}
