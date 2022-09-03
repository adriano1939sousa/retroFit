package br.com.retrofit.modal;

public class Professores {


    private int id;
    private String name;
    private String cpf;
    private transient Allocations allocations;
    private DepartamentoRes department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Allocations getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocations allocations) {
        this.allocations = allocations;
    }

    public DepartamentoRes getDepartment() {
        return department;
    }

    public void setDepartment(DepartamentoRes department) {
        this.department = department;
    }
}
