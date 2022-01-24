package clientes;

import java.util.Scanner;

import erros.TratamentoExcecoes;

public class PessoaFisica extends Cliente {

	@Override
	public String cadastrarNome() {
		Scanner sc = new Scanner(System.in);

		nome = sc.nextLine();

		return nome;
	}

	@Override
	public String cadastrarCPF() {

		Scanner sc = new Scanner(System.in);

		cpf = sc.nextLine();

		return cpf;
	}

	@Override
	public String cadastrarEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cadastrarDataNascimento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cadastrarLogin() {
		
		Scanner sc = new Scanner(System.in);

		login = sc.nextLine();
		
		return login;
	}

	@Override
	public String cadastrarSenha() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String cadastrarRendaMensal() {

		Scanner sc = new Scanner(System.in);

		rendaMensal = sc.nextLine();

		return rendaMensal;
	}

	@Override
	public String escolheAgencia() {

		Scanner sc = new Scanner(System.in);

		String agencia = sc.nextLine();
		
		return agencia;
	}

	@Override
	public String escolheTipoConta() {

		Scanner sc = new Scanner(System.in);

		String tipoConta = sc.nextLine();

		return tipoConta;
		
	}

	@Override
	public String insereNumeroConta() {
		
		Scanner sc = new Scanner(System.in);

		String insereConta = sc.nextLine();

		return insereConta;
	}
	
}
