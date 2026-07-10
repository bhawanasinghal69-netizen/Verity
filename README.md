# Apex Game Engine

A high-performance, lightweight game engine for Android optimized for low-end devices (<1GB RAM).

## Features

✅ **2D, 3D, and 2.5D Rendering**
- Support for pure 2D canvas rendering
- 3D OpenGL ES support
- Isometric/pseudo-3D (2.5D) rendering for hybrid games

✅ **Custom Lighting System**
- Directional, Point, and Spot lights
- Ambient lighting control
- Normal mapping support
- Diffuse and specular lighting
- Optimized for 16 concurrent lights

✅ **Entity-Component System (ECS)**
- Flexible entity-component architecture
- Easy-to-extend component system
- Efficient entity management

✅ **Low-End Device Optimization**
- Object pooling for reduced garbage collection
- Texture atlasing and LOD system
- Memory-efficient rendering pipeline
- Dynamic performance monitoring
- Runs on devices with <1GB RAM

✅ **Easy-to-Use UI Framework**
- Simple widget system (Buttons, Text, Images)
- Layout managers (Vertical, Horizontal, Grid)
- Touch event handling
- Drag-and-drop ready

✅ **Built-in Systems**
- Scene management
- Asset management with caching
- Performance monitoring (FPS, Memory, Delta Time)
- Input handling

## Project Structure

```
verity/
├── src/main/java/com/apex/engine/
│   ├── core/                 # Core engine
│   ├── ecs/                  # Entity-Component System
│   ├── scene/                # Scene management
│   ├── rendering/            # Rendering pipeline
│   ├── lighting/             # Custom lighting system
│   ├── ui/                   # UI framework
│   ├── assets/               # Asset management
│   └── utils/                # Utilities & monitoring
├── build.gradle
└── AndroidManifest.xml
```

## Quick Start

### 1. Create a Scene

```java
public class GameScene extends Scene {
    public GameScene() {
        super("GameScene");
    }
    
    @Override
    public void onLoad() {
        // Create entities
        Entity player = createEntity("Player");
    }
    
    @Override
    public void update(float deltaTime) {
        // Update logic
    }
    
    @Override
    public void render() {
        entityManager.renderAll();
    }
    
    @Override
    public void onUnload() {}
}
```

### 2. Add Lighting

```java
GameEngine engine = // ...
LightingSystem lighting = renderer.getLightingSystem();

// Add a point light
Light pointLight = lighting.addLight(Light.LightType.POINT);
pointLight.setPosition(5, 5, 5);
pointLight.setColor(1.0f, 1.0f, 1.0f);
pointLight.setIntensity(1.0f);
pointLight.setRange(20.0f);
```

### 3. Create UI Elements

```java
UIManager uiManager = new UIManager();

// Add button (implement custom UIButton class)
UIElement button = new UIButton(100, 100, 200, 50, "Play");
button.setOnClickListener(element -> {
    // Handle click
});
uiManager.addElement(button);
```

## Performance

Optimizations for low-end devices:
- ✅ Entity limit: 10,000
- ✅ Light limit: 16 (configurable)
- ✅ Dynamic memory monitoring
- ✅ Automatic garbage collection triggers
- ✅ Texture caching with LRU eviction

## Rendering Modes

- `MODE_2D` - Traditional 2D canvas rendering
- `MODE_3D` - Full 3D OpenGL rendering
- `MODE_2D_3D_HYBRID` - 2.5D isometric rendering (recommended for low-end)

## Next Steps

1. **Add more components** (Transform, Animator, Physics)
2. **Create particle system** for effects
3. **Implement audio manager** for sound/music
4. **Add physics engine** (basic 2D/3D collision)
5. **Create sample games** for reference

## License

MIT License - Feel free to use in your projects!
