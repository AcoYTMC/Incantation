package net.acoyt.incantation.mixin.modMenu;

import com.terraformersmc.modmenu.config.ModMenuConfig;
import com.terraformersmc.modmenu.gui.widget.entries.ModListEntry;
import com.terraformersmc.modmenu.util.mod.Mod;
import net.acoyt.incantation.Incantation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.acoyt.incantation.compat.IncaModMenu.LINE;
import static net.acoyt.incantation.compat.IncaModMenu.SMALL_ICON;

@Mixin(ModListEntry.class)
public abstract class ModMenuMixin {
    @Shadow @Final public Mod mod;

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    private void modifyModNameColor(
            DrawContext drawContext,
            int index,
            int y,
            int x,
            int rowWidth,
            int rowHeight,
            int mouseX,
            int mouseY,
            boolean hovered,
            float delta,
            CallbackInfo ci
    ) {
        // Get the mod ID
        String modId = this.mod.getId();
        int iconSize = ModMenuConfig.COMPACT_LIST.getValue() ? 19 : 32;

        if (Incantation.MOD_ID.equals(modId)) {
            drawContext.drawTexture(RenderLayer::getGuiTexturedOverlay, SMALL_ICON, x + iconSize + 60, y - 5, 0, 0, 16, 16, 16, 16);

            // Draw colored line below 2 rows of text
            drawContext.drawTexture(RenderLayer::getGuiTexturedOverlay, LINE, x + iconSize + 3, y + 31, 0, 0, 76, 1, 76, 1);
        }
    }
}
