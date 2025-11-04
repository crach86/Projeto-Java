package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazo, double taxa, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazo, taxa);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int meses = getPrazoFinanciamento() * 12;
        double numerador = getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, meses);
        double denominador = Math.pow(1 + taxaMensal, meses) - 1;
        return numerador / denominador;
    }

    @Override
    public void exibirResumoFinanciamento() {
        System.out.printf("Resumo do Financiamento (Apartamento):%n");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Vagas de Garagem: %d%n", vagasGaragem);
        System.out.printf("Número do Andar: %d%n", numeroAndar);
        System.out.printf("Prazo: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
