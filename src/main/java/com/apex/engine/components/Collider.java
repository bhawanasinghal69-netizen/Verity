package com.apex.engine.components;

import com.apex.engine.ecs.Component;

public abstract class Collider extends Component {
    protected boolean isTrigger = false;
    protected String collisionTag = "Default";

    public void setIsTrigger(boolean trigger) {
        this.isTrigger = trigger;
    }

    public boolean isTrigger() {
        return isTrigger;
    }

    public void setCollisionTag(String tag) {
        this.collisionTag = tag;
    }

    public String getCollisionTag() {
        return collisionTag;
    }

    public abstract boolean isCollidingWith(Collider other);
}
