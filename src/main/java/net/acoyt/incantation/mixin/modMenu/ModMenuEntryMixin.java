package net.acoyt.incantation.mixin.modMenu;

import com.terraformersmc.modmenu.gui.ModsScreen;
import com.terraformersmc.modmenu.gui.widget.entries.ModListEntry;
import com.terraformersmc.modmenu.util.mod.Mod;
import net.acoyt.acornlib.AcornLib;
import net.acoyt.incantation.Incantation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.acoyt.incantation.compat.IncaModMenu.SMALL_ICON;

@Mixin(ModsScreen.class)
public abstract class ModMenuEntryMixin extends Screen {
    @Shadow private ModListEntry selected;
    @Shadow private int rightPaneX;

    protected ModMenuEntryMixin(Text title) {
        super(title);
    }

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ModListEntry selectedEntry = this.selected;
        if (selectedEntry != null) {
            Mod mod = selectedEntry.getMod();
            int imageOffset = 36;

            if (Incantation.MOD_ID.equals(mod.getId())) {
                context.drawTexture(RenderLayer::getGuiTexturedOverlay, SMALL_ICON, this.rightPaneX + imageOffset + 57, 44, 0, 0, 16, 16, 16, 16);
            }
        }
    }
}
