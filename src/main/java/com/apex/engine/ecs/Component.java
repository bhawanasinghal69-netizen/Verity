package com.apex.engine.ecs;

public abstract class Component {
    protected Entity entity;

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public abstract void update(float deltaTime);
    
    public abstract void render();
}
