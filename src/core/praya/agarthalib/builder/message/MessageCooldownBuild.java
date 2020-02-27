// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

public class MessageCooldownBuild
{
    private final String id;
    private final int priority;
    private final long expired;
    
    public MessageCooldownBuild() {
        this.id = "default";
        this.priority = 0;
        this.expired = System.currentTimeMillis();
    }
    
    public MessageCooldownBuild(final String id, final int priority, final long expired) {
        this.id = id;
        this.priority = priority;
        this.expired = expired;
    }
    
    public final String getID() {
        return this.id;
    }
    
    public final int getPriority() {
        return this.priority;
    }
    
    public final long getExpired() {
        return this.expired;
    }
    
    public final boolean isCooldown() {
        final long now = System.currentTimeMillis();
        return now < this.getExpired();
    }
}
