package com.marc.libraray.ImageTextView;

import android.support.annotation.IntDef;

/**
 * 富文本类型
 */
@IntDef({ImageTextType.HTML, ImageTextType.MARKDOWN})
public @interface ImageTextType {
    int HTML = 0;
    int MARKDOWN = 1;
}
