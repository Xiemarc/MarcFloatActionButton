package com.marc.libraray.ImageTextView.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public final class ImageTextCacheManager {

    private final HashMap<String, SoftReference<CharSequence>> pool;

    private ImageTextCacheManager() {
        pool = new HashMap<>();
    }

    public void put(String key, CharSequence value) {
        pool.put(key, new SoftReference<>(value));
    }

    public CharSequence get(String key) {
        SoftReference<CharSequence> charSequenceSoftReference = pool.get(key);
        if (charSequenceSoftReference == null) {
            return null;
        }
        return charSequenceSoftReference.get();
    }

    public void clear(String key) {
        pool.remove(key);
    }


    private static class RichCacheManagerHolder {
        private static final ImageTextCacheManager RICH_CACHE_MANAGER = new ImageTextCacheManager();
    }

    public static ImageTextCacheManager getCache() {
        return RichCacheManagerHolder.RICH_CACHE_MANAGER;
    }

}
