package com.marc.libraray.ImageTextView.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;

import com.marc.libraray.ImageTextView.callback.OnImageClickListener;
import com.marc.libraray.ImageTextView.callback.OnImageLongClickListener;

import java.util.List;


public class ClickableImageSpan extends ImageSpan implements LongClickableSpan {

    private float x;
    private int top;
    private final int position;
    private final List<String> imageUrls;
    private final OnImageLongClickListener onImageLongClickListener;
    private final OnImageClickListener onImageClickListener;

    public ClickableImageSpan(ImageSpan imageSpan, List<String> imageUrls, int position, OnImageClickListener onImageClickListener, OnImageLongClickListener onImageLongClickListener) {
        super(imageSpan.getDrawable(), imageSpan.getVerticalAlignment());
        this.imageUrls = imageUrls;
        this.position = position;
        this.onImageClickListener = onImageClickListener;
        this.onImageLongClickListener = onImageLongClickListener;
    }


    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        this.x = x;
        this.top = top;
        Log.i("ImageTextView", "src:" + position + "x:" + x + ",top:" + top);
    }

    public boolean clicked(int position) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Rect rect = drawable.getBounds();
            if (position <= rect.right + x && position >= rect.left + x) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void onClick(View widget) {
        if (onImageClickListener != null) {
            onImageClickListener.imageClicked(imageUrls, position);
        }
    }

    @Override
    public boolean onLongClick(View widget) {
        return onImageLongClickListener != null && onImageLongClickListener.imageLongClicked(imageUrls, position);
    }
}
