// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib;

import com.praya.agarthalib.command.executor.CommandAgarthaLib;
import com.praya.agarthalib.listener.core.*;
import com.praya.agarthalib.listener.custom.ListenerMenuClick;
import com.praya.agarthalib.listener.custom.ListenerMenuCreate;
import com.praya.agarthalib.listener.custom.ListenerPlayerHealthChange;
import com.praya.agarthalib.listener.custom.ListenerPlayerHealthMaxChange;
import com.praya.agarthalib.listener.main.*;
import com.praya.agarthalib.listener.support.battlelevels.ListenerBattleLevelsPlayerLevelUp;
import com.praya.agarthalib.listener.support.heroes.ListenerHeroesAttributeAllocationPointsChange;
import com.praya.agarthalib.listener.support.heroes.ListenerHeroesAttributeChange;
import com.praya.agarthalib.listener.support.heroes.ListenerHeroesHeroChangeClass;
import com.praya.agarthalib.listener.support.heroes.ListenerHeroesHeroChangeLevel;
import com.praya.agarthalib.listener.support.skillapi.ListenerSkillAPIAccountChange;
import com.praya.agarthalib.listener.support.skillapi.ListenerSkillAPIClassChange;
import com.praya.agarthalib.listener.support.skillapi.ListenerSkillAPILevelUp;
import com.praya.agarthalib.manager.core.CoreManager;
import com.praya.agarthalib.manager.game.GameManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import com.praya.agarthalib.manager.server.ServerManager;
import com.praya.agarthalib.manager.task.TaskManager;
import com.praya.agarthalib.tabcompleter.TabCompleterAgarthaLib;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.utility.PluginUtil;
import com.praya.agarthalib.utility.ServerEventUtil;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class AgarthaLib extends JavaPlugin implements Agartha
{
    private final String type = "Free";
    private final String placeholder = "agarthalib";
    private AgarthaLibConfig mainConfig;
    private CoreManager coreManager;
    private ServerManager serverManager;
    private PluginManager pluginManager;
    private PlayerManager playerManager;
    private GameManager gameManager;
    private TaskManager taskManager;
    
    public String getPluginName() {
        return this.getName();
    }
    
    public String getPluginType() {
        return "Free";
    }
    
    public String getPluginVersion() {
        return this.getDescription().getVersion();
    }
    
    public String getPluginPlaceholder() {
        return "agarthalib";
    }
    
    public String getPluginWebsite() {
        return this.getPluginManager().getPluginPropertiesManager().getPluginWebsite();
    }
    
    public String getPluginLatest() {
        return this.getPluginManager().getPluginPropertiesManager().getPluginVersion(this.getPluginType());
    }
    
    public List<String> getPluginDevelopers() {
        return this.getPluginManager().getPluginPropertiesManager().getPluginDevelopers();
    }
    
    public final AgarthaLibConfig getMainConfig() {
        return this.mainConfig;
    }
    
    public final CoreManager getCoreManager() {
        return this.coreManager;
    }
    
    public final ServerManager getServerManager() {
        return this.serverManager;
    }
    
    public final PluginManager getPluginManager() {
        return this.pluginManager;
    }
    
    public final PlayerManager getPlayerManager() {
        return this.playerManager;
    }
    
    public final GameManager getGameManager() {
        return this.gameManager;
    }
    
    public final TaskManager getTaskManager() {
        return this.taskManager;
    }
    
    public void onEnable() {
        this.registerConfig();
        this.registerManager();
        this.registerCommand();
        this.registerTabComplete();
        this.registerListener();
        this.registerPlaceholder();
    }
    
    private final void registerConfig() {
        this.mainConfig = new AgarthaLibConfig(this);
    }
    
    private final void registerManager() {
        this.coreManager = new CoreManager(this);
        this.serverManager = new AgarthaServerMemory(this);
        this.pluginManager = new PluginManager(this);
        this.playerManager = new PlayerManager(this);
        this.gameManager = new GameManager(this);
        this.taskManager = new TaskManager(this);
    }
    
    private final void registerPlaceholder() {
        this.getPluginManager().getPlaceholderManager().registerAll();
    }
    
    private final void registerCommand() {
        final CommandExecutor commandAgarthaLib = (CommandExecutor)new CommandAgarthaLib(this);
        this.getCommand("AgarthaLib").setExecutor(commandAgarthaLib);
    }
    
    private final void registerTabComplete() {
        final TabCompleter tabCompleterAgarthaLib = (TabCompleter)new TabCompleterAgarthaLib(this);
        this.getCommand("AgarthaLib").setTabCompleter(tabCompleterAgarthaLib);
    }
    
    private final void registerListener() {
        final Listener listenerCoreBossBarPlayerKick = (Listener)new ListenerCoreBossBarPlayerKick(this);
        final Listener listenerCoreBossBarPlayerQuit = (Listener)new ListenerCoreBossBarPlayerQuit(this);
        final Listener listenerCoreMenuClick = (Listener)new ListenerCoreMenuClick(this);
        final Listener listenerCoreMenuClose = (Listener)new ListenerCoreMenuClose(this);
        final Listener listenerCoreMenuOpen = (Listener)new ListenerCoreMenuOpen(this);
        final Listener listenerMenuClick = (Listener)new ListenerMenuClick(this);
        final Listener listenerMenuCreate = (Listener)new ListenerMenuCreate(this);
        final Listener listenerEntityDamage = (Listener)new ListenerEntityDamage(this);
        final Listener listenerEntityDeath = (Listener)new ListenerEntityDeath(this);
        final Listener listenerEntityShootBow = (Listener)new ListenerEntityShootBow(this);
        final Listener listenerInventoryDrag = (Listener)new ListenerInventoryDrag(this);
        final Listener listenerPlayerJoin = (Listener)new ListenerPlayerJoin(this);
        final Listener listenerPlayerQuit = (Listener)new ListenerPlayerQuit(this);
        final Listener listenerProjectileHit = (Listener)new ListenerProjectileHit(this);
        final Listener listenerProjectileLaunch = (Listener)new ListenerProjectileLaunch(this);
        final Listener listenerWorldLoad = (Listener)new ListenerWorldLoad(this);
        final Listener listenerWorldUnload = (Listener)new ListenerWorldUnload(this);
        final Listener listenerPlayerHealthChange = (Listener)new ListenerPlayerHealthChange(this);
        final Listener listenerPlayerHealthMaxChange = (Listener)new ListenerPlayerHealthMaxChange(this);
        ServerEventUtil.registerEvent((Plugin)this, listenerCoreBossBarPlayerKick);
        ServerEventUtil.registerEvent((Plugin)this, listenerCoreBossBarPlayerQuit);
        ServerEventUtil.registerEvent((Plugin)this, listenerCoreMenuClick);
        ServerEventUtil.registerEvent((Plugin)this, listenerCoreMenuClose);
        ServerEventUtil.registerEvent((Plugin)this, listenerCoreMenuOpen);
        ServerEventUtil.registerEvent((Plugin)this, listenerMenuClick);
        ServerEventUtil.registerEvent((Plugin)this, listenerMenuCreate);
        ServerEventUtil.registerEvent((Plugin)this, listenerEntityDamage);
        ServerEventUtil.registerEvent((Plugin)this, listenerEntityDeath);
        ServerEventUtil.registerEvent((Plugin)this, listenerEntityShootBow);
        ServerEventUtil.registerEvent((Plugin)this, listenerInventoryDrag);
        ServerEventUtil.registerEvent((Plugin)this, listenerPlayerJoin);
        ServerEventUtil.registerEvent((Plugin)this, listenerPlayerQuit);
        ServerEventUtil.registerEvent((Plugin)this, listenerProjectileHit);
        ServerEventUtil.registerEvent((Plugin)this, listenerProjectileLaunch);
        ServerEventUtil.registerEvent((Plugin)this, listenerWorldLoad);
        ServerEventUtil.registerEvent((Plugin)this, listenerWorldUnload);
        ServerEventUtil.registerEvent((Plugin)this, listenerPlayerHealthChange);
        ServerEventUtil.registerEvent((Plugin)this, listenerPlayerHealthMaxChange);
        if (ServerUtil.isLegacy()) {
            final Listener listenerPlayerMove = (Listener)new ListenerPlayerMove(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerPlayerMove);
        }
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final Listener listenerPlayerPickupArrow = (Listener)new ListenerPlayerPickupArrow(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerPlayerPickupArrow);
        }
        else {
            final Listener listenerCoreBossBarPlayerRespawn = (Listener)new ListenerCoreBossBarPlayerRespawn(this);
            final Listener listenerCoreBossBarPlayerTeleport = (Listener)new ListenerCoreBossBarPlayerTeleport(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerCoreBossBarPlayerRespawn);
            ServerEventUtil.registerEvent((Plugin)this, listenerCoreBossBarPlayerTeleport);
        }
        if (PluginUtil.isPluginInstalled("SkillAPI")) {
            final Listener listenerSkillAPIAccountChange = (Listener)new ListenerSkillAPIAccountChange(this);
            final Listener listenerSkillAPIClassChange = (Listener)new ListenerSkillAPIClassChange(this);
            final Listener listenerSkillAPILevelUp = (Listener)new ListenerSkillAPILevelUp(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerSkillAPIAccountChange);
            ServerEventUtil.registerEvent((Plugin)this, listenerSkillAPIClassChange);
            ServerEventUtil.registerEvent((Plugin)this, listenerSkillAPILevelUp);
        }
        if (PluginUtil.isPluginInstalled("BattleLevels")) {
            final Listener listenerBattleLevelsPlayerLevelUp = (Listener)new ListenerBattleLevelsPlayerLevelUp(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerBattleLevelsPlayerLevelUp);
        }
        if (PluginUtil.isPluginInstalled("Heroes")) {
            final Listener listenerHeroesAttributeAllocationPointsChange = (Listener)new ListenerHeroesAttributeAllocationPointsChange(this);
            final Listener listenerHeroesAttributeChange = (Listener)new ListenerHeroesAttributeChange(this);
            final Listener listenerHeroesHeroChangeClass = (Listener)new ListenerHeroesHeroChangeClass(this);
            final Listener listenerHeroesHeroChangeLevel = (Listener)new ListenerHeroesHeroChangeLevel(this);
            ServerEventUtil.registerEvent((Plugin)this, listenerHeroesAttributeAllocationPointsChange);
            ServerEventUtil.registerEvent((Plugin)this, listenerHeroesAttributeChange);
            ServerEventUtil.registerEvent((Plugin)this, listenerHeroesHeroChangeClass);
            ServerEventUtil.registerEvent((Plugin)this, listenerHeroesHeroChangeLevel);
        }
    }
    
    public void onDisable() {
        for (final Player player : PlayerUtil.getOnlinePlayers()) {
            Bridge.getBridgeMessage().removeAllBossBar(player);
        }
    }
}
