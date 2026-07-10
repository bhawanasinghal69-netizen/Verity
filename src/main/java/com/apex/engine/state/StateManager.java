package com.apex.engine.state;

import android.content.Context;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StateManager {
    private Context context;
    private Map<String, GameState> states;
    private GameState currentState;
    private static final String SAVE_DIR = "game_saves";

    public StateManager(Context context) {
        this.context = context;
        this.states = new HashMap<>();
    }

    public GameState createState(String saveSlot) {
        GameState state = new GameState(saveSlot);
        states.put(saveSlot, state);
        return state;
    }

    public void saveState(GameState state) {
        try {
            File dir = new File(context.getFilesDir(), SAVE_DIR);
            if (!dir.exists()) dir.mkdirs();
            
            File saveFile = new File(dir, state.getSaveSlot() + ".save");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile));
            oos.writeObject(state);
            oos.close();
        } catch (IOException e) {
            System.err.println("Failed to save state: " + e.getMessage());
        }
    }

    public GameState loadState(String saveSlot) {
        try {
            File saveFile = new File(new File(context.getFilesDir(), SAVE_DIR), saveSlot + ".save");
            if (!saveFile.exists()) return null;
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
            GameState state = (GameState) ois.readObject();
            ois.close();
            states.put(saveSlot, state);
            return state;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load state: " + e.getMessage());
            return null;
        }
    }

    public void setCurrentState(GameState state) {
        this.currentState = state;
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
