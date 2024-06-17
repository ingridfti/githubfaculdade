import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroSystem {
	private List<Pessoa> pessoas;

	public CadastroSystem() {
		pessoas = new ArrayList<>();
	}

	public boolean cadastrarPessoa(Pessoa pessoa) {
		if (pessoa != null) {
			pessoas.add(pessoa);
			System.out.println("Pessoa cadastrada com sucesso!");
			return true;
		} else {
			System.out.println("Erro ao cadastrar pessoa.");
			return false;
		}
	}

	public void listarPessoas() {
		if (pessoas.isEmpty()) {
			System.out.println("Nenhuma pessoa cadastrada.");
		} else {
			for (Pessoa pessoa : pessoas) {
				pessoa.visualizarDetalhes();
				System.out.println("-------------------------");
			}
		}
	}

	public Pessoa visualizarPessoa(int id) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getId() == id) {
				pessoa.visualizarDetalhes();
				return pessoa;
			}
		}
		System.out.println("Pessoa não encontrada.");
		return null;
	}

	public boolean excluirPessoa(int id) {
		boolean removed = pessoas.removeIf(pessoa -> pessoa.getId() == id);
		if (removed) {
			System.out.println("Pessoa excluída com sucesso!");
			return true;
		} else {
			System.out.println("Pessoa não encontrada.");
			return false;
		}
	}

	public boolean editarPessoa(int id, String novoNome, Endereco novoEndereco) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getId() == id) {
				pessoa.setNome(novoNome);
				pessoa.setEndereco(novoEndereco);
				System.out.println("Pessoa editada com sucesso!");
				return true;
			}
		}
		System.out.println("Pessoa não encontrada.");
		return false;
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {
			System.out.println("Menu:");
			System.out.println("1. Cadastrar Pessoa");
			System.out.println("2. Listar Pessoas");
			System.out.println("3. Visualizar Pessoa");
			System.out.println("4. Excluir Pessoa");
			System.out.println("5. Editar Pessoa");
			System.out.println("0. Sair");
			System.out.print("Digite a opção desejada: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			switch (opcao) {
			case 1:
				int tipo = -1;
				while (tipo != 1 && tipo != 2) {
					System.out.println("Tipo de Pessoa: 1. Física 2. Jurídica");
					tipo = scanner.nextInt();
					scanner.nextLine(); // Consumir a nova linha
					if (tipo != 1 && tipo != 2) {
						System.out.println("Tipo inválido! Tente novamente.");
					}
				}

				System.out.print("ID: ");
				int id = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.println("Endereço (rua, numero, cidade, estado):");
				System.out.print("Rua: ");
				String rua = scanner.nextLine();
				System.out.print("Número: ");
				int numero = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				System.out.print("Cidade: ");
				String cidade = scanner.nextLine();
				System.out.print("Estado: ");
				String estado = scanner.nextLine();
				Endereco endereco = new Endereco(rua, numero, cidade, estado);

				if (tipo == 1) {
					System.out.print("CPF: ");
					String cpf = scanner.nextLine();
					cadastrarPessoa(new PessoaFisica(id, nome, endereco, cpf));
				} else if (tipo == 2) {
					System.out.print("CNPJ: ");
					String cnpj = scanner.nextLine();
					cadastrarPessoa(new PessoaJuridica(id, nome, endereco, cnpj));
				}
				break;
			case 2:
				listarPessoas();
				break;
			case 3:
				System.out.print("ID da Pessoa: ");
				int idVisualizar = scanner.nextInt();
				visualizarPessoa(idVisualizar);
				break;
			case 4:
				System.out.print("ID da Pessoa: ");
				int idExcluir = scanner.nextInt();
				excluirPessoa(idExcluir);
				break;
			case 5:
				System.out.print("ID da Pessoa: ");
				int idEditar = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				System.out.print("Novo Nome: ");
				String novoNome = scanner.nextLine();
				System.out.println("Novo Endereço (rua, numero, cidade, estado):");
				System.out.print("Rua: ");
				String novaRua = scanner.nextLine();
				System.out.print("Número: ");
				int novoNumero = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				System.out.print("Cidade: ");
				String novaCidade = scanner.nextLine();
				System.out.print("Estado: ");
				String novoEstado = scanner.nextLine();
				Endereco novoEndereco = new Endereco(novaRua, novoNumero, novaCidade, novoEstado);
				editarPessoa(idEditar, novoNome, novoEndereco);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		CadastroSystem sistema = new CadastroSystem();
		sistema.menu();
	}
}
