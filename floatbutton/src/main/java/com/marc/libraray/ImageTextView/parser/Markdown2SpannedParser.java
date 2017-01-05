package com.marc.libraray.ImageTextView.parser;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.zzhoujay.markdown.MarkDown;


public class Markdown2SpannedParser implements SpannedParser {

    private TextView textView;

    public Markdown2SpannedParser(TextView textView) {
        this.textView = textView;
    }

    @Override
    public Spanned parse(String source, Html.ImageGetter imageGetter) {
        return MarkDown.fromMarkdown(source, imageGetter, textView);
    }
}
