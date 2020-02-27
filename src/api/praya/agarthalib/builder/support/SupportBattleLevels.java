// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.praya.agarthalib.utility.FileUtil;
import java.io.File;
import com.praya.agarthalib.utility.PluginUtil;
import com.praya.agarthalib.utility.MathUtil;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.UUID;
import me.RobiRami.battlelevels.LevelAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportLevel;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportBattleLevels extends Support implements SupportLevel
{
    public SupportBattleLevels(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public int getPlayerLevel(final OfflinePlayer player) {
        if (player != null) {
            return LevelAPI.getLevel(player.getName());
        }
        return 0;
    }
    
    @Override
    public void addPlayerLevel(final OfflinePlayer player, final int level) {
        if (player != null) {
            LevelAPI.setLevel(player.getName(), level);
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
    
    public final boolean isExtraHealthEnabled() {
        final FileConfiguration config = this.getFileConfiguration();
        return config != null && config.getBoolean("enable-extra-hearts");
    }
    
    public final double getExtraHealthScale() {
        final FileConfiguration config = this.getFileConfiguration();
        return (config != null) ? config.getDouble("extra-hearts-per-level") : 0.0;
    }
    
    public final double getExtraHealthMax() {
        final FileConfiguration config = this.getFileConfiguration();
        return (config != null) ? config.getDouble("max-extra-hearts") : 0.0;
    }
    
    public final double getExtraHealth(final OfflinePlayer player) {
        if (player != null) {
            final int level = this.getPlayerLevel(player);
            final double rawHealth = this.getExtraHealthScale() * level;
            final double extraHealth = MathUtil.limitDouble(rawHealth, 0.0, this.getExtraHealthMax());
            return extraHealth;
        }
        return 0.0;
    }
    
    private final FileConfiguration getFileConfiguration() {
        return this.getFileConfiguration("config.yml");
    }
    
    private final FileConfiguration getFileConfiguration(final String path) {
        if (path != null) {
            final Plugin plugin = PluginUtil.getPlugin("BattleLevels");
            if (plugin != null) {
                final File file = new File(plugin.getDataFolder(), path);
                final FileConfiguration fileConfiguration = FileUtil.getFileConfiguration(file);
                return fileConfiguration;
            }
        }
        return null;
    }
}
