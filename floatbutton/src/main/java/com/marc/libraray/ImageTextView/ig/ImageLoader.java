package com.marc.libraray.ImageTextView.ig;

import android.graphics.Bitmap;

interface ImageLoader {

    /**
     * 加载中，设置placeHolder图片
     */
    void onLoading();

    /**
     * 图片大小已获取到，进行图片缩放处理
     *
     * @param width  图片真实宽度
     * @param height 图片真实高度
     * @return 缩放倍数
     */
    int onSizeReady(int width, int height);

    /**
     * 图片加载失败，设errorImage
     *
     * @param e exception
     */
    void onFailure(Exception e);

    /**
     * 图片加载完成
     *
     * @param bitmap Bitmap
     */
    void onResourceReady(Bitmap bitmap);

}
