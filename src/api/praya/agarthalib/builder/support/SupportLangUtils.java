// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import java.util.Map;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import com.meowj.langutils.lang.LanguageHelper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportLangUtils extends Support
{
    public SupportLangUtils(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public String getItemDisplayName(final ItemStack item, final String locale) {
        return LanguageHelper.getItemDisplayName(item, locale);
    }
    
    public String getItemDisplayName(final ItemStack item, final Player player) {
        return LanguageHelper.getItemDisplayName(item, player);
    }
    
    public String getItemName(final ItemStack item, final String locale) {
        return LanguageHelper.getItemName(item, locale);
    }
    
    public String getItemName(final ItemStack item, final Player player) {
        return LanguageHelper.getItemName(item, player);
    }
    
    public String getItemUnlocalizedName(final ItemStack item) {
        return LanguageHelper.getItemUnlocalizedName(item);
    }
    
    public String getEntityUnlocalizedName(final Entity entity) {
        return LanguageHelper.getEntityUnlocalizedName(entity);
    }
    
    public String getEntityUnlocalizedName(final EntityType entityType) {
        return LanguageHelper.getEntityUnlocalizedName(entityType);
    }
    
    public String getEntityDisplayName(final Entity entity, final String locale) {
        return LanguageHelper.getEntityDisplayName(entity, locale);
    }
    
    public String getEntityDisplayName(final Entity entity, final Player player) {
        return LanguageHelper.getEntityDisplayName(entity, player);
    }
    
    public String getEntityName(final Entity entity, final String locale) {
        return LanguageHelper.getEntityName(entity, locale);
    }
    
    public String getEntityName(final Entity entity, final Player player) {
        return LanguageHelper.getEntityName(entity, player);
    }
    
    public String getEntityName(final EntityType entityType, final String locale) {
        return LanguageHelper.getEntityName(entityType, locale);
    }
    
    public String getEntityName(final EntityType entityType, final Player player) {
        return LanguageHelper.getEntityName(entityType, player);
    }
    
    public String getEnchantmentLevelUnlocalizedName(final int level) {
        return LanguageHelper.getEnchantmentLevelUnlocalizedName(level);
    }
    
    public String getEnchantmentLevelName(final int level, final Player player) {
        return LanguageHelper.getEnchantmentLevelName(level, player);
    }
    
    public String getEnchantmentLevelName(final int level, final String locale) {
        return LanguageHelper.getEnchantmentLevelName(level, locale);
    }
    
    public String getEnchantmentUnlocalizedName(final Enchantment enchantment) {
        return LanguageHelper.getEnchantmentUnlocalizedName(enchantment);
    }
    
    public String getEnchantmentName(final Enchantment enchantment, final Player player) {
        return LanguageHelper.getEnchantmentName(enchantment, player);
    }
    
    public String getEnchantmentName(final Enchantment enchantment, final String locale) {
        return LanguageHelper.getEnchantmentName(enchantment, locale);
    }
    
    public String getEnchantmentDisplayName(final Enchantment enchantment, final int level, final Player player) {
        return LanguageHelper.getEnchantmentDisplayName(enchantment, level, player);
    }
    
    public String getEnchantmentDisplayName(final Enchantment enchantment, final int level, final String locale) {
        return LanguageHelper.getEnchantmentDisplayName(enchantment, level, locale);
    }
    
    public String getEnchantmentDisplayName(final Map.Entry<Enchantment, Integer> entry, final String locale) {
        return LanguageHelper.getEnchantmentDisplayName((Map.Entry)entry, locale);
    }
    
    public String getEnchantmentDisplayName(final Map.Entry<Enchantment, Integer> entry, final Player player) {
        return LanguageHelper.getEnchantmentDisplayName((Map.Entry)entry, player);
    }
    
    public String translateToLocal(final String unlocalizedName, final String locale) {
        return LanguageHelper.translateToLocal(unlocalizedName, locale);
    }
}
