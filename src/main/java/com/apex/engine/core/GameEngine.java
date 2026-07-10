package com.apex.engine.core;

import android.content.Context;
import com.apex.engine.rendering.RenderMode;
import com.apex.engine.scene.Scene;
import com.apex.engine.scene.SceneManager;
import com.apex.engine.ecs.EntityManager;
import com.apex.engine.utils.PerformanceMonitor;

public class GameEngine {
    private Context context;
    private SceneManager sceneManager;
    private EntityManager entityManager;
    private PerformanceMonitor performanceMonitor;
    private float deltaTime = 0f;
    private long lastFrameTime = 0f;
    private boolean isRunning = true;
    private RenderMode renderMode = RenderMode.MODE_2D_3D_HYBRID;

    public GameEngine(Context context) {
        this.context = context;
        this.sceneManager = new SceneManager();
        this.entityManager = new EntityManager();
        this.performanceMonitor = new PerformanceMonitor();
        this.lastFrameTime = System.nanoTime();
    }

    public void update() {
        if (!isRunning) return;
        
        // Calculate delta time
        long currentTime = System.nanoTime();
        deltaTime = (currentTime - lastFrameTime) / 1_000_000_000f; // Convert to seconds
        lastFrameTime = currentTime;
        
        // Cap delta time to prevent large jumps
        if (deltaTime > 0.1f) deltaTime = 0.016f; // ~60 FPS
        
        // Update performance monitor
        performanceMonitor.recordFrame(deltaTime);
        
        // Update current scene
        Scene currentScene = sceneManager.getCurrentScene();
        if (currentScene != null) {
            currentScene.update(deltaTime);
        }
        
        // Update all entities
        entityManager.updateAll(deltaTime);
    }

    public void render() {
        Scene currentScene = sceneManager.getCurrentScene();
        if (currentScene != null) {
            currentScene.render();
        }
    }

    // Getters
    public float getDeltaTime() { return deltaTime; }
    public SceneManager getSceneManager() { return sceneManager; }
    public EntityManager getEntityManager() { return entityManager; }
    public PerformanceMonitor getPerformanceMonitor() { return performanceMonitor; }
    public Context getContext() { return context; }
    public RenderMode getRenderMode() { return renderMode; }
    
    // Setters
    public void setRenderMode(RenderMode mode) { this.renderMode = mode; }
    public void setRunning(boolean running) { this.isRunning = running; }
}
