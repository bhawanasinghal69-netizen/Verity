package com.apex.engine.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.util.HashMap;
import java.util.Map;

public class AudioManager {
    private SoundPool soundPool;
    private Map<String, Integer> soundMap;
    private float masterVolume = 1.0f;
    private static final int MAX_SOUNDS = 10;

    public AudioManager() {
        soundPool = new SoundPool(MAX_SOUNDS, android.media.AudioManager.STREAM_MUSIC, 0);
        soundMap = new HashMap<>();
    }

    public void loadSound(Context context, String soundName, String assetPath) {
        try {
            int soundId = soundPool.load(context.getAssets().openFd(assetPath), 1);
            soundMap.put(soundName, soundId);
        } catch (Exception e) {
            System.err.println("Failed to load sound: " + assetPath);
        }
    }

    public void playSound(String soundName) {
        Integer soundId = soundMap.get(soundName);
        if (soundId != null) {
            soundPool.play(soundId, masterVolume, masterVolume, 1, 0, 1.0f);
        }
    }

    public void playSoundLooped(String soundName) {
        Integer soundId = soundMap.get(soundName);
        if (soundId != null) {
            soundPool.play(soundId, masterVolume, masterVolume, 1, -1, 1.0f);
        }
    }

    public void stopSound(String soundName) {
        Integer soundId = soundMap.get(soundName);
        if (soundId != null) {
            soundPool.stop(soundId);
        }
    }

    public void setMasterVolume(float volume) {
        this.masterVolume = Math.max(0, Math.min(1, volume));
    }

    public void release() {
        soundPool.release();
    }
}
