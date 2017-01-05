package com.marc.libraray.ImageTextView.parser;

import android.text.Html;
import android.text.Spanned;

public class Html2SpannedParser implements SpannedParser {

    private Html.TagHandler tagHandler;

    public Html2SpannedParser(Html.TagHandler tagHandler) {
        this.tagHandler = tagHandler;
    }

    @Override
    public Spanned parse(String source, Html.ImageGetter imageGetter) {
        return Html.fromHtml(source, imageGetter, tagHandler);
    }
}
