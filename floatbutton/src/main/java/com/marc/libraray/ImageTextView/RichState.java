package com.marc.libraray.ImageTextView;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("WeakerAccess")
@IntDef({RichState.ready, RichState.loading, RichState.loaded})
@Retention(RetentionPolicy.SOURCE)
public @interface RichState {
    int ready = 0; // 未开始加载
    int loading = 1; // 加载中
    int loaded = 2; // 加载完毕
}
