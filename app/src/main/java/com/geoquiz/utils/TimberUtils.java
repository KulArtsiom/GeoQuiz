package com.geoquiz.utils;

import timber.log.Timber;

public class TimberUtils {

    public static void d(String message) {
        Timber.d(message);
    }

    public static void e(String message) {
        Timber.e(message);
    }

    public static void i(String message) { Timber.i(message); }

    public static void v(String message) { Timber.v(message);
    }
}
