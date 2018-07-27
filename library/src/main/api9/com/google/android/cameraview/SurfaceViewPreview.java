/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.cameraview;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.cameraview.log.ILog;

class SurfaceViewPreview extends PreviewImpl {
    private ILog mLog = CustomHelper.getLogger();
    final SurfaceView mSurfaceView;

    SurfaceViewPreview(Context context, ViewGroup parent) {
        mLog.logD("SurfaceViewPreview construct");
        final View view = View.inflate(context, R.layout.surface_view, parent);
        mSurfaceView = (SurfaceView) view.findViewById(R.id.surface_view);
        final SurfaceHolder holder = mSurfaceView.getHolder();
        //noinspection deprecation
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder h) {
                mLog.logD("surfaceCreated");
            }

            @Override
            public void surfaceChanged(SurfaceHolder h, int format, int width, int height) {
                mLog.logD("surfaceChanged width: " + width + " | height : " + height);
                setSize(width, height);
                if (!ViewCompat.isInLayout(mSurfaceView)) {
                    mLog.logD("dispatchSurfaceChanged");
                    dispatchSurfaceChanged();
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder h) {
                setSize(0, 0);
            }
        });
    }

    @Override
    Surface getSurface() {
        return getSurfaceHolder().getSurface();
    }

    @Override
    SurfaceHolder getSurfaceHolder() {
        return mSurfaceView.getHolder();
    }

    @Override
    View getView() {
        return mSurfaceView;
    }

    @Override
    Class getOutputClass() {
        return SurfaceHolder.class;
    }

    @Override
    void setDisplayOrientation(int displayOrientation) {
    }

    @Override
    boolean isReady() {
        return getWidth() != 0 && getHeight() != 0;
    }

}
