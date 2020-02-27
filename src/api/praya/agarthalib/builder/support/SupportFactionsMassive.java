// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.factions.entity.BoardColl;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import com.massivecraft.factions.Rel;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import org.bukkit.OfflinePlayer;
import com.massivecraft.factions.entity.MPlayer;
import java.util.UUID;
import java.util.Iterator;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportTerritory;
import api.praya.agarthalib.builder.support.main.SupportFactions;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportFactionsMassive extends Support implements SupportFactions, SupportTerritory
{
    public SupportFactionsMassive(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public Collection<String> getGroupIDs() {
        final Collection<String> groupIDs = new ArrayList<String>();
        for (final Faction faction : FactionColl.get().getAll()) {
            if (this.isRealFaction(faction)) {
                groupIDs.add(faction.getId());
            }
        }
        return groupIDs;
    }
    
    @Override
    public Collection<String> getGroupNames() {
        final Collection<String> groupNames = new ArrayList<String>();
        for (final Faction faction : FactionColl.get().getAll()) {
            if (this.isRealFaction(faction)) {
                groupNames.add(faction.getName());
            }
        }
        return groupNames;
    }
    
    @Override
    public String getGroupNameByID(final String id) {
        final Faction faction = this.getFactionByID(id);
        return (faction != null) ? faction.getName() : null;
    }
    
    @Override
    public String getGroupIDByName(final String name) {
        final Faction faction = this.getFactionByName(name);
        return (faction != null) ? faction.getId() : null;
    }
    
    @Override
    public final UUID getGroupLeaderByID(final String id) {
        final Faction faction = this.getFactionByID(id);
        if (faction != null) {
            final MPlayer mPlayer = faction.getLeader();
            return mPlayer.getUuid();
        }
        return null;
    }
    
    @Override
    public final UUID getGroupLeaderByName(final String name) {
        final Faction faction = this.getFactionByName(name);
        if (faction != null) {
            final MPlayer mPlayer = faction.getLeader();
            return mPlayer.getUuid();
        }
        return null;
    }
    
    @Override
    public final SupportGroup.SupportGroupRole getPlayerRole(final OfflinePlayer player) {
        if (player != null) {
            final MPlayer mPlayer = MPlayer.get((Object)player);
            if (mPlayer != null) {
                final Rel role = mPlayer.getRole();
                switch (role) {
                    case LEADER: {
                        return SupportGroup.SupportGroupRole.LEADER;
                    }
                    case OFFICER: {
                        return SupportGroup.SupportGroupRole.CO_LEADER;
                    }
                    case RECRUIT: {
                        return SupportGroup.SupportGroupRole.MODERATOR;
                    }
                    case MEMBER: {
                        return SupportGroup.SupportGroupRole.MEMBER;
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public final boolean matchPlayerRole(final OfflinePlayer player, final SupportGroup.SupportGroupRole role) {
        if (player != null && role != null) {
            final SupportGroup.SupportGroupRole playerRole = this.getPlayerRole(player);
            return playerRole.equals(playerRole);
        }
        return false;
    }
    
    @Override
    public final boolean isGroupOwner(final OfflinePlayer player) {
        return this.matchPlayerRole(player, SupportGroup.SupportGroupRole.LEADER);
    }
    
    @Override
    public boolean isGroupIDExists(final String id) {
        return this.getFactionByID(id) != null;
    }
    
    @Override
    public boolean isGroupNameExists(final String name) {
        return this.getFactionByName(name) != null;
    }
    
    @Override
    public boolean isPlayerJoinGroup(final OfflinePlayer player) {
        return this.getPlayerFaction(player) != null;
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id) {
        return this.getOnlinePlayersByGroupID(id, null);
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id, final SupportGroup.SupportGroupRole role) {
        final Faction faction = this.getFactionByID(id);
        return this.getOnlinePlayers(faction, role);
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name) {
        return this.getOnlinePlayersByGroupName(name, null);
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name, final SupportGroup.SupportGroupRole role) {
        final Faction faction = this.getFactionByName(name);
        return this.getOnlinePlayers(faction, role);
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id) {
        return this.getGroupPlayersByID(id, null);
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id, final SupportGroup.SupportGroupRole role) {
        final Faction faction = this.getFactionByID(id);
        return this.getPlayers(faction, role);
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name) {
        return this.getGroupPlayersByName(name, null);
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name, final SupportGroup.SupportGroupRole role) {
        final Faction faction = this.getFactionByName(name);
        return this.getPlayers(faction, role);
    }
    
    @Override
    public String getPlayerGroupID(final OfflinePlayer player) {
        final Faction faction = this.getPlayerFaction(player);
        return (faction != null) ? faction.getId() : null;
    }
    
    @Override
    public String getPlayerGroupName(final OfflinePlayer player) {
        final Faction faction = this.getPlayerFaction(player);
        return (faction != null) ? faction.getName() : null;
    }
    
    public final Collection<Faction> getAllFactions() {
        final FactionColl factionColl = FactionColl.get();
        return (Collection<Faction>)factionColl.getAll();
    }
    
    public final Faction getFactionByID(final String id) {
        final FactionColl factionColl = FactionColl.get();
        if (id != null) {
            final Faction faction = (Faction)factionColl.get((Object)id);
            if (this.isRealFaction(faction)) {
                return faction;
            }
        }
        return null;
    }
    
    public final Faction getFactionByName(final String name) {
        final FactionColl factionColl = FactionColl.get();
        if (name != null) {
            final Faction faction = factionColl.getByName(name);
            if (this.isRealFaction(faction)) {
                return faction;
            }
        }
        return null;
    }
    
    public final Faction getFaction(final String faction) {
        final Faction factionByID = this.getFactionByID(faction);
        final Faction factionByName = this.getFactionByName(faction);
        return (factionByID != null) ? factionByID : factionByName;
    }
    
    public final boolean isFactionIDExists(final String id) {
        return this.getFactionByID(id) != null;
    }
    
    public final boolean isFactionNameExists(final String name) {
        return this.getFactionByName(name) != null;
    }
    
    public final Collection<Player> getOnlinePlayers(final Faction faction) {
        return this.getOnlinePlayers(faction, null);
    }
    
    public final Collection<Player> getOnlinePlayers(final Faction faction, final SupportGroup.SupportGroupRole role) {
        if (faction == null) {
            return new ArrayList<Player>();
        }
        final Collection<Player> onlinePlayers = (Collection<Player>)faction.getOnlinePlayers();
        if (role != null) {
            final Collection<Player> onlineRoles = new ArrayList<Player>();
            for (final Player player : onlinePlayers) {
                final SupportGroup.SupportGroupRole playerRole = this.getPlayerRole((OfflinePlayer)player);
                if (playerRole != null && playerRole.equals(role)) {
                    onlinePlayers.add(player);
                }
            }
            return onlineRoles;
        }
        return onlinePlayers;
    }
    
    public final Collection<OfflinePlayer> getPlayers(final Faction faction) {
        return this.getPlayers(faction, null);
    }
    
    public final Collection<OfflinePlayer> getPlayers(final Faction faction, final SupportGroup.SupportGroupRole role) {
        final Collection<OfflinePlayer> players = new ArrayList<OfflinePlayer>();
        if (faction != null) {
            for (final MPlayer mPlayer : faction.getMPlayers()) {
                final Player player = mPlayer.getPlayer();
                if (player != null) {
                    if (role != null) {
                        final SupportGroup.SupportGroupRole playerRole = this.getPlayerRole((OfflinePlayer)player);
                        if (playerRole == null) {
                            continue;
                        }
                        if (!playerRole.equals(role)) {
                            continue;
                        }
                    }
                    players.add((OfflinePlayer)player);
                }
            }
        }
        return players;
    }
    
    public final Faction getPlayerFaction(final OfflinePlayer player) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final MPlayer fPlayer = MPlayer.get((Object)playerID);
            if (fPlayer != null) {
                final Faction faction = fPlayer.getFaction();
                if (this.isRealFaction(faction)) {
                    return faction;
                }
            }
        }
        return null;
    }
    
    private final boolean isRealFaction(final Faction faction) {
        final FactionColl factionColl = FactionColl.get();
        if (faction != null) {
            final Faction none = factionColl.getNone();
            final Faction safezone = factionColl.getSafezone();
            final Faction warzone = factionColl.getWarzone();
            if (!faction.equals(none) && !faction.equals(safezone) && !faction.equals(warzone)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getTerritoryOwner(final Block block) {
        if (block != null) {
            final Location location = block.getLocation();
            return this.getTerritoryOwner(location);
        }
        return null;
    }
    
    @Override
    public String getTerritoryOwner(final Location location) {
        final BoardColl boardColl = BoardColl.get();
        if (location != null) {
            final PS ps = PS.valueOf(location);
            final Faction faction = boardColl.getFactionAt(ps);
            if (this.isRealFaction(faction)) {
                final String factionId = faction.getId();
                return factionId;
            }
        }
        return null;
    }
    
    @Override
    public boolean hasTerritoryOwner(final Block block) {
        return this.getTerritoryOwner(block) != null;
    }
    
    @Override
    public boolean hasTerritoryOwner(final Location location) {
        return this.getTerritoryOwner(location) != null;
    }
    
    @Override
    public boolean isTerritoryOwner(final Block block, final OfflinePlayer player) {
        if (player != null) {
            final String groupId = this.getPlayerGroupID(player);
            return this.isTerritoryOwner(block, groupId);
        }
        return false;
    }
    
    @Override
    public boolean isTerritoryOwner(final Block block, final String owner) {
        if (block != null && owner != null) {
            final String territoryOwner = this.getTerritoryOwner(block);
            return territoryOwner != null && territoryOwner.equals(owner);
        }
        return false;
    }
    
    @Override
    public boolean isTerritoryOwner(final Location location, final OfflinePlayer player) {
        if (player != null) {
            final String groupId = this.getPlayerGroupID(player);
            return this.isTerritoryOwner(location, groupId);
        }
        return false;
    }
    
    @Override
    public boolean isTerritoryOwner(final Location location, final String owner) {
        if (location != null && owner != null) {
            final String territoryOwner = this.getTerritoryOwner(location);
            return territoryOwner != null && territoryOwner.equals(owner);
        }
        return false;
    }
    
    @Override
    public double getTerritoryPower(final OfflinePlayer player) {
        final Faction faction = this.getPlayerFaction(player);
        return (faction != null) ? faction.getPower() : 0.0;
    }
    
    @Override
    public double getTerritoryPower(final String owner) {
        final Faction faction = this.getFactionByID(owner);
        return (faction != null) ? faction.getPower() : 0.0;
    }
    
    @Override
    public double getTerritoryMaxPower(final OfflinePlayer player) {
        final Faction faction = this.getPlayerFaction(player);
        return (faction != null) ? faction.getPowerMax() : 0.0;
    }
    
    @Override
    public double getTerritoryMaxPower(final String owner) {
        final Faction faction = this.getFactionByID(owner);
        return (faction != null) ? faction.getPowerMax() : 0.0;
    }
    
    @Override
    public double getTerritoryPermanentPower(final OfflinePlayer player) {
        return 0.0;
    }
    
    @Override
    public double getTerritoryPermanentPower(final String owner) {
        return 0.0;
    }
    
    @Override
    public void setTerritoryPermanentPower(final OfflinePlayer player, final double power) {
    }
    
    @Override
    public void setTerritoryPermanentPower(final String owner, final double power) {
    }
    
    @Override
    public double getPlayerPower(final OfflinePlayer player) {
        if (player != null) {
            final UUID playerId = player.getUniqueId();
            final MPlayer mPlayer = MPlayer.get((Object)playerId);
            if (mPlayer != null) {
                return mPlayer.getPower();
            }
        }
        return 0.0;
    }
    
    @Override
    public double getPlayerMaxPower(final OfflinePlayer player) {
        if (player != null) {
            final UUID playerId = player.getUniqueId();
            final MPlayer mPlayer = MPlayer.get((Object)playerId);
            if (mPlayer != null) {
                return mPlayer.getPowerMax();
            }
        }
        return 0.0;
    }
    
    @Override
    public void setPlayerPower(final OfflinePlayer player, final double power) {
        if (player != null) {
            final UUID playerId = player.getUniqueId();
            final MPlayer mPlayer = MPlayer.get((Object)playerId);
            if (mPlayer != null) {
                mPlayer.setPower(Double.valueOf(power));
            }
        }
    }
}
