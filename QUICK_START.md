# Apex Game Engine - Quick Start Guide

## Installation

1. Clone the repository:
```bash
git clone https://github.com/bhawanasinghal69-netizen/verity.git
cd verity
git checkout dev
```

2. Open in Android Studio and sync Gradle

## Create Your First Game

### Step 1: Create a Scene
```java
public class MyGameScene extends Scene {
    public MyGameScene() {
        super("MyGame");
    }
    
    @Override
    public void onLoad() {
        Entity player = createEntity("Player");
        player.addComponent(new Transform());
        player.addComponent(new SpriteRenderer("sprites/player.png"));
        player.addComponent(new BoxCollider(32, 32));
        player.addComponent(new RigidBody());
    }
    
    @Override
    public void update(float deltaTime) {
        entityManager.updateAll(deltaTime);
    }
    
    @Override
    public void render() {
        entityManager.renderAll();
    }
    
    @Override
    public void onUnload() {}
}
```

### Step 2: Setup Game Engine in Activity
```java
public class ApexGameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        GameEngine engine = new GameEngine(this);
        GameRenderer renderer = new GameRenderer(engine);
        
        MyGameScene scene = new MyGameScene();
        engine.getSceneManager().addScene(scene);
        engine.getSceneManager().switchScene("MyGame");
    }
}
```

### Step 3: Add Lighting
```java
LightingSystem lighting = renderer.getLightingSystem();
Light mainLight = lighting.addLight(Light.LightType.DIRECTIONAL);
mainLight.setColor(1.0f, 1.0f, 1.0f);
mainLight.setIntensity(0.8f);
```

### Step 4: Add UI
```java
UIManager uiManager = new UIManager();
UIButton playButton = new UIButton(100, 100, 200, 50, "Play");
playButton.setOnClickListener(element -> {
    engine.getSceneManager().switchScene("MyGame");
});
uiManager.addElement(playButton);
```

## Performance Tips

✅ **Do's:**
- Use entity pooling for repeated entities
- Limit active entities to < 1000 for low-end devices
- Use 2.5D rendering mode for better performance
- Implement LOD (Level of Detail) for distant objects
- Cache assets in AssetManager

❌ **Don'ts:**
- Don't create/destroy entities every frame
- Don't load assets without caching
- Don't use more than 16 lights
- Don't render off-screen objects

## Example: Simple 2D Game

```java
public class FlappyBirdScene extends Scene {
    private Entity bird;
    private ParticleSystem particles;
    
    @Override
    public void onLoad() {
        bird = createEntity("Bird");
        Transform birdTransform = new Transform();
        birdTransform.setPosition(100, 200, 0);
        bird.addComponent(birdTransform);
        bird.addComponent(new SpriteRenderer("sprites/bird.png"));
        bird.addComponent(new CircleCollider(16));
        bird.addComponent(new RigidBody());
        
        particles = new ParticleSystem();
    }
    
    @Override
    public void update(float deltaTime) {
        RigidBody rb = bird.getComponent(RigidBody.class);
        rb.addForce(0, -500, 0); // Lift
        
        entityManager.updateAll(deltaTime);
        particles.update(deltaTime);
    }
    
    @Override
    public void render() {
        entityManager.renderAll();
        // Render particles
    }
}
```

## Debugging

Enable performance monitoring:
```java
PerformanceMonitor monitor = engine.getPerformanceMonitor();
System.out.println("FPS: " + monitor.getFPS());
System.out.println("Memory: " + monitor.getMemoryUsedMB() + "MB");
```
