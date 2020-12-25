package com.example.mylibrary.utils;

import java.util.HashMap;

public interface NetInterface {
    <T> void get(String url,NetCallBack<T> netCallBack);
    <T> void post(String url,NetCallBack<T> netCallBack);
    <T> void post(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
}
