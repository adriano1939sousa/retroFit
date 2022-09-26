package br.com.retrofit.modal;

public class MenuModulo {
    private int drawable;

    private String titulo;

    public MenuModulo(int drawable, String titulo) {
        this.drawable = drawable;
        this.titulo = titulo;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
