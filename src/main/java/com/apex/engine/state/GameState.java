package com.apex.engine.state;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> stateData;
    private long timestamp;
    private String saveSlot;

    public GameState(String saveSlot) {
        this.stateData = new HashMap<>();
        this.saveSlot = saveSlot;
        this.timestamp = System.currentTimeMillis();
    }

    public void set(String key, Object value) {
        stateData.put(key, value);
    }

    public Object get(String key) {
        return stateData.get(key);
    }

    public int getInt(String key, int defaultValue) {
        Object value = stateData.get(key);
        return value instanceof Integer ? (Integer) value : defaultValue;
    }

    public float getFloat(String key, float defaultValue) {
        Object value = stateData.get(key);
        return value instanceof Float ? (Float) value : defaultValue;
    }

    public String getString(String key, String defaultValue) {
        Object value = stateData.get(key);
        return value instanceof String ? (String) value : defaultValue;
    }

    public String getSaveSlot() {
        return saveSlot;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
