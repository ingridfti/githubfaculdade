public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(int id, String nome, Endereco endereco, String cnpj) {
        super(id, nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void visualizarDetalhes() {
        super.visualizarDetalhes();
        System.out.println("CNPJ: " + cnpj);
    }
}
