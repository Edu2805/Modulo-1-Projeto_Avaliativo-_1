package menus;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import agencias.Agencia;
import agencias.GeradorNumeroConta;
import clientes.PessoaFisica;
import contas.ContaCorrente;
import contas.ContaInvestimento;
import contas.ContaPoupanca;
import erros.TratamentoExcecoes;

public class ShowMenu {

	public void menuCliente() {

		
		Set<ContaCorrente> listaContaCorrenteClientes = new LinkedHashSet<ContaCorrente>();
		Set<ContaPoupanca> listaContaPoupancaClientes = new LinkedHashSet<ContaPoupanca>();
		Set<ContaInvestimento> listaContaInvestimentoClientes = new LinkedHashSet<ContaInvestimento>();
		
		TratamentoExcecoes trataExcecoesEntrada = new TratamentoExcecoes(null);
		PessoaFisica clientePessoaFisica = new PessoaFisica();
		ContaCorrente contaCorrente = new ContaCorrente(null, null, null, null, null, 0);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, null, null, null, 0);
		ContaInvestimento contaInvestimento = new ContaInvestimento(null, null, null, null, null, 0);
		GeradorNumeroConta geraNumeroConta = new GeradorNumeroConta();
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem-vindo ao DEVInMoney, o banco parceiro da sua vida\n");
		System.out.println("Digite uma das opções listadas abaixo para você desfrutar de nossas soluções:\n");

		
		
		int secaoCliente = 0;
		int contCorrente = 0;
		int contPoupanca = 0;
		int contInvestimento = 0;
		
		String entradaMenu = null;
		String escolheAgencia = null;
		String escolheConta = null;
		String nomeCadastroCliente = null;
		String cpfCadastroCliente = null;
		String rendaCadastroCliente = null;
		String depositoInicial = null;
		
		boolean validacaoMenu = false;

