package com.google.android.cameraview;

import com.google.android.cameraview.log.DefaultLogImpl;
import com.google.android.cameraview.log.ILog;

/**
 * Author: lxy
 * Date: 2018/7/27
 * Version:1.0.0
 * Desc: The Helper for additional function
 */
public class CustomHelper {
    private static ILog sLog;

    /**
     * get Logger
     *
     * @return ILog
     */
    public static ILog getLogger() {
        if (null == sLog) {
            sLog = new DefaultLogImpl();
        }
        return sLog;
    }
}
