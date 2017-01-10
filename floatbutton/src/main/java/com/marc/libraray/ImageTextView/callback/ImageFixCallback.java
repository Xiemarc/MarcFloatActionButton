package com.marc.libraray.ImageTextView.callback;

import com.marc.libraray.ImageTextView.ImageHolder;

public interface ImageFixCallback {
    /**
     * 修复图片尺寸的方法
     *
     * @param holder ImageHolder对象
     */
    void onFix(ImageHolder holder);
}
