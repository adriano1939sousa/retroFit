package br.com.retrofit.service;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.retrofit.R;


public class DepartmentItemHolder extends RecyclerView.ViewHolder {

    private TextView tvName;


    public DepartmentItemHolder (@NonNull View itemView){
        super(itemView);
        tvName = itemView.findViewById(R.id.tvDepartmentName);
    }

    public void setupItens(String nome){
        tvName.setText(nome);
        tvName.setOnClickListener(view -> {
            Toast.makeText(tvName.getContext(), "TOAST", Toast.LENGTH_SHORT).show();
        });
    }


}
