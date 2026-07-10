package com.apex.engine.ecs;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private int id;
    private String name;
    private Map<Class<?>, Component> components;
    private boolean active = true;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
        this.components = new HashMap<>();
    }

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
        component.setEntity(this);
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(Class<T> componentClass) {
        return (T) components.get(componentClass);
    }

    public boolean hasComponent(Class<?> componentClass) {
        return components.containsKey(componentClass);
    }

    public void update(float deltaTime) {
        if (!active) return;
        for (Component component : components.values()) {
            component.update(deltaTime);
        }
    }

    public void render() {
        if (!active) return;
        for (Component component : components.values()) {
            component.render();
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
