package utils;

import modelo.*;

import java.io.*;
import java.util.ArrayList;

public class ArquivoTextoUtils {

    public static void salvarFinanciamentosEmTexto(ArrayList<Financiamento> financiamentos, String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            for (Financiamento f : financiamentos) {
                StringBuilder linha = new StringBuilder();
                linha.append(f.getValorImovel()).append(",");
                linha.append(f.calcularTotalPagamento()).append(",");
                linha.append(f.getTaxaJurosAnual()).append(",");
                linha.append(f.getPrazoFinanciamento());

                if (f instanceof Casa c) {
                    linha.append(",Casa,")
                            .append(c.getAreaConstruida()).append(",")
                            .append(c.getAreaTerreno());
                } else if (f instanceof Apartamento a) {
                    linha.append(",Apartamento,")
                            .append(a.getVagasGaragem()).append(",")
                            .append(a.getNumeroAndar());
                } else if (f instanceof Terreno t) {
                    linha.append(",Terreno,")
                            .append(t.getTipoZona());
                }

                writer.println(linha);
            }

            System.out.println("Dados salvos no arquivo de texto com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de texto: " + e.getMessage());
        }
    }

    public static void lerFinanciamentosDoTexto(String caminho) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Lido do arquivo: " + linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de texto: " + e.getMessage());
        }
    }
}
