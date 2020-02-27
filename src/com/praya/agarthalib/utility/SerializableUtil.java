// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class SerializableUtil
{
    public static final HashMap<String, Map<String, Object>> serializeItemStack(final ItemStack item) {
        final HashMap<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
        if (item != null) {
            final Map<String, Object> serializedItemStack = (Map<String, Object>)item.serialize();
            map.put("Serialized_ItemStack", serializedItemStack);
            if (item.hasItemMeta()) {
                final ItemMeta meta = item.getItemMeta();
                final Map<String, Object> serializedItemMeta = (Map<String, Object>)meta.serialize();
                map.put("Serialized_ItemMeta", serializedItemMeta);
            }
        }
        return map;
    }
    
    public static final ItemStack deserializeItemStack(final HashMap<String, Map<String, Object>> map) {
        if (map != null && map.containsKey("Serialized_ItemStack")) {
            final ItemStack item = ItemStack.deserialize((Map)map.get("Serialized_ItemStack"));
            if (item != null && map.containsKey("Serialized_ItemMeta")) {
                final ItemMeta meta = (ItemMeta)ConfigurationSerialization.deserializeObject((Map)map.get("Serialized_ItemMeta"));
                item.setItemMeta(meta);
            }
            return item;
        }
        return null;
    }
    
    public static final String serializeBase64(final Serializable object) throws IOException {
        if (object != null) {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        }
        return null;
    }
    
    public static final String serializeBase64Silent(final Serializable object) {
        try {
            return serializeBase64(object);
        }
        catch (IOException e) {
            return null;
        }
    }
    
    public static final Object deserializeBase64(final String serialized) throws IOException, ClassNotFoundException {
        if (serialized != null) {
            final byte[] data = Base64.getDecoder().decode(serialized);
            final ByteArrayInputStream bais = new ByteArrayInputStream(data);
            final ObjectInputStream ois = new ObjectInputStream(bais);
            final Object object = ois.readObject();
            ois.close();
            return object;
        }
        return null;
    }
    
    public static final Object deserializeBase64Silent(final String serialized) {
        try {
            return deserializeBase64(serialized);
        }
        catch (ClassNotFoundException | IOException ex2) {
            return null;
        }
    }
}
