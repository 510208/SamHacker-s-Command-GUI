
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.samhacker.scg.init;

import net.samhacker.scg.client.gui.GamemodeScreen;

import net.minecraft.client.gui.screens.MenuScreens;

public class SamhackersCommandGuiModScreens {
	public static void load() {
		MenuScreens.register(SamhackersCommandGuiModMenus.GM_GUI, GamemodeScreen::new);
	}
}
