package net.acoyt.incantation;

import net.acoyt.incantation.init.IncaBlocks;
import net.acoyt.incantation.init.IncaModelLayers;
import net.acoyt.incantation.util.CosmeticHandler;
import net.acoyt.incantation.util.IncaKeyBindings;
import net.fabricmc.api.ClientModInitializer;

public class IncantationClient implements ClientModInitializer {
    public void onInitializeClient() {
        IncaBlocks.clientInit();
        IncaModelLayers.clientInit();

        IncaKeyBindings.initialize();
        CosmeticHandler.initialize();
    }
}
