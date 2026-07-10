package com.apex.engine.ui;

import android.graphics.Paint;

public class UIText extends UIElement {
    private String text;
    private Paint textPaint;
    private int textColor = 0xFF000000;
    private float textSize = 20;

    public UIText(float x, float y, String text) {
        super(x, y, 200, 50);
        this.text = text;
        this.textPaint = new Paint();
        this.textPaint.setColor(textColor);
        this.textPaint.setTextSize(textSize);
    }

    @Override
    public void render() {
        if (!visible) return;
        // Render text
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTextColor(int color) {
        this.textColor = color;
        textPaint.setColor(color);
    }

    public void setTextSize(float size) {
        this.textSize = size;
        textPaint.setTextSize(size);
    }
}
