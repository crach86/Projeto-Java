package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipoZona;

    public Terreno(double valorImovel, int prazo, double taxa, String tipoZona) {
        super(valorImovel, prazo, taxa);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double base = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12 / 100));
        return base * 1.02;
    }

    @Override
    public void exibirResumoFinanciamento() {
        System.out.printf("Resumo do Financiamento (Terreno):%n");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Tipo de Zona: %s%n", tipoZona);
        System.out.printf("Prazo: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
