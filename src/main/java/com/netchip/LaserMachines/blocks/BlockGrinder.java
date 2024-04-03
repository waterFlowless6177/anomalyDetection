package com.netchip.LaserMachines.blocks;

import com.netchip.LaserMachines.tiles.TileGrinder;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGrinder extends BlockContainer {
    protected BlockGrinder() {
        super(Material.piston);
        this.setStepSound(soundTypePiston);
        this.setBlockName("blockGrinder");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileGrinder();
    }
}
