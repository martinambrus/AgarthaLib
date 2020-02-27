// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import java.util.UUID;
import com.praya.agarthalib.utility.PlayerUtil;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.managers.ClanManager;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.entity.Player;
import org.bukkit.OfflinePlayer;
import java.util.Iterator;
import java.util.List;
import net.sacredlabyrinth.phaed.simpleclans.Clan;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportSimpleClans extends Support implements SupportGroup
{
    public SupportSimpleClans(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public Collection<String> getGroupIDs() {
        final List<String> groupIDs = new ArrayList<String>();
        for (final Clan clan : this.getAllClan()) {
            final String id = clan.getTag();
            groupIDs.add(id);
        }
        return groupIDs;
    }
    
    @Override
    public Collection<String> getGroupNames() {
        final List<String> groupNames = new ArrayList<String>();
        for (final Clan clan : this.getAllClan()) {
            final String name = clan.getName();
            groupNames.add(name);
        }
        return groupNames;
    }
    
    @Override
    public String getGroupNameByID(final String id) {
        final Clan clan = this.getClanByID(id);
        return (clan != null) ? clan.getName() : null;
    }
    
    @Override
    public String getGroupIDByName(final String name) {
        final Clan clan = this.getClanByName(name);
        return (clan != null) ? clan.getTag() : null;
    }
    
    @Override
    public boolean isGroupIDExists(final String id) {
        return this.getClanByID(id) != null;
    }
    
    @Override
    public boolean isGroupNameExists(final String name) {
        return this.getClanByName(name) != null;
    }
    
    @Override
    public boolean isPlayerJoinGroup(final OfflinePlayer player) {
        return this.getPlayerClan(player) != null;
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id) {
        final Clan clan = this.getClanByID(id);
        return (clan != null) ? this.getOnlinePlayers(clan) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name) {
        final Clan clan = this.getClanByName(name);
        return (clan != null) ? this.getOnlinePlayers(clan) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id) {
        final Clan clan = this.getClanByID(id);
        return (clan != null) ? this.getPlayers(clan) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name) {
        final Clan clan = this.getClanByName(name);
        return (clan != null) ? this.getPlayers(clan) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public String getPlayerGroupID(final OfflinePlayer player) {
        final Clan clan = this.getPlayerClan(player);
        return (clan != null) ? clan.getTag() : null;
    }
    
    @Override
    public String getPlayerGroupName(final OfflinePlayer player) {
        final Clan clan = this.getPlayerClan(player);
        return (clan != null) ? clan.getName() : null;
    }
    
    public final Collection<Clan> getAllClan() {
        final SimpleClans simpleClans = SimpleClans.getInstance();
        final ClanManager clanManager = simpleClans.getClanManager();
        return (Collection<Clan>)clanManager.getClans();
    }
    
    public final Clan getClanByID(final String id) {
        if (id != null) {
            for (final Clan clan : this.getAllClan()) {
                final String clanID = clan.getTag();
                if (clanID.equalsIgnoreCase(id)) {
                    return clan;
                }
            }
        }
        return null;
    }
    
    public final Clan getClanByName(final String name) {
        if (name != null) {
            for (final Clan clan : this.getAllClan()) {
                final String clanName = clan.getName();
                if (clanName.equalsIgnoreCase(name)) {
                    return clan;
                }
            }
        }
        return null;
    }
    
    public final Clan getClan(final String clan) {
        final Clan clanByID = this.getClanByID(clan);
        final Clan clanByName = this.getClanByName(clan);
        return (clanByID != null) ? clanByID : clanByName;
    }
    
    public final boolean isClanIDExists(final String id) {
        return this.getClanByID(id) != null;
    }
    
    public final boolean isClanNameExists(final String name) {
        return this.getClanByName(name) != null;
    }
    
    public final Collection<Player> getOnlinePlayers(final Clan clan) {
        final Collection<Player> players = new ArrayList<Player>();
        if (clan != null) {
            for (final ClanPlayer clanPlayer : clan.getOnlineMembers()) {
                final Player player = clanPlayer.toPlayer();
                players.add(player);
            }
        }
        return players;
    }
    
    public final Collection<OfflinePlayer> getPlayers(final Clan clan) {
        final Collection<OfflinePlayer> players = new ArrayList<OfflinePlayer>();
        if (clan != null) {
            for (final ClanPlayer clanPlayer : clan.getAllMembers()) {
                final UUID playerID = clanPlayer.getUniqueId();
                if (playerID != null) {
                    final OfflinePlayer player = PlayerUtil.getPlayer(playerID);
                    players.add(player);
                }
            }
        }
        return players;
    }
    
    public final Clan getPlayerClan(final OfflinePlayer player) {
        final SimpleClans simpleClans = SimpleClans.getInstance();
        final ClanManager clanManager = simpleClans.getClanManager();
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final Clan clan = clanManager.getClanByPlayerUniqueId(playerID);
            return clan;
        }
        return null;
    }
    
    public final boolean isPlayerJoinClan(final OfflinePlayer player) {
        return this.getPlayerClan(player) != null;
    }
}
