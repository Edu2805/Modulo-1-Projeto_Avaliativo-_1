package menus;

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
		Set<PessoaFisica> listaDeclientes = new LinkedHashSet<PessoaFisica>();

		TratamentoExcecoes trataExcecoesEntrada = new TratamentoExcecoes(null);
		PessoaFisica clientePessoaFisica = new PessoaFisica(null, null, null);
		ContaCorrente contaCorrente = new ContaCorrente(null, null, null, null, null, null);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, null, null, null, null);
		ContaInvestimento contaInvestimento = new ContaInvestimento(null, null, null, null, null, null);
		GeradorNumeroConta geraNumeroConta = new GeradorNumeroConta();

		int secaoCliente = 0;
		int contCorrente = 0;
		int contPoupanca = 0;
		int contInvestimento = 0;

		String entradaMenu = null;
		String opcoesMenuBanco = null;
		String escolheAgencia = null;
		String escolheConta = null;
		String nomeCadastroCliente = null;
		String cpfCadastroCliente = null;
		String rendaCadastroCliente = null;
		String inserirNumeroAgencia = null;
		String inserirNumeroConta = null;
		String inserirNomeDeUsuario = null;
		String inserirSenhaDoUsuario = null;
		String depositoInicial = null;
		String saldoConta = null;
		String chaveContaCorrente = null;
		String chaveContaPoupanca = null;
		String chaveContainvestimento = null;
		String armazenaAgencia = null;

		boolean validacaoMenu = false;

		while (true) {
			System.out.println("#########################################################");
			System.out.println("# Bem-vindo ao DEVInMoney, o banco parceiro da sua vida #");
			System.out.print("#########################################################\n");

			System.out.println("\nDigite uma das opções listadas abaixo para você desfrutar de nossas soluções:\n");

			while (!validacaoMenu) {
				System.out.println("##################################################");
				System.out.print("#                                                #\n");
				System.out.println(
						"#          DIGITE 1- PARA CRIAR UMA CONTA        #\n#          DIGITE 2- PARA SAIR DO SISTEMA        #");
				System.out.print("#                                                #\n");
				System.out.println("##################################################");

				System.out.print("-->");
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

			if (Integer.parseInt(entradaMenu) == 1) {

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
							"\nEscolha o tipo de conta que você deseja abrir\nESCOLHA 1- Conta Corrente\nESCOLHA 2- Conta Poupança\nESCOLHA 3- Conta Investimento\n-->");
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
							"\nEscolha a agência na qual você prefere abrir a sua conta\nESCOLHA 1- Florianópolis (Agência 001)\nESCOLHA 2- São José (Agência 002)\n-->");
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

				while (!validacaoMenu) {

					System.out.print(
							"\nCadastre o seu nome de usuário, somente letras que podem ser maiúsculas e munúsculas: ");
					inserirNomeDeUsuario = contaCorrente.cadastroNomeDeUsuario();

					try {

						if (!trataExcecoesEntrada.trataExcecaoNomeDeUsuario(inserirNomeDeUsuario)) {
							throw new TratamentoExcecoes(
									"Formato não permitido!\nCadastre o seu nome de usuário, somente letras que podem ser maiúsculas e munúsculas!"); // melhorar

						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nCadastre a sua senha de quatro letras e dois numeros: ");
					inserirSenhaDoUsuario = contaCorrente.cadastroDeSenhaUsuario();

					try {

						if (!trataExcecoesEntrada.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuario)) {
							throw new TratamentoExcecoes(
									"Senha inválida!\nInsira novamente a sua senha, quatro letras e dois numeros!");

						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				System.out.println("Confirme os seus dados");
				// Fazer confirmação dos dados
				// Fazer um loop ou setar aqui mesmo....

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
						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente)
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

						System.out.println("\nO saldo inicial da sua nova conta é de " + saldoConta);
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.FLORIANOPOLIS.getAgencias(), saldoConta);
						listaContaCorrenteClientes.add(contaCorrente);

						// Verificar a necessidade dos construtores...
						clientePessoaFisica = new PessoaFisica(inserirNomeDeUsuario, cpfCadastroCliente,
								rendaCadastroCliente);
						listaDeclientes.add(clientePessoaFisica);

						armazenaAgencia = Agencia.FLORIANOPOLIS.getAgencias();

						break;

					case 2:
						contPoupanca++;

						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.FLORIANOPOLIS.getAgencias(), "0.00");
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.FLORIANOPOLIS.getAgencias(),
								"0.00");
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}

					for (ContaCorrente corrente : listaContaCorrenteClientes) {
						System.out.println(corrente);

					}

				} else if (Integer.parseInt(escolheAgencia) == 2) {

					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaCorrenteClientes.add(contaCorrente);
						break;

					case 2:
						contPoupanca++;

						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.SAOJOSE.getAgencias(), "0.00");
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}

					for (ContaCorrente corrente : listaContaCorrenteClientes) {
						System.out.println(corrente);

					}
					for (ContaPoupanca poupanca : listaContaPoupancaClientes) {
						System.out.println(poupanca);

					}
					for (ContaInvestimento inestimento : listaContaInvestimentoClientes) {
						System.out.println(inestimento);

					}
				}

				// confirmar cadastro e mostrar os dados pro cliente
				// armazenar no array

				// Perguntar se deseja abrir mais alguma conta que não seja outra que já tenha
				// sido criada...

				// ################################################################################################

				System.out.print("\nOlá, NOME");
				while (!validacaoMenu) {

					System.out.print("Informe a sua agencia com três dígitos: ");
					inserirNumeroAgencia = clientePessoaFisica.escolheAgencia();

					try {

						if (!trataExcecoesEntrada.trataExcecaoSelecionaAgenciaCorrentista(inserirNumeroAgencia)) {
							throw new TratamentoExcecoes(
									"Digite uma ag	agência válida: Agência 001 para Florianópolis ou agência 002 para São José!");
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
							throw new TratamentoExcecoes("Digite uma conta válida!");
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInsira o seu nome de usuário: ");
					inserirNomeDeUsuario = contaCorrente.cadastroNomeDeUsuario();

					try {

						if (!trataExcecoesEntrada.trataExcecaoNomeDeUsuario(inserirNomeDeUsuario)) {
							throw new TratamentoExcecoes("Usuário inválido, digite o nome do seu usuario!"); // melhorar
																												// menssagem...
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInsira a sua senha de quatro letras e dois numeros: ");
					inserirSenhaDoUsuario = contaCorrente.cadastroDeSenhaUsuario();

					try {

						if (!trataExcecoesEntrada.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuario)) {
							throw new TratamentoExcecoes(
									"Senha inválida!\nDigite novamente a sua senha, quatro letras e dois numeros!"); // melhorar
																														// menssagem...
						} else {

							break;
						}

					} catch (TratamentoExcecoes e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				// verificar os tipos primitivos...

				boolean menuOperacoes = false;
				while (!menuOperacoes) {

					System.out.println(
							"\n--------------------------------------------------------------------------------------");
					System.out.print("Olá " + nomeCadastroCliente + ", ");
					System.out.print("Agência: " + armazenaAgencia + ", ");
					System.out.println("Conta: " + chaveContaCorrente);

					System.out.println("##############################################################");
					System.out.println("#    Esse é seu menu de operações, o que deseja fazer?       #");
					System.out.print("##############################################################\n");

					System.out.println("##############################################################");
					System.out.print("#                                                            #\n");
					System.out.println(
							"#          DIGITE 1- PARA EXTRATO CONTA CORRENTE             #\n#          DIGITE 2- PARA EXTRATO CONTA POUPANÇA             #\n#          DIGITE 3- PARA EXTRATO CONTA INVESTIMENTO         #\n#          DIGITE 4- SAQUE                                   #\n#          DIGITE 5- TRANSFERENCIA                           #\n#          DIGITE 6- DEPÓSITO                                #\n#          DIGITE 7- SALDO NA TELA                           #\n#          DIGITE 8- SAIR                                    #");
					System.out.print("#                                                            #\n");
					System.out.println("##############################################################");

					System.out.print("-->");
					opcoesMenuBanco = sc.nextLine();

					while (true) {
						try {

							if (!trataExcecoesEntrada.trataExcecaoMenuBanco(opcoesMenuBanco)) {
								throw new TratamentoExcecoes("Digite uma opção válida!");
							} else {

								break;
							}

						} catch (TratamentoExcecoes e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					switch (Integer.parseInt(opcoesMenuBanco)) {

					case 1:

						break;

					case 2:

						break;

					case 3:

						break;

					case 4:

						while (true) {
							
							System.out.print(
									"Escolha qual a conta você deseja realizar o saque\n1- CORRENTE\n2- POUPANCA\n3- INVESTIMENTO\n-->");
							
							String escolheContaMenuSaque = sc.nextLine();
							
							while (true) {
								try {

									if (!trataExcecoesEntrada.trataExcecaoMenuSaque(escolheContaMenuSaque)) {
										throw new TratamentoExcecoes("Digite uma opção válida!");
									} else {

										break;
									}

								} catch (TratamentoExcecoes e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							if (Integer.parseInt(escolheContaMenuSaque) == 1) {
								
								if (contaCorrente.cadastroNomeDeUsuario() == null) {

									System.out.println("Você ainda não possui conta corrente, escolha outra conta!");

								} else {

									for (ContaCorrente contaCorrenteCliente : listaContaCorrenteClientes) {

										System.out.print("Seu saldo é de: " + contaCorrenteCliente.getSaldo()
												+ "\nQuanto você deseja sacar?-->");
										String saqueConta = contaCorrente.saque();
										contaCorrente.setSaldo(saqueConta);
										
									}
									
									System.out.println("\nSaque realizado com sucesso!\n");
									System.out.print("Saldo atual: " + contaCorrente.getSaldo() + "\n");
									
									for (ContaCorrente corrente : listaContaCorrenteClientes) {
										System.out.println("\n" + corrente);

									}
									
									break;
								}

							} else if (Integer.parseInt(escolheContaMenuSaque) == 2) {

								if (contaPoupanca.cadastroNomeDeUsuario() == null) {

									System.out.println("Você ainda não possui conta poupança, escolha outra conta!");

								} else {

									for (ContaPoupanca contaPoupancaCliente : listaContaPoupancaClientes) {

										System.out.print("Seu saldo é de: " + contaPoupancaCliente.getSaldo()
												+ "\nQuanto você deseja sacar?-->");

										
									}
									break;
								}

							} else if (Integer.parseInt(escolheContaMenuSaque) == 2) {

								if (contaInvestimento.cadastroNomeDeUsuario() == null) {

									System.out
											.println("Você ainda não possui conta investimento, escolha outra conta!");

								} else {

									for (ContaInvestimento contaInvestimentoCliente : listaContaInvestimentoClientes) {

										System.out.print("Seu saldo é de: " + contaInvestimentoCliente.getSaldo()
												+ "\nQuanto você deseja sacar?-->");
										
										
									}
									break;
								}
							}
						}
						
						break;
					case 5:
						System.out.println("Caiu aqui");
						break;

					case 6:

						break;

					case 7:

						break;
					}

					secaoCliente++;
				}
			} else if (Integer.parseInt(entradaMenu) == 1) {

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
			}
		}
		sc.close();
	}
}
