package com.apex.engine.components;

public class CircleCollider extends Collider {
    private float radius;
    private float offsetX = 0, offsetY = 0;

    public CircleCollider(float radius) {
        this.radius = radius;
    }

    @Override
    public void update(float deltaTime) {}

    @Override
    public void render() {}

    @Override
    public boolean isCollidingWith(Collider other) {
        Transform t1 = entity.getComponent(Transform.class);
        Transform t2 = other.entity.getComponent(Transform.class);
        
        if (t1 != null && t2 != null) {
            float dx = (t1.x + offsetX) - (t2.x + (other instanceof CircleCollider ? ((CircleCollider) other).offsetX : 0));
            float dy = (t1.y + offsetY) - (t2.y + (other instanceof CircleCollider ? ((CircleCollider) other).offsetY : 0));
            float distance = (float) Math.sqrt(dx * dx + dy * dy);
            
            float otherRadius = other instanceof CircleCollider ? ((CircleCollider) other).radius : 0;
            return distance < radius + otherRadius;
        }
        return false;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}
