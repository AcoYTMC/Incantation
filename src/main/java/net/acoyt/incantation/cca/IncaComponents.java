package net.acoyt.incantation.cca;

import net.acoyt.incantation.Incantation;
import net.minecraft.entity.player.PlayerEntity;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;
import org.ladysnake.cca.api.v3.world.WorldComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.world.WorldComponentInitializer;

public class IncaComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<IncalingComponent> INCALING = ComponentRegistry.getOrCreate(Incantation.id("incaling"), IncalingComponent.class);

    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(PlayerEntity.class, INCALING).respawnStrategy(RespawnCopyStrategy.NEVER_COPY).end(IncalingComponent::new);
    }

    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        //
    }
}
