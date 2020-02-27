// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.language;

import com.praya.agarthalib.manager.plugin.PlaceholderManager;
import core.praya.agarthalib.builder.message.MessageBuild;
import com.praya.agarthalib.placeholder.PlaceholderMemory;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Iterator;
import java.io.File;
import java.util.regex.Pattern;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.utility.FileUtil;
import com.praya.agarthalib.AgarthaLib;
import java.util.ArrayList;
import core.praya.agarthalib.builder.main.LanguageBuild;
import java.util.HashMap;
import java.util.List;
import com.praya.agarthalib.handler.HandlerConfig;

public class LanguageConfig extends HandlerConfig
{
    private static final String PATH_FOLDER = "Language";
    private static final List<String> LIST_PATH_FILES;
    protected final HashMap<String, LanguageBuild> mapLanguageBuild;
    
    static {
        (LIST_PATH_FILES = new ArrayList<String>()).add("Language/lang_en.yml");
        LanguageConfig.LIST_PATH_FILES.add("Language/lang_id.yml");
        LanguageConfig.LIST_PATH_FILES.add("Language/lang_ru.yml");
    }
    
    public LanguageConfig(final AgarthaLib plugin) {
        super(plugin);
        this.mapLanguageBuild = new HashMap<String, LanguageBuild>();
        this.setup();
    }
    
    @Override
    public final void setup() {
        this.moveOldFile();
        this.reset();
        this.loadConfig();
    }
    
    private final void reset() {
        this.mapLanguageBuild.clear();
    }
    
    private final void loadConfig() {
        final File folder = FileUtil.getFile(this.plugin, "Language");
        for (final String pathFile : LanguageConfig.LIST_PATH_FILES) {
            final File file = FileUtil.getFile(this.plugin, pathFile);
            final String name = file.getName().toLowerCase();
            final String id = name.split(Pattern.quote("."))[0];
            final String locale = (id.startsWith("lang_") ? id.replaceFirst("lang_", "") : "en").toLowerCase();
            if (!file.exists()) {
                FileUtil.saveResource(this.plugin, pathFile);
            }
            final FileConfiguration config = FileUtil.getFileConfigurationResource(this.plugin, pathFile);
            final LanguageBuild language = this.loadLanguage(locale, config);
            this.mapLanguageBuild.put(locale, language);
        }
        File[] listFiles;
        for (int length = (listFiles = folder.listFiles()).length, i = 0; i < length; ++i) {
            final File file2 = listFiles[i];
            final String name2 = file2.getName().toLowerCase();
            final String id2 = name2.split(Pattern.quote("."))[0];
            final String locale2 = (id2.startsWith("lang_") ? id2.replaceFirst("lang_", "") : "en").toLowerCase();
            final FileConfiguration config2 = FileUtil.getFileConfiguration(file2);
            final LanguageBuild language2 = this.loadLanguage(locale2, config2);
            final LanguageBuild localeLang = this.mapLanguageBuild.get(locale2);
            if (localeLang != null) {
                localeLang.mergeLanguage(language2);
            }
            else {
                this.mapLanguageBuild.put(id2, language2);
            }
        }
    }
    
    private final LanguageBuild loadLanguage(final String locale, final FileConfiguration config) {
        final PlaceholderManager placeholderManager = PlaceholderMemory.getInstance();
        final HashMap<String, MessageBuild> mapLanguage = new HashMap<String, MessageBuild>();
        for (final String path : config.getKeys(true)) {
            final String key = path.replace(".", "_").toUpperCase();
            if (config.isString(path)) {
                final String text = config.getString(path);
                final List<String> list = new ArrayList<String>();
                list.add(text);
                final List<String> listPlaceholder = placeholderManager.localPlaceholder(list);
                final MessageBuild messages = new MessageBuild(listPlaceholder);
                mapLanguage.put(key, messages);
            }
            else {
                if (!config.isList(path)) {
                    continue;
                }
                final List<String> list2 = (List<String>)config.getStringList(path);
                final List<String> listPlaceholder2 = placeholderManager.localPlaceholder(list2);
                final MessageBuild messages2 = new MessageBuild(listPlaceholder2);
                mapLanguage.put(key, messages2);
            }
        }
        return new LanguageBuild(locale, mapLanguage);
    }
    
    private final void moveOldFile() {
        final String pathOld = "Language/lang.yml";
        final String pathNew = "Language/lang_en.yml";
        final File fileOld = FileUtil.getFile(this.plugin, "Language/lang.yml");
        final File fileNew = FileUtil.getFile(this.plugin, "Language/lang_en.yml");
        if (fileOld.exists()) {
            FileUtil.moveFileSilent(fileOld, fileNew);
        }
    }
}
