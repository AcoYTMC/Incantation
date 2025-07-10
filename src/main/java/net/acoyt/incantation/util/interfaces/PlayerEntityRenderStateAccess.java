package net.acoyt.incantation.util.interfaces;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.player.PlayerEntity;

public interface PlayerEntityRenderStateAccess {
    void inca$setPlayerEntity(PlayerEntity player);
    PlayerEntity inca$getPlayerEntity();

    AnimationState inca$getWingIdleState();
}