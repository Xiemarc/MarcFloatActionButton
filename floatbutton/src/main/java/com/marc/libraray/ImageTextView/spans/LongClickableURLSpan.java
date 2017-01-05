package com.marc.libraray.ImageTextView.spans;

import android.annotation.SuppressLint;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

import com.marc.libraray.ImageTextView.LinkHolder;
import com.marc.libraray.ImageTextView.callback.OnURLClickListener;
import com.marc.libraray.ImageTextView.callback.OnUrlLongClickListener;


@SuppressLint("ParcelCreator")
public class LongClickableURLSpan extends URLSpan implements LongClickableSpan {


    private final OnURLClickListener onURLClickListener;
    private final OnUrlLongClickListener onUrlLongClickListener;
    private final LinkHolder linkHolder;

    public LongClickableURLSpan(String url, OnURLClickListener onURLClickListener, OnUrlLongClickListener onUrlLongClickListener) {
        this(url, onURLClickListener, onUrlLongClickListener, new LinkHolder(url));
    }

    public LongClickableURLSpan(String url, OnURLClickListener onURLClickListener, OnUrlLongClickListener onUrlLongClickListener, LinkHolder linkHolder) {
        super(url);
        this.onURLClickListener = onURLClickListener;
        this.onUrlLongClickListener = onUrlLongClickListener;
        this.linkHolder = linkHolder;
    }

    public LongClickableURLSpan(String url, OnURLClickListener onURLClickListener) {
        this(url, onURLClickListener, null);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(linkHolder.getColor());
        ds.setUnderlineText(linkHolder.isUnderLine());
    }

    @Override
    public void onClick(View widget) {
        if (onURLClickListener != null && onURLClickListener.urlClicked(getURL())) {
            return;
        }
        super.onClick(widget);
    }

    @Override
    public boolean onLongClick(View widget) {
        return onUrlLongClickListener != null && onUrlLongClickListener.urlLongClick(getURL());
    }
}
