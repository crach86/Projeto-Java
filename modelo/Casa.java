package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazo, double taxa, double areaConstruida, double areaTerreno) throws modelo.AumentoMaiorDoQueJurosException {
        super(valorImovel, prazo, taxa);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;

        double base = (valorImovel / (prazo * 12)) * (1 + (taxa / 12 / 100));
        double acrescimo = 80.0;
        double metadeDosJuros = (base - (valorImovel / (prazo * 12))) / 2;

        if (acrescimo > metadeDosJuros) {
            throw new modelo.AumentoMaiorDoQueJurosException("Acréscimo de R$ 80,00 é maior que a metade do valor dos juros mensais.");
        }
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double base = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12 / 100));
        return base + 80.0;
    }

    @Override
    public void exibirResumoFinanciamento() {
        System.out.printf("Resumo do Financiamento (Casa):%n");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Área construída: %.2f m²%n", areaConstruida);
        System.out.printf("Área do terreno: %.2f m²%n", areaTerreno);
        System.out.printf("Prazo: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
