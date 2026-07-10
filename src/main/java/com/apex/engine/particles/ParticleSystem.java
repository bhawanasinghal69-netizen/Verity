package com.apex.engine.particles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleSystem {
    private List<Particle> particles;
    private Random random;
    private static final int MAX_PARTICLES = 5000;

    public ParticleSystem() {
        this.particles = new ArrayList<>();
        this.random = new Random();
    }

    public void update(float deltaTime) {
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            p.update(deltaTime);
            if (!p.isAlive()) {
                particles.remove(i);
            }
        }
    }

    public void emit(float x, float y, int count, float speed, int color) {
        if (particles.size() >= MAX_PARTICLES) return;

        for (int i = 0; i < count; i++) {
            float angle = random.nextFloat() * 360;
            float vx = (float) (Math.cos(Math.toRadians(angle)) * speed);
            float vy = (float) (Math.sin(Math.toRadians(angle)) * speed);
            Particle p = new Particle(x, y, vx, vy, 1.0f, color, 5);
            particles.add(p);
        }
    }

    public List<Particle> getParticles() {
        return particles;
    }

    public void clear() {
        particles.clear();
    }
}
