package com.aicpa.articles.network.rx;

import com.aicpa.articles.network.exceptions.ServerException;
import com.google.gson.JsonObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class RxHelper {

    public static final String HTTP_ERROR = "Network error, please try again later.";

    public static <T> Observable.Transformer<JsonObject, T> handleResult() {
        return responseObservable -> responseObservable.flatMap((Func1<JsonObject, Observable<T>>) responseBody -> {
            if (responseBody != null) {
                return createData((T)responseBody);
            }

            return Observable.error(new ServerException(HTTP_ERROR));
        });
    }

    private static <T> Observable<T> createData(T t) {
        return Observable.unsafeCreate(subscriber -> {
            try {
                subscriber.onNext(t);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
