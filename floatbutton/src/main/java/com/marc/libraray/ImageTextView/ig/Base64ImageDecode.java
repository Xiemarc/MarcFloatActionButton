package com.marc.libraray.ImageTextView.ig;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.marc.libraray.ImageTextView.ImageHolder;
import com.marc.libraray.ImageTextView.RichTextConfig;
import com.marc.libraray.ImageTextView.callback.ImageLoadNotify;
import com.marc.libraray.ImageTextView.drawable.DrawableWrapper;

import java.util.concurrent.Future;

class Base64ImageDecode extends AbstractImageLoader implements Runnable {

    @NonNull
    private byte[] src;

    Base64ImageDecode(@NonNull byte[] src, ImageHolder holder, RichTextConfig config, TextView textView, DrawableWrapper drawableWrapper, ImageLoadNotify iln) {
        super(holder, config, textView, drawableWrapper, iln);
        this.src = src;
    }

    @Override
    public void run() {
        try {
            onLoading();
            BitmapFactory.Options options = new BitmapFactory.Options();
            int[] inDimens = getDimensions(src, options);
            options.inSampleSize = onSizeReady(inDimens[0], inDimens[1]);
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            onResourceReady(decodeBytes(src, options));
        } catch (Exception e) {
            onFailure(e);
        }
    }

    private int[] getDimensions(byte[] bs, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeBytes(bs, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private Bitmap decodeBytes(byte[] bs, BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bs, 0, bs.length, options);
    }
}

class FutureWrapper implements Cancelable {

    private Future future;

    FutureWrapper(Future future) {
        this.future = future;
    }

    @Override
    public void cancel() {
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(true);
            future = null;
        }
    }
}