package net.acoyt.incantation.networking;

import net.acoyt.incantation.Incantation;
import net.acoyt.incantation.util.CosmeticInfo;
import net.acoyt.incantation.util.interfaces.PlayerCosmeticHolder;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;

public class SyncCosmeticsPacketReceiver {
    public static void registerServerPacket() {
        PayloadTypeRegistry.playC2S().register(SyncCosmeticsPacketPayload.ID, SyncCosmeticsPacketPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(SyncCosmeticsPacketPayload.ID, (payload, context) -> context.server().execute(() -> {
            PlayerEntity player = context.player();
            if (player == null || !Incantation.isSupporter(player.getUuid())) {
                return;
            }

            if (player instanceof PlayerCosmeticHolder holder) {
                if (Incantation.isSupporter(player.getUuid())) {
                    CosmeticInfo info = holder.getCosmeticInfo();
                    CosmeticInfo storedInfo = CosmeticInfo.cosmeticData.get(player.getUuid());
                    if (storedInfo != info) {
                        CosmeticInfo.cosmeticData.put(player.getUuid(), info);
                    }
                } else {
                    CosmeticInfo.cosmeticData.put(player.getUuid(), CosmeticInfo.getDefault(player.getUuid()));
                }
            }
        }));
    }
}
