package net.acoyt.incantation.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RunnableWidget extends PressableWidget {
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    private final int u;
    private final int v;
    private final Identifier texture;
    Runnable runnable;

    public RunnableWidget(int x, int y, int u, int v, int width, int height, Identifier texture, Runnable runnable) {
        super(x, y, width, height, Text.empty());
        this.x = x;
        this.y = y;
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.runnable = runnable;
    }

    public void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        context.drawTexture(RenderLayer::getGuiTexturedOverlay, this.texture, this.x, this.y, this.u, this.v, this.width, this.height, 256, 256);
    }

    public void onPress() {
        runnable.run();
    }

    public void appendClickableNarrations(NarrationMessageBuilder builder) {}
}
