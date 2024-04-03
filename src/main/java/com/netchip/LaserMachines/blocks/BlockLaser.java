package com.netchip.LaserMachines.blocks;

import com.netchip.LaserMachines.tiles.TileLaser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLaser extends BlockContainer {
    protected BlockLaser() {
        super(Material.piston);
        this.setStepSound(soundTypePiston);
        this.setBlockName("blockLaser");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileLaser();
    }
}
