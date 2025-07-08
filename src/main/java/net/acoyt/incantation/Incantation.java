package net.acoyt.incantation;

import com.mojang.logging.LogUtils;
import eu.midnightdust.lib.config.MidnightConfig;
import net.acoyt.acornlib.api.ALib;
import net.acoyt.incantation.compat.IncaConfig;
import net.acoyt.incantation.init.IncaBlocks;
import net.acoyt.incantation.init.IncaItems;
import net.acoyt.incantation.networking.SubmersionTogglePacketReceiver;
import net.acoyt.incantation.util.IncaUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class Incantation implements ModInitializer {
	public static final String MOD_ID = "incantation";
	public static final Logger LOGGER = LogUtils.getLogger();

	public void onInitialize() {
		ALib.registerModMenu(MOD_ID, IncaUtils.modNameColor);

        MidnightConfig.init(MOD_ID, IncaConfig.class);

        // Init
        IncaBlocks.init();
        IncaItems.init();

        // Packets
        SubmersionTogglePacketReceiver.registerServerPacket();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}