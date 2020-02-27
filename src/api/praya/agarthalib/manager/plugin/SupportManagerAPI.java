// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.manager.plugin;

import api.praya.agarthalib.builder.support.main.SupportClass;
import api.praya.agarthalib.builder.support.main.SupportLevel;
import api.praya.agarthalib.builder.support.main.SupportTerritory;
import api.praya.agarthalib.builder.support.main.SupportGroup;
import api.praya.agarthalib.builder.support.main.SupportFactions;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.PluginUtil;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.SupportFactionsMassive;
import api.praya.agarthalib.builder.support.SupportFactionsUUID;
import api.praya.agarthalib.builder.support.SupportFactionsLegacy;
import api.praya.agarthalib.builder.support.SupportSimpleClans;
import api.praya.agarthalib.builder.support.SupportTowny;
import api.praya.agarthalib.builder.support.SupportGangs;
import api.praya.agarthalib.builder.support.SupportKingdoms;
import api.praya.agarthalib.builder.support.SupportLangUtils;
import api.praya.agarthalib.builder.support.SupportBattleLevels;
import api.praya.agarthalib.builder.support.SupportLifeEssence;
import api.praya.agarthalib.builder.support.SupportCombatStamina;
import api.praya.agarthalib.builder.support.SupportMyItems;
import api.praya.agarthalib.builder.support.SupportJobsReborn;
import api.praya.agarthalib.builder.support.SupportMcMMO;
import api.praya.agarthalib.builder.support.SupportMythicMobs;
import api.praya.agarthalib.builder.support.SupportHeroes;
import api.praya.agarthalib.builder.support.SupportSkillsPro;
import api.praya.agarthalib.builder.support.SupportSkillAPI;
import api.praya.agarthalib.builder.support.SupportFeatherBoard;
import api.praya.agarthalib.builder.support.SupportHolographicDisplays;
import api.praya.agarthalib.builder.support.SupportCitizens;
import api.praya.agarthalib.builder.support.SupportEssentials;
import api.praya.agarthalib.builder.support.SupportWorldGuard;
import api.praya.agarthalib.builder.support.SupportMVdWPlaceholderAPI;
import api.praya.agarthalib.builder.support.SupportPlaceholderAPI;
import api.praya.agarthalib.builder.support.SupportVault;
import com.praya.agarthalib.handler.HandlerManager;

public class SupportManagerAPI extends HandlerManager
{
    private SupportVault supportVault;
    private SupportPlaceholderAPI supportPlaceholderAPI;
    private SupportMVdWPlaceholderAPI supportMVdWPlaceholderAPI;
    private SupportWorldGuard supportWorldGuard;
    private SupportEssentials supportEssentials;
    private SupportCitizens supportCitizens;
    private SupportHolographicDisplays supportHolographicDisplay;
    private SupportFeatherBoard supportFeatherBoard;
    private SupportSkillAPI supportSkillAPI;
    private SupportSkillsPro supportSkillsPro;
    private SupportHeroes supportHeroes;
    private SupportMythicMobs supportMythicMobs;
    private SupportMcMMO supportMcMMO;
    private SupportJobsReborn supportJobsReborn;
    private SupportMyItems supportMyItems;
    private SupportCombatStamina supportCombatStamina;
    private SupportLifeEssence supportLifeEssence;
    private SupportBattleLevels supportBattleLevels;
    private SupportLangUtils supportLangUtils;
    private SupportKingdoms supportKingdoms;
    private SupportGangs supportGangs;
    private SupportTowny supportTowny;
    private SupportSimpleClans supportSimpleClans;
    private SupportFactionsLegacy supportFactionsLegacy;
    private SupportFactionsUUID supportFactionsUUID;
    private SupportFactionsMassive supportFactionsMassive;
    
