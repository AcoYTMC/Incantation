package net.acoyt.incantation;

import com.mojang.logging.LogUtils;
import eu.midnightdust.lib.config.MidnightConfig;
import net.acoyt.acornlib.api.ALib;
import net.acoyt.acornlib.util.supporter.SupporterUtils;
import net.acoyt.incantation.command.IncalingCommand;
import net.acoyt.incantation.compat.IncaConfig;
import net.acoyt.incantation.init.IncaBlocks;
import net.acoyt.incantation.init.IncaItems;
import net.acoyt.incantation.networking.SubmersionTogglePacketReceiver;
import net.acoyt.incantation.util.CosmeticInfo;
import net.acoyt.incantation.util.IncaUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.util.UUID;

import static net.acoyt.incantation.util.CosmeticInfo.cosmeticData;

public class Incantation implements ModInitializer {
	public static final String MOD_ID = "incantation";
	public static final Logger LOGGER = LogUtils.getLogger();

    public static boolean isSupporter(UUID uuid) {
        return SupporterUtils.isUuidFromSupporter(uuid) || SupporterUtils.isUuidFromFriend(uuid);
    }

	public void onInitialize() {
		ALib.registerModMenu(MOD_ID, IncaUtils.modNameColor);

        MidnightConfig.init(MOD_ID, IncaConfig.class);

        // Init
        IncaBlocks.init();
        IncaItems.init();

        // Packets
        SubmersionTogglePacketReceiver.registerServerPacket();

        // Commands
        CommandRegistrationCallback.EVENT.register(IncalingCommand::register);

        // Cosmetic Data :3
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.player;
            UUID uuid = player.getUuid();
            if (isSupporter(uuid)) {
                if (!cosmeticData.containsKey(uuid)) {
                    cosmeticData.put(uuid, CosmeticInfo.getOrDefault(uuid));
                }
            }
        });
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
