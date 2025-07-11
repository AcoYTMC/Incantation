package net.acoyt.incantation.mixin.interfaces;

import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.acoyt.incantation.util.interfaces.PlayerAnimationStateAccess;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class UpdatePlayerEntityRendererMixin {
    @Inject(method = "updateRenderState(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V", at = @At("HEAD"))
    public void updateRenderState(AbstractClientPlayerEntity clientPlayer, PlayerEntityRenderState renderState, float f, CallbackInfo ci) {
        if (renderState instanceof PlayerEntityRenderStateAccess access) {
            access.inca$setPlayerEntity(clientPlayer);
            if (clientPlayer instanceof PlayerAnimationStateAccess idle) {
                access.inca$getWingIdleState().copyFrom(idle.inca$getWingIdleState());
            }
        }
    }
}
