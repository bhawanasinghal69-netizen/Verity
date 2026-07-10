package com.apex.engine.examples;

import com.apex.engine.scene.Scene;
import com.apex.engine.ecs.Entity;
import com.apex.engine.components.*;
import com.apex.engine.lighting.Light;

public class SampleGame extends Scene {
    public SampleGame() {
        super("SampleGame");
    }

    @Override
    public void onLoad() {
        // Create player entity
        Entity player = createEntity("Player");
        player.addComponent(new Transform());
        player.addComponent(new SpriteRenderer("sprites/player.png"));
        player.addComponent(new BoxCollider(32, 32));
        player.addComponent(new RigidBody());

        // Create enemy
        Entity enemy = createEntity("Enemy");
        enemy.addComponent(new Transform());
        enemy.addComponent(new SpriteRenderer("sprites/enemy.png"));
        enemy.addComponent(new CircleCollider(16));
    }

    @Override
    public void onUnload() {}

    @Override
    public void update(float deltaTime) {
        entityManager.updateAll(deltaTime);
    }

    @Override
    public void render() {
        entityManager.renderAll();
    }
}
