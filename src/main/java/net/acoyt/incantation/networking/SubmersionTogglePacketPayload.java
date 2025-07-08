package net.acoyt.incantation.networking;

import net.acoyt.incantation.Incantation;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record SubmersionTogglePacketPayload(int entityId) implements CustomPayload {
    private static final Identifier TOGGLE_ID = Incantation.id("submersion_toggle");

    public static final CustomPayload.Id<SubmersionTogglePacketPayload> ID = new CustomPayload.Id<>(TOGGLE_ID);

    public static final PacketCodec<RegistryByteBuf, SubmersionTogglePacketPayload> CODEC = PacketCodec.of(SubmersionTogglePacketPayload::write, SubmersionTogglePacketPayload::new);

    public SubmersionTogglePacketPayload(RegistryByteBuf buf) {
        this(buf.readInt());
    }

    public void write(RegistryByteBuf buf) {
        buf.writeInt(entityId);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
