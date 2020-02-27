// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.command.executor;

import com.praya.agarthalib.utility.MathUtil;
import java.util.Iterator;
import java.util.List;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;
import com.praya.agarthalib.menu.MenuAgarthaLib;
import org.bukkit.entity.Player;
import core.praya.agarthalib.builder.message.MessageBuild;
import com.praya.agarthalib.AgarthaLibConfig;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PlaceholderManager;
import com.praya.agarthalib.manager.plugin.CommandManager;
import com.praya.agarthalib.manager.game.MenuManager;
import com.praya.agarthalib.manager.game.GameManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import java.util.HashMap;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.language.LanguageConfig;
import com.praya.agarthalib.handler.Handler;
import com.praya.agarthalib.command.CommandConfig;
import com.praya.agarthalib.utility.SenderUtil;
import core.praya.agarthalib.enums.branch.SoundEnum;
import com.praya.agarthalib.utility.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.command.CommandExecutor;
import com.praya.agarthalib.handler.HandlerCommand;

public class CommandAgarthaLib extends HandlerCommand implements CommandExecutor
{
    public CommandAgarthaLib(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final GameManager gameManager = this.plugin.getGameManager();
        final MenuManager menuManager = gameManager.getMenuManager();
        final CommandManager commandManager = pluginManager.getCommandManager();
        final PlaceholderManager placeholderManager = pluginManager.getPlaceholderManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        if (args.length <= 0) {
            final String[] fullArgs = TextUtil.pressList(args, 2);
            return this.help(sender, command, label, fullArgs);
        }
        final String subCommand = args[0];
        if (commandManager.checkCommand(subCommand, "AgarthaLib_Reload")) {
            if (!commandManager.checkPermission(sender, "AgarthaLib_Reload")) {
                final String permission = commandManager.getPermission("AgarthaLib_Reload");
                final MessageBuild message = lang.getMessage(sender, "Permission_Lack");
                message.sendMessage(sender, "placeholder", permission);
                SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
                return true;
            }
            final MessageBuild message2 = lang.getMessage(sender, "Command_AgarthaLib_Reload_Success");
            final CommandConfig commandConfig = Handler.getHandler(CommandConfig.class);
            final LanguageConfig languageConfig = Handler.getHandler(LanguageConfig.class);
            mainConfig.setup();
            commandConfig.setup();
            languageConfig.setup();
            message2.sendMessage(sender);
            SenderUtil.playSound(sender, SoundEnum.ENTITY_EXPERIENCE_ORB_PICKUP);
            return true;
        }
        else if (commandManager.checkCommand(subCommand, "AgarthaLib_Menu")) {
            if (!commandManager.checkPermission(sender, "AgarthaLib_Menu")) {
                final String permission = commandManager.getPermission("AgarthaLib_Menu");
                final MessageBuild message = lang.getMessage(sender, "Permission_Lack");
                message.sendMessage(sender, "placeholder", permission);
                SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
                return true;
            }
            if (!SenderUtil.isPlayer(sender)) {
                final MessageBuild message2 = lang.getMessage(sender, "Console_Not_Player");
                message2.sendMessage(sender);
                SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
                return true;
            }
            final Player player = PlayerUtil.parse(sender);
            final MenuAgarthaLib menuAgarthaLib = menuManager.getMenuAgarthaLib();
            menuAgarthaLib.openMenuUpdater(player);
            return true;
        }
        else if (commandManager.checkCommand(subCommand, "AgarthaLib_About")) {
            if (!commandManager.checkPermission(sender, "AgarthaLib_About")) {
                final String permission = commandManager.getPermission("AgarthaLib_About");
                final MessageBuild message = lang.getMessage(sender, "Permission_Lack");
                message.sendMessage(sender, "placeholder", permission);
                SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
                return true;
            }
            final PluginPropertiesManager pluginPropertiesManager = pluginManager.getPluginPropertiesManager();
            final String prefix = String.valueOf(placeholderManager.getPlaceholder("prefix")) + " ";
            final String pluginType = this.plugin.getPluginType();
            final String pluginName = this.plugin.getPluginName();
            final String pluginVersion = this.plugin.getPluginVersion();
            final String pluginAuthor = pluginPropertiesManager.getPluginAuthor();
            final String pluginCompany = pluginPropertiesManager.getPluginCompany();
            final List<String> pluginDevelopers = pluginPropertiesManager.getPluginDevelopers();
            final HashMap<String, String> mapPlaceholder = new HashMap<String, String>();
            String aboutHeader = String.valueOf(prefix) + "&7=-=-=-=-=-=-= &6About&7 =-=-=-=-=-=-=";
            String aboutFooter = String.valueOf(prefix) + "&7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
            final String aboutBlank = new StringBuilder(String.valueOf(prefix)).toString();
            String aboutPlugin = String.valueOf(prefix) + "Plugin&f: &c{plugin}";
            String aboutType = String.valueOf(prefix) + "Type&f: &c{type}";
            String aboutVersion = String.valueOf(prefix) + "Version&f: &c{version}";
            String aboutAuthor = String.valueOf(prefix) + "Author&f: &c{author}";
            mapPlaceholder.put("plugin", pluginName);
            mapPlaceholder.put("type", pluginType);
            mapPlaceholder.put("version", pluginVersion);
            mapPlaceholder.put("author", pluginAuthor);
            aboutHeader = TextUtil.placeholder(mapPlaceholder, aboutHeader);
            aboutFooter = TextUtil.placeholder(mapPlaceholder, aboutFooter);
            aboutPlugin = TextUtil.placeholder(mapPlaceholder, aboutPlugin);
            aboutType = TextUtil.placeholder(mapPlaceholder, aboutType);
            aboutVersion = TextUtil.placeholder(mapPlaceholder, aboutVersion);
            aboutAuthor = TextUtil.placeholder(mapPlaceholder, aboutAuthor);
            SenderUtil.sendMessage(sender, aboutHeader);
            SenderUtil.sendMessage(sender, aboutBlank);
            SenderUtil.sendMessage(sender, aboutPlugin);
            SenderUtil.sendMessage(sender, aboutType);
            SenderUtil.sendMessage(sender, aboutVersion);
            SenderUtil.sendMessage(sender, aboutAuthor);
            if (pluginCompany != null) {
                String aboutCompany = String.valueOf(prefix) + "Company&7: &c{company}";
                mapPlaceholder.clear();
                mapPlaceholder.put("company", pluginCompany);
                aboutCompany = TextUtil.placeholder(mapPlaceholder, aboutCompany);
                SenderUtil.sendMessage(sender, aboutCompany);
            }
            if (!pluginDevelopers.isEmpty()) {
                final String aboutDeveloper = String.valueOf(prefix) + "Developer&7:";
                SenderUtil.sendMessage(sender, aboutDeveloper);
                for (final String developer : pluginDevelopers) {
                    String aboutListDeveloper = String.valueOf(prefix) + "&7&l\u27a8 &d{developer}";
                    mapPlaceholder.clear();
                    mapPlaceholder.put("developer", developer);
                    aboutListDeveloper = TextUtil.placeholder(mapPlaceholder, aboutListDeveloper);
                    SenderUtil.sendMessage(sender, aboutListDeveloper);
                }
            }
            SenderUtil.sendMessage(sender, aboutBlank);
            SenderUtil.sendMessage(sender, aboutFooter);
            SenderUtil.playSound(sender, SoundEnum.ENTITY_EXPERIENCE_ORB_PICKUP);
            return true;
        }
        else {
            if (commandManager.checkCommand(subCommand, "AgarthaLib_Help")) {
                final String[] fullArgs2 = TextUtil.pressList(args, 2);
                return this.help(sender, command, label, fullArgs2);
            }
            final MessageBuild message2 = lang.getMessage(sender, "Argument_Invalid");
            message2.sendMessage(sender);
            SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
            return true;
        }
    }
    
