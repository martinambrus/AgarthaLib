// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import java.util.HashMap;
import com.praya.agarthalib.AgarthaLibConfig;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.List;

public class ListUtil
{
    public static final String convertListToString(final List<String> list) {
        String text = "";
        if (list != null) {
            for (final String part : list) {
                text = (text.isEmpty() ? part : (String.valueOf(text) + Pattern.quote("||") + part));
            }
        }
        return text;
    }
    
    public static final List<String> convertStringToList(final String text) {
        return convertStringToList(text, "||");
    }
    
    public static final List<String> convertStringToList(final String text, final String divider) {
        final List<String> list = new ArrayList<String>();
        if (text != null && divider != null) {
            String[] split;
            for (int length = (split = text.split(divider)).length, i = 0; i < length; ++i) {
                final String part = split[i];
                list.add(part);
            }
        }
        return list;
    }
    
    public static final List<String> returnList(final List<String> list) {
        return (list != null) ? (list.isEmpty() ? null : list) : null;
    }
    
    public static final List<String> sendList(final CommandSender sender, final List<String> keyList, final int page) {
        return sendList(sender, keyList, page, true);
    }
    
    public static final List<String> sendList(final CommandSender sender, final List<String> keyList, final int page, final boolean message) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        final int maxRow = mainConfig.getListContent();
        return sendList(sender, keyList, page, maxRow, message);
    }
    
    public static final List<String> sendList(final CommandSender sender, final List<String> keyList, int page, final int maxRow, final boolean message) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final List<String> list = new ArrayList<String>();
        if (sender != null && keyList != null) {
            final int size = keyList.size();
            final int maxPage = MathUtil.isDividedBy(size, maxRow) ? (size / maxRow) : (size / maxRow + 1);
            page = MathUtil.limitInteger(page, 1, maxPage);
            if (message) {
                final HashMap<String, String> map = new HashMap<String, String>();
                String listHeaderMessage = lang.getText(sender, "List_Header");
                map.put("page", String.valueOf(page));
                map.put("maxpage", String.valueOf(maxPage));
                listHeaderMessage = TextUtil.placeholder(map, listHeaderMessage);
                SenderUtil.sendMessage(sender, listHeaderMessage);
            }
            if (size > 0) {
                for (int addNum = (page - 1) * maxRow, t = 0; t < maxRow && t + addNum < size; ++t) {
                    final int index = t + addNum;
                    final String key = keyList.get(index);
                    list.add(key);
                    if (message) {
                        final HashMap<String, String> subMap = new HashMap<String, String>();
                        String listItemMessage = lang.getText(sender, "List_Container");
                        subMap.put("index", String.valueOf(index + 1));
                        subMap.put("container", key);
                        subMap.put("maxpage", String.valueOf(page));
                        listItemMessage = TextUtil.placeholder(subMap, listItemMessage);
                        SenderUtil.sendMessage(sender, listItemMessage);
                    }
                }
            }
        }
        return list;
    }
}
