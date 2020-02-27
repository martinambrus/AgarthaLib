// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import me.leothepro555.skills.SkillInfo;
import me.leothepro555.skills.damagemodifiers.DamageEventModifier;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import me.leothepro555.skills.Skills;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportClass;
import api.praya.agarthalib.builder.support.main.SupportLevel;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportSkillsPro extends Support implements SupportLevel, SupportClass
{
    public SupportSkillsPro(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public int getPlayerLevel(final OfflinePlayer player) {
        return (player != null) ? Skills.getLevel(player) : 0;
    }
    
    @Override
    public void addPlayerLevel(final OfflinePlayer player, final int level) {
        if (player != null) {
            Skills.addLevel(player, level);
        }
    }
    
    @Override
    public void setPlayerLevel(final OfflinePlayer player, final int level) {
        if (player != null) {
            final int playerLevel = this.getPlayerLevel(player);
            final int diff = level - playerLevel;
            this.addPlayerLevel(player, diff);
        }
    }
    
    @Override
    public String getPlayerMainClassName(final OfflinePlayer player) {
        if (player != null) {
            final Skills.SkillType skillType = Skills.getSkill(player);
            return (skillType != null) ? skillType.getConfigName() : null;
        }
        return null;
    }
    
    @Override
    public List<String> getClasses() {
        final List<String> list = new ArrayList<String>();
        Skills.SkillType[] values;
        for (int length = (values = Skills.SkillType.values()).length, i = 0; i < length; ++i) {
            final Skills.SkillType key = values[i];
            list.add(key.getConfigName());
        }
        return list;
    }
    
    @Override
    public List<String> getPlayerClasses(final OfflinePlayer player) {
        final List<String> list = new ArrayList<String>();
        if (player != null) {
            final String playerSkill = this.getPlayerMainClassName(player);
            if (playerSkill != null) {
                list.add(playerSkill);
            }
        }
        return list;
    }
    
    @Override
    public boolean isSupportMultiClass() {
        return false;
    }
    
    @Override
    public boolean isPlayerHasMainClass(final OfflinePlayer player) {
        return this.getPlayerMainClassName(player) != null;
    }
    
    @Override
    public boolean isPlayerHasClass(final OfflinePlayer player, final String rpgClass) {
        return this.isPlayerJoinClass(player, rpgClass);
    }
    
    @Override
    public boolean isPlayerJoinClass(final OfflinePlayer player, final String rpgClass) {
        if (player != null && rpgClass != null) {
            final Skills.SkillType skillType = Skills.getSkill(player);
            return skillType != null && (skillType.name().equalsIgnoreCase(rpgClass) || skillType.getConfigName().equalsIgnoreCase(rpgClass));
        }
        return false;
    }
    
    @Override
    public boolean isClassExists(final String rpgClass) {
        if (rpgClass != null && !rpgClass.equalsIgnoreCase("None")) {
            Skills.SkillType[] values;
            for (int length = (values = Skills.SkillType.values()).length, i = 0; i < length; ++i) {
                final Skills.SkillType type = values[i];
                if (type.name().equalsIgnoreCase(rpgClass) || type.getConfigName().equalsIgnoreCase(rpgClass)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public final double getBonusMaxHealth(final Player player) {
        if (player != null) {
            final SkillInfo skillInfo = DamageEventModifier.getSkillInfo(player);
            return (skillInfo != null) ? (skillInfo.getMaxhealth() - 20) : 0;
        }
        return 0.0;
    }
    
    public final void updateValues(final Player player) {
        if (player != null) {
            final DamageEventModifier damageEventModifier = Skills.getInstance().damagemodifier;
            damageEventModifier.updateValues(player);
        }
    }
}
