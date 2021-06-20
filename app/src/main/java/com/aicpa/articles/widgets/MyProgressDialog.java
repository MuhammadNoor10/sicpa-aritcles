package com.aicpa.articles.widgets;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.aicpa.articles.R;

/**
 * Created by Noor aka Thor on 2020-04-11.
 */
public class MyProgressDialog {

    private final Context context;
    private Dialog dialog;

    public MyProgressDialog(Context context) {
        this.context = context;
        createDialog().setCancelable(false);
    }

    private Dialog createDialog() {
        dialog = new Dialog(context, R.style.WrapDialogTheme);
        dialog.setContentView(R.layout.custom_progress_dialog);

        return dialog;
    }

    public void dismissDialog() {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
        }
    }

    public void showDialog() {
        if (!getDialog().isShowing()) {
            getDialog().show();
        }
    }

    private Dialog getDialog() {
        if (dialog == null) {
            createDialog();
        }
        return dialog;
    }
}





























