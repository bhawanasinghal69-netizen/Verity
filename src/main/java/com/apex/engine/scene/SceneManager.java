package com.apex.engine.scene;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private Map<String, Scene> scenes;
    private Scene currentScene;

    public SceneManager() {
        this.scenes = new HashMap<>();
    }

    public void addScene(Scene scene) {
        scene.onLoad();
        scenes.put(scene.getName(), scene);
    }

    public void switchScene(String sceneName) {
        if (currentScene != null) {
            currentScene.onUnload();
            currentScene.setActive(false);
        }
        
        currentScene = scenes.get(sceneName);
        if (currentScene != null) {
            currentScene.setActive(true);
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Scene getScene(String name) {
        return scenes.get(name);
    }
}
