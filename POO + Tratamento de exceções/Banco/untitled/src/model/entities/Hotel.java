package model.entities;

import model.exceptions.DataInvalidaException;
import model.exceptions.QuartoIndispException;
import model.exceptions.QuartoNaoEncontradoException;

import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel(){}

    public Hotel(List<Quarto> quartos, List<Reserva> reservas){
        this.quartos = quartos;
        this.reservas = reservas;
    }



    public void adicionarQuarto(Quarto quarto){
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

    public void fazerReserva(int numeroQuarto, LocalDate dataInicio, LocalDate dataFim){

        throws QuartoNaoEncontradoException, DataInvalidaException, QuartoIndispException {
            Quarto quarto = null;
            for (Quarto q : quartos){
                if (q.getNumero() == numeroQuarto){
                    quarto = q;
                    break;
                }
            }
            if (quarto == null){
                throw new QuartoNaoEncontradoException("Quarto número  " + numeroQuarto +
                        " não foi encontrado");
            }
        }
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
