package net.acoyt.incantation.networking;

import net.acoyt.incantation.Incantation;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record SyncCosmeticsPacketPayload(boolean wings) implements CustomPayload {
    private static final Identifier SYNC_ID = Incantation.id("sync_cosmetics");

    public static final CustomPayload.Id<SyncCosmeticsPacketPayload> ID = new CustomPayload.Id<>(SYNC_ID);

    public static final PacketCodec<RegistryByteBuf, SyncCosmeticsPacketPayload> CODEC = PacketCodec.of(
            SyncCosmeticsPacketPayload::write, SyncCosmeticsPacketPayload::new
    );

    public SyncCosmeticsPacketPayload(RegistryByteBuf buf) {
        this(buf.readBoolean());
    }

    public void write(RegistryByteBuf buf) {
        buf.writeBoolean(wings);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
