package net.acoyt.incantation.client.gui;

import net.acoyt.incantation.Incantation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.client.gui.screen.ingame.InventoryScreen.drawEntity;

public class CosmeticSelectionScreen extends Screen {
    private final Screen previousScreen;

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
        this.x = (this.width / 2) - (CosmeticUVs.BACKGROUND.getWidth() / 2);
        this.y = (this.height / 2) - (CosmeticUVs.BACKGROUND.getHeight() / 2);

        if (this.player != null) {
            if (!Incantation.isSupporter(this.player.getUuid())) {
                this.close();
            }
        }

        MinecraftClient client = MinecraftClient.getInstance();

        this.addDrawableChild(new RunnableWidget(this.x + 104, this.y + 109, CosmeticUVs.SQUARE.getWidth(), CosmeticUVs.SQUARE.getHeight(), Text.empty(), CosmeticUVs.SQUARE, CosmeticUVs.SQUARE, () -> {
            Screen currentScreen = client.currentScreen;
            if (currentScreen != null) {
                currentScreen.close();
            }
        }));

        this.addDrawableChild(new RunnableWidget(this.x + 128, this.y + 109, CosmeticUVs.SQUARE.getWidth(), CosmeticUVs.SQUARE.getHeight(), Text.literal("TEST"), CosmeticUVs.SQUARE, CosmeticUVs.SQUARE, () -> {
            client.setScreen(this.previousScreen);
        }));
    }

    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        MinecraftClient client = MinecraftClient.getInstance();
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, CosmeticUVs.GUI_TEXTURE, this.x, this.y, 0, 0, CosmeticUVs.BACKGROUND.getWidth(), CosmeticUVs.BACKGROUND.getHeight(), 256, 256);
        if (this.player != null) {
            drawEntity(context, this.x + 11, this.y + 22, this.x + 66, this.y + 123, 40, 0.3625F, this.x + 20 + mouseX * 0.1F, this.y + 62 + mouseY * 0.1F, this.player);
        }
        context.drawText(this.textRenderer, this.title, this.width / 2 - textRenderer.getWidth(this.title) / 2, this.y + 7, -12566464, false);
    }
}
