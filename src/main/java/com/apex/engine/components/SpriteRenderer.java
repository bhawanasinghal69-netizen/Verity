package com.apex.engine.components;

import android.graphics.Bitmap;
import com.apex.engine.ecs.Component;

public class SpriteRenderer extends Component {
    private Bitmap sprite;
    private String spritePath;
    private int color = 0xFFFFFFFF;
    private float alpha = 1.0f;
    private int layer = 0;

    public SpriteRenderer(String spritePath) {
        this.spritePath = spritePath;
    }

    @Override
    public void update(float deltaTime) {}

    @Override
    public void render() {
        if (sprite != null && entity != null) {
            Transform transform = entity.getComponent(Transform.class);
            if (transform != null) {
                // Render sprite at transform position
            }
        }
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setAlpha(float alpha) {
        this.alpha = Math.max(0, Math.min(1, alpha));
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }
}
