// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.item;

import org.bukkit.inventory.ItemStack;

public class ItemSingle implements Item
{
    private ItemStack item;
    
    public ItemSingle(final ItemStack item) {
        this.item = item;
    }
    
    @Override
    public ItemStack getItemStack() {
        return this.item;
    }
    
    @Override
    public void setItemStack(final ItemStack item) {
        this.item = item;
    }
    
    @Override
    public void addItemStack(final ItemStack item) {
        this.item = item;
    }
    
    @Override
    public void removeItemStack(final ItemStack item) {
        if (item != null && this.item != null && this.item.equals((Object)item)) {
            this.item = null;
        }
    }
    
    @Override
    public void clearItemStack() {
        this.item = null;
    }
}
