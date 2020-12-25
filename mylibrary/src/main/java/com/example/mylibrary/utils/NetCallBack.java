package com.example.mylibrary.utils;

public interface NetCallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
