package com.netchip.LaserMachines.tiles;

import cofh.api.energy.EnergyStorage;
import com.netchip.LaserMachines.api.ILaserTile;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public abstract class TileLaserPowered extends AbstractTileBase implements ILaserTile {
    public EnergyStorage es = null;

    public TileLaserPowered(String invName, int slots, int maxRFStorage) {
        super(invName, slots);
        es = new EnergyStorage(maxRFStorage);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if(getDrainTick() == 0)
            return;
        if (es.getEnergyStored() < getDrainTick())
            return;
        es.extractEnergy(getDrainTick(), false);
        doWork();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        es.writeToNBT(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        es.readFromNBT(tag);
    }

    protected abstract void doWork();
    protected abstract int getDrainTick();

    public abstract int[] getAccessibleSlotsFromSide(int p_94128_1_);
    public abstract boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_);
    public abstract boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_);
    public abstract boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_);

    @Override
    public boolean needsPower() {
        return true;
    }

    @Override
    public abstract int transferPower(int amountPower);

    protected EnergyStorage getEnergyStorage() {
        return es;
    }
}
