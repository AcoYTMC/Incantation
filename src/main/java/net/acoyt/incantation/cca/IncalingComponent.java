package net.acoyt.incantation.cca;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class IncalingComponent implements AutoSyncedComponent {
    private final PlayerEntity player;
    private boolean isInked = false;
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

    public boolean isInked() {
        return isInked;
    }

    public void setInked(boolean inked) {
        this.isInked = inked;
        this.sync();
    }

    public boolean isSubmerged() {
        return isSubmerged;
    }

    public void setSubmerged(boolean submerged) {
        this.isSubmerged = submerged;
        this.sync();
    }

    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.isInked = tag.getBoolean("isInked", false);
        this.isSubmerged = tag.getBoolean("isSubmerged", false);
    }

    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        tag.putBoolean("isInked", this.isInked);
        tag.putBoolean("isSubmerged", this.isSubmerged);
    }
}
