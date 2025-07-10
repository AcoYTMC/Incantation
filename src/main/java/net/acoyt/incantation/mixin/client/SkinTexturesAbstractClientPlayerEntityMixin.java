package net.acoyt.incantation.mixin.client;

import net.acoyt.incantation.util.IncaUtils;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public class SkinTexturesAbstractClientPlayerEntityMixin {
    @Inject(
            method = "getSkinTextures",
            at = @At("HEAD"),
            cancellable = true
    )
    private void inca$skinTextures(CallbackInfoReturnable<SkinTextures> cir) {
        AbstractClientPlayerEntity clientPlayer = (AbstractClientPlayerEntity)(Object)this;
        SkinTextures defaultTextures = cir.getReturnValue();
        if (defaultTextures != null) {
            if (IncaUtils.isIncaling(clientPlayer)) {
                cir.setReturnValue(IncaUtils.getTextures(clientPlayer.getUuid(), defaultTextures));
            }
        }
    }
}
