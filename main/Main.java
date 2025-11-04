package main;

import modelo.*;
import modelo.AumentoMaiorDoQueJurosException;
import utils.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario iu = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("=== Financiamento 1 (dados do usuário) ===");
        double valor = iu.pedirValorImovel();
        int prazo = iu.pedirPrazoFinanciamento();
        double taxa = iu.pedirTaxaJurosAnual();

        double areaConstruida = 120;
        double areaTerreno = 300;

        try {
            financiamentos.add(new Casa(valor, prazo, taxa, areaConstruida, areaTerreno));
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro ao criar Casa: " + e.getMessage());
        }

        try {
            financiamentos.add(new Casa(400000, 20, 8.5, 150, 400));
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro ao criar Casa: " + e.getMessage());
        }

        financiamentos.add(new Apartamento(500000, 10, 10, 2, 5));
        financiamentos.add(new Apartamento(300000, 15, 9, 1, 10));
        financiamentos.add(new Terreno(200000, 12, 11, "Residencial"));

        iu.fecharScanner();

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento f = financiamentos.get(i);
            System.out.println(">>> Financiamento " + (i + 1));
            f.exibirResumoFinanciamento();
            System.out.println();

            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.printf("=== RESUMO FINAL ===%n");
        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalFinanciamentos);

        
        String caminhoTxt = "financiamentos.txt";
        String caminhoBin = "financiamentos.ser";

        ArquivoTextoUtils.salvarFinanciamentosEmTexto(financiamentos, caminhoTxt);
        ArquivoTextoUtils.lerFinanciamentosDoTexto(caminhoTxt);

        ArquivoBinarioUtils.salvarFinanciamentosSerializados(financiamentos, caminhoBin);
        ArrayList<Financiamento> recuperados = ArquivoBinarioUtils.lerFinanciamentosSerializados(caminhoBin);
        System.out.println("Recuperados da serialização: " + recuperados.size());
    }
}
