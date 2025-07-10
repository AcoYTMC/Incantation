package net.acoyt.incantation.mixin.cosmetic;

import net.acoyt.incantation.util.CosmeticInfo;
import net.acoyt.incantation.util.interfaces.PlayerCosmeticHolder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerCosmeticHolder {
    @Unique private CosmeticInfo cosmeticInfo = CosmeticInfo.getOrDefault(this.getUuid());

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public CosmeticInfo inca$getCosmeticInfo() {
        return this.cosmeticInfo;
    }

    @Override
    public void inca$setCosmeticInfo(CosmeticInfo info) {
        this.cosmeticInfo = info;
    }
}