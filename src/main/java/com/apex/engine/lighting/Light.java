package com.apex.engine.lighting;

public class Light {
    public enum LightType {
        DIRECTIONAL,
        POINT,
        SPOT
    }

    private LightType type;
    private float[] position = new float[3];
    private float[] color = new float[3];
    private float intensity = 1.0f;
    private float range = 10.0f; // For point lights
    private float[] direction = new float[3]; // For directional/spot lights
    private float spotAngle = 45.0f; // For spot lights
    private boolean enabled = true;

    public Light(LightType type) {
        this.type = type;
        this.color[0] = this.color[1] = this.color[2] = 1.0f;
    }

    // Getters and Setters
    public LightType getType() { return type; }
    public float[] getPosition() { return position; }
    public void setPosition(float x, float y, float z) {
        position[0] = x;
        position[1] = y;
        position[2] = z;
    }

    public float[] getColor() { return color; }
    public void setColor(float r, float g, float b) {
        color[0] = r;
        color[1] = g;
        color[2] = b;
    }

    public float getIntensity() { return intensity; }
    public void setIntensity(float intensity) { this.intensity = intensity; }

    public float getRange() { return range; }
    public void setRange(float range) { this.range = range; }

    public float[] getDirection() { return direction; }
    public void setDirection(float x, float y, float z) {
        direction[0] = x;
        direction[1] = y;
        direction[2] = z;
    }

    public float getSpotAngle() { return spotAngle; }
    public void setSpotAngle(float angle) { this.spotAngle = angle; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
