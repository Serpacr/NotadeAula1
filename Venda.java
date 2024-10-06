public class Venda {
    private Produto produto;
    private double valorPago;
    private String formaPagamento;

    public Venda(Produto produto, double valorPago, String formaPagamento) {
        this.produto = produto;
        this.valorPago = valorPago;
        this.formaPagamento = formaPagamento;
    }

    public double calcularDesconto() {
        if (formaPagamento.equals("Pix") || formaPagamento.equals("Espécie") || formaPagamento.equals("Transferência") || formaPagamento.equals("Débito")) {
            return produto.getValor() * 0.05;
        } else if (formaPagamento.equals("Crédito")) {
            return 0;
        } else {
            return 0;
        }
    }

    public double calcularTroco() {
        if (formaPagamento.equals("Espécie")) {
            return valorPago - produto.getValor();
        } else {
            return 0;
        }
    }

    public void realizarVenda() {
        double desconto = calcularDesconto();
        double valorTotal = produto.getValor() - desconto;
        System.out.println("Valor total: R$ " + valorTotal);
        System.out.println("Desconto: R$ " + desconto);
        System.out.println("Troco: R$ " + calcularTroco());
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
    }
}