		while (!validacaoMenu) {
			System.out.print(""
					+ "Se você já é nossoa cliente, DIGITE 1\nSe ainda não é nosso cliente e deseja criar uma conta GRÁTIS, DIGITE 2\nOu DIGITE 3 para sair do sistema\n-->");

			entradaMenu = sc.nextLine();

			try {

				if (!trataExcecoesEntrada.trataExcecaoEntradaMenu(entradaMenu)) {
					throw new TratamentoExcecoes("Digite uma opção válida!");
				} else {

					break;
				}

			} catch (TratamentoExcecoes e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		while (Integer.parseInt(entradaMenu) >= 0 && Integer.parseInt(entradaMenu) <= 3) {

			while (true) {
				System.out.println("Digite seus dados para abrir a sua conta\n");
				System.out.print("Nome: ");

				nomeCadastroCliente = clientePessoaFisica.cadastrarNome();

				try {

					if (!trataExcecoesEntrada.trataExcecaoNomeClientes(nomeCadastroCliente)) {
						throw new TratamentoExcecoes(
								"Digite corretamente o seu nome completo sem acentos e com a primeira letra maúscula, números não serão aceitos!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			// Fazer a confirmação dos dados....

			while (true) {
				System.out.print("CPF: ");

				cpfCadastroCliente = clientePessoaFisica.cadastrarCPF();
				try {

					if (!trataExcecoesEntrada.trataExcecaoCpfClientes(cpfCadastroCliente)) {
						throw new TratamentoExcecoes("Digite um numero de CPF válido com 11 dígitos!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}
			
			while (true) {
				System.out.print("Renda Mensal: ");
				rendaCadastroCliente = clientePessoaFisica.cadastrarRendaMensal();

				try {

					if (!trataExcecoesEntrada.trataExcecaoRendaClientes(rendaCadastroCliente)) {
						throw new TratamentoExcecoes("Digite corretamente a sua renda, use o ponto para separar dos centávos,\nvocê deve digitar os centávos mesmo que seja zero!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			while (true) {

				System.out.println(
						"Escolha o tipo de conta que você deseja abrir\nESCOLHA 1- Conta Corrente\nESCOLHA 2- Conta Poupança\nESCOLHA 3- Conta Investimento\n-->");
				escolheConta = clientePessoaFisica.escolheTipoConta();
				
				try {
					//Reutilização do mesmo método que trata os erros do menu inicial do sistema
					if (!trataExcecoesEntrada.trataExcecaoEntradaMenu(escolheConta)) {
						throw new TratamentoExcecoes("Digite corretamente uma das opções listadas!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			
			while (true) {

				System.out.println(
						"Escolha a agência na qual você prefere abrir a sua conta\nESCOLHA 1- Florianópolis\nESCOLHA 2- São José\n-->");
				escolheAgencia = clientePessoaFisica.escolheAgencia();
				
				try {

					if (!trataExcecoesEntrada.trataExcecaoEscolhaAgencia(escolheAgencia)) {
						throw new TratamentoExcecoes("Digite corretamente o numero correspondente a agência!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			
			if(Integer.parseInt(escolheAgencia) == 1) {
				switch (Integer.parseInt(escolheConta)) {

				case 1:
					contCorrente++;
					
					/**
					 * Gera chave da conta que inclui no primeiro dígito um sequencial gerado
					 * automaticamente pelos contadores conteCorrente, contepoupanca e contInvestimento,
					 * Em seguida é adicionado um - para gerar o proximo digito que é segue uma
					 * convenção onde: 1-contas de natureza corrente
					 * 				   2-contas de natureza poupanca
					 * 				   3-contas de natureza investimento
					 * Por último, adiciona mais um - seguido do numeto da agencia obtido no enum Agencia
					 * 
					 * A chave fica da seguinte forma: 1-1-001 --> conta de numero 1 de natureza corrente
					 * da agencia Florianópolis
					 */
					String chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente).concat(Agencia.FLORIANOPOLIS.getAgencias());
					contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContaCorrente,
							Agencia.FLORIANOPOLIS.getAgencias(), 0.0);
					listaContaCorrenteClientes.add(contaCorrente);
					
					//Teste
					
					for (ContaCorrente corrente : listaContaCorrenteClientes) {
						System.out.println(corrente);
					}
					
					break;

				case 2:
					contPoupanca++;
					
					String chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca).concat(Agencia.FLORIANOPOLIS.getAgencias());
					contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContaPoupanca,
							Agencia.FLORIANOPOLIS.getAgencias(), 0.0);
					listaContaPoupancaClientes.add(contaPoupanca);
					break;
					
				case 3:
					contInvestimento++;
					
					String chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento).concat(Agencia.FLORIANOPOLIS.getAgencias());
					contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContainvestimento,
							Agencia.FLORIANOPOLIS.getAgencias(), 0.0);
					listaContaInvestimentoClientes.add(contaInvestimento);
					break;
				}
				
			} else if(Integer.parseInt(escolheAgencia) == 2) {
				switch (Integer.parseInt(escolheConta)) {

				case 1:
					contCorrente++;
					
					String chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente).concat(Agencia.SAOJOSE.getAgencias());
					contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContaCorrente,
							Agencia.SAOJOSE.getAgencias(), 0.0);
					listaContaCorrenteClientes.add(contaCorrente);
					break;

				case 2:
					contPoupanca++;
					
					String chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca).concat(Agencia.SAOJOSE.getAgencias());
					contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContaPoupanca,
							Agencia.SAOJOSE.getAgencias(), 0.0);
					listaContaPoupancaClientes.add(contaPoupanca);
					break;
					
				case 3:
					contInvestimento++;
					
					String chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento).concat(Agencia.SAOJOSE.getAgencias());
					contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente, chaveContainvestimento,
							Agencia.SAOJOSE.getAgencias(), 0.0);
					listaContaInvestimentoClientes.add(contaInvestimento);
					break;
				}
			}
			
			

			secaoCliente++;
			
		}
	}
}
