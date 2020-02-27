// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

public class StatsProperties
{
    private final String id;
    private double value;
    
    protected StatsProperties(final String id, final double value) {
        this.id = id;
        this.value = value;
    }
    
    public final String getID() {
        return this.id;
    }
    
    public final double getValue() {
        return this.value;
    }
    
    public final void setValue(final double value) {
        this.value = value;
    }
}
