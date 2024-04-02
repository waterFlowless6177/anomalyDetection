package com.netchip.LaserMachines.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock {
    public static final BlockGrinder blockGrinder = new BlockGrinder();
    public static final BlockLaser blockLaser = new BlockLaser();
    public static void registerBlocks() {
        GameRegistry.registerBlock(blockGrinder, "blockGrinder");
        GameRegistry.registerBlock(blockLaser, "blockLaser");
    }
}
