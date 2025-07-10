package net.acoyt.incantation.cca;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class IncalingComponent implements AutoSyncedComponent, CommonTickingComponent {
    private final PlayerEntity player;
    private boolean incaling = false;
    private boolean submerged = false;

    public IncalingComponent(PlayerEntity player) {
        this.player = player;
    }

    public static IncalingComponent get(PlayerEntity player) {
        return IncaComponents.INCALING.get(player);
    }

    private void sync() {
        IncaComponents.INCALING.sync(this.player);
    }

    public void tick() {
        if (!incaling && submerged) {
            submerged = false;
        }
    }

    public boolean isIncaling() {
        return this.incaling;
    }

    public void setIncaling(boolean incaling) {
        this.incaling = incaling;
        this.sync();
    }

    public boolean isSubmerged() {
        return this.submerged;
    }

    public void setSubmerged(boolean submerged) {
        this.submerged = submerged;
        this.sync();
    }

    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.incaling = tag.getBoolean("incaling", false);
        this.submerged = tag.getBoolean("submerged", false);
    }

    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup wrapperLookup) {
        tag.putBoolean("incaling", this.incaling);
        tag.putBoolean("submerged", this.submerged);
    }
}
