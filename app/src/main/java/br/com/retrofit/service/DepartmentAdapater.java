package br.com.retrofit.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.retrofit.modal.DepartamentoRes;

import br.com.retrofit.R;

public class DepartmentAdapater extends RecyclerView.Adapter<DepartmentItemHolder> {

    private List<DepartamentoRes> departments;

    public DepartmentAdapater(List<DepartamentoRes> departments) {
        this.departments = departments;
    }

    public void configureDepartmentAdapter(List<DepartamentoRes> departments) {
       this.departments = departments;
       notifyDataSetChanged();
    };

    @NonNull
    @Override
    public DepartmentItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.department_item_layout,
                        parent,
                        false
                );

        return new DepartmentItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentItemHolder holder, int position) {
        DepartamentoRes department = departments.get(position);

        holder.setupItens(department.getName());
    }


    @Override
    public int getItemCount() {
        return departments.size();
    }
}
