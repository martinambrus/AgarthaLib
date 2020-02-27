// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.plugin;

import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.Reader;
import java.io.InputStream;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import java.util.HashMap;
import java.util.ArrayList;
import com.praya.agarthalib.utility.SystemUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.InputStreamReader;
import com.praya.agarthalib.utility.FileUtil;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.face.Agartha;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginPropertiesBuild
{
    private final String name;
    private final String company;
    private final String author;
    private final String owner;
    private final String website;
    
    public PluginPropertiesBuild() {
        this(null, null, null, null, null);
    }
    
    public PluginPropertiesBuild(final String name, final String company, final String author, final String website) {
        this(name, company, author, author, website);
    }
    
    public PluginPropertiesBuild(final String name, final String company, final String author, final String owner, final String website) {
        this.name = name;
        this.company = company;
        this.author = author;
        this.owner = owner;
        this.website = website;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final String getCompany() {
        return this.company;
    }
    
    public final String getAuthor() {
        return this.author;
    }
    
    public final String getOwner() {
        return this.owner;
    }
    
    public final String getWebsite() {
        return this.website;
    }
    
    public static final PluginPropertiesResourceBuild getPluginPropertiesResource(final JavaPlugin plugin, final String type, final String version) {
        if (plugin != null) {
            final PluginDescriptionFile description = plugin.getDescription();
            final String name = description.getName();
            final String company = description.getVersion();
            final String author = description.getAuthors().get(0);
            final String website = description.getWebsite();
            return new PluginPropertiesResourceBuild(name, company, author, website, type, version);
        }
        return new PluginPropertiesResourceBuild(null, null, null, null, null, type, version);
    }
    
    public static final PluginPropertiesStreamBuild getPluginPropertiesStream(final Agartha plugin) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final PluginPropertiesManager pluginPropertiesManager = pluginManager.getPluginPropertiesManager();
        if (plugin != null) {
            final String name = plugin.getPluginName();
            final PluginPropertiesStreamBuild pluginPropertiesStream = pluginPropertiesManager.getPluginProperties(name);
            if (pluginPropertiesStream != null) {
                return pluginPropertiesStream;
            }
        }
        return new PluginPropertiesStreamBuild();
    }
    
    @Deprecated
    public static final PluginPropertiesStreamBuild getPluginPropertiesStream(final String link) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        FileConfiguration config;
        try {
            final InputStream stream = FileUtil.openStream(FileUtil.createLink(link));
            final Reader reader = new InputStreamReader(stream);
            config = (FileConfiguration)YamlConfiguration.loadConfiguration(reader);
            stream.close();
        }
        catch (Exception e) {
            final String message = lang.getText("Updater_Failed");
            SystemUtil.sendMessage(message);
            return new PluginPropertiesStreamBuild();
        }
        final List<String> developer = new ArrayList<String>();
        final HashMap<String, PluginTypePropertiesBuild> mapTypeProperties = new HashMap<String, PluginTypePropertiesBuild>();
        final HashMap<String, PluginBannedPropertiesBuild> mapBannedProperties = new HashMap<String, PluginBannedPropertiesBuild>();
        boolean activated = true;
        String name = null;
        String company = null;
        String author = null;
        String website = null;
        for (final String key : config.getKeys(false)) {
            if (key.equalsIgnoreCase("Activated")) {
                activated = config.getBoolean(key);
            }
            else if (key.equalsIgnoreCase("Name")) {
                name = config.getString(key);
            }
            else if (key.equalsIgnoreCase("Company")) {
                company = config.getString(key);
            }
            else if (key.equalsIgnoreCase("Author")) {
                author = config.getString(key);
            }
            else if (key.equalsIgnoreCase("Website")) {
                website = config.getString(key);
            }
            else if (key.equalsIgnoreCase("Developer")) {
                for (final String dev : config.getStringList(key)) {
                    developer.add(dev);
                }
            }
            else if (key.equalsIgnoreCase("Type")) {
                final ConfigurationSection typeSection = config.getConfigurationSection(key);
                for (final String type : typeSection.getKeys(false)) {
                    final ConfigurationSection typePropertiesSection = typeSection.getConfigurationSection(type);
                    final List<String> announcement = new ArrayList<String>();
                    final List<String> changelog = new ArrayList<String>();
                    String version = agarthaLib.getPluginVersion();
                    for (final String typeProperties : typePropertiesSection.getKeys(false)) {
                        if (typeProperties.equalsIgnoreCase("Version")) {
                            version = typePropertiesSection.getString(typeProperties);
                        }
                        else if (typeProperties.equalsIgnoreCase("Announcement")) {
                            for (final String keyAnnouncement : typePropertiesSection.getStringList(typeProperties)) {
                                announcement.add(keyAnnouncement);
                            }
                        }
                        else {
                            if (!typeProperties.equalsIgnoreCase("Changelog")) {
                                continue;
                            }
                            for (final String keyChangelog : typePropertiesSection.getStringList(typeProperties)) {
                                changelog.add(keyChangelog);
                            }
                        }
                    }
                    final PluginTypePropertiesBuild typePropertiesBuild = new PluginTypePropertiesBuild(version, announcement, changelog);
                    mapTypeProperties.put(type, typePropertiesBuild);
                }
            }
            else {
                if (!key.equalsIgnoreCase("Banned")) {
                    continue;
                }
                final ConfigurationSection bannedSection = config.getConfigurationSection(key);
                for (final String reason : bannedSection.getKeys(false)) {
                    final ConfigurationSection bannedPropertiesSection = bannedSection.getConfigurationSection(reason);
                    final List<String> messages = new ArrayList<String>();
                    final List<String> servers = new ArrayList<String>();
                    for (final String bannedProperties : bannedPropertiesSection.getKeys(false)) {
                        if (bannedProperties.equalsIgnoreCase("Messages") || bannedProperties.equalsIgnoreCase("Message")) {
                            for (final String message2 : bannedPropertiesSection.getStringList(bannedProperties)) {
                                messages.add(message2);
                            }
                        }
                        else {
                            if (!bannedProperties.equalsIgnoreCase("Servers") && !bannedProperties.equalsIgnoreCase("Server")) {
                                continue;
                            }
                            for (final String server : bannedPropertiesSection.getStringList(bannedProperties)) {
                                servers.add(server);
                            }
                        }
                    }
                    final PluginBannedPropertiesBuild bannedProperties2 = new PluginBannedPropertiesBuild(messages, servers);
                    mapBannedProperties.put(reason, bannedProperties2);
                }
            }
        }
        return new PluginPropertiesStreamBuild(activated, name, company, author, website, developer, mapTypeProperties, mapBannedProperties);
    }
}
