package model.entities;

import model.exceptions.DataInvalidaException;
import model.exceptions.QuartoIndispException;
import model.exceptions.QuartoNaoEncontradoException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;


    public Hotel(){
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto){
        if (quarto == null){
            throw new IllegalArgumentException("Quarto não pode ser nulo");
        }
        quartos.add(quarto);
    }


    public void buscarQuartoDisponivel(String tipo){
        for (Quarto q : quartos){
            if (q != null){
                throw new QuartoIndispException("Quarto indisponível por ocupação!");
            } else if (q.getTipo() == tipo) {
                System.out.println("Quartos do tipo " + tipo + ": " + q);
            }
        }
    }

    public void fazerReserva (int numeroQuarto, String dataInicio, String dataFim)
            throws QuartoNaoEncontradoException, DataInvalidaException, QuartoIndispException
    {
    Quarto quarto = null;
            for (Quarto q : quartos){
                if (q.getNumero() == numeroQuarto){
                    quarto = q;
                    break;
                }
            }
            if (quarto == null){
                throw new QuartoNaoEncontradoException("Quarto número " + numeroQuarto +
                        " não existe");
            }
        if (!quarto.isDisponivel()){
            throw new QuartoIndispException("Quarto indisponível no momento!");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date inicio = sdf.parse(dataInicio);
            Date fim = sdf.parse(dataFim);

            if (inicio.after(fim)){
                throw new DataInvalidaException("A data de check-in deve ser anterior a de check-out");
            }
        } catch (ParseException e) {
            throw new DataInvalidaException("Formato inválido. Digite no formato de DD/MM/AAAA");
        }

        Reserva novaReserva = new Reserva(quarto, dataInicio, dataFim);

        reservas.add(novaReserva);
        quarto.reservar();
        System.out.println("Reserva confirmada no quarto " + quarto.getNumero());

    }



    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}
