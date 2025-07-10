package net.acoyt.incantation.util;

import net.acoyt.incantation.cca.IncalingComponent;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.UUID;

import static net.acoyt.acornlib.util.AcornLibUtils.acoUuid;

public class IncaUtils {
    public static final int modNameColor = 0x785876;

    // Booleans
    public static boolean isIncaling(PlayerEntity player) {
        return IncalingComponent.get(player).isIncaling();
    }

    public static boolean isSubmerged(PlayerEntity player) {
        return IncalingComponent.get(player).isSubmerged();
    }

    // Textures
    private static SkinTextures createTextures(SkinTextures defaultTextures, Identifier skinId, SkinTextures.Model model) {
        return new SkinTextures(skinId, defaultTextures.textureUrl(), defaultTextures.capeTexture(), defaultTextures.elytraTexture(), model, defaultTextures.secure());
    }

    public static SkinTextures getTextures(UUID uuid, SkinTextures defaultTextures) {
        SkinTextures.Model model = defaultTextures.model();
        if (uuid.equals(acoUuid)) {
            return createTextures(defaultTextures, IncaTextures.ACO, SkinTextures.Model.SLIM);
        }

        return model == SkinTextures.Model.SLIM
                ? createTextures(defaultTextures, IncaTextures.SLIM_DEFAULT, SkinTextures.Model.SLIM)
                : createTextures(defaultTextures, IncaTextures.CLASSIC_DEFAULT, SkinTextures.Model.WIDE);
    }
}
