package com.netchip.LaserMachines.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public abstract class AbstractTileBase extends TileEntity implements ISidedInventory {
    private ItemStack[] is = null;
    private String invName = null;

    public AbstractTileBase(String invName, int slots) {
        this.invName = invName;
        is = new ItemStack[slots];
    }

    public abstract int[] getAccessibleSlotsFromSide(int p_94128_1_);
    public abstract boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_);
    public abstract boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_);
    public abstract boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_);

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 3, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public int getSizeInventory() {
        return is.length;
    }

    @Override
    public ItemStack getStackInSlot(int id) {
        return is[id];
    }

    @Override
    public ItemStack decrStackSize(int slotID, int amountItems) {
        ItemStack is = getStackInSlot(slotID);
        if (is == null)
            return null;
        if (is.stackSize > amountItems) {
            ItemStack result = is.splitStack(amountItems);
            markDirty();
            return result;
        }
        ItemStack result = getStackInSlot(slotID);
        setInventorySlotContents(slotID, null);
        return result;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int id) {
        if (id > getSizeInventory())
            return null;
        ItemStack isReturn = is[id];
        setInventorySlotContents(id, null);
        return isReturn;
    }

    @Override
    public void setInventorySlotContents(int id, ItemStack stack) {
        is[id] = stack;
    }

    @Override
    public String getInventoryName() {
        return invName;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }
}

