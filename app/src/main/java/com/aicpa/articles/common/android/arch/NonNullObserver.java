package com.aicpa.articles.common.android.arch;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

public interface NonNullObserver<T> extends Observer<T> {
    @Override
    default void onChanged(@Nullable T t) {
        if (t != null) {
            onValueChanged(t);
        }
    }

    void onValueChanged(@NonNull T t);
}
