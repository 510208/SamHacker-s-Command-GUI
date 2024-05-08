
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.samhacker.scg.init;

import net.samhacker.scg.network.ShowGMMessage;
import net.samhacker.scg.SamhackersCommandGuiMod;

import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class SamhackersCommandGuiModKeyMappingsServer {
	public static void serverLoad() {
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(SamhackersCommandGuiMod.MODID, "show_gm"), ShowGMMessage::apply);
	}
}
