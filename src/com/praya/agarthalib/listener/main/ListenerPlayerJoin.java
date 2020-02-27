// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import java.util.Collection;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import core.praya.agarthalib.builder.message.MessageBuild;
import org.bukkit.command.CommandSender;
import java.util.HashMap;
import com.praya.agarthalib.utility.TextUtil;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.utility.MetadataUtil;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.AgarthaLibConfig;
import org.bukkit.Bukkit;
import core.praya.agarthalib.builder.face.Agartha;
import java.util.ArrayList;
import api.praya.agarthalib.manager.plugin.SupportManagerAPI;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.PlayerUtil;
import org.bukkit.scheduler.BukkitRunnable;
import api.praya.agarthalib.main.AgarthaLibAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import com.praya.agarthalib.server.ServerPlayerMemory;
import org.bukkit.event.player.PlayerJoinEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerCommand;

public class ListenerPlayerJoin extends HandlerCommand implements Listener
{
    public ListenerPlayerJoin(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler
    public void registerPlayer(final PlayerJoinEvent event) {
        final ServerPlayerMemory serverPlayerMemory = ServerPlayerMemory.getInstance();
        final Player player = event.getPlayer();
        serverPlayerMemory.register(player);
    }
    
    @EventHandler
    public void eventPlayerJoin(final PlayerJoinEvent event) {
        final AgarthaLibAPI agarthaLibAPI = AgarthaLibAPI.getInstance();
        final SupportManagerAPI supportManagerAPI = agarthaLibAPI.getPluginManagerAPI().getSupportManager();
        final boolean supportBattleLevels = supportManagerAPI.isSupportBattleLevels();
        final boolean supportSkillAPI = supportManagerAPI.isSupportSkillAPI();
        if (supportBattleLevels || supportSkillAPI) {
            final Player player = event.getPlayer();
            new BukkitRunnable() {
                public void run() {
                    PlayerUtil.setMaxHealth(player);
                }
            }.runTaskLater((Plugin)this.plugin, 2L);
        }
    }
    
    @EventHandler
    public void eventUpdater(final PlayerJoinEvent event) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final PluginPropertiesManager pluginPropertiesManager = pluginManager.getPluginPropertiesManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        final Player player = event.getPlayer();
        if (player.isOp()) {
            final Collection<PluginPropertiesStreamBuild> allProperties = pluginPropertiesManager.getAllPluginProperties();
            final Collection<Agartha> listUpToDate = new ArrayList<Agartha>();
            final Collection<Agartha> listOutDated = new ArrayList<Agartha>();
            Plugin[] plugins;
            for (int length = (plugins = Bukkit.getPluginManager().getPlugins()).length, i = 0; i < length; ++i) {
                final Plugin loop = plugins[i];
                if (loop instanceof Agartha) {
                    final Agartha agartha = (Agartha)loop;
                    try {
                        final String version = agartha.getPluginVersion();
                        final String latest = agartha.getPluginLatest();
                        if (version.equalsIgnoreCase(latest)) {
                            listUpToDate.add(agartha);
                        }
                        else {
                            listOutDated.add(agartha);
                        }
                    }
                    catch (AbstractMethodError abstractMethodError) {}
                }
            }
            final int pluginTotal = allProperties.size();
            final int pluginUpToDate = listUpToDate.size();
            final int pluginOutDated = listOutDated.size();
            final int pluginInstalled = pluginUpToDate + pluginOutDated;
            if (pluginOutDated > 0) {
                final String pluginAuthor = pluginPropertiesManager.getPluginAuthor();
                new BukkitRunnable() {
                    public void run() {
                        if (player.isOnline()) {
                            final String metaUpdater = "Agartha Updater";
                            final boolean updateMessage = mainConfig.updaterMessage();
                            final boolean isCooldown = MetadataUtil.isCooldown((Entity)player, "Agartha Updater");
                            final long cooldown = 3600000L;
                            if (updateMessage && !isCooldown) {
                                final String buttonHelp = lang.getText((LivingEntity)player, "Updater_Button_Help");
                                final String buttonSpigot = lang.getText((LivingEntity)player, "Updater_Button_Spigot");
                                final String buttonDiscord = lang.getText((LivingEntity)player, "Updater_Button_Discord");
                                final String buttonPatreon = lang.getText((LivingEntity)player, "Updater_Button_Patreon");
                                final String buttonMenu = lang.getText((LivingEntity)player, "Updater_Button_Menu");
                                final String loresHelp = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Help"));
                                final String loresSpigot = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Spigot"));
                                final String loresDiscord = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Discord"));
                                final String loresPatreon = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Patreon"));
                                final String loresMenu = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Menu"));
                                final String commandUpdater = "AgarthaLib Menu";
                                final String urlSpigot = "https://goo.gl/BrDEqY";
                                final String urlDiscord = "https://goo.gl/FbHffz";
                                final String urlPatreon = "https://goo.gl/UAcVX7";
                                final String tooltipHelp = "||" + buttonHelp + "||ttp: " + loresHelp + "||";
                                final String tooltipSpigot = "||" + buttonSpigot + "||ttp: " + loresSpigot + "||url:" + "https://goo.gl/BrDEqY" + "||";
                                final String tooltipDiscord = "||" + buttonDiscord + "||ttp: " + loresDiscord + "||url:" + "https://goo.gl/FbHffz" + "||";
                                final String tooltipPatreon = "||" + buttonPatreon + "||ttp: " + loresPatreon + "||url:" + "https://goo.gl/UAcVX7" + "||";
                                final String tooltipMenu = "||" + buttonMenu + "||ttp: " + loresMenu + "||cmd:/" + "AgarthaLib Menu" + "||";
                                final HashMap<String, String> mapPlaceholder = new HashMap<String, String>();
                                final MessageBuild message = lang.getMessage((LivingEntity)player, "Updater_Message_Join");
                                mapPlaceholder.put("tooltip_help", tooltipHelp);
                                mapPlaceholder.put("tooltip_spigot", tooltipSpigot);
                                mapPlaceholder.put("tooltip_discord", tooltipDiscord);
                                mapPlaceholder.put("tooltip_patreon", tooltipPatreon);
                                mapPlaceholder.put("tooltip_menu", tooltipMenu);
                                mapPlaceholder.put("plugin_author", pluginAuthor);
                                mapPlaceholder.put("plugin_total", String.valueOf(pluginTotal));
                                mapPlaceholder.put("plugin_installed", String.valueOf(pluginInstalled));
                                mapPlaceholder.put("plugin_outdated", String.valueOf(pluginOutDated));
                                message.sendMessage((CommandSender)player, mapPlaceholder);
                                MetadataUtil.setCooldown((Entity)player, "Agartha Updater", 3600000L);
                            }
                        }
                    }
                }.runTaskLater((Plugin)this.plugin, 20L);
            }
        }
    }
}
