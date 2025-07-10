package net.acoyt.incantation.mixin.interfaces;

import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntityRenderState.class)
public class PlayerEntityRenderStateAccessMixin implements PlayerEntityRenderStateAccess {
    @Unique private PlayerEntity playerEntity;
    @Unique private final AnimationState wingIdleState = new AnimationState();

    @Override
    public void inca$setPlayerEntity(PlayerEntity player) {
        this.playerEntity = player;
    }

    @Override
    public PlayerEntity inca$getPlayerEntity() {
        return this.playerEntity;
    }

    @Override
    public AnimationState inca$getWingIdleState() {
        return this.wingIdleState;
    }
}