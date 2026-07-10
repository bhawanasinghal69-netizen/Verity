package com.apex.engine.ui;

public abstract class UIElement {
    protected float x, y, width, height;
    protected boolean visible = true;
    protected boolean clickable = true;
    protected OnClickListener onClickListener;

    public UIElement(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void render();

    public boolean isPointInside(float px, float py) {
        return px >= x && px <= x + width && py >= y && py <= y + height;
    }

    public void onClick() {
        if (onClickListener != null) {
            onClickListener.onClicked(this);
        }
    }

    // Getters and Setters
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public float getWidth() { return width; }
    public void setWidth(float width) { this.width = width; }
    public float getHeight() { return height; }
    public void setHeight(float height) { this.height = height; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
    public void setOnClickListener(OnClickListener listener) { this.onClickListener = listener; }

    public interface OnClickListener {
        void onClicked(UIElement element);
    }
}
