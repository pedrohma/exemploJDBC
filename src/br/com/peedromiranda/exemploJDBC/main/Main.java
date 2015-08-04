package br.com.peedromiranda.exemploJDBC.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import br.com.peedromiranda.exemploJDBC.entity.Contato;
import br.com.peedromiranda.exemploJDBC.persistence.ContatoDao;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		Contato contato = new Contato();
		ContatoDao contatoDao = new ContatoDao();
		List<Contato> listaContatos = contatoDao.listarTodos();
		int id = 0;
		
		System.out.println("Selecione uma das opções a seguir: \n"
				+ "1 - Inclusão de Contato \n"
				+ "2 - Exclusão de Contato \n"
				+ "3 - Alteração de Contato \n"
				+ "4 - Encontrar um Contato \n"
				+ "5 - Listar todos os Contatos \n"
				+ "0 - Sair");
		
		int opcao = s.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do contato:");
			String nome = s.nextLine();
			contato.setNome(nome);
			System.out.println("");
			System.out.println("Digite o telefone do contato:");
			String telefone = s.nextLine();
			contato.setTelefone(telefone);
			System.out.println("Digite o email do contato:");
			String email = s.nextLine();
			contato.setEmail(email);
			contato.setDataCadastro(new Date(System.currentTimeMillis()));
			contatoDao.salvar(contato);
			System.out.println(contato.getNome() + " salvo com sucesso!");
			break;
		case 2:
			System.out.println("Digite o id do contato:");
			id = s.nextInt();
			contatoDao.excluir(id);
			System.out.println("Contato excluido com sucesso!");
			break;
		case 3:
			System.out.println("Digite o id do contato:");
			id = s.nextInt();
			contato = contatoDao.encontrar(id);
			System.out.println("Dados do contato: \n" + contato.toString());
			System.out.println("Digite o nome do contato:");
			contato.setNome(s.nextLine());
			System.out.println("Digite o telefone do contato:");
			contato.setTelefone(s.nextLine());
			System.out.println("Digite o email do contato:");
			contato.setEmail(s.nextLine());
			contatoDao.salvar(contato);
			System.out.println(contato.getNome() + " alterado com sucesso!");
			break;
		case 4:
			System.out.println("Digite o id do contato:");
			id = s.nextInt();
			contato = contatoDao.encontrar(id);
			System.out.println(contato.toString());
			break;
		case 5:
			for (Contato contato2 : listaContatos) {
				System.out.println(contato.toString());
			}
			System.out.println("Quantidade de contatos: " + listaContatos.size());
			
		default:
			break;
		}
	}

}
