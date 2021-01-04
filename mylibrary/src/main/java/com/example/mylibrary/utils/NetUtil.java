package com.example.mylibrary.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;

public class NetUtil implements NetInterface {
    private static volatile NetUtil netUtil;
    private final ApiService apiService;

    public NetUtil() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        apiService = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetConstant.homeUrl)
                .build().create(ApiService.class);
    }

    public static NetUtil getNetUtil() {
        if (netUtil ==null){
            synchronized (NetUtil.class){
                if (netUtil == null){
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    @Override
    public <T> void get(String url, NetCallBack<T> netCallBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            netCallBack.onSuccess(new Gson().fromJson(string,type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void get(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        apiService.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            netCallBack.onSuccess(new Gson().fromJson(string,type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, NetCallBack<T> netCallBack) {
        apiService.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            T json = new Gson().fromJson(string, type);
                            Log.e("TAG", "onNext: "+json);
                            netCallBack.onSuccess(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {

        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            netCallBack.onSuccess(new Gson().fromJson(string,type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String,String> header, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        if (map==null) map=new HashMap<>();
        if (header==null) header=new HashMap<>();

        apiService.post(url,header,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            netCallBack.onSuccess(new Gson().fromJson(string,type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
