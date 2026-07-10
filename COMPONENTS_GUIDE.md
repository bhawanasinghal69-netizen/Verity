# Apex Game Engine - Components Guide

## Core Components

### Transform
Manages position, rotation, and scale of entities.
```java
Transform transform = new Transform();
transform.setPosition(10, 20, 0);
transform.setRotation(0, 0, 45);
transform.setScale(1, 1, 1);
```

### SpriteRenderer
Renders 2D sprites with alpha and layer support.
```java
SpriteRenderer sprite = new SpriteRenderer("sprites/player.png");
sprite.setColor(0xFFFFFFFF);
sprite.setAlpha(0.8f);
sprite.setLayer(0);
entity.addComponent(sprite);
```

## Physics Components

### RigidBody
Adds physics simulation with gravity and velocity.
```java
RigidBody rb = new RigidBody();
rb.setVelocity(5, 0, 0);
rb.addForce(10, 0, 0);
rb.setGravityScale(1.0f);
entity.addComponent(rb);
```

### BoxCollider
2D rectangular collision detection.
```java
BoxCollider collider = new BoxCollider(32, 32);
collider.setIsTrigger(false);
collider.setCollisionTag("Player");
entity.addComponent(collider);
```

### CircleCollider
2D circular collision detection.
```java
CircleCollider collider = new CircleCollider(16);
collider.setRadius(20);
entity.addComponent(collider);
```

## Animation Components

### Animator
Manages sprite animations with multiple sequences.
```java
Animator animator = new Animator();
Animation walkAnimation = new Animation("walk");
walkAnimation.addFrame(sprite1, 0.1f);
walkAnimation.addFrame(sprite2, 0.1f);
animator.addAnimation(walkAnimation);
animator.playAnimation("walk");
entity.addComponent(animator);
```

## Usage Example

```java
// Create entity
Entity player = scene.createEntity("Player");

// Add components
Transform transform = new Transform();
transform.setPosition(0, 0, 0);
player.addComponent(transform);

SpriteRenderer sprite = new SpriteRenderer("sprites/player.png");
player.addComponent(sprite);

RigidBody rb = new RigidBody();
player.addComponent(rb);

BoxCollider collider = new BoxCollider(32, 32);
player.addComponent(collider);
```

## Systems

### PhysicsEngine
Handles collision detection and rigid body updates.
```java
PhysicsEngine physics = new PhysicsEngine();
physics.registerEntity(player);
physics.addCollisionCallback((a, b) -> {
    System.out.println(a.getName() + " collided with " + b.getName());
});
```

### ParticleSystem
Creates and manages particle effects.
```java
ParticleSystem particles = new ParticleSystem();
particles.emit(x, y, 50, 5.0f, 0xFF00FF00);
```

### AudioManager
Manages game sounds and music.
```java
AudioManager audio = new AudioManager();
audio.loadSound(context, "jump", "sounds/jump.wav");
audio.playSound("jump");
```

### StateManager
Saves and loads game progress.
```java
StateManager stateManager = new StateManager(context);
GameState state = stateManager.createState("slot1");
state.set("score", 1000);
stateManager.saveState(state);
```
