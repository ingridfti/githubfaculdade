public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(int id, String nome, Endereco endereco, String cpf) {
        super(id, nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void visualizarDetalhes() {
        super.visualizarDetalhes();
        System.out.println("CPF: " + cpf);
    }
}
