package com.marc.libraray.ImageTextView.parser;

import android.text.Html;
import android.text.Spanned;

public interface SpannedParser {

    Spanned parse(String source, Html.ImageGetter imageGetter);

}
