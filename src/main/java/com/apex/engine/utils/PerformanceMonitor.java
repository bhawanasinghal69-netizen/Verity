package com.apex.engine.utils;

public class PerformanceMonitor {
    private int frameCount = 0;
    private long lastUpdateTime = 0;
    private float fps = 0;
    private float avgDeltaTime = 0;
    private long startTime = System.nanoTime();
    private float cpuUsage = 0;
    private long memoryUsed = 0;

    public void recordFrame(float deltaTime) {
        frameCount++;
        avgDeltaTime = deltaTime;
        
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= 1000) { // Update FPS every second
            fps = frameCount;
            frameCount = 0;
            lastUpdateTime = currentTime;
            
            // Log performance
            logPerformanceStats();
        }
    }

    private void logPerformanceStats() {
        Runtime runtime = Runtime.getRuntime();
        memoryUsed = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024); // MB
        
        System.out.println("FPS: " + fps + " | Delta: " + avgDeltaTime + " | Memory: " + memoryUsed + "MB");
    }

    public float getFPS() { return fps; }
    public float getAvgDeltaTime() { return avgDeltaTime; }
    public long getMemoryUsedMB() { return memoryUsed; }
    public long getElapsedTimeSeconds() { return (System.nanoTime() - startTime) / 1_000_000_000L; }
}
