// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.entity.Entity;
import core.praya.agarthalib.enums.main.JsonOption;
import java.util.regex.Pattern;
import core.praya.agarthalib.builder.message.JsonBuild;

public class JsonUtil
{
    public static final String getJsonText(final String text) {
        return getJsonText(text, false);
    }
    
    public static final String getJsonText(final String text, final boolean flat) {
        if (text == null) {
            return "";
        }
        final JsonBuild jsonBuilder = new JsonBuild();
        final String[] parts = text.split(Pattern.quote("||"));
        String[] array;
        for (int length = (array = parts).length, i = 0; i < length; ++i) {
            final String part = array[i];
            final String[] element = part.split(":");
            final String key = element[0];
            final JsonOption jsonOption = JsonOption.getJsonOption(key);
            if (jsonOption.equals(JsonOption.TEXT)) {
                jsonBuilder.addText(part);
            }
            else if (!flat) {
                final String value = TextUtil.firstSolidCharacter(part.replaceFirst(String.valueOf(key) + ":", ""));
                if (jsonOption.equals(JsonOption.COLOR)) {
                    jsonBuilder.setColor(value);
                }
                else if (jsonOption.equals(JsonOption.INSERTION)) {
                    jsonBuilder.setInsertion(value);
                }
                else if (isJsonClick(jsonOption)) {
                    jsonBuilder.addClickEvent(jsonOption, value);
                }
                else if (isJsonHover(jsonOption)) {
                    jsonBuilder.addHoverEvent(jsonOption, value);
                }
            }
        }
        return jsonBuilder.read();
    }
    
    public static final String clearJson(final String text) {
        if (text == null) {
            return "";
        }
        final String[] parts = text.split(Pattern.quote("||"));
        String newText = "";
        for (int t = 0; t < parts.length; ++t) {
            final String part = parts[t];
            final String[] element = part.split(":");
            final String key = element[0];
            final JsonOption jsonOption = JsonOption.getJsonOption(key);
            if (jsonOption.equals(JsonOption.TEXT)) {
                if (t == 0) {
                    newText = part;
                }
                else {
                    newText = String.valueOf(newText) + part;
                }
            }
        }
        return newText;
    }
    
    public static final String getJsonEntity(final Entity entity) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", entity.getUniqueId());
        map.put("type", "minecraft:" + entity.getType());
        if (entity.getCustomName() != null) {
            map.put("name", entity.getCustomName());
        }
        return map.toString().replaceAll("=", ":").replaceAll(" ", "");
    }
    
    public static final String generateJsonTooltip(final String text, final String... tooltip) {
        return generateJsonTooltip(text, true, tooltip);
    }
    
    public static final String generateJsonTooltip(final String text, final boolean isInside, final String... tooltip) {
        String json = (text != null) ? (String.valueOf(text) + "||ttp: ") : "ttp: ";
        for (int i = 0; i < tooltip.length; ++i) {
            if (i == 0) {
                json = String.valueOf(json) + tooltip[i];
            }
            else {
                json = String.valueOf(json) + "\n" + tooltip[i];
            }
        }
        return isInside ? ("||" + json + "||") : json;
    }
    
    public static final String generateJsonItem(final ItemStack item) {
        return generateJsonItem(null, true, item);
    }
    
    public static final String generateJsonItem(final boolean isInside, final ItemStack item) {
        return generateJsonItem(null, isInside, item);
    }
    
    public static final String generateJsonItem(final String text, final ItemStack item) {
        return generateJsonItem(text, true, item);
    }
    
    public static final String generateJsonItem(final String text, final boolean isInside, final ItemStack item) {
        final String jsonItem = (text != null) ? (String.valueOf(text) + "||item: " + Bridge.getBridgeMessage().getJsonItem(item)) : ("item: " + Bridge.getBridgeMessage().getJsonItem(item));
        return isInside ? ("||" + jsonItem + "||") : jsonItem;
    }
    
    public static final String generateJsonEntity(final Entity entity) {
        return generateJsonEntity(null, entity, true);
    }
    
    public static final String generateJsonEntity(final boolean isInside, final Entity entity) {
        return generateJsonEntity(null, entity, isInside);
    }
    
    public static final String generateJsonEntity(final String text, final Entity entity) {
        return generateJsonEntity(text, entity, true);
    }
    
    public static final String generateJsonEntity(final String text, final Entity entity, final boolean isInside) {
        final String jsonEntity = (text != null) ? (String.valueOf(text) + "||entity: " + getJsonEntity(entity)) : ("entity: " + getJsonEntity(entity));
        return isInside ? jsonEntity : ("||" + jsonEntity + "||");
    }
    
    public static final String setInside(final String text) {
        return "||" + text + "||";
    }
    
    public static final boolean isJsonClick(final JsonOption jsonOption) {
        switch (jsonOption) {
            case CLICK_OPEN_URL: {
                return true;
            }
            case CLICK_RUN_COMMAND: {
                return true;
            }
            case CLICK_SUGGEST_COMMAND: {
                return true;
            }
            case CLICK_CHANGE_PAGE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isJsonHover(final JsonOption jsonOption) {
        switch (jsonOption) {
            case HOVER_SHOW_ACHIEVEMENT: {
                return true;
            }
            case HOVER_SHOW_ITEM: {
                return true;
            }
            case HOVER_SHOW_ENTITY: {
                return true;
            }
            case HOVER_SHOW_TEXT: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
