package com.marc.libraray.ImageTextView;

import android.support.annotation.IntDef;

@IntDef({CacheType.NONE, CacheType.LAYOUT, CacheType.ALL})
public @interface CacheType {
    int NONE = 0; // 不进行缓存
    int LAYOUT = 1; // 只缓存文字样式和图片大小信息
    @Deprecated
    int ALL = 2; // 在LAYOUT的基础上还缓存图片
}
