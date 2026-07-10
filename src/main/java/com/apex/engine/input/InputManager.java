package com.apex.engine.input;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private List<TouchListener> touchListeners;
    private float touchX, touchY;
    private boolean touched = false;

    public InputManager() {
        this.touchListeners = new ArrayList<>();
    }

    public void handleTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touched = true;
                for (TouchListener listener : touchListeners) {
                    listener.onTouchDown(touchX, touchY);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for (TouchListener listener : touchListeners) {
                    listener.onTouchMove(touchX, touchY);
                }
                break;
            case MotionEvent.ACTION_UP:
                touched = false;
                for (TouchListener listener : touchListeners) {
                    listener.onTouchUp(touchX, touchY);
                }
                break;
        }
    }

    public void addTouchListener(TouchListener listener) {
        touchListeners.add(listener);
    }

    public float getTouchX() { return touchX; }
    public float getTouchY() { return touchY; }
    public boolean isTouched() { return touched; }

    public interface TouchListener {
        void onTouchDown(float x, float y);
        void onTouchMove(float x, float y);
        void onTouchUp(float x, float y);
    }
}
