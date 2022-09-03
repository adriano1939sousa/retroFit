package br.com.retrofit;

import br.com.retrofit.service.DepartamentService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitConfig newInstance() {
        return new RetrofitConfig();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public DepartamentService departamentService() {
        return retrofit.create(DepartamentService.class);
    }
}
