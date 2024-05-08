
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.samhacker.scg.init;

import net.samhacker.scg.world.inventory.GamemodeMenu;
import net.samhacker.scg.SamhackersCommandGuiMod;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class SamhackersCommandGuiModMenus {
	public static MenuType<GamemodeMenu> GM_GUI;

	public static void load() {
		GM_GUI = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(SamhackersCommandGuiMod.MODID, "gm_gui"), new ExtendedScreenHandlerType<>(GamemodeMenu::new));
		GamemodeMenu.screenInit();
	}
}
