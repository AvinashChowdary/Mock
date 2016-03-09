package com.example.sample.services;

import com.example.sample.model.TouristPlace;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Avinash
 */
public interface Services {

    @GET("/sample.json")
    void getTouristPlaces(Callback<List<TouristPlace>> callBack);

}
