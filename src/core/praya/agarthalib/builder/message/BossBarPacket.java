// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import core.praya.agarthalib.builder.reflection.resolver.main.ResolverQuery;
import org.bukkit.Location;
import com.praya.agarthalib.utility.PacketUtil;
import com.praya.agarthalib.utility.JsonUtil;
import com.praya.agarthalib.utility.MathUtil;
import java.util.Iterator;
import com.praya.agarthalib.manager.player.PlayerBossBarManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.Collection;
import java.util.UUID;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverMethod;
import core.praya.agarthalib.builder.reflection.resolver.main.ResolverField;
import core.praya.agarthalib.builder.reflection.resolver.minecraft.MinecraftResolverNMS;

public class BossBarPacket implements BossBar
{
    private static final MinecraftResolverNMS nmsClassResolver;
    private static final Class<?> PacketPlayOutBoss;
    private static final Class<?> PacketPlayOutBossAction;
    private static final Class<?> ChatSerializer;
    private static final Class<?> BossBattleBarColor;
    private static final Class<?> BossBattleBarStyle;
    private static final ResolverField PacketPlayOutBossFieldResolver;
    private static final ResolverMethod ChatSerializerMethodResolver;
    private final String id;
    private final int priority;
    private final UUID uuid;
    private Collection<Player> receivers;
    private float progress;
    private String message;
    private Color color;
    private Style style;
    private boolean visible;
    private boolean darkenSky;
    private boolean playMusic;
    private boolean createFog;
    
    static {
        nmsClassResolver = new MinecraftResolverNMS();
        PacketPlayOutBoss = BossBarPacket.nmsClassResolver.resolveSilent("PacketPlayOutBoss");
        PacketPlayOutBossAction = BossBarPacket.nmsClassResolver.resolveSilent("PacketPlayOutBoss$Action");
        ChatSerializer = BossBarPacket.nmsClassResolver.resolveSilent("ChatSerializer", "IChatBaseComponent$ChatSerializer");
        BossBattleBarColor = BossBarPacket.nmsClassResolver.resolveSilent("BossBattle$BarColor");
        BossBattleBarStyle = BossBarPacket.nmsClassResolver.resolveSilent("BossBattle$BarStyle");
        PacketPlayOutBossFieldResolver = new ResolverField(BossBarPacket.PacketPlayOutBoss);
        ChatSerializerMethodResolver = new ResolverMethod(BossBarPacket.ChatSerializer);
    }
    
    public BossBarPacket(final String message, final Color color, final Style style, final float progress, final Property... properties) {
        this(message, "Default", 0, color, style, progress, properties);
    }
    
    public BossBarPacket(final String message, final String id, final int priority, final Color color, final Style style, final float progress, final Property... properties) {
        this.id = id;
        this.priority = priority;
        this.receivers = new ArrayList<Player>();
        this.uuid = UUID.randomUUID();
        this.color = ((color != null) ? color : Color.PURPLE);
        this.style = ((style != null) ? style : Style.PROGRESS);
        this.setMessage(message);
        this.setProgress(progress);
        for (final Property property : properties) {
            this.setProperty(property, true);
        }
    }
    
    @Override
    public String getID() {
        return this.id;
    }
    
    @Override
    public int getPriority() {
        return this.priority;
    }
    
    @Override
    public Collection<Player> getPlayers() {
        return this.receivers;
    }
    
