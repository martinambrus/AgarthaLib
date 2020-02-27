// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.Location;
import org.bukkit.World;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportCitizens extends Support
{
    public SupportCitizens(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final Iterable<NPCRegistry> getNPCRegistries() {
        return (Iterable<NPCRegistry>)CitizensAPI.getNPCRegistries();
    }
    
    public final Iterable<NPC> getAllNPCByRegister(final String npcRegistry) {
        final NPCRegistry registry = (npcRegistry != null) ? CitizensAPI.getNamedNPCRegistry(npcRegistry) : null;
        return (registry != null) ? registry.sorted() : new ArrayList<NPC>();
    }
    
    public final Iterable<NPC> getAllNPCByRegister(final NPCRegistry registry) {
        return (registry != null) ? registry.sorted() : new ArrayList<NPC>();
    }
    
    public final Collection<NPC> getAllNPC() {
        final Collection<NPC> npcs = new ArrayList<NPC>();
        for (final NPCRegistry registry : this.getNPCRegistries()) {
            for (final NPC npc : registry.sorted()) {
                npcs.add(npc);
            }
        }
        return npcs;
    }
    
    public final Collection<NPC> getAllNPC(final World world) {
        final Collection<NPC> npcs = new ArrayList<NPC>();
        if (world != null) {
            for (final NPC npc : this.getAllNPC()) {
                final Location npcLocation = npc.getStoredLocation();
                final World npcWorld = npcLocation.getWorld();
                if (npcWorld.equals(world)) {
                    npcs.add(npc);
                }
            }
        }
        return npcs;
    }
    
    public final Collection<Entity> getAllNPCEntity() {
        final Collection<Entity> entities = new ArrayList<Entity>();
        for (final NPC npc : this.getAllNPC()) {
            final Entity entity = npc.getEntity();
            if (entity != null) {
                entities.add(entity);
            }
        }
        return entities;
    }
    
    public final Collection<Entity> getAllNPCEntity(final World world) {
        final Collection<Entity> entities = new ArrayList<Entity>();
        if (world != null) {
            for (final Entity entity : this.getAllNPCEntity()) {
                final World worldEntity = entity.getWorld();
                if (worldEntity.equals(world)) {
                    entities.add(entity);
                }
            }
        }
        return entities;
    }
    
    public final NPC getNPCByUUID(final UUID uuid) {
        if (uuid != null) {
            for (final NPC npc : this.getAllNPC()) {
                final UUID npcID = npc.getUniqueId();
                if (npcID.equals(uuid)) {
                    return npc;
                }
            }
        }
        return null;
    }
    
    public final NPC getNPCByEntityUUID(final UUID uuid) {
        if (uuid != null) {
            for (final NPC npc : this.getAllNPC()) {
                final Entity entity = npc.getEntity();
                if (entity != null) {
                    final UUID entityUUID = entity.getUniqueId();
                    if (entityUUID.equals(uuid)) {
                        return npc;
                    }
                    continue;
                }
            }
        }
        return null;
    }
    
    public final boolean isNPCExists(final UUID uuid) {
        return this.getNPCByUUID(uuid) != null;
    }
    
    public final boolean isNPCEntityExists(final UUID uuid) {
        return this.getNPCByEntityUUID(uuid) != null;
    }
}
