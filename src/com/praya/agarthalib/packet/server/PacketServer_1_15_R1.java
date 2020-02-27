// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.server;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.utility.MathUtil;
import core.praya.agarthalib.builder.bridge.ServerTools;
import net.minecraft.server.v1_15_R1.MinecraftServer;

public class PacketServer_1_15_R1 extends HandlerPacket implements ServerTools
{
    public PacketServer_1_15_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public double getTPS() {
        final double tps = MathUtil.roundNumber(MinecraftServer.getServer().recentTps[0], 2);
        return MathUtil.limitDouble(tps, 0.0, 20.0);
    }
}
