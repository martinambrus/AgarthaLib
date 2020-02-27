// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.tabcompleter;

import com.praya.agarthalib.manager.plugin.CommandManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import com.praya.agarthalib.utility.TabCompleterUtil;
import com.praya.agarthalib.utility.SenderUtil;
import core.praya.agarthalib.enums.branch.SoundEnum;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.command.TabCompleter;
import com.praya.agarthalib.handler.HandlerTabCompleter;

public class TabCompleterAgarthaLib extends HandlerTabCompleter implements TabCompleter
{
    public TabCompleterAgarthaLib(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final CommandManager commandManager = pluginManager.getCommandManager();
        final List<String> tabList = new ArrayList<String>();
        SenderUtil.playSound(sender, SoundEnum.BLOCK_WOOD_BUTTON_CLICK_ON);
        if (args.length == 1) {
            if (commandManager.checkPermission(sender, "AgarthaLib_Help")) {
                tabList.add("Help");
            }
            if (commandManager.checkPermission(sender, "AgarthaLib_About")) {
                tabList.add("About");
            }
            if (commandManager.checkPermission(sender, "AgarthaLib_Reload")) {
                tabList.add("Reload");
            }
        }
        return TabCompleterUtil.returnList(tabList, args);
    }
}
