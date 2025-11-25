package com.swaglabs.mobile.utils;

public class DragPositionUtil {
    private int customX = 0;
    private int customY = 0;

    public DragPositionUtil(int customX, int customY) {
        this.customX = customX;
        this.customY = customY;
    }

    public int getCustomX() {
        return customX;
    }

    public void setCustomX(int customX) {
        this.customX = customX;
    }

    public int getCustomY() {
        return customY;
    }

    public void setCustomY(int customY) {
        this.customY = customY;
    }
}
