// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.menu;

import java.util.Iterator;
import java.util.List;
import core.praya.agarthalib.builder.plugin.PluginTypePropertiesBuild;
import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;
import com.praya.agarthalib.manager.game.MenuManager;
import com.praya.agarthalib.manager.game.GameManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import org.bukkit.command.CommandSender;
import com.praya.agarthalib.utility.SenderUtil;
import java.util.HashMap;
import com.praya.agarthalib.utility.TextUtil;
import org.bukkit.entity.LivingEntity;
import com.praya.agarthalib.utility.MathUtil;
import core.praya.agarthalib.builder.menu.MenuSlotAction;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.menu.MenuExecutor;
import com.praya.agarthalib.handler.HandlerMenuExecutor;

public class MenuAgarthaLibExecutor extends HandlerMenuExecutor implements MenuExecutor
{
    protected MenuAgarthaLibExecutor(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void onClick(final Player player, final Menu menu, final MenuSlotAction.ActionType actionType, final String... args) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final GameManager gameManager = this.plugin.getGameManager();
        final MenuManager menuManager = gameManager.getMenuManager();
        final PluginPropertiesManager pluginPropertiesManager = pluginManager.getPluginPropertiesManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        if (args.length > 0) {
            final String label = args[0];
            if (label.equalsIgnoreCase("AgarthaLib") && args.length > 1) {
                final String key = args[1];
                if (key.equalsIgnoreCase("Menu")) {
                    if (args.length > 2) {
                        final String type = args[2];
                        final MenuAgarthaLib menuAgarthaLib = menuManager.getMenuAgarthaLib();
                        if (type.equalsIgnoreCase("Updater")) {
                            int page;
                            if (args.length > 3) {
                                final String textPage = args[3];
                                if (!MathUtil.isNumber(textPage)) {
                                    return;
                                }
                                page = MathUtil.parseInteger(textPage);
                            }
                            else {
                                page = 1;
                            }
                            menuAgarthaLib.openMenuUpdater(player, page);
                        }
                    }
                }
                else if (key.equalsIgnoreCase("About") && args.length > 2) {
                    final String pluginName = args[2];
                    final PluginPropertiesStreamBuild properties = pluginPropertiesManager.getPluginProperties(pluginName);
                    if (properties != null && args.length > 3) {
                        final String pluginType = args[3];
                        final PluginTypePropertiesBuild typeProperties = properties.getTypeProperties(pluginType);
                        if (typeProperties != null) {
                            final String pluginAuthor = properties.getAuthor();
                            final String pluginVersion = typeProperties.getVersion();
                            final String pluginWebsite = typeProperties.getWebsite();
                            final String pluginPriceSymbol = typeProperties.getPriceSymbol();
                            final double pluginPriceValue = typeProperties.getPriceValue();
                            final String buttonWebsite = lang.getText((LivingEntity)player, "Updater_Button_Website");
                            final String loresWebsite = TextUtil.convertListToString(lang.getListText((LivingEntity)player, "Updater_Tooltip_Website"));
                            final String tooltipWebsite = "||" + buttonWebsite + "||ttp: " + loresWebsite + "||url:" + pluginWebsite + "||";
                            final HashMap<String, String> map = new HashMap<String, String>();
                            String textPrice;
                            if (pluginPriceValue > 0.0) {
                                final String formatPrice = lang.getText((LivingEntity)player, "Updater_Price_Premium");
                                map.put("plugin_price_symbol", pluginPriceSymbol);
                                map.put("plugin_price_value", String.valueOf(pluginPriceValue));
                                textPrice = TextUtil.placeholder(map, formatPrice);
                            }
                            else {
                                textPrice = lang.getText((LivingEntity)player, "Updater_Price_Free");
                            }
                            List<String> messages = lang.getListText((LivingEntity)player, "Updater_Message_About");
                            map.clear();
                            map.put("plugin_name", pluginName);
                            map.put("plugin_author", pluginAuthor);
                            map.put("plugin_version", pluginVersion);
                            map.put("plugin_price", textPrice);
                            map.put("plugin_website", pluginWebsite);
                            map.put("tooltip_website", tooltipWebsite);
                            messages = TextUtil.placeholder(map, messages);
                            for (final String message : messages) {
                                SenderUtil.sendMessage((CommandSender)player, message);
                            }
                        }
                    }
                }
            }
        }
    }
}
