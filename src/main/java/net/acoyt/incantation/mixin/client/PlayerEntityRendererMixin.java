package net.acoyt.incantation.mixin.client;

import net.acoyt.incantation.client.render.entity.feature.IncaWingsFeatureRenderer;
import net.acoyt.incantation.util.IncaTextures;
import net.acoyt.incantation.util.IncaUtils;
import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityRenderState, PlayerEntityModel> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    private void inca$addWingsFeature(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo ci) {
        this.addFeature(new IncaWingsFeatureRenderer(this, ctx.getEntityModels()));
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void inca$skinTextures(PlayerEntityRenderState renderState, CallbackInfoReturnable<Identifier> cir) {
        if (renderState instanceof PlayerEntityRenderStateAccess access) {
            PlayerEntity player = access.inca$getPlayerEntity();
            if (IncaUtils.isIncaling(player)) {
                cir.setReturnValue(
                        IncaTextures.getTextures(
                                player.getUuid(),
                                renderState.skinTextures.model() == SkinTextures.Model.SLIM
                        )
                );
            }
        }
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void inca$skinTextures(LivingEntityRenderState state, CallbackInfoReturnable<Identifier> cir) {
        if (state instanceof PlayerEntityRenderState renderState) {
            if (renderState instanceof PlayerEntityRenderStateAccess access) {
                PlayerEntity player = access.inca$getPlayerEntity();
                if (IncaUtils.isIncaling(player)) {
                    cir.setReturnValue(
                            IncaTextures.getTextures(
                                    player.getUuid(),
                                    renderState.skinTextures.model() == SkinTextures.Model.SLIM
                            )
                    );
                }
            }
        }
    }
}
