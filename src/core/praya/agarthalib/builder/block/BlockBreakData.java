// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.block;

import org.bukkit.Location;

@Deprecated
public class BlockBreakData
{
    private final int id;
    private Location location;
    private Long expired;
    
    public BlockBreakData(final int id, final Location location) {
        this(id, location, 200);
    }
    
    public BlockBreakData(final int id, final Location location, final int cooldown) {
        this.id = id;
        this.location = location;
        this.setCooldown(cooldown);
    }
    
    public final int getId() {
        return this.id;
    }
    
    public final Location getLocation() {
        return this.location;
    }
    
    public final boolean isActive() {
        final long now = System.currentTimeMillis();
        return now < this.expired;
    }
    
    public final void setCooldown(final int cooldown) {
        final long now = System.currentTimeMillis();
        final long expired = now + cooldown * 50;
        this.expired = expired;
    }
    
    @Deprecated
    public final int getID() {
        return this.getId();
    }
}
