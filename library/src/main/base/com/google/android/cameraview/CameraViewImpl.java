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

import android.view.View;

abstract class CameraViewImpl implements ICameraView {

    final ICameraViewCallback mCallback;

    final PreviewImpl mPreview;

    CameraViewImpl(ICameraViewCallback callback, PreviewImpl preview) {
        mCallback = callback;
        mPreview = preview;
    }

    View getView() {
        return mPreview.getView();
    }

    /*--------------- for  manual focus */

    public static final int FOCUS_AREA_SIZE_DEFAULT = 300;
    public static final int FOCUS_METERING_AREA_WEIGHT_DEFAULT = 1000;
    public static final int DELAY_MILLIS_BEFORE_RESETTING_FOCUS = 3000;


    int getFocusAreaSize() {
        return FOCUS_AREA_SIZE_DEFAULT;
    }

    int getFocusMeteringAreaWeight() {
        return FOCUS_METERING_AREA_WEIGHT_DEFAULT;
    }

    void detachFocusTapListener() {
        if (mPreview != null && mPreview.getView() != null) {
            mPreview.getView().setOnTouchListener(null);
        }
    }
}
