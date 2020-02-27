// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import java.util.ArrayList;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.MerchantRecipe;

public class SerializeUtil
{
    public static final String serializeMerchantRecipe(final MerchantRecipe recipe) {
        final FileConfiguration config = (FileConfiguration)new YamlConfiguration();
        config.set("result", (Object)recipe.getResult());
        config.set("ingredients", (Object)recipe.getIngredients());
        config.set("uses", (Object)recipe.getUses());
        config.set("maxUses", (Object)recipe.getMaxUses());
        config.set("toggleExp", (Object)recipe.hasExperienceReward());
        return config.saveToString();
    }
    
    public static final MerchantRecipe deserializeMerchantRecipe(final String serialize) throws InvalidConfigurationException {
        if (serialize == null) {
            return null;
        }
        final FileConfiguration config = (FileConfiguration)new YamlConfiguration();
        config.loadFromString(serialize);
        final ItemStack result = config.getItemStack("result");
        final List<ItemStack> ingredients = (List<ItemStack>)config.getList("ingredients");
        final int uses = config.getInt("uses");
        final int maxUses = config.getInt("maxUses");
        final boolean toggleExp = config.getBoolean("toggleExp");
        final MerchantRecipe recipe = new MerchantRecipe(result, uses, maxUses, toggleExp);
        recipe.setIngredients((List)ingredients);
        return recipe;
    }
    
    public static final MerchantRecipe deserializeMerchantRecipeSilent(final String serialize) {
        try {
            return deserializeMerchantRecipe(serialize);
        }
        catch (InvalidConfigurationException e) {
            return null;
        }
    }
    
    public static final String serializeMerchantRecipes(final List<MerchantRecipe> recipes) {
        final List<String> serializeRecipes = new ArrayList<String>();
        final FileConfiguration config = (FileConfiguration)new YamlConfiguration();
        for (final MerchantRecipe recipe : recipes) {
            final String serializeRecipe = serializeMerchantRecipe(recipe);
            serializeRecipes.add(serializeRecipe);
        }
        config.set("recipes", (Object)serializeRecipes);
        return config.saveToString();
    }
    
    public static final List<MerchantRecipe> deserializeMerchantRecipes(final String serialize) throws InvalidConfigurationException {
        if (serialize == null) {
            return null;
        }
        final FileConfiguration config = (FileConfiguration)new YamlConfiguration();
        final List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
        config.loadFromString(serialize);
        final List<String> serializeRecipes = (List<String>)config.getStringList("recipes");
        for (final String serializeRecipe : serializeRecipes) {
            final MerchantRecipe recipe = deserializeMerchantRecipeSilent(serializeRecipe);
            if (recipe != null) {
                recipes.add(recipe);
            }
        }
        return recipes;
    }
    
    public static final List<MerchantRecipe> deserializeMerchantRecipesSilent(final String serialize) {
        try {
            return deserializeMerchantRecipes(serialize);
        }
        catch (InvalidConfigurationException e) {
            return new ArrayList<MerchantRecipe>();
        }
    }
}
