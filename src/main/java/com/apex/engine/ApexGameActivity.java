package com.apex.engine;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.SurfaceView;
import com.apex.engine.core.GameEngine;
import com.apex.engine.rendering.GameRenderer;

public class ApexGameActivity extends Activity {
    private GLSurfaceView glSurfaceView;
    private GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize game engine
        gameEngine = new GameEngine(this);
        
        // Setup OpenGL Surface
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        
        GameRenderer renderer = new GameRenderer(gameEngine);
        glSurfaceView.setRenderer(renderer);
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        
        setContentView(glSurfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        glSurfaceView.onPause();
        super.onPause();
    }
}
