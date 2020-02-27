// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import org.kingdoms.constants.player.OfflineKingdomPlayer;
import com.praya.agarthalib.utility.PlayerUtil;
import java.util.UUID;
import org.kingdoms.constants.player.KingdomPlayer;
import org.kingdoms.manager.game.GameManagement;
import org.bukkit.entity.Player;
import org.bukkit.OfflinePlayer;
import org.kingdoms.constants.kingdom.OfflineKingdom;
import java.util.Iterator;
import java.util.List;
import org.kingdoms.manager.game.KingdomManager;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportKingdoms extends Support implements SupportGroup
{
    public SupportKingdoms(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    @Override
    public Collection<String> getGroupIDs() {
        final List<String> groupIDs = new ArrayList<String>();
        for (final String id : KingdomManager.kingdomList.keySet()) {
            groupIDs.add(id);
        }
        return groupIDs;
    }
    
    @Override
    public Collection<String> getGroupNames() {
        final List<String> groupNames = new ArrayList<String>();
        for (final OfflineKingdom kingdom : this.getAllKingdoms()) {
            final String kingdomName = kingdom.getKingdomName();
            groupNames.add(kingdomName);
        }
        return groupNames;
    }
    
    @Override
    public String getGroupNameByID(final String id) {
        final OfflineKingdom kingdom = this.getKingdomByID(id);
        return (kingdom != null) ? kingdom.getKingdomName() : null;
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
        return this.getKingdomByID(id) != null;
    }
    
    @Override
    public boolean isGroupNameExists(final String name) {
        return this.getKingdomByName(name) != null;
    }
    
    @Override
    public boolean isPlayerJoinGroup(final OfflinePlayer player) {
        return this.getPlayerKingdom(player) != null;
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupID(final String id) {
        final OfflineKingdom kingdom = this.getKingdomByID(id);
        return (kingdom != null) ? this.getOnlinePlayers(kingdom) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<Player> getOnlinePlayersByGroupName(final String name) {
        final OfflineKingdom kingdom = this.getKingdomByName(name);
        return (kingdom != null) ? this.getOnlinePlayers(kingdom) : new ArrayList<Player>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByID(final String id) {
        final OfflineKingdom kingdom = this.getKingdomByID(id);
        return (kingdom != null) ? this.getPlayers(kingdom) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public Collection<OfflinePlayer> getGroupPlayersByName(final String name) {
        final OfflineKingdom kingdom = this.getKingdomByName(name);
        return (kingdom != null) ? this.getPlayers(kingdom) : new ArrayList<OfflinePlayer>();
    }
    
    @Override
    public String getPlayerGroupID(final OfflinePlayer player) {
        final OfflineKingdom kingdom = this.getPlayerKingdom(player);
        if (kingdom != null) {
            final String name = kingdom.getKingdomName();
            return this.getGroupIDByName(name);
        }
        return null;
    }
    
    @Override
    public String getPlayerGroupName(final OfflinePlayer player) {
        final OfflineKingdom kingdom = this.getPlayerKingdom(player);
        return (kingdom != null) ? kingdom.getKingdomName() : null;
    }
    
    public final Collection<String> getKingdomIDs() {
        return (Collection<String>)KingdomManager.kingdomList.keySet();
    }
    
    public final Collection<OfflineKingdom> getAllKingdoms() {
        return KingdomManager.kingdomList.values();
    }
    
    public final OfflineKingdom getKingdomByID(final String id) {
        if (id != null) {
            for (final String key : this.getKingdomIDs()) {
                if (key.equalsIgnoreCase(id)) {
                    return KingdomManager.kingdomList.get(key);
                }
            }
        }
        return null;
    }
    
    public final OfflineKingdom getKingdomByName(final String name) {
        final KingdomManager kingdomManager = GameManagement.getKingdomManager();
        return (name != null) ? kingdomManager.getOfflineKingdom(name) : null;
    }
    
    public final OfflineKingdom getKingdom(final String kingdom) {
        final OfflineKingdom kingdomByID = this.getKingdomByID(kingdom);
        final OfflineKingdom kingdomByName = this.getKingdomByName(kingdom);
        return (kingdomByID != null) ? kingdomByID : kingdomByName;
    }
    
    public final boolean isKingdomIDExists(final String id) {
        return this.getKingdomByID(id) != null;
    }
    
    public final boolean isKingdomNameExists(final String name) {
        return this.getKingdomByName(name) != null;
    }
    
    public final Collection<Player> getOnlinePlayers(final OfflineKingdom kingdom) {
        final Collection<Player> players = new ArrayList<Player>();
        if (kingdom != null) {
            for (final KingdomPlayer kingdomPlayer : kingdom.getKingdom().getOnlineMembers()) {
                final Player player = kingdomPlayer.getPlayer();
                players.add(player);
            }
        }
        return players;
    }
    
    public final Collection<OfflinePlayer> getPlayers(final OfflineKingdom kingdom) {
        final Collection<OfflinePlayer> players = new ArrayList<OfflinePlayer>();
        if (kingdom != null) {
            for (final UUID playerID : kingdom.getMembersList()) {
                final OfflinePlayer player = PlayerUtil.getPlayer(playerID);
                players.add(player);
            }
        }
        return players;
    }
    
    public final OfflineKingdom getPlayerKingdom(final OfflinePlayer player) {
        if (player != null) {
            final OfflineKingdomPlayer kingdomPlayer = GameManagement.getPlayerManager().getOfflineKingdomPlayer(player);
            if (kingdomPlayer != null) {
                final String kingdomName = kingdomPlayer.getKingdomName();
                return this.getKingdomByName(kingdomName);
            }
        }
        return null;
    }
}
