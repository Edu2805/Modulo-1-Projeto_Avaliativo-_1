package menus;

import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.Locale;
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

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		String acessoSistema = null;
		Set<ContaCorrente> listaContaCorrenteClientes = new LinkedHashSet<ContaCorrente>();
		Set<ContaPoupanca> listaContaPoupancaClientes = new LinkedHashSet<ContaPoupanca>();
		Set<ContaInvestimento> listaContaInvestimentoClientes = new LinkedHashSet<ContaInvestimento>();

		TratamentoExcecoes trataExcecoesEntrada = new TratamentoExcecoes(null);
		PessoaFisica clientePessoaFisica = new PessoaFisica();
		ContaCorrente contaCorrente = new ContaCorrente(null, null, null, null, null, null);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, null, null, null, null);
		ContaInvestimento contaInvestimento = new ContaInvestimento(null, null, null, null, null, null);
		GeradorNumeroConta geraNumeroConta = new GeradorNumeroConta();

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
		String inserirNumeroAgencia = null;
		String inserirNumeroConta = null;
		String depositoInicial = null;
		String saldoConta = null;

		boolean validacaoMenu = false;

		while (true) {
			System.out.println("#########################################################");
			System.out.println("# Bem-vindo ao DEVInMoney, o banco parceiro da sua vida #");
			  System.out.print("#########################################################\n");
			
			System.out.println("\nDigite uma das opções listadas abaixo para você desfrutar de nossas soluções:\n");

			while (!validacaoMenu) {
				System.out.println("##################################################");
				System.out.print("#                                                #\n");
				System.out.println("#          DIGITE 1- PARA CORRENTISTA            #\n#          DIGITE 2- PARA CRIAR UMA CONTA        #\n#          DIGITE 3- PARA SAIR DO SISTEMA        #");
				System.out.print("#                                                #\n");
				System.out.println("##################################################");

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

//################################################################################################

			if (Integer.parseInt(entradaMenu) == 2) {

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

						if (!trataExcecoesEntrada.trataExcecaoValoresMonetarios(rendaCadastroCliente)) {
							throw new TratamentoExcecoes(
									"Digite corretamente a sua renda, use o ponto para separar dos centávos,\nvocê deve digitar os centávos mesmo que seja zero!");
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
						// Reutilização do mesmo método que trata os erros do menu inicial do sistema
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
							"Escolha a agência na qual você prefere abrir a sua conta\nESCOLHA 1- Florianópolis(Agência 001)\nESCOLHA 2- São José(Agência 002)\n-->");
					escolheAgencia = clientePessoaFisica.escolheAgencia();

					try {

						if (!trataExcecoesEntrada.trataExcecaoEscolhaAgenciaCadastro(escolheAgencia)) {
							throw new TratamentoExcecoes("Digite corretamente o numero correspondente a agência!");
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

//################################################################################################

				if (Integer.parseInt(escolheAgencia) == 1) {
					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						/**
						 * Gera chave da conta que inclui no primeiro dígito um sequencial gerado
						 * automaticamente pelos contadores conteCorrente, contepoupanca e
						 * contInvestimento, Em seguida é adicionado um - para gerar o proximo digito
						 * que segue uma convenção onde: 1-contas de natureza corrente 2-contas de
						 * natureza poupanca 3-contas de natureza investimento Por último, adiciona mais
						 * um - seguido do numeto da agencia obtido no enum Agencia
						 * 
						 * A chave fica da seguinte forma: 1-1-001 --> conta de numero 1 de natureza
						 * corrente da agencia Florianópolis
						 */
						String chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());

						while (true) {
							System.out.print(
									"\nPara ativar a sua conta, será preciso fazer um dépósito de no mínimo R$ 1,00\nDigite o valor do depósito: ");
							depositoInicial = contaCorrente.deposito();

							try {

								if (!trataExcecoesEntrada.trataExcecaoValoresMonetarios(depositoInicial)) {
									throw new TratamentoExcecoes(
											"Digite corretamente o valor, use o ponto para separar dos centávos,\nvocê deve digitar os centávos mesmo que seja zero!");
								} else {

									break;
								}

							} catch (TratamentoExcecoes e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						saldoConta = contaCorrente.saldo(depositoInicial, "0.00", "0.00");

						System.out.println("O saldo inicial da sua nova conta é de " + saldoConta);
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.FLORIANOPOLIS.getAgencias(), saldoConta);
						listaContaCorrenteClientes.add(contaCorrente);

						break;

					case 2:
						contPoupanca++;

						String chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.FLORIANOPOLIS.getAgencias(), "0.00");
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						String chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.FLORIANOPOLIS.getAgencias(),
								"0.00");
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}

				} else if (Integer.parseInt(escolheAgencia) == 2) {
					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						String chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaCorrenteClientes.add(contaCorrente);
						break;

					case 2:
						contPoupanca++;

						String chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						String chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}
				}

				for (ContaCorrente corrente : listaContaCorrenteClientes) {
					System.out.println(corrente);

				}

				// Perguntar se deseja abrir mais alguma conta que não seja outra que já tenha
				// sido criada...
				
//################################################################################################
				
			} else if (Integer.parseInt(entradaMenu) == 1) {

				System.out.print("\nOlá, informe a sua agencia com três dígitos: ");
				while (!validacaoMenu) {

					System.out.print("\nInforme a sua agencia com três dígitos");
					inserirNumeroAgencia = clientePessoaFisica.escolheAgencia();

					try {

						if (!trataExcecoesEntrada.trataExcecaoSelecionaAgenciaCorrentista(inserirNumeroAgencia)) {
							throw new TratamentoExcecoes("Digite uma opção válida!");
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInforme o numero da sua conta seguido do dígito: Ex: 1-1: ");
					inserirNumeroConta = clientePessoaFisica.insereNumeroConta();

					try {

						if (!trataExcecoesEntrada.trataExcecaoInserirConta(inserirNumeroConta)) {
							throw new TratamentoExcecoes(
									"Digite uma conta válida: Agência 001 para Florianópolis ou agência 002 para São José!");
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}
				
				
				
				//Continuar......
				while (!validacaoMenu) {

					System.out.print("\nInsira o seu nome de usuário: ");
					inserirNumeroConta = sc.nextLine();

					try {

						if (!trataExcecoesEntrada.trataExcecaoInserirConta(inserirNumeroConta)) {
							throw new TratamentoExcecoes(
									"Digite uma conta válida: Agência 001 para Florianópolis ou agência 002 para São José!");
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}
				
				
				
				
				
			}

			secaoCliente++;
			while (!validacaoMenu) {

				System.out.print("Deseja sair do sistema?\nDIGITE 1- Para permanecer\nDIGITE 2- Para sair\n-->");
				acessoSistema = sc.nextLine();

				try {

					if (!trataExcecoesEntrada.trataExcecaoEntradaMenu(acessoSistema)) {
						throw new TratamentoExcecoes("Digite uma opção válida!");
					} else {

						break;
					}

				} catch (TratamentoExcecoes e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			if (Integer.parseInt(acessoSistema) == 1) {

			} else if (Integer.parseInt(acessoSistema) == 2) {

				break;
			}

			sc.close();

		}
	}
}
