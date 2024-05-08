
package net.samhacker.scg.network;

import net.samhacker.scg.world.inventory.GamemodeMenu;
import net.samhacker.scg.procedures.GmSurvivalProcedure;
import net.samhacker.scg.procedures.GmSpectorProcedure;
import net.samhacker.scg.procedures.GmCreativeProcedure;
import net.samhacker.scg.procedures.GmAdventureProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class GamemodeButtonMessage extends FriendlyByteBuf {
	public GamemodeButtonMessage(int buttonID, int x, int y, int z) {
		super(Unpooled.buffer());
		writeInt(buttonID);
		writeInt(x);
		writeInt(y);
		writeInt(z);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		int buttonID = buf.readInt();
		double x = buf.readInt();
		double y = buf.readInt();
		double z = buf.readInt();
		server.execute(() -> {
			Level world = entity.level();
			HashMap guistate = GamemodeMenu.guistate;
			if (buttonID == 0) {

				GmCreativeProcedure.execute(entity);
			}
			if (buttonID == 1) {

				GmSurvivalProcedure.execute(entity);
			}
			if (buttonID == 2) {

				GmAdventureProcedure.execute(entity);
			}
			if (buttonID == 3) {

				GmSpectorProcedure.execute(entity);
			}
		});
	}
}
