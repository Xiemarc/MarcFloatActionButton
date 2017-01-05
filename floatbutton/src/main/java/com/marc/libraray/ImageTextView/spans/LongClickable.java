package com.marc.libraray.ImageTextView.spans;

import android.view.View;

public interface LongClickable {
    /**
     * 长按点击时间
     *
     * @param widget 　view
     * @return true:已处理，false:交由onClick处理
     */
    boolean onLongClick(View widget);
}
