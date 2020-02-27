// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.sucy.skill.api.enums.ExpSource;
import java.util.Iterator;
import com.praya.agarthalib.utility.SortUtil;
import java.util.List;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.OfflinePlayer;
import com.sucy.skill.SkillAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportClass;
import api.praya.agarthalib.builder.support.main.SupportLevel;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportSkillAPI extends Support implements SupportLevel, SupportClass
{
    public SupportSkillAPI(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final double getBonusStats(final Player player, final String attribute, final double value) {
        if (player != null && attribute != null) {
            final PlayerData playerData = SkillAPI.getPlayerData((OfflinePlayer)player);
            final double attributesValue = playerData.scaleStat(attribute, value);
            double scaleValue = attributesValue - value;
            if (attribute.equalsIgnoreCase("health") || attribute.equalsIgnoreCase("mana")) {
                final PlayerClass playerClass = playerData.getMainClass();
                if (playerClass != null) {
                    final RPGClass rpgClass = playerClass.getData();
                    final int level = this.getPlayerLevel((OfflinePlayer)player);
                    double valueClass;
                    if (attribute.equalsIgnoreCase("health")) {
                        valueClass = rpgClass.getHealth(level) - 20.0;
                    }
                    else {
                        valueClass = rpgClass.getMana(level);
                    }
                    scaleValue += valueClass;
                }
            }
            return scaleValue;
        }
        return value;
    }
    
    public final void setMaxHealth(final Player player, final double maxHealth) {
        if (player != null) {
            final PlayerData playerData = SkillAPI.getPlayerData((OfflinePlayer)player);
            final double totalMaxMana = playerData.getMaxMana();
            final double healthAttributes = playerData.scaleStat("health", maxHealth);
            final double maxHealthBonus = healthAttributes - 20.0;
            playerData.clearBonuses();
            final double baseMaxMana = playerData.getMaxMana();
            final double bonusMaxmana = totalMaxMana - baseMaxMana;
            player.resetMaxHealth();
            playerData.addMaxHealth(maxHealthBonus);
            playerData.addMaxMana(bonusMaxmana);
            playerData.updateHealthAndMana(player);
        }
    }
    
    @Override
    public String getPlayerMainClassName(final OfflinePlayer player) {
        return this.isPlayerHasMainClass(player) ? SkillAPI.getPlayerData(player).getMainClass().getData().getName() : null;
    }
    
    @Override
    public List<String> getClasses() {
        return SortUtil.toList(SkillAPI.getClasses().keySet());
    }
    
    @Override
    public List<String> getPlayerClasses(final OfflinePlayer player) {
        final List<String> classes = this.getClasses();
        if (player != null) {
            final PlayerData playerData = SkillAPI.getPlayerData(player);
            for (final PlayerClass playerClass : playerData.getClasses()) {
                classes.add(playerClass.getData().getName());
            }
        }
        return classes;
    }
    
    @Override
    public boolean isSupportMultiClass() {
        return true;
    }
    
    @Override
    public boolean isPlayerHasMainClass(final OfflinePlayer player) {
        return player != null && SkillAPI.getPlayerData(player).getMainClass() != null;
    }
    
    @Override
    public boolean isPlayerHasClass(final OfflinePlayer player, final String rpgClass) {
        if (player != null && rpgClass != null) {
            final PlayerData playerData = SkillAPI.getPlayerData(player);
            return playerData.hasClass(rpgClass);
        }
        return false;
    }
    
    @Override
    public boolean isPlayerJoinClass(final OfflinePlayer player, final String rpgClass) {
        if (player != null && rpgClass != null) {
            final String mainClass = this.getPlayerMainClassName(player);
            return mainClass != null && mainClass.equalsIgnoreCase(rpgClass);
        }
        return false;
    }
    
    @Override
    public boolean isClassExists(final String rpgClass) {
        return rpgClass != null && SkillAPI.isClassRegistered(rpgClass);
    }
    
    @Override
    public int getPlayerLevel(final OfflinePlayer player) {
        return this.isPlayerHasMainClass(player) ? SkillAPI.getPlayerData(player).getMainClass().getLevel() : 0;
    }
    
    @Override
    public void addPlayerLevel(final OfflinePlayer player, final int level) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            mainClass.giveLevels(level);
        }
    }
    
    @Override
    public void setPlayerLevel(final OfflinePlayer player, final int level) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            mainClass.setLevel(level);
        }
    }
    
    public final double getPlayerExp(final OfflinePlayer player) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            return mainClass.getExp();
        }
        return 0.0;
    }
    
    public final double getPlayerTotalExp(final OfflinePlayer player) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            return mainClass.getTotalExp();
        }
        return 0.0;
    }
    
    public final double getPlayerRequiredExp(final OfflinePlayer player) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            return mainClass.getRequiredExp();
        }
        return 0.0;
    }
    
    public final void addPlayerExp(final OfflinePlayer player, final double exp) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            mainClass.giveExp(exp, ExpSource.SPECIAL);
        }
    }
    
    public final void setPlayerExp(final OfflinePlayer player, final double exp) {
        if (this.isPlayerHasMainClass(player)) {
            final PlayerClass mainClass = SkillAPI.getPlayerData(player).getMainClass();
            mainClass.setExp(exp);
        }
    }
}
