package net.acoyt.incantation.util;

import net.acoyt.incantation.Incantation;
import net.acoyt.incantation.networking.SubmersionTogglePacketPayload;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class IncaKeyBindings {
    public static KeyBinding submergedToggle;

    public static void initialize() {
        registerKeyBindings();
        setupToggleDetection();
    }

    private static void registerKeyBindings() {
        submergedToggle = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.incantation.submergedToggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.incantation"
        ));
    }

    private static void setupToggleDetection() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player != null && submergedToggle.wasPressed()) {
                handleTogglePress(client);
            }
        });
    }

    // Global variable to track the last time the key was pressed
    private static long lastToggleTime = 0;  // Time of last toggle in milliseconds
    private static final long COOLDOWN_TIME = 500;  // Cooldown time in milliseconds (500 ms = 0.5 seconds)

    private static void handleTogglePress(MinecraftClient client) {
        if (client.player == null) {
            return;
        }

        if (!client.player.isOnGround() || !IncaUtils.isIncaling(client.player)) {
            return;
        }

        long currentTime = System.currentTimeMillis();

        if (currentTime - lastToggleTime < COOLDOWN_TIME) {
            return;
        }

        try {
            SubmersionTogglePacketPayload payload = new SubmersionTogglePacketPayload(client.player.getId());
            ClientPlayNetworking.send(payload);

            lastToggleTime = System.currentTimeMillis();
        } catch (Exception e) {
            Incantation.LOGGER.error("Failed to send Submersion Toggle Packet");
        }
    }
}
