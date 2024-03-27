package com.netchip.LaserMachines.tiles;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import com.netchip.LaserMachines.api.ILaserTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileLaser extends TileEntity implements IEnergyHandler {
    private EnergyStorage storage = new EnergyStorage(20000, 20000, 20000);

    @Override
    public void updateEntity() {
        if(!worldObj.isRemote)
            return;

        if(worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) == null)
            return;
        TileEntity te = worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        if(!(te instanceof ILaserTile))
            return;
        if(((ILaserTile) te).needsPower()) {
            System.out.println(storage.receiveEnergy(((ILaserTile) te).transferPower(storage.extractEnergy(1024, false)), false));
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        storage.readFromNBT(tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        storage.writeToNBT(tag);
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }
}
