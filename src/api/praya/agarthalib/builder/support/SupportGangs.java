// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import net.brcdev.gangs.GangsPlusApi;
import org.bukkit.entity.Player;
import org.bukkit.OfflinePlayer;
import java.util.Iterator;
import java.util.List;
import net.brcdev.gangs.gang.Gang;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportGangs extends Support implements SupportGroup
{
    public SupportGangs(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public Collection<String> getGroupIDs() {
        final List<String> groupIDs = new ArrayList<String>();
        for (final Gang gang : this.getAllGangs()) {
            final String id = String.valueOf(gang.getId());
            groupIDs.add(id);
        }
        return groupIDs;
    }
    
    @Override
    public Collection<String> getGroupNames() {
        final List<String> groupNames = new ArrayList<String>();
        for (final Gang gang : this.getAllGangs()) {
            final String name = gang.getName();
            groupNames.add(name);
        }
        return groupNames;
    }
    
    @Override
    public String getGroupNameByID(final String id) {
        final Gang gang = this.getGangByID(id);
        return (gang != null) ? gang.getName() : null;
    }
    
    @Override
    public String getGroupIDByName(final String name) {
        for (final String id : this.getGroupIDs()) {
            final String groupName = this.getGroupNameByID(id);
            if (groupName.equalsIgnoreCase(name)) {
                return id;
            }
        }
        return null;
    }
    
    @Override
    public boolean isGroupIDExists(final String id) {
        return this.getGangByID(id) != null;
    }
    
    @Override
    public boolean isGroupNameExists(final String name) {
        return this.getGangByName(name) != null;
    }
    
    @Override
    public boolean isPlayerJoinGroup(final OfflinePlayer player) {
        return this.getPlayerGang(player) != null;
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id) {
        final Gang gang = this.getGangByID(id);
        return (gang != null) ? this.getOnlinePlayers(gang) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name) {
        final Gang gang = this.getGangByName(name);
        return (gang != null) ? this.getOnlinePlayers(gang) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id) {
        final Gang gang = this.getGangByID(id);
        return (gang != null) ? this.getPlayers(gang) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name) {
        final Gang gang = this.getGangByName(name);
        return (gang != null) ? this.getPlayers(gang) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public String getPlayerGroupID(final OfflinePlayer player) {
        final Gang gang = this.getPlayerGang(player);
        return (gang != null) ? String.valueOf(gang.getId()) : null;
    }
    
    @Override
    public String getPlayerGroupName(final OfflinePlayer player) {
        final Gang gang = this.getPlayerGang(player);
        return (gang != null) ? gang.getName() : null;
    }
    
    public final Collection<Gang> getAllGangs() {
        return (Collection<Gang>)GangsPlusApi.getAllGangs();
    }
    
    public final Gang getGangByID(final String id) {
        if (id != null) {
            for (final Gang gang : this.getAllGangs()) {
                final String gangID = String.valueOf(gang.getId());
                if (gangID.equalsIgnoreCase(id)) {
                    return gang;
                }
            }
        }
        return null;
    }
    
    public final Gang getGangByName(final String name) {
        if (name != null) {
            for (final Gang gang : GangsPlusApi.getAllGangs()) {
                final String gangName = gang.getName();
                if (gangName.equalsIgnoreCase(name)) {
                    return gang;
                }
            }
        }
        return null;
    }
    
    public final Gang getGang(final String gang) {
        final Gang gangByID = this.getGangByID(gang);
        final Gang gangByName = this.getGangByName(gang);
        return (gangByID != null) ? gangByID : gangByName;
    }
    
    public final boolean isGangNameExists(final String name) {
        return this.getGangByName(name) != null;
    }
    
    public final Collection<Player> getOnlinePlayers(final Gang gang) {
        final Collection<Player> players = new ArrayList<Player>();
        if (gang != null) {
            for (final Player player : gang.getOnlineMembers()) {
                players.add(player);
            }
        }
        return players;
    }
    
    public final Collection<OfflinePlayer> getPlayers(final Gang gang) {
        final Collection<OfflinePlayer> players = new ArrayList<OfflinePlayer>();
        if (gang != null) {
            for (final OfflinePlayer player : gang.getAllMembers()) {
                players.add(player);
            }
        }
        return players;
    }
    
    public final Gang getPlayerGang(final OfflinePlayer player) {
        if (player != null && player.isOnline()) {
            final Player onlinePlayer = player.getPlayer();
            return GangsPlusApi.getPlayersGang(onlinePlayer);
        }
        return null;
    }
}
