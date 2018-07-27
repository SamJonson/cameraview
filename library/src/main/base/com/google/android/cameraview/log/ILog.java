package com.google.android.cameraview.log;

import android.support.annotation.NonNull;

/**
 * the interface for log
 */
public interface ILog {
    void logE(@NonNull String tag, @NonNull String msg, @NonNull Exception ex);

    void logD(@NonNull String tag, @NonNull String msg);

    void logD(@NonNull String msg);

    void logE(@NonNull String msg, @NonNull Exception ex);
}
