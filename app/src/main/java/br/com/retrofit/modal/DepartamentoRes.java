package br.com.retrofit.modal;

import java.util.List;

public class DepartamentoRes {


    private Long id;
    private String name;
    private List<Professores> professors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Professores> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professores> professors) {
        this.professors = professors;
    }
}
