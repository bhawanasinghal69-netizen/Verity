package com.apex.engine.lighting;

import java.util.ArrayList;
import java.util.List;

public class LightingSystem {
    private List<Light> lights;
    private float[] ambientColor = new float[3];
    private float ambientStrength = 0.3f;
    private static final int MAX_LIGHTS = 16; // Optimized for low-end devices

    public LightingSystem() {
        this.lights = new ArrayList<>();
        this.ambientColor[0] = this.ambientColor[1] = this.ambientColor[2] = 1.0f;
    }

    public Light addLight(Light.LightType type) {
        if (lights.size() >= MAX_LIGHTS) {
            System.err.println("Max lights reached: " + MAX_LIGHTS);
            return null;
        }
        Light light = new Light(type);
        lights.add(light);
        return light;
    }

    public void removeLight(Light light) {
        lights.remove(light);
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setAmbientColor(float r, float g, float b) {
        ambientColor[0] = r;
        ambientColor[1] = g;
        ambientColor[2] = b;
    }

    public float[] getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientStrength(float strength) {
        this.ambientStrength = Math.max(0.0f, Math.min(1.0f, strength));
    }

    public float getAmbientStrength() {
        return ambientStrength;
    }

    public void prepareFrame() {
        // Prepare lighting data for rendering
        for (Light light : lights) {
            if (light.isEnabled()) {
                // Process active lights
            }
        }
    }
}
