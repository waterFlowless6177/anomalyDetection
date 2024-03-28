package com.netchip.LaserMachines.tiles;

import net.minecraft.item.ItemStack;

public class TileGrinder extends TileLaserPowered {
    public TileGrinder() {
        super("tileGrinder", 3, 50000);
    }

    @Override
    protected void doWork() {

    }

    @Override
    protected int getDrainTick() {
        //System.out.println(es.getEnergyStored());
        return 0;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }

    @Override
    public int transferPower(int amountPower) {
        System.out.println(amountPower);
        int received = es.receiveEnergy(amountPower, false);
        return amountPower - received;
    }
}
