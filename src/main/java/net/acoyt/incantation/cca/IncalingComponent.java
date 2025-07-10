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
    private boolean particles = false;

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
        // If they are not an Incaling, but they are still submerged, un-submerge them, and stop spawning particles.
        // Only runs once, when conditions are met
        if (!incaling && submerged) {
            submerged = false;
            particles = false;
            this.sync();
        }

        // If they are submerged, but aren't spawning particles, start spawning particles
        // Only runs once, when conditions are met
        if (submerged && !particles) {
            particles = true;
            this.sync();
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

    public boolean isParticles() {
        return this.particles;
    }

    public void setParticles(boolean particles) {
        this.particles = particles;
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
