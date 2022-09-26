package br.com.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import br.com.retrofit.adapter.MenuModuloAdapter;
import br.com.retrofit.modal.MenuModulo;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private GridView gridModulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridModulo = findViewById(R.id.gridModulo);

        List<MenuModulo> menuChecklists = new ArrayList<>();

        menuChecklists.add(new MenuModulo(R.drawable.ic_curso, getString(R.string.curso)));
        menuChecklists.add(new MenuModulo(R.drawable.ic_professor, getString(R.string.professor)));
        menuChecklists.add(new MenuModulo(R.drawable.ic_departament, getString(R.string.departamento)));
        menuChecklists.add(new MenuModulo(R.drawable.ic_lista, getString(R.string.alocacao)));
        MenuModuloAdapter menuModuloAdapter = new MenuModuloAdapter(this, menuChecklists);
        gridModulo.setAdapter(menuModuloAdapter);

        gridModulo.setOnItemClickListener((adapterView, view, i, l) -> {

            switch (menuModuloAdapter.getItem(i).getTitulo()) {
                    case "Curso":
                        startActivity(new Intent(HomeActivity.this,CursoActivity.class));
                    break;
                    case "Professor":
                        startActivity(new Intent(HomeActivity.this,ProfessorActivity.class));
                    break;
                    case "Departamento":
                    startActivity(new Intent(HomeActivity.this, DepartamentActivity.class));
                    break;
                    case "Alocação":
                        startActivity(new Intent(HomeActivity.this, AllocationActivity.class));                    break;
            }
        });
    }
}