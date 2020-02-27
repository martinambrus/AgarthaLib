// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.block;

public enum BlockChainStatus
{
    MATCH("MATCH", 0), 
    NOT_MATCH("NOT_MATCH", 1), 
    LEAK("LEAK", 2), 
    LIMIT("LIMIT", 3);
    
    private BlockChainStatus(final String name, final int ordinal) {
    }
    
    public static final BlockChainStatus getBlockChainStatus(final String status) {
        if (status != null) {
            BlockChainStatus[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final BlockChainStatus key = values[i];
                if (key.toString().equalsIgnoreCase(status)) {
                    return key;
                }
            }
        }
        return null;
    }
}
