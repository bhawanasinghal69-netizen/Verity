package com.apex.engine.ecs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {
    private Map<Integer, Entity> entities;
    private List<Entity> activeEntities;
    private int nextEntityId = 0;
    private static final int MAX_ENTITIES = 10000; // Limit for low-end devices

    public EntityManager() {
        this.entities = new HashMap<>();
        this.activeEntities = new ArrayList<>();
    }

    public Entity createEntity(String name) {
        if (entities.size() >= MAX_ENTITIES) {
            System.err.println("Max entity limit reached!");
            return null;
        }
        Entity entity = new Entity(nextEntityId++, name);
        entities.put(entity.getId(), entity);
        activeEntities.add(entity);
        return entity;
    }

    public void destroyEntity(Entity entity) {
        entities.remove(entity.getId());
        activeEntities.remove(entity);
    }

    public Entity getEntity(int id) {
        return entities.get(id);
    }

    public void updateAll(float deltaTime) {
        for (Entity entity : activeEntities) {
            if (entity.isActive()) {
                entity.update(deltaTime);
            }
        }
    }

    public void renderAll() {
        for (Entity entity : activeEntities) {
            if (entity.isActive()) {
                entity.render();
            }
        }
    }

    public int getEntityCount() {
        return entities.size();
    }
}
