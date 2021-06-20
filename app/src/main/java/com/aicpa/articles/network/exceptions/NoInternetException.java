package com.aicpa.articles.network.exceptions;

public class NoInternetException extends Exception {
    public NoInternetException() {
        super("There is no Internet connection.");
    }
}
