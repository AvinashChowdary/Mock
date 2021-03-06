package com.example.sample.helper;

import android.support.design.widget.Snackbar;
import android.view.View;


/**
 * Created by Avinash
 */
public class SnackBar {

    private static Snackbar snackBar;

    /**
     * Default constructor
     */
    private SnackBar() {
        // Private constructor to avoid public
    }

    public static Snackbar showSnackBar(View view, int text) {
        snackBar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        return snackBar;
    }

    public static Snackbar showSnackBar(View view, String text) {
        snackBar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        return snackBar;
    }

    public static boolean isSnackBarShowing() {
        if (snackBar != null) {
            return snackBar.isShown();
        }
        return false;
    }

    public static void dismissSnackBar() {
        if (snackBar != null) {
            snackBar.dismiss();
        }
    }
}