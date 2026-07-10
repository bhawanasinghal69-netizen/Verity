package com.apex.engine.ui;

import java.util.ArrayList;
import java.util.List;

public class UIManager {
    private List<UIElement> elements;
    private UILayoutManager layoutManager;

    public UIManager() {
        this.elements = new ArrayList<>();
        this.layoutManager = new UILayoutManager();
    }

    public void addElement(UIElement element) {
        elements.add(element);
    }

    public void removeElement(UIElement element) {
        elements.remove(element);
    }

    public void renderAll() {
        for (UIElement element : elements) {
            if (element.isVisible()) {
                element.render();
            }
        }
    }

    public void onTouchDown(float x, float y) {
        for (UIElement element : elements) {
            if (element.isVisible() && element.isPointInside(x, y)) {
                element.onClick();
                break;
            }
        }
    }

    public UILayoutManager getLayoutManager() {
        return layoutManager;
    }
}
