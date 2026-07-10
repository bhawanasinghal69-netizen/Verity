package com.apex.engine.components;

import com.apex.engine.ecs.Component;

public class RigidBody extends Component {
    private float velocityX = 0, velocityY = 0, velocityZ = 0;
    private float mass = 1.0f;
    private float friction = 0.9f;
    private float drag = 0.99f;
    private boolean useGravity = true;
    private float gravityScale = 1.0f;
    private static final float GRAVITY = 9.8f;

    @Override
    public void update(float deltaTime) {
        Transform transform = entity.getComponent(Transform.class);
        if (transform == null) return;

        // Apply gravity
        if (useGravity) {
            velocityY += GRAVITY * gravityScale * deltaTime;
        }

        // Apply drag
        velocityX *= drag;
        velocityY *= drag;
        velocityZ *= drag;

        // Update position
        transform.x += velocityX * deltaTime;
        transform.y += velocityY * deltaTime;
        transform.z += velocityZ * deltaTime;
    }

    @Override
    public void render() {}

    public void addForce(float x, float y, float z) {
        velocityX += x / mass;
        velocityY += y / mass;
        velocityZ += z / mass;
    }

    public void setVelocity(float x, float y, float z) {
        this.velocityX = x;
        this.velocityY = y;
        this.velocityZ = z;
    }

    public float getVelocityX() { return velocityX; }
    public float getVelocityY() { return velocityY; }
    public void setMass(float mass) { this.mass = Math.max(0.1f, mass); }
    public void setGravityScale(float scale) { this.gravityScale = scale; }
}
