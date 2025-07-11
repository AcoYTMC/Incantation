package net.acoyt.incantation.networking;

import net.acoyt.incantation.cca.IncalingComponent;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;

public class SubmersionTogglePacketReceiver {
    public static void registerServerPacket() {
        PayloadTypeRegistry.playC2S().register(SubmersionTogglePacketPayload.ID, SubmersionTogglePacketPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(SubmersionTogglePacketPayload.ID, (payload, context) -> context.server().execute(() -> {
            PlayerEntity player = context.player();
            if (player == null) {
                return;
            }

            IncalingComponent incaling = IncalingComponent.get(player);
            boolean bl = incaling.isSubmerged();
            incaling.setSubmerged(!bl);
        }));
    }
}
