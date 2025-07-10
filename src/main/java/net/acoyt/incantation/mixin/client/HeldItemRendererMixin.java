package net.acoyt.incantation.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.acoyt.incantation.util.IncaUtils;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {
    @WrapOperation(
            method = "renderArm",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/ClientPlayerEntity;getSkinTextures()Lnet/minecraft/client/util/SkinTextures;"
            )
    )
    private SkinTextures inca$armSkin(ClientPlayerEntity instance, Operation<SkinTextures> original) {
        return IncaUtils.isIncaling(instance) ? IncaUtils.getTextures(instance.getUuid(), instance.getSkinTextures()) : original.call(instance);
    }

    @WrapOperation(
            method = "renderArmHoldingItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;getSkinTextures()Lnet/minecraft/client/util/SkinTextures;"
            )
    )
    private SkinTextures inca$armSkin(AbstractClientPlayerEntity instance, Operation<SkinTextures> original) {
        return IncaUtils.isIncaling(instance) ? IncaUtils.getTextures(instance.getUuid(), instance.getSkinTextures()) : original.call(instance);
    }
}