    public SupportManagerAPI(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public final SupportVault getSupportVault() {
        if (this.supportVault == null) {
            final Plugin source = PluginUtil.getPlugin("Vault");
            if (source != null && source.isEnabled()) {
                this.supportVault = new SupportVault(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportVault.getSource();
            if (!source.isEnabled()) {
                this.supportVault = null;
            }
        }
        return this.supportVault;
    }
    
    public final SupportPlaceholderAPI getSupportPlaceholderAPI() {
        if (this.supportPlaceholderAPI == null) {
            final Plugin source = PluginUtil.getPlugin("PlaceholderAPI");
            if (source != null && source.isEnabled()) {
                this.supportPlaceholderAPI = new SupportPlaceholderAPI(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportPlaceholderAPI.getSource();
            if (!source.isEnabled()) {
                this.supportPlaceholderAPI = null;
            }
        }
        return this.supportPlaceholderAPI;
    }
    
    public final SupportMVdWPlaceholderAPI getSupportMVdWPlaceholderAPI() {
        if (this.supportMVdWPlaceholderAPI == null) {
            final Plugin source = PluginUtil.getPlugin("MVdWPlaceholderAPI");
            if (source != null && source.isEnabled()) {
                this.supportMVdWPlaceholderAPI = new SupportMVdWPlaceholderAPI(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportMVdWPlaceholderAPI.getSource();
            if (!source.isEnabled()) {
                this.supportMVdWPlaceholderAPI = null;
            }
        }
        return this.supportMVdWPlaceholderAPI;
    }
    
    public final SupportWorldGuard getSupportWorldGuard() {
        if (this.supportWorldGuard == null) {
            final Plugin source = PluginUtil.getPlugin("WorldGuard");
            if (source != null && source.isEnabled()) {
                this.supportWorldGuard = new SupportWorldGuard(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportWorldGuard.getSource();
            if (!source.isEnabled()) {
                this.supportWorldGuard = null;
            }
        }
        return this.supportWorldGuard;
    }
    
    public final SupportEssentials getSupportEssentials() {
        if (this.supportEssentials == null) {
            final Plugin source = PluginUtil.getPlugin("Essentials");
            if (source != null && source.isEnabled()) {
                this.supportEssentials = new SupportEssentials(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportEssentials.getSource();
            if (!source.isEnabled()) {
                this.supportEssentials = null;
            }
        }
        return this.supportEssentials;
    }
    
    public final SupportCitizens getSupportCitizens() {
        if (this.supportCitizens == null) {
            final Plugin source = PluginUtil.getPlugin("Citizens");
            if (source != null && source.isEnabled()) {
                this.supportCitizens = new SupportCitizens(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportCitizens.getSource();
            if (!source.isEnabled()) {
                this.supportCitizens = null;
            }
        }
        return this.supportCitizens;
    }
    
    public final SupportHolographicDisplays getSupportHolographicDisplays() {
        if (this.supportHolographicDisplay == null) {
            final Plugin source = PluginUtil.getPlugin("HolographicDisplays");
            if (source != null && source.isEnabled()) {
                this.supportHolographicDisplay = new SupportHolographicDisplays(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportHolographicDisplay.getSource();
            if (!source.isEnabled()) {
                this.supportHolographicDisplay = null;
            }
        }
        return this.supportHolographicDisplay;
    }
    
    public final SupportFeatherBoard getSupportFeatherBoard() {
        if (this.supportFeatherBoard == null) {
            final Plugin source = PluginUtil.getPlugin("FeatherBoard");
            if (source != null && source.isEnabled()) {
                this.supportFeatherBoard = new SupportFeatherBoard(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportFeatherBoard.getSource();
            if (!source.isEnabled()) {
                this.supportFeatherBoard = null;
            }
        }
        return this.supportFeatherBoard;
    }
    
    public final SupportSkillAPI getSupportSkillAPI() {
        if (this.supportSkillAPI == null) {
            final Plugin source = PluginUtil.getPlugin("SkillAPI");
            if (source != null && source.isEnabled()) {
                this.supportSkillAPI = new SupportSkillAPI(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportSkillAPI.getSource();
            if (!source.isEnabled()) {
                this.supportSkillAPI = null;
            }
        }
        return this.supportSkillAPI;
    }
    
    public final SupportSkillsPro getSupportSkillsPro() {
        if (this.supportSkillsPro == null) {
            final Plugin source = PluginUtil.getPlugin("Skills");
            if (source != null && source.isEnabled()) {
                this.supportSkillsPro = new SupportSkillsPro(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportSkillsPro.getSource();
            if (!source.isEnabled()) {
                this.supportSkillsPro = null;
            }
        }
        return this.supportSkillsPro;
    }
    
    public final SupportHeroes getSupportHeroes() {
        if (this.supportHeroes == null) {
            final Plugin source = PluginUtil.getPlugin("Heroes");
            if (source != null && source.isEnabled()) {
                this.supportHeroes = new SupportHeroes(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportHeroes.getSource();
            if (!source.isEnabled()) {
                this.supportHeroes = null;
            }
        }
        return this.supportHeroes;
    }
    
    public final SupportMythicMobs getSupportMythicMobs() {
        if (this.supportMythicMobs == null) {
            final Plugin source = PluginUtil.getPlugin("MythicMobs");
            if (source != null && source.isEnabled()) {
                this.supportMythicMobs = new SupportMythicMobs(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportMythicMobs.getSource();
            if (!source.isEnabled()) {
                this.supportMythicMobs = null;
            }
        }
        return this.supportMythicMobs;
    }
    
    public final SupportMcMMO getSupportMcMMO() {
        if (this.supportMcMMO == null) {
            final Plugin source = PluginUtil.getPlugin("mcMMO");
            if (source != null && source.isEnabled()) {
                this.supportMcMMO = new SupportMcMMO(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportMcMMO.getSource();
            if (!source.isEnabled()) {
                this.supportMcMMO = null;
            }
        }
        return this.supportMcMMO;
    }
    
    public final SupportJobsReborn getSupportJobsReborn() {
        if (this.supportJobsReborn == null) {
            final Plugin source = PluginUtil.getPlugin("Jobs");
            if (source != null && source.isEnabled()) {
                this.supportJobsReborn = new SupportJobsReborn(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportJobsReborn.getSource();
            if (!source.isEnabled()) {
                this.supportJobsReborn = null;
            }
        }
        return this.supportJobsReborn;
    }
    
    public final SupportMyItems getSupportMyItems() {
        if (this.supportMyItems == null) {
            final Plugin source = PluginUtil.getPlugin("MyItems");
            if (source != null && source.isEnabled()) {
                this.supportMyItems = new SupportMyItems(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportMyItems.getSource();
            if (!source.isEnabled()) {
                this.supportMyItems = null;
            }
        }
        return this.supportMyItems;
    }
    
    public final SupportCombatStamina getSupportCombatStamina() {
        if (this.supportCombatStamina == null) {
            final Plugin source = PluginUtil.getPlugin("CombatStamina");
            if (source != null && source.isEnabled()) {
                this.supportCombatStamina = new SupportCombatStamina(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportCombatStamina.getSource();
            if (!source.isEnabled()) {
                this.supportCombatStamina = null;
            }
        }
        return this.supportCombatStamina;
    }
    
    public final SupportLifeEssence getSupportLifeEssence() {
        if (this.supportLifeEssence == null) {
            final Plugin source = PluginUtil.getPlugin("LifeEssence");
            if (source != null && source.isEnabled()) {
                this.supportLifeEssence = new SupportLifeEssence(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportLifeEssence.getSource();
            if (!source.isEnabled()) {
                this.supportLifeEssence = null;
            }
        }
        return this.supportLifeEssence;
    }
    
    public final SupportBattleLevels getSupportBattleLevels() {
        if (this.supportBattleLevels == null) {
            final Plugin source = PluginUtil.getPlugin("BattleLevels");
            if (source != null && source.isEnabled()) {
                this.supportBattleLevels = new SupportBattleLevels(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportBattleLevels.getSource();
            if (!source.isEnabled()) {
                this.supportBattleLevels = null;
            }
        }
        return this.supportBattleLevels;
    }
    
    public final SupportLangUtils getSupportLangUtils() {
        if (this.supportLangUtils == null) {
            final Plugin source = PluginUtil.getPlugin("LangUtils");
            if (source != null && source.isEnabled()) {
                this.supportLangUtils = new SupportLangUtils(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportLangUtils.getSource();
            if (!source.isEnabled()) {
                this.supportLangUtils = null;
            }
        }
        return this.supportLangUtils;
    }
    
    public final SupportKingdoms getSupportKingdoms() {
        if (this.supportKingdoms == null) {
            final Plugin source = PluginUtil.getPlugin("Kingdoms");
            if (source != null && source.isEnabled()) {
                this.supportKingdoms = new SupportKingdoms(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportKingdoms.getSource();
            if (!source.isEnabled()) {
                this.supportKingdoms = null;
            }
        }
        return this.supportKingdoms;
    }
    
    public final SupportGangs getSupportGangs() {
        if (this.supportGangs == null) {
            final Plugin source = PluginUtil.getPlugin("GangsPlus");
            if (source != null && source.isEnabled()) {
                this.supportGangs = new SupportGangs(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportGangs.getSource();
            if (!source.isEnabled()) {
                this.supportGangs = null;
            }
        }
        return this.supportGangs;
    }
    
    public final SupportTowny getSupportTowny() {
        if (this.supportTowny == null) {
            final Plugin source = PluginUtil.getPlugin("Towny");
            if (source != null && source.isEnabled()) {
                this.supportTowny = new SupportTowny(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportTowny.getSource();
            if (!source.isEnabled()) {
                this.supportTowny = null;
            }
        }
        return this.supportTowny;
    }
    
    public final SupportSimpleClans getSupportSimpleClans() {
        if (this.supportSimpleClans == null) {
            final Plugin source = PluginUtil.getPlugin("SimpleClans");
            if (source != null && source.isEnabled()) {
                this.supportSimpleClans = new SupportSimpleClans(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportSimpleClans.getSource();
            if (!source.isEnabled()) {
                this.supportSimpleClans = null;
            }
        }
        return this.supportSimpleClans;
    }
    
    public final SupportFactionsLegacy getSupportFactionsLegacy() {
        if (this.supportFactionsLegacy == null) {
            final Plugin source = PluginUtil.getPlugin("LegacyFactions");
            if (source != null && source.isEnabled()) {
                this.supportFactionsLegacy = new SupportFactionsLegacy(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportFactionsLegacy.getSource();
            if (!source.isEnabled()) {
                this.supportFactionsLegacy = null;
            }
        }
        return this.supportFactionsLegacy;
    }
    
    public final SupportFactionsUUID getSupportFactionsUUID() {
        if (this.supportFactionsUUID == null) {
            final Plugin source = PluginUtil.getPlugin("Factions", "drtshock");
            if (source != null && source.isEnabled()) {
                this.supportFactionsUUID = new SupportFactionsUUID(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportFactionsUUID.getSource();
            if (!source.isEnabled()) {
                this.supportFactionsUUID = null;
            }
        }
        return this.supportFactionsUUID;
    }
    
    public final SupportFactionsMassive getSupportFactionsMassive() {
        if (this.supportFactionsMassive == null) {
            final Plugin source = PluginUtil.getPlugin("Factions", "Cayorion");
            if (source != null && source.isEnabled()) {
                this.supportFactionsMassive = new SupportFactionsMassive(this.plugin, source);
            }
        }
        else {
            final Plugin source = this.supportFactionsMassive.getSource();
            if (!source.isEnabled()) {
                this.supportFactionsMassive = null;
            }
        }
        return this.supportFactionsMassive;
    }
    
    public final SupportFactions getSupportFactions() {
        SupportFactions.SupportFactionsType[] values;
        for (int length = (values = SupportFactions.SupportFactionsType.values()).length, i = 0; i < length; ++i) {
            final SupportFactions.SupportFactionsType factionsType = values[i];
            final SupportFactions supportFactions = this.getSupportFactions(factionsType);
            if (supportFactions != null) {
                return supportFactions;
            }
        }
        return null;
    }
    
    public final SupportFactions getSupportFactions(final SupportFactions.SupportFactionsType factionsType) {
        switch (factionsType) {
            case FACTIONS_LEGACY: {
                return this.getSupportFactionsLegacy();
            }
            case FACTIONS_MASSIVE: {
                return this.getSupportFactionsMassive();
            }
            case FACTIONS_UUID: {
                return this.getSupportFactionsUUID();
            }
            default: {
                return null;
            }
        }
    }
    
    public final SupportGroup getSupportGroup() {
        SupportGroup.SupportGroupType[] values;
        for (int length = (values = SupportGroup.SupportGroupType.values()).length, i = 0; i < length; ++i) {
            final SupportGroup.SupportGroupType groupType = values[i];
            final SupportGroup supportGroup = this.getSupportGroup(groupType);
            if (supportGroup != null) {
                return supportGroup;
            }
        }
        return null;
    }
    
    public final SupportGroup getSupportGroup(final SupportGroup.SupportGroupType groupType) {
        switch (groupType) {
            case FACTIONS: {
                return this.getSupportFactions();
            }
            case KINGDOMS: {
                return this.getSupportKingdoms();
            }
            case GANGS: {
                return this.getSupportGangs();
            }
            case TOWNY: {
                return this.getSupportTowny();
            }
            case SIMPLE_CLANS: {
                return this.getSupportSimpleClans();
            }
            default: {
                return null;
            }
        }
    }
    
    public final SupportTerritory getSupportTerritory() {
        SupportTerritory.SupportTerritoryType[] values;
        for (int length = (values = SupportTerritory.SupportTerritoryType.values()).length, i = 0; i < length; ++i) {
            final SupportTerritory.SupportTerritoryType groupType = values[i];
            final SupportTerritory supportGroup = this.getSupportTerritory(groupType);
            if (supportGroup != null) {
                return supportGroup;
            }
        }
        return null;
    }
    
    public final SupportTerritory getSupportTerritory(final SupportTerritory.SupportTerritoryType groupType) {
        switch (groupType) {
            case FACTIONS: {
                return this.getSupportFactions();
            }
            default: {
                return null;
            }
        }
    }
    
    public final SupportLevel getSupportLevel() {
        SupportLevel.SupportLevelType[] values;
        for (int length = (values = SupportLevel.SupportLevelType.values()).length, i = 0; i < length; ++i) {
            final SupportLevel.SupportLevelType levelType = values[i];
            final SupportLevel supportLevel = this.getSupportLevel(levelType);
            if (supportLevel != null) {
                return supportLevel;
            }
        }
        return null;
    }
    
    public final SupportLevel getSupportLevel(final SupportLevel.SupportLevelType levelType) {
        switch (levelType) {
            case BATTLE_LEVELS: {
                return this.getSupportBattleLevels();
            }
            case SKILL_API: {
                return this.getSupportSkillAPI();
            }
            case SKILLS_PRO: {
                return this.getSupportSkillsPro();
            }
            case HEROES: {
                return this.getSupportHeroes();
            }
            default: {
                return null;
            }
        }
    }
    
    public final SupportClass getSupportClass() {
        SupportClass.SupportClassType[] values;
        for (int length = (values = SupportClass.SupportClassType.values()).length, i = 0; i < length; ++i) {
            final SupportClass.SupportClassType classType = values[i];
            final SupportClass supportClass = this.getSupportClass(classType);
            if (supportClass != null) {
                return supportClass;
            }
        }
        return null;
    }
    
    public final SupportClass getSupportClass(final SupportClass.SupportClassType classType) {
        switch (classType) {
            case SKILL_API: {
                return this.getSupportSkillAPI();
            }
            case SKILLS_PRO: {
                return this.getSupportSkillsPro();
            }
            case HEROES: {
                return this.getSupportHeroes();
            }
            default: {
                return null;
            }
        }
    }
    
    public final boolean isSupportVault() {
        return this.getSupportVault() != null;
    }
    
    public final boolean isSupportPlaceholderAPI() {
        return this.getSupportPlaceholderAPI() != null;
    }
    
    public final boolean isSupportMVdWPlaceholder() {
        return this.getSupportMVdWPlaceholderAPI() != null;
    }
    
    public final boolean isSupportWorldGuard() {
        return this.getSupportWorldGuard() != null;
    }
    
    public final boolean isSupportEssentials() {
        return this.getSupportEssentials() != null;
    }
    
    public final boolean isSupportCitizens() {
        return this.getSupportCitizens() != null;
    }
    
    public final boolean isSupportHolographicDisplay() {
        return this.getSupportHolographicDisplays() != null;
    }
    
    public final boolean isSupportFeatherBoard() {
        return this.getSupportFeatherBoard() != null;
    }
    
    public final boolean isSupportSkillAPI() {
        return this.getSupportSkillAPI() != null;
    }
    
    public final boolean isSupportSkillsPro() {
        return this.getSupportSkillsPro() != null;
    }
    
    public final boolean isSupportHeroes() {
        return this.getSupportHeroes() != null;
    }
    
    public final boolean isSupportMythicMobs() {
        return this.getSupportMythicMobs() != null;
    }
    
    public final boolean isSupportMcMMO() {
        return this.getSupportMcMMO() != null;
    }
    
    public final boolean isSupportJobsReborn() {
        return this.getSupportJobsReborn() != null;
    }
    
    public final boolean isSupportMyItems() {
        return this.getSupportMyItems() != null;
    }
    
    public final boolean isSupportCombatStamina() {
        return this.getSupportCombatStamina() != null;
    }
    
    public final boolean isSupportLifeEssence() {
        return this.getSupportLifeEssence() != null;
    }
    
    public final boolean isSupportBattleLevels() {
        return this.getSupportBattleLevels() != null;
    }
    
    public final boolean isSupportLangUtils() {
        return this.getSupportLangUtils() != null;
    }
    
    public final boolean isSupportKingdoms() {
        return this.getSupportKingdoms() != null;
    }
    
    public final boolean isSupportGangs() {
        return this.getSupportGangs() != null;
    }
    
    public final boolean isSupportTowny() {
        return this.getSupportTowny() != null;
    }
    
    public final boolean isSupportSimpleClans() {
        return this.getSupportSimpleClans() != null;
    }
    
    public final boolean isSupportFactionsLegacy() {
        return this.getSupportFactionsLegacy() != null;
    }
    
    public final boolean isSupportFactionsUUID() {
        return this.getSupportFactionsUUID() != null;
    }
    
    public final boolean isSupportFactionsMassive() {
        return this.getSupportFactionsMassive() != null;
    }
    
    public final boolean isSupportFactions() {
        return this.getSupportFactions() != null;
    }
    
    public final boolean isSupportGroups() {
        return this.getSupportGroup() != null;
    }
    
    public final boolean isSupportLevel() {
        return this.getSupportLevel() != null;
    }
    
    public final boolean isSupportClass() {
        return this.getSupportClass() != null;
    }
    
    @Deprecated
    public final boolean isHookVault() {
        return this.getSupportVault() != null;
    }
    
    @Deprecated
    public final boolean isHookPlaceholderAPI() {
        return this.getSupportPlaceholderAPI() != null;
    }
    
    @Deprecated
    public final boolean isHookMVDWPlaceholder() {
        return this.getSupportMVdWPlaceholderAPI() != null;
    }
    
    @Deprecated
    public final boolean isHookWorldGuard() {
        return this.getSupportWorldGuard() != null;
    }
    
    @Deprecated
    public final boolean isHookHolographicDisplay() {
        return this.getSupportHolographicDisplays() != null;
    }
    
    @Deprecated
    public final boolean isHookSkillAPI() {
        return this.getSupportSkillAPI() != null;
    }
    
    @Deprecated
    public final boolean isHookMythicMobs() {
        return this.getSupportMythicMobs() != null;
    }
    
    @Deprecated
    public final boolean isHookMcMMO() {
        return this.getSupportMcMMO() != null;
    }
    
    @Deprecated
    public final boolean isHookJobsReborn() {
        return this.getSupportJobsReborn() != null;
    }
    
    @Deprecated
    public final boolean isHookKingdoms() {
        return this.getSupportKingdoms() != null;
    }
    
    @Deprecated
    public final boolean isHookFactionsLegacy() {
        return this.getSupportFactionsLegacy() != null;
    }
    
    @Deprecated
    public final boolean isHookFactionsUUID() {
        return this.getSupportFactionsUUID() != null;
    }
    
    @Deprecated
    public final boolean isHookFactionsMassive() {
        return this.getSupportFactionsMassive() != null;
    }
    
    @Deprecated
    public final boolean isHookFactions() {
        return this.getSupportFactions() != null;
    }
    
    @Deprecated
    public final boolean isHookGroups() {
        return this.getSupportGroup() != null;
    }
}
