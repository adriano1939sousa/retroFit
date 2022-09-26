package br.com.retrofit.service;



import java.util.List;

import br.com.retrofit.modal.Departament;
import br.com.retrofit.modal.DepartamentoRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartamentService {

    @GET("/departments")
    Call<List<DepartamentoRes>> getAllDepartmant();

    @POST("/departments")
    Call<DepartamentoRes> creteDepartament(@Body Departament departament);

    @GET("departments/{department_id}")
    Call<DepartamentoRes> findDepartament(@Path("department_id") Long id);

    @DELETE("departments/{department_id}")
    Call<DepartamentoRes> deleteDepartament(@Path("department_id") Long id);


    @PUT("departments/{department_id}")
    Call<DepartamentoRes> updateDepartament(@Path("department_id")  Long id, @Body Departament departament);

    Call<List<Departament>> getAllDepartaments();
}
