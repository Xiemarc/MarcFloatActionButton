package com.marc.libraray.ImageTextView.callback;

public interface OnUrlLongClickListener {

    /**
     * 链接长按回调
     *
     * @param url 　链接
     * @return true:已处理，false:未处理并交给urlClick处理
     */
    boolean urlLongClick(String url);

}
