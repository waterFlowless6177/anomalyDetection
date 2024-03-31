package com.netchip.LaserMachines.network;

import com.netchip.LaserMachines.LaserMachines;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageGrinder implements IMessage {
    int x, y , z;

    public MessageGrinder(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    public static class Handler implements IMessageHandler<MessageGrinder, IMessage> {
        @Override
        public IMessage onMessage(MessageGrinder message, MessageContext ctx) {
            TileEntity te = LaserMachines.proxy.getClientWorld().getTileEntity(message.x, message.y, message.z);
            return null;
        }
    }
}
