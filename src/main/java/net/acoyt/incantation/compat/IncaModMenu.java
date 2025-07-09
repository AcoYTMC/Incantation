package net.acoyt.incantation.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;
import net.acoyt.incantation.Incantation;
import net.minecraft.util.Identifier;

public class IncaModMenu implements ModMenuApi {
    public static final Identifier LINE = Incantation.id("textures/modmenu/inca_line.png");
    public static final Identifier SMALL_ICON = Incantation.id("textures/modmenu/inca_small_icon.png");

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent, Incantation.MOD_ID);
    }
}
