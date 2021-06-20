package com.aicpa.articles.ui.base;

import com.aicpa.articles.common.android.arch.NullableEventLiveData;
import com.aicpa.articles.common.android.arch.resource.UIDataState;

import javax.inject.Inject;

public class BaseUIState<T> extends NullableEventLiveData<UIDataState<T>> {
    @Inject
    BaseUIState() { }
}
