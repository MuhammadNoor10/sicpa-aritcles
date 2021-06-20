package com.aicpa.articles.common.android.arch.resource;

public enum ResourceState {
    READY, LOADING, SUCCESS, ERROR;

    public boolean isTerminalState() {
        return ResourceState.SUCCESS.equals(this) || ResourceState.ERROR.equals(this);
    }

    public boolean isLoading() {
        return ResourceState.LOADING.equals(this);
    }
}
