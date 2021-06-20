package com.aicpa.articles.ui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.aicpa.articles.R;
import com.aicpa.articles.widgets.MyProgressDialog;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    protected MyProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (progressDialog != null) {
            progressDialog.dismissDialog();
        }
        super.onDestroy();
    }

    protected void showProgressDialog(Context context) {
        progressDialog = new MyProgressDialog(context);
        progressDialog.showDialog();
    }

    protected void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismissDialog();
        }
    }
}
