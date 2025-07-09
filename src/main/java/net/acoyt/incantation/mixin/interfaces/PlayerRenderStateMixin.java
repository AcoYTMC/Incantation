package net.acoyt.incantation.mixin.interfaces;

import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntityRenderState.class)
public class PlayerRenderStateMixin implements PlayerEntityRenderStateAccess {
    @Unique private PlayerEntity playerEntity;

    @Override
    public void inca$setPlayerEntity(PlayerEntity player) {
        this.playerEntity = player;
    }

    @Override
    public PlayerEntity inca$getPlayerEntity() {
        return this.playerEntity;
    }
}