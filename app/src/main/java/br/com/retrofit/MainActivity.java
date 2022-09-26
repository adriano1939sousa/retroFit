package br.com.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.retrofit.modal.Departament;
import br.com.retrofit.modal.DepartamentoRes;
import br.com.retrofit.modal.Professores;
import br.com.retrofit.service.DepartamentService;

import br.com.retrofit.service.DepartmentAdapater;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private EditText nameTXT;
    private Button delButton;

    private EditText idDepTXT;
    private Button findButton;

    private EditText cadDepName;
    private Button cadButton;

    private EditText edIdDep;
    private EditText edNameUp;
    private Button btUpdate;

    private RecyclerView rvList;
    private DepartmentAdapater adapter;
    private DepartamentService departmentService;


    private List<DepartamentoRes> depResList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            nameTXT = findViewById(R.id.edDepartmentName);
            delButton = findViewById(R.id.button);


            findButton = findViewById(R.id.btfind);
            idDepTXT = findViewById(R.id.edDepId);

            cadDepName = findViewById(R.id.edNameDep);
            cadButton = findViewById(R.id.btCadDep);


            edIdDep = findViewById(R.id.edIdDep);
            edNameUp = findViewById(R.id.edNameUp);
            btUpdate = findViewById(R.id.btUpdate);


            DepartamentService service = RetrofitConfig
                    .newInstance()
                    .departamentService();


            findButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findDepartment(service);
                }
            });

            delButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteDepartment(service);
                }
            });

            cadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createDepartment(service);
                }
            });

            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateDepartment(service);
                }
            });
        }
    private void findDepartment(DepartamentService service){

            Long idDep = Long.parseLong(idDepTXT.getText().toString());

            service.findDepartament(idDep).enqueue(new Callback<DepartamentoRes>() {
                        @Override
                        public void onResponse(Call<DepartamentoRes> call, Response<DepartamentoRes> response) {
                            DepartamentoRes departamentoRes = response.body();
                            Toast.makeText(getApplicationContext(), "Department encontrado: " +departamentoRes.getName(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<DepartamentoRes> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        }
                    }
            );

    }

    private void updateDepartment(DepartamentService service) {
        DepartamentoRes dep = new DepartamentoRes();
        dep.setId(Long.parseLong(edIdDep.getText().toString()));

        Departament departament = new Departament();
        departament.setName(edNameUp.getText().toString());

        service.updateDepartament(dep.getId(), departament).enqueue(new Callback<DepartamentoRes>() {
             @Override
             public void onResponse(Call<DepartamentoRes> call, Response<DepartamentoRes> response) {
                 DepartamentoRes departamentoRes = response.body();
                 Toast.makeText(getApplicationContext(), "Department Alterado: " +departamentoRes.getName(), Toast.LENGTH_LONG).show();
             }

             @Override
             public void onFailure(Call<DepartamentoRes> call, Throwable t) {
                 Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
             }
                                                     }
        );
    }

    private void createDepartment(DepartamentService service){
            Departament dep = new Departament();
            dep.setName(cadDepName.getText().toString());

            service.creteDepartament(dep).enqueue(new Callback<DepartamentoRes>() {
                   @Override
                   public void onResponse(Call<DepartamentoRes> call, Response<DepartamentoRes> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Departamento Criado com Sucesso",
                                    Toast.LENGTH_LONG

                            ).show();
                        }else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "ERRO: Departamento não foi criado",
                                    Toast.LENGTH_LONG

                            ).show();
                        }
                   }

                   @Override
                   public void onFailure(Call<DepartamentoRes> call, Throwable t) {
                       Toast.makeText(getApplicationContext(), "Erro na requisição para criar departamento!", Toast.LENGTH_LONG).show();
                   }
               }

            );
        }

    private void deleteDepartment(DepartamentService service){
            Long idDep = Long.parseLong(nameTXT.getText().toString());

        service.deleteDepartament(idDep).enqueue(new Callback<DepartamentoRes>() {
            @Override
            public void onResponse(Call<DepartamentoRes> call, Response<DepartamentoRes> response) {
                DepartamentoRes departamentoRes = response.body();
                Toast.makeText(getApplicationContext(), "Department Deletado: " + idDep, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DepartamentoRes> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                                                         }
                                                     }
        );

    }
        private void getAllDepartment(DepartamentService service){

           service.getAllDepartmant().enqueue(
                    new Callback<List<DepartamentoRes>>() {
                        @Override
                        public void onResponse(Call<List<DepartamentoRes>> call, Response<List<DepartamentoRes>> response) {
                            List<DepartamentoRes> list = response.body();
                            depResList = list;

                        }

                        @Override
                        public void onFailure(Call<List<DepartamentoRes>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }

    private void getAllDepartments(){
        departmentService.getAllDepartmant().enqueue(
                new Callback<List<DepartamentoRes>>() {
                    @Override
                    public void onResponse(Call<List<DepartamentoRes>> call, Response<List<DepartamentoRes>> response) {
                        List<DepartamentoRes> lista = response.body();
                        adapter.configureDepartmentAdapter(lista);

                    }

                    @Override
                    public void onFailure(Call<List<DepartamentoRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void init(){
        rvList = findViewById(R.id.rvDepartmentList);
        departmentService = RetrofitConfig.newInstance().departamentService();
        adapter = new DepartmentAdapater(new ArrayList<>());
    }

}