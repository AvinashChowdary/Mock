package com.example.sample.services.rest;

import android.content.Context;

import com.example.sample.services.Services;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Avinash
 */
public class RestClient implements RequestInterceptor {

    private static final String BASE_URL = "http://express-it.optusnet.com.au";
    private Services svService;

    public static final String TAG = RestClient.class.getSimpleName();

    public static RestClient getInstance() {
        return new RestClient();
    }


    /**
     * Creating rest adapter
     *
     */
    public Services getService() {
        final String svBaseUrl = BASE_URL;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(svBaseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(this)
                .setClient(new retrofit.client.UrlConnectionClient())
                .build();
        svService = restAdapter.create(Services.class);
        return svService;
    }

    @Override
    public void intercept(RequestFacade request) {
//
    }


}
