// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.bridge;

import java.util.List;
import org.bukkit.inventory.ItemStack;

public interface TagsNBTCustom
{
    void setString(final String p0, final String p1, final ItemStack p2, final String p3);
    
    void setInt(final String p0, final String p1, final ItemStack p2, final int p3);
    
    void setDouble(final String p0, final String p1, final ItemStack p2, final double p3);
    
    void setLong(final String p0, final String p1, final ItemStack p2, final long p3);
    
    void setBoolean(final String p0, final String p1, final ItemStack p2, final boolean p3);
    
    void setListString(final String p0, final String p1, final ItemStack p2, final List<String> p3);
    
    String getString(final String p0, final String p1, final ItemStack p2);
    
    int getInt(final String p0, final String p1, final ItemStack p2);
    
    double getDouble(final String p0, final String p1, final ItemStack p2);
    
    long getLong(final String p0, final String p1, final ItemStack p2);
    
    boolean getBoolean(final String p0, final String p1, final ItemStack p2);
    
    List<String> getListString(final String p0, final String p1, final ItemStack p2);
    
    void remove(final String p0, final String p1, final ItemStack p2);
}
