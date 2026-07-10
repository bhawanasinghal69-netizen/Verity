package com.apex.engine.ui;

import android.graphics.Bitmap;

public class UIImage extends UIElement {
    private Bitmap image;
    private float alpha = 1.0f;

    public UIImage(float x, float y, float width, float height, Bitmap image) {
        super(x, y, width, height);
        this.image = image;
    }

    @Override
    public void render() {
        if (!visible || image == null) return;
        // Render image
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setAlpha(float alpha) {
        this.alpha = Math.max(0, Math.min(1, alpha));
    }

    public float getAlpha() {
        return alpha;
    }
}