    private final boolean help(final CommandSender sender, final Command command, final String label, final String[] args) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final CommandManager commandManager = pluginManager.getCommandManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        if (!commandManager.checkPermission(sender, "AgarthaLib_Help")) {
            final String permission = commandManager.getPermission("AgarthaLib_Help");
            final MessageBuild message = lang.getMessage(sender, "Permission_Lack");
            message.sendMessage(sender, "placeholder", permission);
            SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
            return true;
        }
        if (args.length < 1) {
            final MessageBuild message2 = lang.getMessage(sender, "Argument_AgarthaLib_Help");
            final String tooltip = TextUtil.getJsonTooltip(lang.getText(sender, "Tooltip_AgarthaLib_Help"));
            message2.sendMessage(sender, "tooltip_help", tooltip);
            SenderUtil.playSound(sender, SoundEnum.ENTITY_BLAZE_DEATH);
            return true;
        }
        final String textPage = args[0];
        final int maxPage = 1;
        final HashMap<String, String> map = new HashMap<String, String>();
        int page = 1;
        if (MathUtil.isNumber(textPage)) {
            page = MathUtil.parseInteger(textPage);
            page = MathUtil.limitInteger(page, 1, 1);
        }
        String helpLeader = lang.getText(sender, "Help_Header");
        String helpPage = lang.getText(sender, "Help_Page");
        String previousTooltip = "||&6&l\u25c0||ttp: {text_previous_page}||cmd: /{plugin} help {previous_page}||";
        String nextTooltip = "||&6&l\u25b6||ttp: {text_next_page}||cmd: /{plugin} help {next_page}||";
        String command_Help = lang.getText(sender, "Argument_AgarthaLib_Help");
        String command_About = lang.getText(sender, "Argument_AgarthaLib_About");
        String command_Menu = lang.getText(sender, "Argument_AgarthaLib_Menu");
        String command_Reload = lang.getText(sender, "Argument_AgarthaLib_Reload");
        map.put("plugin", this.plugin.getPluginName());
        map.put("page", String.valueOf(page));
        map.put("maxpage", String.valueOf(1));
        map.put("previous_page", String.valueOf(page - 1));
        map.put("next_page", String.valueOf(page + 1));
        map.put("text_previous_page", lang.getText(sender, "Help_Previous_Page"));
        map.put("text_next_page", lang.getText(sender, "Help_Next_Page"));
        map.put("tooltip_help", TextUtil.getJsonTooltip(lang.getText(sender, "Tooltip_AgarthaLib_Help")));
        map.put("tooltip_about", TextUtil.getJsonTooltip(lang.getText(sender, "Tooltip_AgarthaLib_About")));
        map.put("tooltip_menu", TextUtil.getJsonTooltip(lang.getText(sender, "Tooltip_AgarthaLib_Menu")));
        map.put("tooltip_reload", TextUtil.getJsonTooltip(lang.getText(sender, "Tooltip_AgarthaLib_Reload")));
        previousTooltip = TextUtil.placeholder(map, previousTooltip);
        nextTooltip = TextUtil.placeholder(map, nextTooltip);
        command_Help = TextUtil.placeholder(map, command_Help);
        command_About = TextUtil.placeholder(map, command_About);
        command_Menu = TextUtil.placeholder(map, command_Menu);
        command_Reload = TextUtil.placeholder(map, command_Reload);
        map.put("previous", previousTooltip);
        map.put("next", nextTooltip);
        helpLeader = TextUtil.placeholder(map, helpLeader);
        helpPage = TextUtil.placeholder(map, helpPage);
        SenderUtil.sendMessage(sender, helpLeader);
        SenderUtil.sendMessage(sender, "", true);
        SenderUtil.sendMessage(sender, helpPage);
        if (page == 1) {
            SenderUtil.sendMessage(sender, command_Help);
            SenderUtil.sendMessage(sender, command_About);
            SenderUtil.sendMessage(sender, command_Menu);
            SenderUtil.sendMessage(sender, command_Reload);
        }
        SenderUtil.playSound(sender, SoundEnum.ENTITY_EXPERIENCE_ORB_PICKUP);
        SenderUtil.sendMessage(sender, helpPage);
        return true;
    }
}
