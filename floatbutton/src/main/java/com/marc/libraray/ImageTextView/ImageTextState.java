package com.marc.libraray.ImageTextView;

import android.support.annotation.IntDef;

/**
 * Image Load State
 */
@SuppressWarnings("WeakerAccess")
@IntDef({ImageTextState.ready, ImageTextState.loading, ImageTextState.loaded})
public @interface ImageTextState {
    int ready = 0; // 未开始加载
    int loading = 1; // 加载中
    int loaded = 2; // 加载完毕
}
