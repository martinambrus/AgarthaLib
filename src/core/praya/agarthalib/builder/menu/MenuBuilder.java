// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import org.bukkit.entity.Player;
import core.praya.agarthalib.builder.text.Text;

public abstract class MenuBuilder
{
    public abstract String getID();
    
    public abstract Text getTitle();
    
    public abstract void setTitle(final Text p0);
    
    public abstract boolean isEditable();
    
    public abstract void setEditable(final boolean p0);
    
    public abstract MenuExecutor getExecutor();
    
    public abstract void setExecutor(final MenuExecutor p0);
    
    public abstract boolean hasExecutor();
    
    public abstract void removeExecutor();
    
    public abstract Menu build();
    
    public abstract Menu build(final Player p0);
}
