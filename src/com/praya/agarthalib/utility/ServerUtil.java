// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.main.ServerType;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerUtil
{
    private static final VersionNMS VERSION_NMS;
    private static final ServerType SERVER_TYPE;
    
    static {
        VERSION_NMS = VersionNMS.getVersionNMS(getTextVersionNMS());
        SERVER_TYPE = ServerType.getServerType();
    }
    
    public static final VersionNMS getVersionNMS() {
        return ServerUtil.VERSION_NMS;
    }
    
    public static final ServerType getServerType() {
        return ServerUtil.SERVER_TYPE;
    }
    
    public static final String getTextVersionNMS() {
        try {
            return Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public static final String getName() {
        return Bukkit.getName();
    }
    
    public static final String getVersion() {
        return Bukkit.getVersion();
    }
    
    public static final long getFreeRam() {
        return Runtime.getRuntime().freeMemory() / 1048576L;
    }
    
    public static final long getMaxRam() {
        return Runtime.getRuntime().maxMemory() / 1048576L;
    }
    
    public static final long getUsedRam() {
        return getMaxRam() - getFreeRam();
    }
    
    public static final String getIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            return "Local";
        }
    }
    
    public static final double getTPS() {
        return Bridge.getBridgeServer().getTPS();
    }
    
    public static final boolean isEnable(final Plugin plugin) {
        return Bukkit.getPluginManager().isPluginEnabled(plugin);
    }
    
    public static final String getServerFullVersion() {
        final String[] baseVersion = Bukkit.getVersion().split(" ");
        final String fullVersion = baseVersion[baseVersion.length - 1].replace(")", "");
        return fullVersion;
    }
    
    public static final String getServerVersion() {
        final String fullVersion = getServerFullVersion();
        final String[] serverVersion = fullVersion.replace(".", " ").split(" ");
        final String version = String.valueOf(serverVersion[0]) + "." + serverVersion[1];
        return version;
    }
    
    public static final boolean isCompatible(final VersionNMS minReq) {
        return isCompatible(minReq, VersionNMS.V1_15_R1);
    }
    
    public static final boolean isCompatible(final VersionNMS minReq, final VersionNMS maxReq) {
        final int ordinalMin = (minReq != null) ? minReq.ordinal() : 0;
        final int ordinalMax = (maxReq != null) ? maxReq.ordinal() : 0;
        final int ordinalValue = getVersionNMS().ordinal();
        return ordinalValue >= ordinalMin && ordinalValue <= ordinalMax;
    }
    
    public static final boolean isLegacy() {
        return !isCompatible(VersionNMS.V1_13_R2);
    }
    
    public static final boolean isVersion_1_7() {
        switch (getVersionNMS()) {
            case V1_7_R4: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_8() {
        switch (getVersionNMS()) {
            case V1_8_R3: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_9() {
        switch (getVersionNMS()) {
            case V1_9_R2: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_10() {
        switch (getVersionNMS()) {
            case V1_10_R1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_11() {
        switch (getVersionNMS()) {
            case V1_11_R1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_12() {
        switch (getVersionNMS()) {
            case V1_12_R1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final boolean isVersion_1_13() {
        switch (getVersionNMS()) {
            case V1_13_R2: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static final boolean isVersion_1_14() {
        switch (getVersionNMS()) {
            case V1_14_R1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static final boolean isVersion_1_15() {
        switch (getVersionNMS()) {
            case V1_15_R1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Deprecated
    public static final boolean isBanned() {
        return getBannedReason() != null;
    }
    
    @Deprecated
    public static final String getBannedReason() {
        return null;
    }
}
