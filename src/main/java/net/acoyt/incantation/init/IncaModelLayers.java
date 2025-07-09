package net.acoyt.incantation.init;

import net.acoyt.incantation.Incantation;
import net.acoyt.incantation.client.render.entity.model.IncaWingsModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public interface IncaModelLayers {
    EntityModelLayer INCA_WINGS = create("inca_wings");

    private static EntityModelLayer create(String name) {
        return new EntityModelLayer(Incantation.id(name), "main");
    }

    static void clientInit() {
        EntityModelLayerRegistry.registerModelLayer(INCA_WINGS, IncaWingsModel::getTexturedModelData);
    }
}
