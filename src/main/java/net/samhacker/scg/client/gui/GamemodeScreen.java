
package net.samhacker.scg.client.gui;

import net.samhacker.scg.world.inventory.GamemodeMenu;
import net.samhacker.scg.network.GamemodeButtonMessage;
import net.samhacker.scg.SamhackersCommandGuiMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GamemodeScreen extends AbstractContainerScreen<GamemodeMenu> {
	private final static HashMap<String, Object> guistate = GamemodeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_creative;
	Button button_survival;
	Button button_adventure;
	Button button_spector;

	public GamemodeScreen(GamemodeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 116;
	}

	private static final ResourceLocation texture = new ResourceLocation("samhackers_command_gui:textures/screens/gm_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.samhackers_command_gui.gm_gui.label_gamemode_changer"), 14, 8, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_creative = Button.builder(Component.translatable("gui.samhackers_command_gui.gm_gui.button_creative"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "gamemode_button_0"), new GamemodeButtonMessage(0, x, y, z));
			}
		}).bounds(this.leftPos + 14, this.topPos + 41, 149, 20).build();
		guistate.put("button:button_creative", button_creative);
		this.addRenderableWidget(button_creative);
		button_survival = Button.builder(Component.translatable("gui.samhackers_command_gui.gm_gui.button_survival"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "gamemode_button_1"), new GamemodeButtonMessage(1, x, y, z));
			}
		}).bounds(this.leftPos + 14, this.topPos + 19, 149, 20).build();
		guistate.put("button:button_survival", button_survival);
		this.addRenderableWidget(button_survival);
		button_adventure = Button.builder(Component.translatable("gui.samhackers_command_gui.gm_gui.button_adventure"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "gamemode_button_2"), new GamemodeButtonMessage(2, x, y, z));
			}
		}).bounds(this.leftPos + 14, this.topPos + 63, 149, 20).build();
		guistate.put("button:button_adventure", button_adventure);
		this.addRenderableWidget(button_adventure);
		button_spector = Button.builder(Component.translatable("gui.samhackers_command_gui.gm_gui.button_spector"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(SamhackersCommandGuiMod.MODID, "gamemode_button_3"), new GamemodeButtonMessage(3, x, y, z));
			}
		}).bounds(this.leftPos + 14, this.topPos + 85, 149, 20).build();
		guistate.put("button:button_spector", button_spector);
		this.addRenderableWidget(button_spector);
	}
}
