package net.acoyt.incantation.util;

import net.acoyt.incantation.Incantation;
import net.minecraft.util.Identifier;

import java.util.UUID;

import static net.acoyt.acornlib.util.AcornLibUtils.acoUuid;

public class IncaTextures {
    public static Identifier getTextures(UUID uuid, boolean slim) {
        if (uuid.equals(acoUuid)) {
            return ACO;
        }

        return slim ? SLIM_DEFAULT : CLASSIC_DEFAULT;
    }

    // Others
    public static final Identifier WINGS = Incantation.id("textures/incaling/wings.png");

    // Per-player
    public static final Identifier ACO = Incantation.id("textures/incaling/aco.png");

    // Defaults
    public static final Identifier SLIM_DEFAULT = Incantation.id("textures/incaling/default_slim.png");
    public static final Identifier CLASSIC_DEFAULT = Incantation.id("textures/incaling/classic_default.png");
}
