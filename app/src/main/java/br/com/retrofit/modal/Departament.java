package br.com.retrofit.modal;

import java.util.List;

public class Departament {

    private Long id;
    private String name;
    private transient List<Professores> professores;

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

    public List<Professores> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professores> professores) {
        this.professores = professores;
    }
}
