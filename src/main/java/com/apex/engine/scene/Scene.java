package com.apex.engine.scene;

import com.apex.engine.ecs.Entity;
import com.apex.engine.ecs.EntityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    protected EntityManager entityManager;
    protected List<Entity> entities;
    protected String name;
    protected boolean isActive = true;

    public Scene(String name) {
        this.name = name;
        this.entityManager = new EntityManager();
        this.entities = new ArrayList<>();
    }

    public abstract void onLoad();
    
    public abstract void onUnload();
    
    public abstract void update(float deltaTime);
    
    public abstract void render();

    public Entity createEntity(String entityName) {
        Entity entity = entityManager.createEntity(entityName);
        if (entity != null) entities.add(entity);
        return entity;
    }

    public void destroyEntity(Entity entity) {
        entityManager.destroyEntity(entity);
        entities.remove(entity);
    }

    public String getName() { return name; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
    public List<Entity> getEntities() { return entities; }
}
