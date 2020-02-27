// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.utility.TextUtil;
import com.praya.agarthalib.utility.EquipmentUtil;
import com.praya.agarthalib.utility.MathUtil;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import com.praya.agarthalib.utility.MaterialUtil;
import java.util.Iterator;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.util.List;
import java.util.ArrayList;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportHolographicDisplays extends Support
{
    public SupportHolographicDisplays(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final Hologram createHologram(final Location location) {
        return this.createHologram(location, "");
    }
    
    public final Hologram createHologram(final Location location, final String text) {
        if (text != null) {
            final List<String> listLineText = new ArrayList<String>();
            return this.createHologram(location, listLineText);
        }
        return null;
    }
    
    public final Hologram createHologram(final Location location, final List<String> listText) {
        if (location != null && listText != null) {
            final Hologram hologram = HologramsAPI.createHologram((Plugin)this.plugin, location);
            if (hologram != null) {
                this.setLineText(hologram, listText);
                return hologram;
            }
        }
        return null;
    }
    
    public final void setLineText(final Hologram hologram, final List<String> listLineText) {
        if (hologram != null && listLineText != null) {
            hologram.clearLines();
            for (final String lineText : listLineText) {
                this.addLine(hologram, lineText);
            }
        }
    }
    
    public final void addLine(final Hologram hologram, final String lineText) {
        if (hologram != null && lineText != null) {
            if (lineText.toLowerCase().startsWith("item:")) {
                final String[] parts = lineText.toLowerCase().replace(" ", "").split(",");
                final String textMaterial = parts[0].replace("item:", "");
                final Material material = MaterialUtil.getMaterial(textMaterial);
                if (material != null && !material.equals((Object)Material.AIR)) {
                    final ItemStack item = new ItemStack(material);
                    if (parts.length > 1) {
                        for (int index = 1; index < parts.length; ++index) {
                            final String part = parts[index];
                            if (part.startsWith("data:")) {
                                final String textData = part.replace("data:", "");
                                if (MathUtil.isNumber(textData)) {
                                    final int data = MathUtil.parseInteger(textData);
                                    EquipmentUtil.setData(item, (short)data);
                                }
                            }
                            else if (part.startsWith("shiny:")) {
                                final String textData = part.replace("shiny:", "");
                                if (textData.equalsIgnoreCase("true")) {
                                    EquipmentUtil.shiny(item);
                                }
                            }
                        }
                    }
                    this.addLineItem(hologram, item);
                    return;
                }
            }
            this.addLineText(hologram, lineText);
        }
    }
    
    public final void insertLine(final Hologram hologram, final int lineIndex, final String lineText) {
        if (hologram != null && lineText != null) {
            if (lineText.toLowerCase().startsWith("item:")) {
                final String textMaterial = TextUtil.firstSolidCharacter(lineText.toLowerCase().split("item:")[1]);
                final Material material = MaterialUtil.getMaterial(textMaterial);
                if (material != null && !material.equals((Object)Material.AIR)) {
                    final ItemStack item = new ItemStack(material);
                    this.insertLineItem(hologram, lineIndex, item);
                    return;
                }
            }
            this.insertLineText(hologram, lineIndex, lineText);
        }
    }
    
    public final void addLineText(final Hologram hologram, final String text) {
        if (hologram != null) {
            if (text != null) {
                hologram.appendTextLine(text);
            }
            else {
                hologram.appendTextLine("");
            }
        }
    }
    
    public final void insertLineText(final Hologram hologram, final int lineIndex, final String text) {
        if (hologram != null) {
            if (text != null) {
                hologram.insertTextLine(lineIndex, text);
            }
            else {
                hologram.insertTextLine(lineIndex, "");
            }
        }
    }
    
    public final void addLineItem(final Hologram hologram, final ItemStack item) {
        if (hologram != null) {
            if (item != null) {
                hologram.appendItemLine(item);
            }
            else {
                hologram.appendTextLine("");
            }
        }
    }
    
    public final void insertLineItem(final Hologram hologram, final int lineIndex, final ItemStack item) {
        if (hologram != null) {
            if (item != null) {
                hologram.insertItemLine(lineIndex, item);
            }
            else {
                hologram.insertTextLine(lineIndex, "");
            }
        }
    }
    
    public final void removeLine(final Hologram hologram, final int lineIndex) {
        if (hologram != null) {
            hologram.removeLine(lineIndex);
        }
    }
    
    public final void movingHolo(final Hologram hologram, final Entity entity, final int time) {
        this.movingHolo(hologram, entity, time, 2.0);
    }
    
    public final void movingHolo(final Hologram hologram, final Entity entity, final int time, final double height) {
        if (hologram != null && entity != null) {
            new BukkitRunnable() {
                int t = 0;
                Location loc = entity.getLocation().add(0.0, height, 0.0);
                
                public void run() {
                    if (hologram.isDeleted()) {
                        this.cancel();
                        return;
                    }
                    if (!entity.isDead()) {
                        this.loc = entity.getLocation().add(0.0, height, 0.0);
                        hologram.teleport(this.loc);
                    }
                    ++this.t;
                    if (this.t >= time) {
                        hologram.delete();
                        this.cancel();
                    }
                }
            }.runTaskTimer((Plugin)this.plugin, 0L, 1L);
        }
    }
    
    public final void removeByTime(final Hologram hologram, final long time) {
        if (hologram != null) {
            final long elapsedTime = System.currentTimeMillis() - hologram.getCreationTimestamp();
            if (elapsedTime > time) {
                hologram.delete();
            }
        }
    }
    
    public final void removeHolosByTime(final long time) {
        for (final Hologram hologram : HologramsAPI.getHolograms((Plugin)this.plugin)) {
            this.removeByTime(hologram, time);
        }
    }
}
