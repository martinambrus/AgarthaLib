// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.plugin;

import java.util.ArrayList;
import java.util.List;
import com.praya.agarthalib.AgarthaLibConfig;
import org.bukkit.command.CommandSender;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import core.praya.agarthalib.builder.message.MessageBuild;
import core.praya.agarthalib.builder.main.LanguageBuild;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class LanguageManager extends HandlerManager
{
    protected LanguageManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<String> getLanguageIds();
    
    public abstract Collection<LanguageBuild> getAllLanguageBuild();
    
    public abstract LanguageBuild getLocaleLanguage(final String p0);
    
    public abstract MessageBuild getLocaleMessage(final String p0, final String p1);
    
    public final LanguageBuild getLanguage(final String id) {
        if (id != null) {
            final String[] parts = id.split("_");
            int size;
            for (int length = size = parts.length; size > 0; --size) {
                final StringBuilder builder = new StringBuilder();
                for (int index = 0; index < size; ++index) {
                    final String component = parts[index];
                    if (index > 0) {
                        builder.append("_");
                    }
                    builder.append(component);
                }
                final String identifier = builder.toString();
                final LanguageBuild languageBuild = this.getLocaleLanguage(identifier);
                if (languageBuild != null) {
                    return languageBuild;
                }
            }
        }
        return this.getLocaleLanguage("en");
    }
    
    public final boolean isLanguageExists(final String id) {
        return this.getLocaleLanguage(id) != null;
    }
    
    public final MessageBuild getMessage(final LivingEntity entity, final String key) {
        if (entity != null && entity instanceof Player) {
            final Player player = (Player)entity;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getMessage(locale, key);
        }
        return this.getMessage(key);
    }
    
    public final MessageBuild getMessage(final CommandSender sender, final String key) {
        if (sender != null && sender instanceof Player) {
            final Player player = (Player)sender;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getMessage(locale, key);
        }
        return this.getMessage(key);
    }
    
    public final MessageBuild getMessage(final String key) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        final String locale = mainConfig.getGeneralLocale();
        return this.getMessage(locale, key);
    }
    
    public final MessageBuild getMessage(final String id, final String key) {
        if (id != null) {
            final String[] parts = id.split("_");
            int size;
            for (int length = size = parts.length; size > 0; --size) {
                final StringBuilder builder = new StringBuilder();
                for (int index = 0; index < size; ++index) {
                    final String component = parts[index];
                    if (index > 0) {
                        builder.append("_");
                    }
                    builder.append(component);
                }
                final String identifier = builder.toString();
                final LanguageBuild languageBuild = this.getLocaleLanguage(identifier);
                if (languageBuild != null) {
                    final MessageBuild message = languageBuild.getMessage(key);
                    if (message.isSet()) {
                        return message;
                    }
                }
            }
        }
        return this.getLocaleMessage("en", key);
    }
    
    public final List<String> getListText(final LivingEntity entity, final String key) {
        if (entity != null && entity instanceof Player) {
            final Player player = (Player)entity;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getListText(locale, key);
        }
        return this.getListText(key);
    }
    
    public final List<String> getListText(final CommandSender sender, final String key) {
        if (sender != null && sender instanceof Player) {
            final Player player = (Player)sender;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getListText(locale, key);
        }
        return this.getListText(key);
    }
    
    public final List<String> getListText(final String key) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        final String locale = mainConfig.getGeneralLocale();
        return this.getListText(locale, key);
    }
    
    public final List<String> getListText(final String id, final String key) {
        final MessageBuild message = this.getMessage(id, key);
        return (message != null) ? message.getListText() : new ArrayList<String>();
    }
    
    public final String getText(final LivingEntity entity, final String key) {
        if (entity != null && entity instanceof Player) {
            final Player player = (Player)entity;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getText(locale, key);
        }
        return this.getText(key);
    }
    
    public final String getText(final CommandSender sender, final String key) {
        if (sender != null && sender instanceof Player) {
            final Player player = (Player)sender;
            final String locale = Bridge.getBridgePlayer().getLocale(player);
            return this.getText(locale, key);
        }
        return this.getText(key);
    }
    
    public final String getText(final String key) {
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        final String locale = mainConfig.getGeneralLocale();
        return this.getText(locale, key);
    }
    
    public final String getText(final String id, final String key) {
        final MessageBuild message = this.getMessage(id, key);
        return (message != null) ? message.getText() : "";
    }
}
