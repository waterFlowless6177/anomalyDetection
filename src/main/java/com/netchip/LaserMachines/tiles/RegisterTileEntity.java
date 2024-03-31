package com.netchip.LaserMachines.tiles;

import com.netchip.LaserMachines.utils.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntity {
    public static void registerTiles() {
        GameRegistry.registerTileEntity(TileGrinder.class, "tileGrinder");
        GameRegistry.registerTileEntity(TileLaser.class, "tileLaser");
    }
}
