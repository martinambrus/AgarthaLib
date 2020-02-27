// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import com.praya.agarthalib.utility.NMSClassUtil;
import com.praya.agarthalib.utility.DataWatcher;
import org.bukkit.util.Vector;
import com.praya.agarthalib.utility.PacketUtil;
import java.util.ArrayList;
import java.util.Collection;
import com.praya.agarthalib.manager.player.PlayerBossBarManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import org.bukkit.plugin.Plugin;
import java.util.Random;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.UUID;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarEntity extends BukkitRunnable implements BossBar
{
    private static final int ENTITY_DISTANCE = 32;
    private final String id;
    private final int priority;
    private final int entityID;
    private final UUID uuid;
    private final Player receiver;
    private String message;
    private float health;
    private float healthMinus;
    private float minHealth;
    private Location location;
    private World world;
    private boolean visible;
    private Object dataWatcher;
    
    public BossBarEntity(final Player player, final String message, final float percentage, final int timeout, final float minHealth) {
        this(player, message, "Default", 0, percentage, timeout, minHealth);
    }
    
    public BossBarEntity(final Player player, final String message, final String id, final int priority, final float percentage, final int timeout, final float minHealth) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        this.id = id;
        this.priority = priority;
        this.minHealth = 1.0f;
        this.visible = false;
        this.entityID = new Random().nextInt();
        this.uuid = UUID.randomUUID();
        this.receiver = player;
        this.message = message;
        this.health = percentage / 100.0f * this.getMaxHealth();
        this.minHealth = minHealth;
        this.world = player.getWorld();
        this.location = this.makeLocation(player.getLocation());
        if (percentage <= minHealth) {
            playerBossBarManager.removeBar(player);
        }
        if (timeout > 0) {
            this.healthMinus = this.getMaxHealth() / timeout;
            this.runTaskTimer((Plugin)plugin, 20L, 20L);
        }
    }
    
    public String getID() {
        return this.id;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public float getMaxHealth() {
        return 300.0f;
    }
    
    public void setHealth(final float percentage) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final float health = percentage / 100.0f * this.getMaxHealth();
        this.health = health;
        if (this.health <= this.minHealth) {
            playerBossBarManager.removeBar(this.receiver);
        }
        else {
            this.sendMetadata();
        }
    }
    
    public float getHealth() {
        return this.health;
    }
    
    public void setMessage(final String message) {
        if (this.message != message) {
            this.message = message;
            if (this.isVisible()) {
                this.sendMetadata();
            }
        }
    }
    
    public Collection<Player> getPlayers() {
        final Collection<Player> players = new ArrayList<Player>();
        players.add(this.receiver);
        return players;
    }
    
    public void addPlayer(final Player player) {
    }
    
    public void removePlayer(final Player player) {
        if (this.receiver != null && player != null && this.receiver.equals(player)) {
            this.setVisible(false);
        }
    }
    
    public void remove() {
        this.removePlayer(this.receiver);
    }
    
    public Color getColor() {
        return null;
    }
    
    public void setColor(final Color color) {
    }
    
    public Style getStyle() {
        return null;
    }
    
    public void setStyle(final Style style) {
    }
    
    public void setProperty(final Property property, final boolean flag) {
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public void setVisible(final boolean flag) {
        if (flag != this.visible) {
            if (flag) {
                this.spawn();
            }
            else {
                this.destroy();
            }
        }
    }
    
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setProgress(final float progress) {
        this.setHealth(progress * 100.0f);
    }
    
    public float getProgress() {
        return this.getHealth() / 100.0f;
    }
    
    public void updateMovement() {
        if (this.visible) {
            this.location = this.makeLocation(this.receiver.getLocation());
            try {
                final Object packet = PacketUtil.buildTeleportPacket(this.entityID, this.getLocation(), false, false);
                PacketUtil.sendPacket(this.receiver, packet);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public final Player getReceiver() {
        return this.receiver;
    }
    
    public void copyData(final BossBar bossBar) {
        this.setMessage(bossBar.getMessage());
        this.setProgress(bossBar.getProgress());
    }
    
    public void run() {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        this.health -= this.healthMinus;
        if (this.health <= this.minHealth) {
            playerBossBarManager.removeBar(this.receiver);
        }
        else {
            this.sendMetadata();
        }
    }
    
    private final Location makeLocation(final Location base) {
        final Vector vector = base.toVector();
        return base.getDirection().multiply(32).add(vector).toLocation(this.world);
    }
    
    private void updateDataWatcher() {
        if (this.dataWatcher == null) {
            try {
                DataWatcher.setValue(this.dataWatcher = DataWatcher.newDataWatcher(null), 17, DataWatcher.V1_9.ValueType.ENTITY_WITHER_a, new Integer(0));
                DataWatcher.setValue(this.dataWatcher, 18, DataWatcher.V1_9.ValueType.ENTITY_WIHER_b, new Integer(0));
                DataWatcher.setValue(this.dataWatcher, 19, DataWatcher.V1_9.ValueType.ENTITY_WITHER_c, new Integer(0));
                DataWatcher.setValue(this.dataWatcher, 20, DataWatcher.V1_9.ValueType.ENTITY_WITHER_bw, new Integer(1000));
                DataWatcher.setValue(this.dataWatcher, 0, DataWatcher.V1_9.ValueType.ENTITY_FLAG, 32);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            DataWatcher.setValue(this.dataWatcher, 6, DataWatcher.V1_9.ValueType.ENTITY_LIVING_HEALTH, this.health);
            DataWatcher.setValue(this.dataWatcher, 10, DataWatcher.V1_9.ValueType.ENTITY_NAME, this.message);
            DataWatcher.setValue(this.dataWatcher, 2, DataWatcher.V1_9.ValueType.ENTITY_NAME, this.message);
            DataWatcher.setValue(this.dataWatcher, 11, DataWatcher.V1_9.ValueType.ENTITY_NAME_VISIBLE, 1);
            DataWatcher.setValue(this.dataWatcher, 3, DataWatcher.V1_9.ValueType.ENTITY_NAME_VISIBLE, 1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void sendMetadata() {
        this.updateDataWatcher();
        try {
            final Object metaPacket = PacketUtil.buildNameMetadataPacket(this.entityID, this.dataWatcher, 2, 3, this.message);
            PacketUtil.sendPacket(this.receiver, metaPacket);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void spawn() {
        try {
            this.updateMovement();
            this.updateDataWatcher();
            final Object packet = PacketUtil.buildWitherSpawnPacket(this.entityID, this.uuid, this.getLocation(), this.dataWatcher);
            PacketUtil.sendPacket(this.receiver, packet);
            this.visible = true;
            this.sendMetadata();
            this.updateMovement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void destroy() {
        try {
            this.cancel();
        }
        catch (IllegalStateException ex) {}
        try {
            final Object packet = NMSClassUtil.PacketPlayOutEntityDestroy.getConstructor(int[].class).newInstance(new int[] { this.entityID });
            PacketUtil.sendPacket(this.receiver, packet);
            this.visible = false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
