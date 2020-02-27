// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarTimer extends BukkitRunnable
{
    private final BossBarPacket bossBar;
    private final float progressMinus;
    
    public BossBarTimer(final BossBarPacket packetBossBar, final float progress, final int timeout) {
        this.bossBar = packetBossBar;
        this.progressMinus = progress / timeout;
    }
    
    public void run() {
        final float newProgress = this.bossBar.getProgress() - this.progressMinus;
        if (newProgress <= 0.0f) {
            for (final Player player : this.bossBar.getPlayers()) {
                this.bossBar.removePlayer(player);
            }
            this.cancel();
        }
        else {
            this.bossBar.setProgress(newProgress);
        }
    }
}
