package com.netchip.LaserMachines.network;

import net.minecraft.client.multiplayer.WorldClient;

public class CommonProxy {
    public WorldClient getClientWorld() throws RuntimeException {
        throw new RuntimeException("Only for the client.");
    }
}
