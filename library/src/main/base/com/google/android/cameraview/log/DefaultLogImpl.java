package com.google.android.cameraview.log;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

/**
 * the default log implement
 */
public class DefaultLogImpl implements ILog {
    private final String TAG = "DefaultLogTAG";

    @Override
    public void logE(@NonNull String tag, @NonNull String msg, @NonNull Exception ex) {
        logE(msg, ex);
    }

    @Override
    public void logD(@NonNull String tag, @NonNull String msg) {
        logD(msg);
    }

    @Override
    public void logD(@NonNull String msg) {
        Logger.d(msg);
    }

    @Override
    public void logE(@NonNull String msg, @NonNull Exception ex) {
        Logger.e(ex, msg);
    }
}
