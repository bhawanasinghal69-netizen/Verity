package com.apex.engine.physics;

import com.apex.engine.ecs.Entity;
import com.apex.engine.components.Collider;
import com.apex.engine.components.RigidBody;
import java.util.ArrayList;
import java.util.List;

public class PhysicsEngine {
    private List<Entity> physicsEntities;
    private List<CollisionCallback> collisionCallbacks;
    private float timeStep = 0.016f;

    public PhysicsEngine() {
        this.physicsEntities = new ArrayList<>();
        this.collisionCallbacks = new ArrayList<>();
    }

    public void update(float deltaTime) {
        // Update rigid bodies
        for (Entity entity : physicsEntities) {
            RigidBody rb = entity.getComponent(RigidBody.class);
            if (rb != null) {
                rb.update(deltaTime);
            }
        }

        // Check collisions
        checkCollisions();
    }

    private void checkCollisions() {
        for (int i = 0; i < physicsEntities.size(); i++) {
            Collider collider1 = physicsEntities.get(i).getComponent(Collider.class);
            if (collider1 == null) continue;

            for (int j = i + 1; j < physicsEntities.size(); j++) {
                Collider collider2 = physicsEntities.get(j).getComponent(Collider.class);
                if (collider2 != null && collider1.isCollidingWith(collider2)) {
                    fireCollisionEvent(physicsEntities.get(i), physicsEntities.get(j));
                }
            }
        }
    }

    private void fireCollisionEvent(Entity a, Entity b) {
        for (CollisionCallback callback : collisionCallbacks) {
            callback.onCollision(a, b);
        }
    }

    public void registerEntity(Entity entity) {
        if (!physicsEntities.contains(entity)) {
            physicsEntities.add(entity);
        }
    }

    public void addCollisionCallback(CollisionCallback callback) {
        collisionCallbacks.add(callback);
    }

    public interface CollisionCallback {
        void onCollision(Entity a, Entity b);
    }
}
