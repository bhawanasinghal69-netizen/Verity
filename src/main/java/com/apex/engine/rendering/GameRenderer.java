package com.apex.engine.rendering;

import android.opengl.GLSurfaceView;
import android.opengl.GLES20;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import com.apex.engine.core.GameEngine;
import com.apex.engine.lighting.LightingSystem;

public class GameRenderer implements GLSurfaceView.Renderer {
    private GameEngine gameEngine;
    private LightingSystem lightingSystem;
    private ShaderProgram defaultShaderProgram;
    private int screenWidth, screenHeight;

    public GameRenderer(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.lightingSystem = new LightingSystem();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set clear color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        
        // Initialize shaders
        defaultShaderProgram = new ShaderProgram();
        defaultShaderProgram.compile();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear screen
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        
        // Update game engine
        gameEngine.update();
        
        // Render with lighting
        lightingSystem.prepareFrame();
        gameEngine.render();
    }

    public LightingSystem getLightingSystem() {
        return lightingSystem;
    }

    public ShaderProgram getShaderProgram() {
        return defaultShaderProgram;
    }
}
