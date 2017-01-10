package com.marc.libraray.ImageTextView.callback;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.marc.libraray.ImageTextView.RichTextConfig;
import com.marc.libraray.ImageTextView.ImageHolder;

public interface ImageGetter extends Recyclable {

    /**
     * 获取图片
     *
     * @param holder   ImageHolder
     * @param config   RichTextConfig
     * @param textView TextView
     * @return Drawable
     * @see ImageHolder
     * @see RichTextConfig
     */
    Drawable getDrawable(ImageHolder holder, RichTextConfig config, TextView textView);

    void registerImageLoadNotify(ImageLoadNotify imageLoadNotify);
}
