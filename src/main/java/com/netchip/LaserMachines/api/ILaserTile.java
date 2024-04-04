package com.netchip.LaserMachines.api;

public interface ILaserTile {
    public boolean needsPower();
    public int transferPower(int amountPower);
}
