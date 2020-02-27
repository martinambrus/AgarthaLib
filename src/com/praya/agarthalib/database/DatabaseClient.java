// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.database;

public class DatabaseClient
{
    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;
    
    public DatabaseClient(final String host, final int port, final String database) {
        this(host, port, database, "root", null);
    }
    
    public DatabaseClient(final String host, final int port, final String database, final String username, final String password) {
        if (host == null || database == null || username == null) {
            throw new IllegalArgumentException();
        }
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }
    
    public final String getHost() {
        return this.host;
    }
    
    public final int getPort() {
        return this.port;
    }
    
    public final String getDatabase() {
        return this.database;
    }
    
    public final String getUsername() {
        return this.username;
    }
    
    public final String getPassword() {
        return this.password;
    }
}
