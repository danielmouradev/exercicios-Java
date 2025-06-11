package model.entities;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private Quarto quarto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reserva(){}

    public Reserva(int id, Quarto quarto, LocalDate dataInicio, LocalDate dataFim){
        this.id = id;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
