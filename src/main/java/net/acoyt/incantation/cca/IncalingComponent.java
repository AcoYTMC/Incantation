package net.acoyt.incantation.cca;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class IncalingComponent implements AutoSyncedComponent {
    private final PlayerEntity player;
    private boolean isIncaling = false;
    private boolean isSubmerged = false;

    public IncalingComponent(PlayerEntity player) {
        this.player = player;
    }

    public static IncalingComponent get(PlayerEntity player) {
        return IncaComponents.INCALING.get(player);
    }

    private void sync() {
        IncaComponents.INCALING.sync(this.player);
    }

    public boolean isIncaling() {
        return this.isIncaling;
    }

    public void setIncaling(boolean isIncaling) {
        this.isIncaling = isIncaling;
        this.sync();
    }

    public boolean isSubmerged() {
        return this.isSubmerged;
    }

    public void setSubmerged(boolean isSubmerged) {
        this.isSubmerged = isSubmerged;
        this.sync();
    }

    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.isIncaling = tag.getBoolean("isIncaling", false);
        this.isSubmerged = tag.getBoolean("isSubmerged", false);
    }

    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        tag.putBoolean("isIncaling", this.isIncaling);
        tag.putBoolean("isSubmerged", this.isSubmerged);
    }
}
