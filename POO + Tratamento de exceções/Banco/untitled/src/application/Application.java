package application;

import model.entities.Hotel;
import model.entities.Quarto;
import model.exceptions.DataInvalidaException;
import model.exceptions.QuartoIndispException;
import model.exceptions.QuartoNaoEncontradoException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        Hotel hotel = new Hotel();
        hotel.adicionarQuarto(new Quarto(201, "Normal", true));
        try {
            while (loop){

                System.out.print("Digite o número do quarto: ");
                int numQuarto = sc.nextInt();
                sc.nextLine();

                System.out.print("Digite a data de check-in (DD/MM/AAAA): ");
                String dataInicio = sc.nextLine();
                System.out.print("Digite a data de check-out (DD/MM/AAAA): ");
                String dataFim = sc.nextLine();

                hotel.fazerReserva(numQuarto, dataInicio, dataFim);

                System.out.print("Deseja fazer mais alguma reserva? (S/N): ");
                char continuar = sc.nextLine().charAt(0);

                if (continuar == 's' || continuar == 'S'){
                    loop = true;
                }else {
                    loop = false;
                }
            }
        } catch (DataInvalidaException | QuartoIndispException | QuartoNaoEncontradoException e) {
            System.out.println("ERRO: " + e);
            loop = false;
        }finally {
            sc.close();
        }
    }
}