    @Override
    public void addPlayer(final Player player) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        if (!this.receivers.contains(player)) {
            this.receivers.add(player);
            this.sendPacket(0, player);
            playerBossBarManager.addBarForPlayer(player, this);
        }
    }
    
    @Override
    public void removePlayer(final Player player) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        if (this.receivers.contains(player)) {
            this.receivers.remove(player);
            this.sendPacket(1, player);
            playerBossBarManager.removeBarForPlayer(player, this);
        }
    }
    
    @Override
    public void remove() {
        for (final Player player : this.receivers) {
            this.removePlayer(player);
        }
    }
    
    @Override
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public void setColor(final Color color) {
        if (color != this.color) {
            this.color = color;
            this.sendPacket(4, null);
        }
    }
    
    @Override
    public Style getStyle() {
        return this.style;
    }
    
    @Override
    public void setStyle(final Style style) {
        if (style != this.style) {
            this.style = style;
            this.sendPacket(4, null);
        }
    }
    
    @Override
    public void setProperty(final Property property, final boolean flag) {
        switch (property) {
            case DARKEN_SKY: {
                this.darkenSky = flag;
                break;
            }
            case PLAY_MUSIC: {
                this.playMusic = flag;
                break;
            }
            case CREATE_FOG: {
                this.createFog = flag;
                break;
            }
        }
        this.sendPacket(5, null);
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public void setMessage(final String message) {
        if (message != null && !message.equals(this.message)) {
            this.message = message;
            this.sendPacket(3, null);
        }
    }
    
    @Override
    public float getProgress() {
        return this.progress;
    }
    
    @Override
    public void setProgress(float progress) {
        progress = (float)MathUtil.limitDouble(progress, 0.0, 1.0);
        if (progress != this.progress) {
            this.progress = progress;
            this.sendPacket(2, null);
        }
    }
    
    @Override
    public boolean isVisible() {
        return this.visible;
    }
    
    @Override
    public void setVisible(final boolean flag) {
        if (flag != this.visible) {
            this.visible = flag;
            this.sendPacket(flag ? 0 : 1, null);
        }
    }
    
    @Override
    public void copyData(final BossBar bossBar) {
        this.setMessage(bossBar.getMessage());
        this.setProgress(bossBar.getProgress());
        if (bossBar instanceof BossBarPacket) {
            final BossBarPacket input = (BossBarPacket)bossBar;
            final Collection<Property> properties = input.getActiveProperties();
            this.setColor(input.getColor());
            this.setStyle(input.getStyle());
            Property[] values;
            for (int length = (values = Property.values()).length, i = 0; i < length; ++i) {
                final Property property = values[i];
                final boolean flag = properties.contains(property);
                this.setProperty(property, flag);
            }
        }
    }
    
    public final Collection<Property> getActiveProperties() {
        final Collection<Property> properties = new ArrayList<Property>();
        if (this.darkenSky) {
            properties.add(Property.DARKEN_SKY);
        }
        if (this.playMusic) {
            properties.add(Property.PLAY_MUSIC);
        }
        if (this.createFog) {
            properties.add(Property.CREATE_FOG);
        }
        return properties;
    }
    
    private void sendPacket(final int action, final Player player) {
        try {
            final String message = this.getMessage();
            final String jsonMessage = (!message.startsWith("{") || !message.endsWith("}")) ? JsonUtil.getJsonText(message) : message;
            final Object packet = BossBarPacket.PacketPlayOutBoss.newInstance();
            final Object bossBarMessage = serialize(jsonMessage);
            final Object bossBarAction = BossBarPacket.PacketPlayOutBossAction.getEnumConstants()[action];
            final Object bossBarColor = BossBarPacket.BossBattleBarColor.getEnumConstants()[this.color.ordinal()];
            final Object bossBarStyle = BossBarPacket.BossBattleBarStyle.getEnumConstants()[this.style.ordinal()];
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("a").set(packet, this.uuid);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("b").set(packet, bossBarAction);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("c").set(packet, bossBarMessage);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("d").set(packet, this.progress);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("e").set(packet, bossBarColor);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("f").set(packet, bossBarStyle);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("g").set(packet, this.darkenSky);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("h").set(packet, this.playMusic);
            BossBarPacket.PacketPlayOutBossFieldResolver.resolve("i").set(packet, this.createFog);
            if (player != null) {
                PacketUtil.sendPacket(player, packet);
            }
            else {
                for (final Player receiver : this.getPlayers()) {
                    PacketUtil.sendPacket(receiver, packet);
                }
            }
        }
        catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public float getMaxHealth() {
        return 100.0f;
    }
    
    @Override
    public void setHealth(final float percentage) {
        this.setProgress(percentage / 100.0f);
    }
    
    @Override
    public float getHealth() {
        return this.getProgress() * 100.0f;
    }
    
    @Override
    public Player getReceiver() {
        return null;
    }
    
    @Override
    public Location getLocation() {
        return null;
    }
    
    @Override
    public void updateMovement() {
    }
    
    private static final Object serialize(final String json) throws ReflectiveOperationException {
        return BossBarPacket.ChatSerializerMethodResolver.resolve(new ResolverQuery("a", (Class<?>[])new Class[] { String.class })).invoke(null, json);
    }
}
