package com.google.android.cameraview;

/**
 * Author: lxy
 * Date: 2018/7/30
 * Version:1.0.0
 * Desc:
 */
public interface ICameraViewCallback {

    void onCameraOpened();

    void onCameraClosed();

    void onPictureTaken(byte[] data);
}
