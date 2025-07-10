package net.acoyt.incantation.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;

public class RunnableWidget extends PressableWidget {
    Runnable runnable;
    private final CosmeticUVs texture;
    private final CosmeticUVs hoverTexture;
    private int width;
    private int height;

    public RunnableWidget(int x, int y, int width, int height, Text text, CosmeticUVs texture, CosmeticUVs hoverTexture, Runnable runnable) {
        super(x, y, width, height, text);
        this.runnable = runnable;
        this.texture = texture;
        this.hoverTexture = hoverTexture;
        this.width = width;
        this.height = height;
    }

    public void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        CosmeticUVs icon = this.isMouseOver(mouseX, mouseY) ? hoverTexture : texture;
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, CosmeticUVs.GUI_TEXTURE, this.getX(), this.getY(), icon.getU(), icon.getV(), icon.getWidth(), icon.getHeight(), 256, 256);
    }

    public void onPress() {
        runnable.run();
    }

    public void appendClickableNarrations(NarrationMessageBuilder builder) {}
}
