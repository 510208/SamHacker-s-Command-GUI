
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.samhacker.scg.init;

import org.lwjgl.glfw.GLFW;

import net.samhacker.scg.network.ShowGMMessage;
import net.samhacker.scg.SamhackersCommandGuiMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.KeyMapping;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import com.mojang.blaze3d.platform.InputConstants;

public class SamhackersCommandGuiModKeyMappings {
	public static class SamhackersCommandGuiModKeyMapping extends KeyMapping {
		private boolean isDownOld;

		public SamhackersCommandGuiModKeyMapping(String string, int i, String string2) {
			super(string, InputConstants.Type.KEYSYM, i, string2);
		}

		public int action() {
			if (isDownOld != isDown() && isDown()) {
				isDownOld = isDown();
				return 1;
			} else if (isDownOld != isDown() && !isDown()) {
				isDownOld = isDown();
				return 2;
			}
			isDownOld = isDown();
			return 0;
		}
	}

	public static SamhackersCommandGuiModKeyMapping SHOW_GM = (SamhackersCommandGuiModKeyMapping) KeyBindingHelper
			.registerKeyBinding(new SamhackersCommandGuiModKeyMapping("key.samhackers_command_gui.show_gm", GLFW.GLFW_KEY_G, "key.categories.open_gamemode"));

	public static void load() {
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			int SHOW_GMaction = SHOW_GM.action();
			if (SHOW_GMaction == 1) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "show_gm"), new ShowGMMessage(true, false));
			} else if (SHOW_GMaction == 2) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "show_gm"), new ShowGMMessage(false, true));
			}
		});
	}
}
