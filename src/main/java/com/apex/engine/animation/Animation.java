package com.apex.engine.animation;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List<AnimationFrame> frames;
    private String name;
    private float currentTime = 0;
    private int currentFrame = 0;
    private boolean isLooping = true;
    private boolean isPlaying = false;

    public Animation(String name) {
        this.name = name;
        this.frames = new ArrayList<>();
    }

    public void addFrame(Bitmap sprite, float duration) {
        frames.add(new AnimationFrame(sprite, duration));
    }

    public void update(float deltaTime) {
        if (!isPlaying || frames.isEmpty()) return;

        currentTime += deltaTime;
        
        if (currentTime >= frames.get(currentFrame).duration) {
            currentTime -= frames.get(currentFrame).duration;
            currentFrame++;

            if (currentFrame >= frames.size()) {
                if (isLooping) {
                    currentFrame = 0;
                } else {
                    isPlaying = false;
                }
            }
        }
    }

    public Bitmap getCurrentSprite() {
        if (currentFrame < frames.size()) {
            return frames.get(currentFrame).sprite;
        }
        return null;
    }

    public void play() {
        isPlaying = true;
        currentFrame = 0;
        currentTime = 0;
    }

    public void stop() {
        isPlaying = false;
    }

    public void setLooping(boolean looping) {
        this.isLooping = looping;
    }

    public boolean isFinished() {
        return !isPlaying && currentFrame >= frames.size() - 1;
    }

    private static class AnimationFrame {
        Bitmap sprite;
        float duration;

        AnimationFrame(Bitmap sprite, float duration) {
            this.sprite = sprite;
            this.duration = duration;
        }
    }
}
