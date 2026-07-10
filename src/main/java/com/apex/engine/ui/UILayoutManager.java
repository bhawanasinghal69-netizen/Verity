package com.apex.engine.ui;

public class UILayoutManager {
    
    public enum LayoutType {
        VERTICAL,
        HORIZONTAL,
        GRID,
        FREE
    }

    private LayoutType layoutType = LayoutType.FREE;
    private float spacing = 5.0f;
    private float padding = 10.0f;

    public void arrangeVertical(UIElement[] elements, float startX, float startY) {
        float currentY = startY + padding;
        for (UIElement element : elements) {
            element.setX(startX + padding);
            element.setY(currentY);
            currentY += element.getHeight() + spacing;
        }
    }

    public void arrangeHorizontal(UIElement[] elements, float startX, float startY) {
        float currentX = startX + padding;
        for (UIElement element : elements) {
            element.setX(currentX);
            element.setY(startY + padding);
            currentX += element.getWidth() + spacing;
        }
    }

    public void setLayoutType(LayoutType type) { this.layoutType = type; }
    public void setSpacing(float spacing) { this.spacing = spacing; }
    public void setPadding(float padding) { this.padding = padding; }
}
