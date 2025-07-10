package net.acoyt.incantation.mixin.interfaces;

import net.acoyt.incantation.util.interfaces.PlayerAnimationStateAccess;
import net.acoyt.incantation.util.interfaces.PlayerCosmeticHolder;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerAnimationStateAccess, PlayerCosmeticHolder {
    @Unique private final AnimationState wingIdleState = new AnimationState();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AnimationState inca$getWingIdleState() {
        return this.wingIdleState;
    }
}
