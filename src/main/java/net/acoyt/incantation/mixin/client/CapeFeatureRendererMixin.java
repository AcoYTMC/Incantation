package net.acoyt.incantation.mixin.client;

import net.acoyt.incantation.util.IncaUtils;
import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
    @Inject(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/PlayerEntityRenderState;FF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, PlayerEntityRenderState renderState, float f, float g, CallbackInfo ci) {
        if (renderState instanceof PlayerEntityRenderStateAccess access) {
            if (IncaUtils.isIncaling(access.inca$getPlayerEntity())) {
                ci.cancel();
            }
        }
    }
}
