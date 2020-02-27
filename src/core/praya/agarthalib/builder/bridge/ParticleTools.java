// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.bridge;

import org.bukkit.Location;
import core.praya.agarthalib.enums.branch.ParticleEnum;
import org.bukkit.entity.Player;
import java.util.Collection;

public interface ParticleTools
{
    void packetPlayParticle(final Collection<Player> p0, final ParticleEnum p1, final Location p2, final int p3, final float p4, final float p5, final float p6, final float p7, final Object p8);
    
    @Deprecated
    void packetPlayParticle(final Collection<Player> p0, final ParticleEnum p1, final Location p2, final int p3, final double p4, final double p5, final double p6, final int p7, final float p8);
}
