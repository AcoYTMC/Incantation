package net.acoyt.incantation.util;

import net.acoyt.incantation.client.gui.CosmeticSelectionScreen;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class CosmeticHandler {
    private static boolean openCosmeticsScreen;

    public static void initialize() {
        registerUseToOpenScreen();
        registerOpenWhenTrue();
    }

    private static void registerUseToOpenScreen() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (player.isSneaking() && stack.isOf(Items.MUSIC_DISC_STAL)) {
                openCosmeticsScreen = true;
            }

            return ActionResult.PASS;
        });
    }

    private static void registerOpenWhenTrue() {
        MinecraftClient client = MinecraftClient.getInstance();
        WorldRenderEvents.LAST.register(context -> {
            if (openCosmeticsScreen) {
                Screen currentScreen = client.currentScreen;
                client.setScreen(new CosmeticSelectionScreen(currentScreen));
                openCosmeticsScreen = false;
            }
        });
    }
}
