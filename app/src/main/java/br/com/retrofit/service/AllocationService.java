package br.com.retrofit.service;

import br.com.retrofit.modal.Allocation;
import br.com.retrofit.modal.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllocationService {

    @GET("/allocations")
    Call<List<Allocation>> getAllAllocations();
}
