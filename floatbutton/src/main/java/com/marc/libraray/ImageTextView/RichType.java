package com.marc.libraray.ImageTextView;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("ALL")
@IntDef({RichType.HTML, RichType.MARKDOWN})
@Retention(RetentionPolicy.SOURCE)
public @interface RichType {
    int HTML = 0;
    int MARKDOWN = 1;
}
