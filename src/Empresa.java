public class Empresa extends Cadastro {
    private Endereco endereco;

    public Empresa(int id, String nome, Endereco endereco) {
        super(id, nome);
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public void visualizarDetalhes() {
        System.out.println("Empresa ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + endereco.getRua() + ", " + endereco.getNumero());
    }
}
