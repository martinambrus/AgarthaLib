// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.gmail.nossr50.datatypes.experience.XPGainReason;
import com.gmail.nossr50.datatypes.experience.XPGainSource;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.util.player.UserManager;
import com.herocraftonline.heroes.characters.skill.SkillType;
import org.bukkit.inventory.ItemStack;
import com.gmail.nossr50.skills.fishing.FishingManager;
import org.bukkit.entity.Item;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportMcMMO extends Support
{
    public SupportMcMMO(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final boolean isSkillTypeExists(final String skillType) {
        return this.getSkillType(skillType) != null;
    }
    
    public final boolean isXPGainReasonExists(final String reason) {
        return this.getXPGainReason(reason) != null;
    }
    
    public final float getExp(final OfflinePlayer player, final String skillTypeName) {
        final PrimarySkillType skillType = this.getSkillType(skillTypeName);
        return this.getExp(player, skillType);
    }
    
    public final float getExp(final OfflinePlayer player, final PrimarySkillType skillType) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        return (mPlayer != null && skillType != null) ? mPlayer.getSkillXpLevelRaw(skillType) : 0.0f;
    }
    
    public final float getExpToLevel(final OfflinePlayer player, final String skillTypeName) {
        final PrimarySkillType skillType = this.getSkillType(skillTypeName);
        return this.getExpToLevel(player, skillType);
    }
    
    public final float getExpToLevel(final OfflinePlayer player, final PrimarySkillType skillType) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        return (float)((mPlayer != null && skillType != null) ? mPlayer.getXpToLevel(skillType) : 0);
    }
    
    public final int getLevel(final OfflinePlayer player, final String skillTypeName) {
        final PrimarySkillType skillType = this.getSkillType(skillTypeName);
        return this.getLevel(player, skillType);
    }
    
    public final int getLevel(final OfflinePlayer player, final PrimarySkillType skillType) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        return (mPlayer != null && skillType != null) ? mPlayer.getSkillLevel(skillType) : 0;
    }
    
    public final void addLevels(final OfflinePlayer player, final String skillTypeName, final int levels) {
        final PrimarySkillType skillType = this.getSkillType(skillTypeName);
        this.addLevels(player, skillType, levels);
    }
    
    public final void addLevels(final OfflinePlayer player, final PrimarySkillType skillType, final int levels) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        if (mPlayer != null && skillType != null) {
            mPlayer.addLevels(skillType, levels);
        }
    }
    
    public final void addExp(final OfflinePlayer player, final String skillTypeName, final float exp, final String reasonName, final XPGainSource source) {
        this.addExp(player, skillTypeName, exp, reasonName, source, false);
    }
    
    public final void addExp(final OfflinePlayer player, final String skillTypeName, final float exp, final String reasonName, final XPGainSource source, final boolean isUnshared) {
        final PrimarySkillType skillType = this.getSkillType(skillTypeName);
        final XPGainReason reason = this.getXPGainReason(reasonName);
        this.addExp(player, skillType, exp, reason, source, isUnshared);
    }
    
    public final void addExp(final OfflinePlayer player, final PrimarySkillType skillType, final float exp, final XPGainReason reason, final XPGainSource source, final boolean isUnshared) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        if (mPlayer != null && skillType != null && reason != null) {
            if (isUnshared) {
                mPlayer.beginUnsharedXpGain(skillType, exp, reason, source);
            }
            else {
                mPlayer.beginXpGain(skillType, exp, reason, source);
            }
        }
    }
    
    public final boolean handleFishingItem(final OfflinePlayer player, final Item item) {
        final McMMOPlayer mPlayer = this.getPlayer(player);
        if (mPlayer != null && item != null) {
            final FishingManager fishingManager = mPlayer.getFishingManager();
            final ItemStack itemFish = item.getItemStack();
            fishingManager.handleFishing(item);
            if (!itemFish.equals((Object)item.getItemStack())) {
                return true;
            }
        }
        return false;
    }
    
    private final McMMOPlayer getPlayer(final OfflinePlayer player) {
        return (player != null) ? UserManager.getOfflinePlayer(player) : null;
    }
    
    private final PrimarySkillType getSkillType(final String skillTypeName) {
        if (skillTypeName != null) {
            PrimarySkillType[] values;
            for (int length = (values = PrimarySkillType.values()).length, i = 0; i < length; ++i) {
                final PrimarySkillType key = values[i];
                if (key.toString().equalsIgnoreCase(skillTypeName)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    private final XPGainReason getXPGainReason(final String reason) {
        if (reason != null) {
            XPGainReason[] values;
            for (int length = (values = XPGainReason.values()).length, i = 0; i < length; ++i) {
                final XPGainReason key = values[i];
                if (key.toString().equalsIgnoreCase(reason)) {
                    return key;
                }
            }
        }
        return null;
    }
}
