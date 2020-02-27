// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.palmergames.bukkit.towny.TownyUniverse;
import org.bukkit.entity.Player;
import org.bukkit.OfflinePlayer;
import java.util.Iterator;
import java.util.List;
import com.palmergames.bukkit.towny.object.Town;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import com.palmergames.bukkit.towny.Towny;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportTowny extends Support implements SupportGroup
{
    public SupportTowny(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public Collection<String> getGroupIDs() {
        final Towny         towny         = (Towny)JavaPlugin.getPlugin((Class)Towny.class);
        final TownyUniverse townyUniverse = towny.getTownyUniverse();
        return (Collection<String>)townyUniverse.getTownsMap().keySet();
    }
    
    @Override
    public Collection<String> getGroupNames() {
        final List<String> groupNames = new ArrayList<String>();
        for (final Town town : this.getAllTown()) {
            final String name = town.getName();
            groupNames.add(name);
        }
        return groupNames;
    }
    
    @Override
    public String getGroupNameByID(final String id) {
        final Town town = this.getTownByID(id);
        return (town != null) ? town.getName() : null;
    }
    
    @Override
    public String getGroupIDByName(final String name) {
        final Town town = this.getTownByName(name);
        return (town != null) ? town.getUuid().toString() : null;
    }
    
    @Override
    public boolean isGroupIDExists(final String id) {
        return this.getTownByID(id) != null;
    }
    
    @Override
    public boolean isGroupNameExists(final String name) {
        return this.getTownByName(name) != null;
    }
    
    @Override
    public boolean isPlayerJoinGroup(final OfflinePlayer player) {
        return this.getPlayerTown(player) != null;
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id) {
        final Town town = this.getTownByID(id);
        return (town != null) ? this.getOnlinePlayers(town) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name) {
        final Town town = this.getTownByName(name);
        return (town != null) ? this.getOnlinePlayers(town) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id) {
        final Town town = this.getTownByID(id);
        return (town != null) ? this.getPlayers(town) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name) {
        final Town town = this.getTownByName(name);
        return (town != null) ? this.getPlayers(town) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public String getPlayerGroupID(final OfflinePlayer player) {
        final Town town = this.getPlayerTown(player);
        return (town != null) ? town.getUuid().toString() : null;
    }
    
    @Override
    public String getPlayerGroupName(final OfflinePlayer player) {
        final Town town = this.getPlayerTown(player);
        return (town != null) ? town.getName() : null;
    }
    
    public final Collection<Town> getAllTown() {
        final Towny towny = (Towny)JavaPlugin.getPlugin((Class)Towny.class);
        final TownyUniverse townUniverse = towny.getTownyUniverse();
        return townUniverse.getTownsMap().values();
    }
    
    public final Town getTownByID(final String id) {
        if (id != null) {
            for (final Town town : this.getAllTown()) {
                final String townID = town.getUuid().toString();
                if (townID.equalsIgnoreCase(id)) {
                    return town;
                }
            }
        }
        return null;
    }
    
    public final Town getTownByName(final String name) {
        if (name != null) {
            for (final Town town : this.getAllTown()) {
                final String townName = town.getName();
                if (townName.equalsIgnoreCase(name)) {
                    return town;
                }
            }
        }
        return null;
    }
    
    public final Town getTown(final String town) {
        final Town townByID = this.getTownByID(town);
        final Town townByName = this.getTownByName(town);
        return (townByID != null) ? townByID : townByName;
    }
    
    public final boolean isTownIDExists(final String id) {
        return this.getTownByID(id) != null;
    }
    
    public final boolean isTownNameExists(final String name) {
        return this.getTownByName(name) != null;
    }
    
    public final Collection<Player> getOnlinePlayers(final Town town) {
        return (town != null) ? com.palmergames.bukkit.towny.object.TownyUniverse.getOnlinePlayers(town) : new ArrayList<Player>();
    }
    
    public final Collection<OfflinePlayer> getPlayers(final Town town) {
        final Collection<Player> players = this.getOnlinePlayers(town);
        final Collection<OfflinePlayer> offlinePlayers = new ArrayList<OfflinePlayer>();
        for (final Player player : players) {
            final OfflinePlayer offlinePlayer = (OfflinePlayer)player.getPlayer();
            offlinePlayers.add(offlinePlayer);
        }
        return offlinePlayers;
    }
    
    public final Town getPlayerTown(final OfflinePlayer player) {
        if (player != null) {
            for (final Town town : this.getAllTown()) {
                final Collection<OfflinePlayer> players = this.getPlayers(town);
                if (players.contains(player)) {
                    return town;
                }
            }
        }
        return null;
    }
}
