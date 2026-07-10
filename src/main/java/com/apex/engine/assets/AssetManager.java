package com.apex.engine.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    private Context context;
    private Map<String, Bitmap> textureCache;
    private Map<String, Object> assetCache;
    private static final int MAX_CACHE_SIZE = 50 * 1024 * 1024; // 50MB max cache
    private int currentCacheSize = 0;

    public AssetManager(Context context) {
        this.context = context;
        this.textureCache = new HashMap<>();
        this.assetCache = new HashMap<>();
    }

    public Bitmap loadTexture(String assetPath) {
        // Check cache first
        if (textureCache.containsKey(assetPath)) {
            return textureCache.get(assetPath);
        }

        try {
            Bitmap bitmap = BitmapFactory.decodeStream(context.getAssets().open(assetPath));
            
            // Simple cache management
            if (currentCacheSize + bitmap.getByteCount() <= MAX_CACHE_SIZE) {
                textureCache.put(assetPath, bitmap);
                currentCacheSize += bitmap.getByteCount();
            }
            
            return bitmap;
        } catch (Exception e) {
            System.err.println("Failed to load texture: " + assetPath);
            return null;
        }
    }

    public void unloadTexture(String assetPath) {
        Bitmap bitmap = textureCache.remove(assetPath);
        if (bitmap != null) {
            currentCacheSize -= bitmap.getByteCount();
            bitmap.recycle();
        }
    }

    public void clearCache() {
        for (Bitmap bitmap : textureCache.values()) {
            bitmap.recycle();
        }
        textureCache.clear();
        assetCache.clear();
        currentCacheSize = 0;
    }
}
