package br.com.retrofit.service;

import br.com.retrofit.modal.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CursoService {

    @GET("/courses")
    Call<List<Curso>> getAllCousers();
}
