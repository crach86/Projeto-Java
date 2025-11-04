package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel (positivo): ");
                double valor = scanner.nextDouble();
                if (valor > 0) return valor;
                System.out.println("Valor inválido.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
    }

    public int pedirPrazoFinanciamento() {
        while (true) {
            try {
                System.out.print("Digite o prazo em anos: ");
                int prazo = scanner.nextInt();
                if (prazo > 0) return prazo;
                System.out.println("Prazo inválido.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
        }
    }

    public double pedirTaxaJurosAnual() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual (%): ");
                double taxa = scanner.nextDouble();
                if (taxa > 0 && taxa <= 100) return taxa;
                System.out.println("Taxa inválida.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
        }
    }

    public void fecharScanner() {
        scanner.close();
    }
}
