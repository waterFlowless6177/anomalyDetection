package com.netchip.LaserMachines;

import akka.io.Tcp;
import com.netchip.LaserMachines.blocks.RegisterBlock;
import com.netchip.LaserMachines.network.CommonProxy;
import com.netchip.LaserMachines.network.MessageGrinder;
import com.netchip.LaserMachines.tiles.RegisterTileEntity;
import com.netchip.LaserMachines.utils.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Constants.MODID, version = Constants.VERSION)
public class LaserMachines {
    @SidedProxy(clientSide="com.netchip.LaserMachines.network.ClientProxy", serverSide="com.netchip.LaserMachines.network.CommonProxy")
    public static CommonProxy proxy;

    public static final SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RegisterTileEntity.registerTiles();
        RegisterBlock.registerBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        networkWrapper.registerMessage(MessageGrinder.Handler.class, MessageGrinder.class, 0, Side.SERVER);
    }
}
