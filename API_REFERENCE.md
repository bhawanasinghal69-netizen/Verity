# Apex Game Engine - API Reference

## Core Classes

### GameEngine
```java
GameEngine engine = new GameEngine(context);
engine.update();
engine.render();
engine.getDeltaTime();
engine.getSceneManager();
engine.getEntityManager();
```

### Scene
```java
Scene scene = new MyScene("name");
Entity entity = scene.createEntity("entity_name");
scene.destroyEntity(entity);
scene.update(deltaTime);
scene.render();
```

### Entity
```java
entity.addComponent(component);
Transform t = entity.getComponent(Transform.class);
entity.isActive();
entity.setActive(false);
```

## Components

### Transform
- `setPosition(x, y, z)`
- `setRotation(x, y, z)`
- `setScale(x, y, z)`
- `getMatrix()`

### SpriteRenderer
- `setSprite(bitmap)`
- `setColor(color)`
- `setAlpha(alpha)`
- `setLayer(layer)`

### RigidBody
- `addForce(x, y, z)`
- `setVelocity(x, y, z)`
- `setMass(mass)`
- `setGravityScale(scale)`

### Colliders
- `setIsTrigger(trigger)`
- `setCollisionTag(tag)`
- `isCollidingWith(other)`

## Systems

### LightingSystem
```java
Light light = lighting.addLight(Light.LightType.POINT);
light.setPosition(x, y, z);
light.setColor(r, g, b);
light.setIntensity(intensity);
light.setRange(range);
```

### PhysicsEngine
```java
PhysicsEngine physics = new PhysicsEngine();
physics.registerEntity(entity);
physics.update(deltaTime);
physics.addCollisionCallback((a, b) -> {});
```

### ParticleSystem
```java
ParticleSystem particles = new ParticleSystem();
particles.emit(x, y, count, speed, color);
particles.update(deltaTime);
```

### AudioManager
```java
AudioManager audio = new AudioManager();
audio.loadSound(context, "name", "path");
audio.playSound("name");
audio.setMasterVolume(volume);
```

### UIManager
```java
UIManager ui = new UIManager();
ui.addElement(element);
ui.renderAll();
ui.onTouchDown(x, y);
```

### StateManager
```java
StateManager state = new StateManager(context);
GameState gameState = state.createState("slot");
gameState.set("key", value);
state.saveState(gameState);
state.loadState("slot");
```

## Enums

### RenderMode
- `MODE_2D`
- `MODE_3D`
- `MODE_2D_3D_HYBRID`
- `MODE_CUSTOM`

### Light.LightType
- `DIRECTIONAL`
- `POINT`
- `SPOT`
