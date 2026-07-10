package com.apex.engine.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class UIButton extends UIElement {
    private String text;
    private Paint paint;
    private Paint textPaint;
    private int backgroundColor = 0xFF4CAF50;
    private int textColor = 0xFFFFFFFF;
    private boolean isPressed = false;

    public UIButton(float x, float y, float width, float height, String text) {
        super(x, y, width, height);
        this.text = text;
        this.paint = new Paint();
        this.textPaint = new Paint();
        this.textPaint.setColor(textColor);
        this.textPaint.setTextSize(20);
    }

    @Override
    public void render() {
        if (!visible) return;
        // Render button (implementation in canvas rendering)
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
    }

    public void setTextColor(int color) {
        this.textColor = color;
        textPaint.setColor(color);
    }

    public void setPressed(boolean pressed) {
        this.isPressed = pressed;
    }
}
