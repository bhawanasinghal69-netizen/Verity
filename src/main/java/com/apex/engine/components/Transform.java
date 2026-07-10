package com.apex.engine.components;

import com.apex.engine.ecs.Component;

public class Transform extends Component {
    public float x = 0, y = 0, z = 0;
    public float rotationX = 0, rotationY = 0, rotationZ = 0;
    public float scaleX = 1, scaleY = 1, scaleZ = 1;
    private float[] matrix = new float[16];

    @Override
    public void update(float deltaTime) {
        updateMatrix();
    }

    @Override
    public void render() {}

    private void updateMatrix() {
        // Update transformation matrix
    }

    public void setPosition(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setRotation(float x, float y, float z) {
        this.rotationX = x;
        this.rotationY = y;
        this.rotationZ = z;
    }

    public void setScale(float x, float y, float z) {
        this.scaleX = x;
        this.scaleY = y;
        this.scaleZ = z;
    }

    public float[] getMatrix() {
        return matrix;
    }
}
