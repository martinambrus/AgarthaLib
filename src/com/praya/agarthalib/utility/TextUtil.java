// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import api.praya.agarthalib.builder.support.SupportMVdWPlaceholderAPI;
import api.praya.agarthalib.builder.support.SupportPlaceholderAPI;
import api.praya.agarthalib.manager.plugin.SupportManagerAPI;
import api.praya.agarthalib.manager.plugin.PluginManagerAPI;
import org.bukkit.OfflinePlayer;
import api.praya.agarthalib.main.AgarthaLibAPI;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import java.util.List;
import com.praya.agarthalib.AgarthaLibConfig;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;

public class TextUtil
{
    public static final String getJsonTooltip(final String text) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        final String tooltip = mainConfig.getUtilityTooltip();
        return (text != null) ? JsonUtil.generateJsonTooltip(tooltip, text) : "";
    }
    
    public static final String[] pressList(final String[] list, final int first) {
        if (list != null) {
            final String rawText = concatenate(list, first);
            final String[] newList = rawText.split(" ");
            return newList;
        }
        return new String[0];
    }
    
    public static final String concatenate(final String[] list) {
        return concatenate(list, 1);
    }
    
    public static final String concatenate(final String[] list, final int first) {
        if (list != null) {
            final StringBuilder temp = new StringBuilder();
            int i;
            for (int firstIndex = i = first - 1; i >= 0 && i < list.length; ++i) {
                temp.append((i == firstIndex) ? list[i] : (" " + list[i]));
            }
            return temp.toString();
        }
        return "";
    }
    
    public static final String encrypt(final String text, int x, int y) {
        if (text != null) {
            final StringBuffer buffer = new StringBuffer(text);
            String encryptText = "";
            x = MathUtil.limitInteger(x, 1, x);
            y = MathUtil.limitInteger(y, 0, y);
            for (int i = 0; i < buffer.length(); ++i) {
                int tempering = buffer.charAt(i);
                tempering = tempering * (i + x) + (i ^ y);
                buffer.setCharAt(i, (char)tempering);
                encryptText = ((i == 0) ? String.valueOf(tempering) : (String.valueOf(encryptText) + " " + String.valueOf(tempering)));
            }
            return encryptText;
        }
        return "";
    }
    
    public static final String deEncrypt(final String text, int x, int y) {
        if (text != null) {
            final String[] list = text.split(" ");
            String deEncryptText = "";
            x = MathUtil.limitInteger(x, 1, x);
            y = MathUtil.limitInteger(y, 0, y);
            for (int i = 0; i < list.length; ++i) {
                deEncryptText = String.valueOf(deEncryptText) + "@";
            }
            final StringBuffer buffer = new StringBuffer(deEncryptText);
            for (int j = 0; j < list.length; ++j) {
                int tempering = Integer.valueOf(list[j]);
                tempering = (tempering - (j ^ y)) / (j + x);
                buffer.setCharAt(j, (char)tempering);
            }
            return buffer.toString();
        }
        return "";
    }
    
    public static final List<String> colorful(final List<String> list) {
        if (list != null) {
            for (int index = 0; index < list.size(); ++index) {
                final String text = list.get(index);
                final String coloredText = colorful(text);
                list.set(index, coloredText);
            }
        }
        return list;
    }
    
    public static final String colorful(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    
    public static final String hookPlaceholderAPI(final Player player, String text) {
        if (text != null) {
            final PluginManagerAPI pluginManagerAPI = AgarthaLibAPI.getInstance().getPluginManagerAPI();
            final SupportManagerAPI supportManagerAPI = pluginManagerAPI.getSupportManager();
            final SupportPlaceholderAPI supportPlaceholderAPI = supportManagerAPI.getSupportPlaceholderAPI();
            final SupportMVdWPlaceholderAPI supportMVDWPlaceholder = supportManagerAPI.getSupportMVdWPlaceholderAPI();
            if (supportPlaceholderAPI != null) {
                text = supportPlaceholderAPI.setPlaceholders((OfflinePlayer)player, text);
            }
            if (supportMVDWPlaceholder != null) {
                text = supportMVDWPlaceholder.setPlaceholders((OfflinePlayer)player, text);
            }
            return text;
        }
        return "";
    }
    
    public static final List<String> hookPlaceholderAPI(final Player player, final List<String> list) {
        final List<String> listPlaceholder = new ArrayList<String>();
        if (list != null) {
            for (final String text : list) {
                final String linePlaceholder = hookPlaceholderAPI(player, text);
                listPlaceholder.add(linePlaceholder);
            }
        }
        return listPlaceholder;
    }
    
    public static final String placeholder(final String text, final String placeholder, final String replacement) {
        final HashMap<String, String> map = new HashMap<String, String>();
        map.put(placeholder, replacement);
        return placeholder(map, text);
    }
    
    public static final String placeholder(final HashMap<String, String> map, final String text) {
        return placeholder(map, text, "{", "}");
    }
    
    public static final String placeholder(final HashMap<String, String> map, final String text, final String key) {
        return placeholder(map, text, key, key);
    }
    
    public static final String placeholder(final HashMap<String, String> map, String text, final String leftKey, final String rightKey) {
        if (text == null) {
            return "";
        }
        if (map != null && leftKey != null && rightKey != null) {
            final int lengthLeft = leftKey.length();
            final int lengthRight = rightKey.length();
            final String idLeft = Pattern.quote(leftKey);
            final String idRight = Pattern.quote(rightKey);
            final String regex = String.valueOf(idLeft) + "[^(" + idRight + "|" + idLeft + ")]+" + idRight;
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final String component = matcher.group();
                final int length = component.length();
                final String variable = component.substring(lengthLeft, length - lengthRight);
                for (final String key : map.keySet()) {
                    if (key.equalsIgnoreCase(variable)) {
                        final String value = map.get(key);
                        final String replacement = (value != null) ? value : "";
                        text = text.replace(component, replacement);
                    }
                }
            }
        }
        return text;
    }
    
    public static final List<String> placeholder(final HashMap<String, String> map, final List<String> list) {
        return placeholder(map, list, "{", "}");
    }
    
    public static final List<String> placeholder(final HashMap<String, String> map, final List<String> list, final String leftKey, final String rightKey) {
        final List<String> newList = new ArrayList<String>();
        if (list == null) {
            return newList;
        }
        if (map == null) {
            return list;
        }
        for (final String part : list) {
            newList.add(placeholder(map, part, leftKey, rightKey));
        }
        return newList;
    }
    
    public static final String placeholderRaw(final String text, final String placeholder, final String replacement) {
        return (text != null && placeholder != null && replacement != null) ? (text.contains(placeholder) ? text.replace(placeholder, replacement) : text) : text;
    }
    
    public static final String placeholderRaw(final HashMap<String, String> map, String text) {
        for (final String placeholder : map.keySet()) {
            if (text.contains(placeholder)) {
                text = text.replace(placeholder, map.get(placeholder));
            }
        }
        return text;
    }
    
    public static final String toTitleCase(final String text) {
        if (text != null) {
            final String lowerText = text.toLowerCase();
            final String[] textBuild = lowerText.split(" ");
            String newText = "";
            String[] array;
            for (int length = (array = textBuild).length, i = 0; i < length; ++i) {
                String textPart = array[i];
                final String first = String.valueOf(textPart.charAt(0));
                textPart = textPart.replaceFirst(first, first.toUpperCase());
                newText = (newText.isEmpty() ? textPart : (String.valueOf(newText) + " " + textPart));
            }
            return newText;
        }
        return "";
    }
    
    public static final String fixSpace(final String text) {
        return (text != null) ? text.replace("_", " ") : "";
    }
    
    public static final String firstSolidCharacter(String text) {
        if (text != null) {
            while (!text.isEmpty() && text.substring(0, 1).equalsIgnoreCase(" ")) {
                text = text.replaceFirst(" ", "");
            }
            return text;
        }
        return "";
    }
    
    public static boolean hasSpecialCharacter(final String text) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        if (text != null) {
            final String key = mainConfig.getPatternSpecial();
            final Pattern pattern = Pattern.compile(key);
            return pattern.matcher(text).find();
        }
        return false;
    }
    
    public static final String convertSpaceToDot(final String text) {
        return (text != null) ? text.replaceAll("_", Pattern.quote(".")) : "";
    }
    
    public static final String convertDotToSpace(final String text) {
        return (text != null) ? text.replaceAll(Pattern.quote("."), "_") : "";
    }
    
    public static final String getBar(final String bar, int limit, final double decimal, String plusPrefix, String minPrefix) {
        if (bar != null) {
            final StringBuilder builder = new StringBuilder();
            plusPrefix = ((plusPrefix != null) ? plusPrefix : "&a");
            minPrefix = ((minPrefix != null) ? minPrefix : "&c");
            limit = MathUtil.limitInteger(limit, 1, limit);
            for (double t = 0.0; t < limit; ++t) {
                final double barDecimal = (t + 1.0) / limit;
                if (barDecimal <= decimal) {
                    builder.append(plusPrefix);
                }
                else {
                    builder.append(minPrefix);
                }
                builder.append(bar);
            }
            return colorful(builder.toString());
        }
        return "";
    }
    
    public static final String convertListToString(final List<String> list) {
        return convertListToString(list, "\n");
    }
    
    public static final String convertListToString(final List<String> list, final String divider) {
        String text = "";
        if (list != null) {
            for (int t = 0; t < list.size(); ++t) {
                final String part = list.get(t);
                text = ((t == 0) ? part : (String.valueOf(text) + divider + part));
            }
        }
        return text;
    }
    
    public static final List<String> expandList(final List<String> list, final String divider) {
        final List<String> expandList = new ArrayList<String>();
        for (final String text : list) {
            final String[] parts = text.split(divider);
            String[] array;
            for (int length = (array = parts).length, i = 0; i < length; ++i) {
                final String part = array[i];
                expandList.add(part);
            }
        }
        return expandList;
    }
    
    public static final HashMap<Integer, List<String>> orderList(final List<String> list) {
        final HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        int totalDelay = 0;
        if (list != null) {
            for (final String key : list) {
                final String[] parts = key.split(" ");
                if (parts.length > 1) {
                    final String detect = parts[0];
                    if (detect.equalsIgnoreCase("@wait:") || detect.equalsIgnoreCase("@wait") || detect.equalsIgnoreCase("@delay:") || detect.equalsIgnoreCase("@delay")) {
                        final String textCooldown = parts[1];
                        if (MathUtil.isNumber(parts[1])) {
                            final int delay = MathUtil.parseInteger(textCooldown);
                            if (delay > 0) {
                                totalDelay += delay;
                                continue;
                            }
                        }
                    }
                }
                if (!map.containsKey(totalDelay)) {
                    final List<String> components = new ArrayList<String>();
                    map.put(totalDelay, components);
                }
                map.get(totalDelay).add(key);
            }
        }
        return map;
    }
    
    public static final String limitString(final String text, final int limit) {
        return (text != null) ? ((text.length() > limit) ? text.substring(0, limit) : text) : "";
    }
}
