// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import net.milkbowl.vault.economy.Economy;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportVault extends Support
{
    private Economy economy;
    
    public SupportVault(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final Economy getEconomy() {
        if (this.economy == null) {
            this.registerService();
        }
        return this.economy;
    }
    
    public final void createAccount(final OfflinePlayer player) {
        if (player != null) {
            final Economy economy = this.getEconomy();
            if (economy != null) {
                economy.createPlayerAccount(player);
            }
        }
    }
    
    public final void createBank(final OfflinePlayer player, final String bank) {
        if (player != null && bank != null) {
            final Economy economy = this.getEconomy();
            if (economy != null) {
                economy.createBank(bank, player);
            }
        }
    }
    
    public final boolean hasAccount(final OfflinePlayer player) {
        final Economy economy = this.getEconomy();
        return player != null && economy != null && economy.hasAccount(player);
    }
    
    public final double getBalance(final OfflinePlayer player) {
        final Economy economy = this.getEconomy();
        return this.hasAccount(player) ? economy.getBalance(player) : 0.0;
    }
    
    public final void addBalance(final OfflinePlayer player, final double money) {
        if (this.hasAccount(player)) {
            final Economy economy = this.getEconomy();
            if (money < 0.0) {
                final double amount = money * -1.0;
                economy.withdrawPlayer(player, amount);
            }
            else {
                final double amount = money * 1.0;
                economy.depositPlayer(player, amount);
            }
        }
    }
    
    public final void remBalance(final OfflinePlayer player, final double money) {
        if (this.hasAccount(player)) {
            final Economy economy = this.getEconomy();
            if (money < 0.0) {
                final double amount = money * -1.0;
                economy.depositPlayer(player, amount);
            }
            else {
                final double amount = money * 1.0;
                economy.withdrawPlayer(player, amount);
            }
        }
    }
    
    private final void registerService() {
        final ServicesManager servicesManager = Bukkit.getServicesManager();
        final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>)servicesManager.getRegistration((Class)Economy.class);
        if (economyProvider != null) {
            this.economy = (Economy)economyProvider.getProvider();
        }
    }
}
