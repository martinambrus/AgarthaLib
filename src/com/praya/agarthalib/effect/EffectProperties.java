// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

public class EffectProperties
{
    private final String key;
    private double value;
    private long expired;
    
    protected EffectProperties(final String key, final Double value) {
        this(key, value, null);
    }
    
    protected EffectProperties(final String key, final Double value, final Integer duration) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        final long now = System.currentTimeMillis();
        this.key = key;
        this.value = ((value != null) ? value : 0.0);
        this.expired = ((duration != null) ? (now + duration * 50) : now);
    }
    
    public final String getKey() {
        return this.key;
    }
    
    public final double getValue() {
        return this.value;
    }
    
    public final long getTimeExpired() {
        return this.expired;
    }
    
    public final void setValue(final Double value) {
        if (value != null) {
            this.value = value;
        }
    }
    
    public final void setDuration(final Integer duration) {
        if (duration != null) {
            final long now = System.currentTimeMillis();
            final long expired = now + duration * 50;
            this.expired = expired;
        }
    }
    
    public final boolean isExpired() {
        final long now = System.currentTimeMillis();
        return this.getTimeExpired() <= now;
    }
}
