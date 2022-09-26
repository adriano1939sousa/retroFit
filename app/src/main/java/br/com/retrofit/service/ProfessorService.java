package br.com.retrofit.service;

import br.com.retrofit.modal.Professor;

import java.util.List;

import br.com.retrofit.modal.Professores;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfessorService {

    @GET("/professors")
    Call<List<Professores>> getAllProfessors();
}
