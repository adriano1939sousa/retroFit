package br.com.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import br.com.retrofit.adapter.DepartamentAdapter;
import br.com.retrofit.adapter.ProfessorAdapter;
import br.com.retrofit.modal.Departament;
import br.com.retrofit.modal.Professores;
import br.com.retrofit.service.ProfessorService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorActivity extends AppCompatActivity {

   private ProfessorService professorService;
   private ListView list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        list = findViewById(R.id.listview_professor);

        professorService = RetrofitConfig.newInstance().professorService();

        professorService.getAllProfessors().enqueue(new Callback<List<Professores>>() {
            @Override
            public void onResponse(Call<List<Professores>> call, Response<List<Professores>> response) {
                List<Professores> lista = response.body();

                for (Professores item : lista){
                    Log.e("professor >>>>", item.getName());
                }
                setAdapter(lista);
            }

            @Override
            public void onFailure(Call<List<Professores>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<Professores> professors){

        ProfessorAdapter professorAdapter = new ProfessorAdapter(ProfessorActivity.this, professors);
        professorAdapter.setDropDownViewResource(0);
        list.setAdapter(professorAdapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {

            Professores professor = professorAdapter.getItem(i);
            Toast.makeText(ProfessorActivity.this, " Departament "
                    + professor.getName(), Toast.LENGTH_LONG).show();

        });

    }
}