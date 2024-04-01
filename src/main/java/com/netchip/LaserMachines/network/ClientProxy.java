package com.netchip.LaserMachines.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

public class ClientProxy extends CommonProxy {
    @Override
    public WorldClient getClientWorld() {
        return Minecraft.getMinecraft().theWorld;
    }
}
