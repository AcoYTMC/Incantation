package net.acoyt.incantation.client.gui;

import net.acoyt.incantation.Incantation;
import net.acoyt.incantation.util.CosmeticInfo;
import net.acoyt.incantation.util.IncaTextures;
import net.acoyt.incantation.util.interfaces.PlayerCosmeticHolder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.client.gui.screen.ingame.InventoryScreen.drawEntity;

public class CosmeticSelectionScreen extends Screen {
    private final int backWidth = 182;
    private final int backHeight = 135;

    private final int buttonScale = 18;

    private final int toggleScaleX = 60;
    private final int toggleScaleY = 18;

    private final Screen previousScreen;
    private RunnableWidget exitWidget;
    private RunnableWidget wingToggleWidget;

    private final PlayerEntity player;
    protected int x;
    protected int y;

    public CosmeticSelectionScreen(Screen previousScreen) {
        super(Text.translatable("incaling.cosmetics.screen.title"));
        this.previousScreen = previousScreen;
        MinecraftClient client = MinecraftClient.getInstance();
        this.player = client.player;
    }

    public boolean shouldPause() {
        return false;
    }

    public void init() {
        this.x = (this.width / 2) - (this.backWidth / 2);
        this.y = (this.height / 2) - (this.backHeight / 2);

        if (this.player != null) {
            if (!Incantation.isSupporter(this.player.getUuid())) {
                this.close();
            }
        }

        MinecraftClient client = MinecraftClient.getInstance();

        this.exitWidget = new RunnableWidget(this.x + 157, this.y + 7, 0, 153, this.buttonScale, this.buttonScale, IncaTextures.GUI_TEXTURE, () -> {
            Screen currentScreen = client.currentScreen;
            if (currentScreen != null) {
                client.setScreen(this.previousScreen);
            }
        });

        this.wingToggleWidget = new RunnableWidget(this.x + 88, this.y + 23, 0, 153, 60, 20, IncaTextures.GUI_TEXTURE, () -> {
            if (client.player instanceof PlayerCosmeticHolder holder) {
                CosmeticInfo info = holder.getCosmeticInfo();
                boolean bl = info.wings();
                holder.setCosmeticInfo(info.withWings(!bl));
            }
        });

        this.addDrawableChild(this.exitWidget);
        this.addDrawableChild(this.wingToggleWidget);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.renderBackground(context, mouseX, mouseY, deltaTicks);
    }

    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        boolean wings = false;
        if (this.player instanceof PlayerCosmeticHolder holder) {
            wings = holder.getCosmeticInfo().wings();
        }
        // Background?
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x, this.y, 0, 0, this.backWidth, this.backHeight, 256, 256);

        // Player Render
        if (this.player != null) {
            drawEntity(context, this.x + 13, this.y + 17, this.x + 66, this.y + 123, 40, 0.3625F, this.x + 20 + mouseX * 0.1F, this.y + 62 + mouseY * 0.1F, this.player);
        }

        // Title
        context.drawText(this.textRenderer, this.title, this.width / 2 - textRenderer.getWidth(this.title) / 2, this.y + 7, 0xd6ce82, true);

        // Exit Button
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 157, this.y + 7, 0, 154, this.buttonScale, this.buttonScale, 256, 256);

        // Toggles
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 88, this.y + 23, 21, wings ? 154 : 135, this.toggleScaleX, this.toggleScaleY, 256, 256);
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 88, this.y + 49, 21, wings ? 154 : 135, this.toggleScaleX, this.toggleScaleY, 256, 256);
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 88, this.y + 75, 21, wings ? 154 : 135, this.toggleScaleX, this.toggleScaleY, 256, 256);
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 88, this.y + 101, 21, wings ? 154 : 135, this.toggleScaleX, this.toggleScaleY, 256, 256);
    }
}
