package net.acoyt.incantation.client.gui;

import net.acoyt.incantation.Incantation;
import net.minecraft.util.Identifier;

// For Ease of Access, and an easy Reference (I got tired of trying to remember what was what :sob:)
public enum CosmeticUVs {
    BACKGROUND(0, 0, 182, 135),
    SQUARE(0, 135, 18, 18);

    public static final Identifier GUI_TEXTURE = Incantation.id("textures/gui/gui_temp.png");
    private final int u;
    private final int v;
    private final int width;
    private final int height;

    CosmeticUVs(int u, int v, int width, int height) {
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
    }

    public int getU() {
        return this.u;
    }

    public int getV() {
        return this.v;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}