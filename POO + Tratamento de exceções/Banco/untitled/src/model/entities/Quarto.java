package model.entities;

public class Quarto {
    private int numero;
    private String tipo;
    private boolean disponivel;

    public Quarto(){}

    public Quarto(int numero, String tipo, boolean disponivel){
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public void reservar(){}

    public void liberar(){}



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
