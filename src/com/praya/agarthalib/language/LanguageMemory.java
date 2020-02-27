// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.language;

import org.bukkit.plugin.java.JavaPlugin;
import core.praya.agarthalib.builder.message.MessageBuild;
import java.util.Iterator;
import core.praya.agarthalib.builder.main.LanguageBuild;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.manager.plugin.LanguageManager;

public class LanguageMemory extends LanguageManager
{
    private final LanguageConfig languageConfig;
    
    private LanguageMemory(final AgarthaLib plugin) {
        super(plugin);
        this.languageConfig = new LanguageConfig(plugin);
    }
    
    public static final LanguageMemory getInstance() {
        return LanguageMemoryHelper.instance;
    }
    
    public final LanguageConfig getLanguageConfig() {
        return this.languageConfig;
    }
    
    @Override
    public final Collection<String> getLanguageIds() {
        return this.getLanguageConfig().mapLanguageBuild.keySet();
    }
    
    @Override
    public final Collection<LanguageBuild> getAllLanguageBuild() {
        return this.getLanguageConfig().mapLanguageBuild.values();
    }
    
    @Override
    public final LanguageBuild getLocaleLanguage(final String id) {
        if (id != null) {
            for (final String key : this.getLanguageIds()) {
                if (key.equalsIgnoreCase(id)) {
                    return this.getLanguageConfig().mapLanguageBuild.get(key);
                }
            }
        }
        return null;
    }
    
    @Override
    public final MessageBuild getLocaleMessage(final String id, final String key) {
        if (id != null && key != null) {
            final LanguageBuild languageBuild = this.getLocaleLanguage(id);
            if (languageBuild != null) {
                return languageBuild.getMessage(key);
            }
        }
        return new MessageBuild();
    }
    
    private static class LanguageMemoryHelper
    {
        private static final LanguageMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new LanguageMemory(plugin);
        }
    }
}
