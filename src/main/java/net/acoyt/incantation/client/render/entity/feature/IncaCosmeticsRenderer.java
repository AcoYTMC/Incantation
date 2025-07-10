package net.acoyt.incantation.client.render.entity.feature;

import net.acoyt.incantation.client.render.entity.model.IncaWingsModel;
import net.acoyt.incantation.init.IncaModelLayers;
import net.acoyt.incantation.util.CosmeticInfo;
import net.acoyt.incantation.util.IncaTextures;
import net.acoyt.incantation.util.IncaUtils;
import net.acoyt.incantation.util.interfaces.PlayerAnimationStateAccess;
import net.acoyt.incantation.util.interfaces.PlayerEntityRenderStateAccess;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class IncaCosmeticsRenderer extends FeatureRenderer<PlayerEntityRenderState, PlayerEntityModel> {
    private final IncaWingsModel wingsModel;

    public IncaCosmeticsRenderer(FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel> context, LoadedEntityModels modelLoader) {
        super(context);
        this.wingsModel = new IncaWingsModel(modelLoader.getModelPart(IncaModelLayers.INCA_WINGS), RenderLayer::getEntityCutoutNoCull);
    }

    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, PlayerEntityRenderState renderState, float limbAngle, float limbDistance) {
        if (renderState instanceof PlayerEntityRenderStateAccess access) {
            PlayerEntity player = access.inca$getPlayerEntity();
            CosmeticInfo info = CosmeticInfo.getOrDefault(player.getUuid());
            boolean wings = info.wings();
            if (wings) {
                if (player instanceof PlayerAnimationStateAccess wingIdle) {
                    if (IncaUtils.isWingedIncaling(player)) {
                        matrices.push();
                        matrices.translate(0.0F, 0.0F, 1.0F);
                        float scale = 1.0F;
                        matrices.scale(scale, scale, scale);
                        this.wingsModel.render(matrices, vertexConsumers.getBuffer(this.wingsModel.getLayer(IncaTextures.WINGS)), light, OverlayTexture.DEFAULT_UV, 0xFFFFFF);
                        this.wingsModel.animate(wingIdle.inca$getWingIdleState(), IncaWingsModel.WingAnimations.idle, player.age);
                        matrices.pop();
                    }
                }
            }
        }
    }
}
