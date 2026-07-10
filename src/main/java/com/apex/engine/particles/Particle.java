package com.apex.engine.particles;

import com.apex.engine.components.Transform;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Particle {
    public float x, y;
    public float velocityX, velocityY;
    public float life, maxLife;
    public int color;
    public float size;
    private Paint paint;

    public Particle(float x, float y, float vx, float vy, float life, int color, float size) {
        this.x = x;
        this.y = y;
        this.velocityX = vx;
        this.velocityY = vy;
        this.life = life;
        this.maxLife = life;
        this.color = color;
        this.size = size;
        this.paint = new Paint();
        this.paint.setColor(color);
    }

    public void update(float deltaTime) {
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;
        life -= deltaTime;
        velocityY += 9.8f * deltaTime; // Gravity
    }

    public boolean isAlive() {
        return life > 0;
    }

    public float getAlpha() {
        return life / maxLife;
    }
}
