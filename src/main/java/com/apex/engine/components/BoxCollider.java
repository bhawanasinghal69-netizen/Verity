package com.apex.engine.components;

public class BoxCollider extends Collider {
    private float width, height;
    private float offsetX = 0, offsetY = 0;

    public BoxCollider(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(float deltaTime) {}

    @Override
    public void render() {}

    @Override
    public boolean isCollidingWith(Collider other) {
        if (other instanceof BoxCollider) {
            BoxCollider box = (BoxCollider) other;
            Transform t1 = entity.getComponent(Transform.class);
            Transform t2 = box.entity.getComponent(Transform.class);
            
            if (t1 != null && t2 != null) {
                return (t1.x + offsetX < t2.x + box.offsetX + box.width &&
                        t1.x + offsetX + width > t2.x + box.offsetX &&
                        t1.y + offsetY < t2.y + box.offsetY + box.height &&
                        t1.y + offsetY + height > t2.y + box.offsetY);
            }
        }
        return false;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setOffset(float x, float y) {
        this.offsetX = x;
        this.offsetY = y;
    }
}
