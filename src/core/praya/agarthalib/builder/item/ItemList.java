// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.item;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import java.util.List;

public class ItemList implements Item, Cloneable
{
    private final List<ItemStack> itemList;
    private int index;
    
    public ItemList() {
        this(new ArrayList<ItemStack>());
    }
    
    public ItemList(final ItemStack... items) {
        final List<ItemStack> list = new ArrayList<ItemStack>();
        for (final ItemStack item : items) {
            list.add(item);
        }
        this.itemList = list;
        this.index = 0;
    }
    
    public ItemList(final List<ItemStack> itemList) {
        this.itemList = itemList;
        this.index = 0;
    }
    
    @Override
    public final ItemStack getItemStack() {
        return this.itemList.isEmpty() ? null : this.itemList.get(this.index);
    }
    
    @Override
    public void setItemStack(final ItemStack item) {
        this.itemList.clear();
        this.itemList.add(item);
    }
    
    @Override
    public final void addItemStack(final ItemStack item) {
        this.itemList.add(item);
    }
    
    @Override
    public void removeItemStack(final ItemStack item) {
        final List<ItemStack> itemList = new ArrayList<ItemStack>(this.getItemList());
        for (final ItemStack itemStack : itemList) {
            if (itemStack.equals((Object)item)) {
                this.itemList.remove(itemStack);
            }
        }
    }
    
    @Override
    public final void clearItemStack() {
        this.itemList.clear();
    }
    
    public final List<ItemStack> getItemList() {
        return this.itemList;
    }
    
    public final void removeLastItem() {
        final int size = this.itemList.size();
        if (size > 0) {
            this.itemList.remove(size - 1);
        }
    }
    
    public final ItemStack next() {
        final int size = this.itemList.size();
        final ItemStack item = (this.index < size) ? this.itemList.get(this.index) : null;
        ++this.index;
        if (this.index >= size) {
            this.index = 0;
        }
        return item;
    }
    
    public ItemList clone() {
        return new ItemList(this.itemList);
    }
}
