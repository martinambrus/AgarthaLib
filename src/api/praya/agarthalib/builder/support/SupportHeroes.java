// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.praya.agarthalib.utility.FileUtil;
import java.io.File;
import java.util.Iterator;
import com.herocraftonline.heroes.characters.classes.HeroClassManager;
import java.util.ArrayList;
import java.util.List;
import com.herocraftonline.heroes.characters.classes.HeroClass;
import org.bukkit.OfflinePlayer;
import com.herocraftonline.heroes.characters.classes.scaling.Scaling;
import com.herocraftonline.heroes.characters.Hero;
import org.bukkit.configuration.file.FileConfiguration;
import com.herocraftonline.heroes.characters.CharacterManager;
import com.herocraftonline.heroes.attributes.AttributeType;
import com.herocraftonline.heroes.Heroes;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportClass;
import api.praya.agarthalib.builder.support.main.SupportLevel;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportHeroes extends Support implements SupportLevel, SupportClass
{
    public SupportHeroes(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final double getBonusMaxHealth(final Player player) {
        final Heroes heroes = Heroes.getInstance();
        final CharacterManager characterManager = heroes.getCharacterManager();
        final FileConfiguration config = this.getFileConfiguration();
        if (player != null) {
            final Hero hero = characterManager.getHero(player);
            final Scaling scaling = hero.getHeroClass().getMaxHealth();
            final double constitution = hero.getAttributeValue(AttributeType.CONSTITUTION);
            final double scaleAttributes = config.getDouble("attributes.health-per-constitution");
            final double scaleMaxHealth = scaling.getScaled(hero);
            final double bonusClass = scaleMaxHealth - 20.0;
            final double bonusAttributes = scaleAttributes * constitution;
            final double bonusMaxHealth = bonusClass + bonusAttributes;
            return bonusMaxHealth;
        }
        return 0.0;
    }
    
    @Override
    public String getPlayerMainClassName(final OfflinePlayer player) {
        final Heroes heroes = Heroes.getInstance();
        final CharacterManager characterManager = heroes.getCharacterManager();
        if (player != null && player.isOnline()) {
            final Player onlinePlayer = player.getPlayer();
            final Hero hero = characterManager.getHero(onlinePlayer);
            if (hero != null) {
                final HeroClass heroClass = hero.getHeroClass();
                final String heroName = heroClass.getName();
                return heroName;
            }
        }
        return null;
    }
    
    @Override
    public List<String> getClasses() {
        final Heroes heroes = Heroes.getInstance();
        final HeroClassManager heroClassManager = heroes.getClassManager();
        final List<String> list = new ArrayList<String>();
        for (final HeroClass heroClass : heroClassManager.getClasses()) {
            list.add(heroClass.getName());
        }
        return list;
    }
    
    @Override
    public List<String> getPlayerClasses(final OfflinePlayer player) {
        final List<String> list = new ArrayList<String>();
        if (this.isPlayerHasMainClass(player)) {
            final String playerMainClass = this.getPlayerMainClassName(player);
            list.add(playerMainClass);
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
        final String playerMainClass = this.getPlayerMainClassName(player);
        return playerMainClass != null && rpgClass != null && playerMainClass.equalsIgnoreCase(rpgClass);
    }
    
    @Override
    public boolean isPlayerJoinClass(final OfflinePlayer player, final String rpgClass) {
        return this.isPlayerHasClass(player, rpgClass);
    }
    
    @Override
    public boolean isClassExists(final String rpgClass) {
        for (final String heroClass : this.getClasses()) {
            if (heroClass.equalsIgnoreCase(rpgClass)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getPlayerLevel(final OfflinePlayer player) {
        final Heroes heroes = Heroes.getInstance();
        final CharacterManager characterManager = heroes.getCharacterManager();
        if (player != null && player.isOnline()) {
            final Player onlinePlayer = player.getPlayer();
            final Hero hero = characterManager.getHero(onlinePlayer);
            final int level = hero.getHeroLevel();
            return level;
        }
        return 0;
    }
    
    @Override
    public void addPlayerLevel(final OfflinePlayer player, final int level) {
    }
    
    @Override
    public void setPlayerLevel(final OfflinePlayer player, final int level) {
    }
    
    private final FileConfiguration getFileConfiguration() {
        return this.getFileConfiguration("config.yml");
    }
    
    private final FileConfiguration getFileConfiguration(final String path) {
        final Heroes heroes = Heroes.getInstance();
        if (path != null) {
            final File file = new File(heroes.getDataFolder(), path);
            final FileConfiguration fileConfiguration = FileUtil.getFileConfiguration(file);
            return fileConfiguration;
        }
        return null;
    }
}
