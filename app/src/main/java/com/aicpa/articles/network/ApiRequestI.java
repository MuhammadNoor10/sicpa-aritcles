package com.aicpa.articles.network;

import com.google.gson.JsonObject;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;
import rx.Observable;

public interface ApiRequestI {
    /**
     * @param url end point of api
     */
    @Headers("Content-Type: application/json")
    @GET
    Observable<JsonObject> get(@Url String url);
}









































