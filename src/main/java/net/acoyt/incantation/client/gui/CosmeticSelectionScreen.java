package net.acoyt.incantation.client.gui;

import net.acoyt.incantation.Incantation;
import net.acoyt.incantation.util.IncaTextures;
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
    private final int toggleScaleY = 20;

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

        this.wingToggleWidget = new RunnableWidget(this.x + 157, this.y + 7, 0, 153, 60, 20, IncaTextures.GUI_TEXTURE, () -> {
            if (client.player != null) {
                //
            }
        });

        this.addDrawableChild(this.exitWidget);
        this.addDrawableChild(this.wingToggleWidget);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.renderBackground(context, mouseX, mouseY, deltaTicks);
    }

    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        if (this.player != null) {
            //
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
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 157, this.y + 7, 0, 153, this.buttonScale, this.buttonScale, 256, 256);

        // Toggles
        //context.drawTexture(RenderLayer::getGuiTexturedOverlay, IncaTextures.GUI_TEXTURE, this.x + 100, this.y + 57, 22, );
    }
}
