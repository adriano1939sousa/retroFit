package br.com.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import br.com.retrofit.modal.DepartamentoRes;
import br.com.retrofit.modal.Departament;
import br.com.retrofit.service.DepartamentService;
import com.google.android.material.textfield.TextInputLayout;
import br.com.retrofit.adapter.DepartamentAdapter;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartamentActivity extends AppCompatActivity {

    private TextInputLayout tilDepartamento;
    private Button btnSalvar, btnAtualizar, btnDelete;
    private DepartamentService service;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

         service = RetrofitConfig
                .newInstance()
                .departamentService();


//        btnSalvar.setOnClickListener(view -> {
//
//            if(!Objects.requireNonNull(tilDepartamento.getEditText()).getText().toString().isEmpty()){
//                DepartamentDTO dto = new DepartamentDTO();
//                dto.setName(tilDepartamento.getEditText().getText().toString());
//                service.createDepatament(dto).enqueue(new Callback<Departament>() {
//                    @Override
//                    public void onResponse(Call<Departament> call, Response<Departament> response) {
//                        Log.e(">>>>>", "onResponse: " + response.code() );
//
//                        if(response.isSuccessful()){
//                            Log.e(">>>>>", " SUCESSO " );
//                        }else{
//                            Log.e(">>>>>", " FUDEUUUUU " );
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Departament> call, Throwable t) {
//
//                    }
//                });
//            }else{
//                Toast.makeText(DepartamentActivity.this, "Departamento não pode ser vazio", Toast.LENGTH_LONG).show();
//            }
//
//
//        });
//
//        btnAtualizar.setOnClickListener(view -> {
//
//        });
//
//        btnDelete.setOnClickListener(view -> {
//
//            if(!Objects.requireNonNull(tilDepartamento.getEditText()).getText().toString().isEmpty()) {
//
//                long id = Long.parseLong(tilDepartamento.getEditText().getText().toString());
//
//                service.deleteDepartmentById(id).enqueue(new Callback<Departament>() {
//                    @Override
//                    public void onResponse(Call<Departament> call, Response<Departament> response) {
//                        Log.e(">>>>>", "onResponse: " + response.code());
//
//                        if (response.isSuccessful()) {
//                            Log.e(">>>>>", " SUCESSO deletou  ");
//
//                        } else {
//                            Log.e(">>>>>", " FUDEUUUUU ");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Departament> call, Throwable t) {
//
//                    }
//                });
//
//            }else{
//                Toast.makeText(DepartamentActivity.this, "Departamento não pode ser vazio", Toast.LENGTH_LONG).show();
//            }
//
//        });
//




        service.getAllDepartaments().enqueue(new Callback<List<Departament>>() {
            @Override
            public void onResponse(Call<List<Departament>> call, Response<List<Departament>> response) {
                List<Departament> lista = response.body();

                for (Departament item : lista){
                    Log.i(">>>>", item.getName());
                }

                setAdapter(lista);
            }

            @Override
            public void onFailure(Call<List<Departament>> call, Throwable t) {

            }
        });




    }

    private void setAdapter(List<Departament> departaments){

        DepartamentAdapter departamentAdapter = new DepartamentAdapter(DepartamentActivity.this, departaments);
        departamentAdapter.setDropDownViewResource(0);
        list.setAdapter(departamentAdapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {

            Departament departament = departamentAdapter.getItem(i);
            Toast.makeText(DepartamentActivity.this, " Departament "
                    + departament.getName(), Toast.LENGTH_LONG).show();

        });

    }

    private void initView (){
//        tilDepartamento = findViewById(R.id.til_departamento);
//        btnSalvar = findViewById(R.id.btn_salvar);
//        btnAtualizar = findViewById(R.id.btn_atualizar);
//        btnDelete = findViewById(R.id.btn_delete);
        list = findViewById(R.id.listview_departament);
    }
}