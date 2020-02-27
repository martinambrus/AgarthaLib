// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.server;

import com.praya.agarthalib.utility.MathUtil;
import net.minecraft.server.v1_13_R2.MinecraftServer;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.ServerTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketServer_1_13_R2 extends HandlerPacket implements ServerTools
{
    public PacketServer_1_13_R2(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public double getTPS() {
        final double tps = MathUtil.roundNumber(MinecraftServer.getServer().recentTps[0], 2);
        return MathUtil.limitDouble(tps, 0.0, 20.0);
    }
}
