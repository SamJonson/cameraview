package com.google.android.cameraview;

import java.util.Set;

/**
 * Author: lxy
 * Date: 2018/7/30
 * Version: 1.0.0
 * Desc:
 */
public interface ICameraView {
    /**
     * @return {@code true} if the implementation was able to start the camera session.
     */
    boolean start();

    void stop();

    boolean isCameraOpened();

    void setFacing(int facing);

    int getFacing();

    Set<AspectRatio> getSupportedAspectRatios();

    /**
     * @return {@code true} if the aspect ratio was changed.
     */
    boolean setAspectRatio(AspectRatio ratio);

    AspectRatio getAspectRatio();

    void setAutoFocus(boolean autoFocus);

    boolean getAutoFocus();

    void setFlash(int flash);

    int getFlash();

    void takePicture();

    void setDisplayOrientation(int displayOrientation);
}
