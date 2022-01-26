package menus;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
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
import erros.TratamentoExcecoesNumeros;
import erros.TratamentoExcecoesTexto;

public class ShowMenu {

	public void menuCliente() {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		String acessoSistema = null;
		Set<ContaCorrente> listaContaCorrenteClientes = new LinkedHashSet<ContaCorrente>();
		Set<ContaPoupanca> listaContaPoupancaClientes = new LinkedHashSet<ContaPoupanca>();
		Set<ContaInvestimento> listaContaInvestimentoClientes = new LinkedHashSet<ContaInvestimento>();
		Set<PessoaFisica> listaDeclientes = new LinkedHashSet<PessoaFisica>();

		TratamentoExcecoesTexto trataExcecoesEntradaTexto = new TratamentoExcecoesTexto(null);
		TratamentoExcecoesNumeros trataExcecoesEntradaNumeros = new TratamentoExcecoesNumeros();
		PessoaFisica clientePessoaFisica = new PessoaFisica(null, null, null);
		ContaCorrente contaCorrente = new ContaCorrente(null, null, 0, null, null, 0);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, 0, null, null, 0);
		ContaInvestimento contaInvestimento = new ContaInvestimento(null, null, 0, null, null, 0);
		GeradorNumeroConta geraNumeroConta = new GeradorNumeroConta();

		int secaoCliente = 0;
		int contCorrente = 0;
		int contPoupanca = 0;
		int contInvestimento = 0;

		double rendaCadastroCliente = 0;
		double depositoInicial = 0;
		double saldoConta = 0;

		String entradaMenu = null;
		String opcoesMenuBanco = null;
		String escolheAgencia = null;
		String escolheConta = null;
		String nomeCadastroCliente = null;
		String cpfCadastroCliente = null;
		String inserirNumeroAgencia = null;
		String inserirNumeroConta = null;
		String inserirNomeDeUsuario = null;
		String inserirSenhaDoUsuario = null;
		String chaveContaCorrente = null;
		String chaveContaPoupanca = null;
		String chaveContainvestimento = null;
		String armazenaAgencia = null;
		String tranformaValores = null;

		boolean validacaoMenu = false;

		while (true) {
			System.out.println("#########################################################");
			System.out.println("# Bem-vindo ao DEVInMoney, o banco parceiro da sua vida #");
			System.out.print("#########################################################\n");

			System.out.println("\nDigite uma das opções listadas abaixo para você desfrutar de nossas soluções:\n");

			while (!validacaoMenu) {
				System.out.println("#########################################################");
				System.out.println("#                                                       #");
				System.out.println("#           DIGITE 1- PARA CRIAR UMA CONTA              #");
				System.out.println("#           DIGITE 2- SE VOCE JÁ É NOSSO CLIENTE        #");
				System.out.println("#           DIGITE 3- PARA SAIR DO SISTEMA              #");
				System.out.println("#                                                       #");
				System.out.println("#########################################################");

				System.out.println("Se você já é nosso cliente, não deixe de olhar nossas outras opções de conta");
				System.out.print("-->");
				entradaMenu = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoEntradaMenu(entradaMenu)) {
						throw new TratamentoExcecoesTexto("Digite uma opção válida!");
					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

//################################################################################################

			if (Integer.parseInt(entradaMenu) == 1) {

				while (true) {
					while (true) {
						System.out.println("Digite seus dados para abrir a sua conta\n");
						System.out.print("Nome: ");

						nomeCadastroCliente = clientePessoaFisica.cadastrarNome();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoNomeClientes(nomeCadastroCliente)) {
								throw new TratamentoExcecoesTexto(
										"Digite corretamente o seu nome completo sem acentos e com a primeira letra maúscula, números não serão aceitos!");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					// Fazer a confirmação dos dados....

					while (true) {
						System.out.print("CPF: ");

						cpfCadastroCliente = clientePessoaFisica.cadastrarCPF();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoCpfClientes(cpfCadastroCliente)) {
								throw new TratamentoExcecoesTexto("Digite um numero de CPF válido com 11 dígitos!");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (true) {
						System.out.print("Renda Mensal: ");

						trataExcecoesEntradaNumeros.verificaEntradaIncorreta();

						trataExcecoesEntradaNumeros.trataValorDeEntrada(trataExcecoesEntradaNumeros.getValorTratado());
						System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
						if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || trataExcecoesEntradaNumeros.verificaEntradaIncorreta() == 0.00) {
							System.out.println(
									"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

							if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

							}
						} else {
							rendaCadastroCliente = trataExcecoesEntradaNumeros.getValorTratado();
							break;
						}
					}

					while (true) {

						System.out.println(
								"\nEscolha o tipo de conta que você deseja abrir\nESCOLHA 1- Conta Corrente\nESCOLHA 2- Conta Poupança\nESCOLHA 3- Conta Investimento\n-->");
						escolheConta = clientePessoaFisica.escolheTipoConta();

						try {
							// Reutilização do mesmo método que trata os erros do menu inicial do sistema
							if (!trataExcecoesEntradaTexto.trataExcecaoEntradaMenu(escolheConta)) {
								throw new TratamentoExcecoesTexto("Digite corretamente uma das opções listadas!");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (true) {

						System.out.println(
								"\nEscolha a agência na qual você prefere abrir a sua conta\nESCOLHA 1- Florianópolis (Agência 001)\nESCOLHA 2- São José (Agência 002)\n-->");
						escolheAgencia = clientePessoaFisica.escolheAgencia();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoEscolhaAgenciaCadastro(escolheAgencia)) {
								throw new TratamentoExcecoesTexto(
										"Digite corretamente o numero correspondente a agência!");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (!validacaoMenu) {

						System.out.print(
								"\nCadastre o seu nome de usuário, somente letras que podem ser maiúsculas e munúsculas: ");
						inserirNomeDeUsuario = contaCorrente.cadastroNomeDeUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoNomeDeUsuario(inserirNomeDeUsuario)) {
								throw new TratamentoExcecoesTexto(
										"Formato não permitido!\nCadastre o seu nome de usuário, somente letras que podem ser maiúsculas e munúsculas!"); // melhorar

							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (!validacaoMenu) {

						System.out.print("\nCadastre a sua senha de quatro letras e dois numeros: ");
						inserirSenhaDoUsuario = contaCorrente.cadastroDeSenhaUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuario)) {
								throw new TratamentoExcecoesTexto(
										"Senha inválida!\nInsira novamente a sua senha, quatro letras e dois numeros!");

							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (!validacaoMenu) {

						System.out.print("\nConfirme a sua senha: ");
						String verificaSenha = contaCorrente.cadastroDeSenhaUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuario)) {
								throw new TratamentoExcecoesTexto(
										"Senha inválida!\nInsira novamente a sua senha, quatro letras e dois numeros!");

							} else {

								if (verificaSenha.equals(inserirSenhaDoUsuario)) {
									System.out.println("\nSenha cadastrada com sucesso");
									break;
								} else {
									System.out.println(
											"\nA senha digitada não corresponde com a senha que você informou inicialmente\n");
								}
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					System.out.println(
							"\nAbaixo estão seus dados, guarde-os em um local seguro!\nVocê irá precisar deles para acessar a sua conta\n");
					System.out.println("Nome: " + nomeCadastroCliente);
					System.out.println("CPF " + cpfCadastroCliente);
					System.out.println("Renda: " + String.format("%.2f", rendaCadastroCliente));
					System.out.println("Login: " + inserirNomeDeUsuario);

					System.out.println("\nSeus dados estão corretos?\n1- SIM\n2- NÃO\n-->");
					String menuConfirmacaoDados = null;
					while (true) {

						menuConfirmacaoDados = sc.nextLine();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoConfirmaDados(menuConfirmacaoDados)) {
								throw new TratamentoExcecoesTexto(
										"Opção inválida, escolha uma das opções listadas no menu");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					if (Integer.parseInt(menuConfirmacaoDados) == 1) {
						break;
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
						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente).concat("-")
								.concat(Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						if (Integer.parseInt(escolheConta) == 1) {

							System.out.println("Tipo de conta: Conta Corrente");

						} else if (Integer.parseInt(escolheConta) == 2) {

							System.out.println("Tipo de conta: Conta Poupança");

						} else if (Integer.parseInt(escolheConta) == 3) {

							System.out.println("Tipo de conta: Conta Investimento");
						}
						System.out.println("Numero da conta: " + geraNumeroConta.geradorDeContaCorrente(contCorrente));
						System.out.println("Agência: " + Agencia.FLORIANOPOLIS.getAgencias());

						while (true) {
							System.out.print(
									"\nPara ativar a sua conta, será preciso fazer um dépósito de no mínimo R$ 1.00\nDigite o valor do depósito: ");
							depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorreta();

							trataExcecoesEntradaNumeros
									.trataValorDeEntrada(trataExcecoesEntradaNumeros.getValorTratado());
							System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
							if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial == 0.00) {
								System.out.println(
										"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

								if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

								}
							} else {
								depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
								contaCorrente.deposito(depositoInicial);
								break;
							}

							break;
						}

						saldoConta = contaCorrente.getSaldo();

						System.out.println(
								"\nO saldo inicial da sua nova conta é de " + String.format("%.2f", saldoConta));
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.FLORIANOPOLIS.getAgencias(), saldoConta);
						listaContaCorrenteClientes.add(contaCorrente);

						// Verificar a necessidade dos construtores...
//						clientePessoaFisica = new PessoaFisica(inserirNomeDeUsuario, cpfCadastroCliente,
//								rendaCadastroCliente);
//						listaDeclientes.add(clientePessoaFisica);

						armazenaAgencia = Agencia.FLORIANOPOLIS.getAgencias();

						break;

					case 2:
						contPoupanca++;

						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.FLORIANOPOLIS.getAgencias(), 0.0);
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.FLORIANOPOLIS.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.FLORIANOPOLIS.getAgencias(), 0.0);
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}

					// Para testes
					for (ContaCorrente corrente : listaContaCorrenteClientes) {

						System.out.println(corrente.getNome());
						System.out.println(corrente.getCpf());
						System.out.println(corrente.getRendaMensal());
						System.out.println(corrente.getAgencia());
						System.out.println(corrente.getNumeroConta());

					}

				} else if (Integer.parseInt(escolheAgencia) == 2) {

					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.SAOJOSE.getAgencias(), 0.0);
						listaContaCorrenteClientes.add(contaCorrente);
						break;

					case 2:
						contPoupanca++;

						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaPoupanca, Agencia.SAOJOSE.getAgencias(), 0.0);
						listaContaPoupancaClientes.add(contaPoupanca);
						break;

					case 3:
						contInvestimento++;

						chaveContainvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat(Agencia.SAOJOSE.getAgencias());
						contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
								rendaCadastroCliente, chaveContainvestimento, Agencia.SAOJOSE.getAgencias(), 0.0);
						listaContaInvestimentoClientes.add(contaInvestimento);
						break;
					}

					for (ContaCorrente corrente : listaContaCorrenteClientes) {
						System.out.println(corrente);

					}
				}

// ################################################################################################

			} else if (Integer.parseInt(entradaMenu) == 2) {
				while (!validacaoMenu) {

					System.out.print("Olá, informe a sua agencia com três dígitos: ");
					inserirNumeroAgencia = clientePessoaFisica.escolheAgencia();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoSelecionaAgenciaCorrentista(inserirNumeroAgencia)) {
							throw new TratamentoExcecoesTexto(
									"Digite uma ag	agência válida: Agência 001 para Florianópolis ou agência 002 para São José!");
						} else {

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInforme o numero da sua conta seguido do dígito: Ex: 1-1: ");
					inserirNumeroConta = clientePessoaFisica.insereNumeroConta();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoInserirConta(inserirNumeroConta)) {
							throw new TratamentoExcecoesTexto("Digite uma conta válida!");
						} else {

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInsira o seu nome de usuário: ");
					inserirNomeDeUsuario = contaCorrente.cadastroNomeDeUsuario();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoNomeDeUsuario(inserirNomeDeUsuario)) {
							throw new TratamentoExcecoesTexto("Usuário inválido, digite o nome do seu usuario!"); // melhorar
																													// menssagem...
						} else {

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				while (!validacaoMenu) {

					System.out.print("\nInsira a sua senha de quatro letras e dois numeros: ");
					inserirSenhaDoUsuario = contaCorrente.cadastroDeSenhaUsuario();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuario)) {
							throw new TratamentoExcecoesTexto(
									"Senha inválida!\nDigite novamente a sua senha, quatro letras e dois numeros!"); // melhorar
																														// menssagem...
						} else {

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

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
					System.out.println("#                                                            #");
					System.out.println("#           DIGITE 1- PARA EXTRATO CONTA CORRENTE            #");
					System.out.println("#           DIGITE 2- PARA EXTRATO CONTA POUPANÇA            #");
					System.out.println("#           DIGITE 3- PARA EXTRATO CONTA INVESTIMENTO        #");
					System.out.println("#           DIGITE 4- SAQUE                                  #");
					System.out.println("#           DIGITE 5- TRANSFERENCIA                          #");
					System.out.println("#           DIGITE 6- DEPÓSITO                               #");
					System.out.println("#           DIGITE 7- SALDO NA TELA                          #");
					System.out.println("#           DIGITE 8- SAIR                                   #");
					System.out.println("#                                                            #");
					System.out.println("##############################################################");

					System.out.print("-->");
					opcoesMenuBanco = sc.nextLine();

					while (true) {
						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoMenuBanco(opcoesMenuBanco)) {
								throw new TratamentoExcecoesTexto("\nDigite uma opção válida!\n");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
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
									"\nEscolha qual a conta você deseja realizar o saque\n1- CORRENTE\n2- POUPANCA\n3- INVESTIMENTO\n-->");

							String escolheContaMenuSaque = sc.nextLine();

							while (true) {
								try {

									if (!trataExcecoesEntradaTexto.trataExcecaoMenuSaque(escolheContaMenuSaque)) {
										throw new TratamentoExcecoesTexto("Digite uma opção válida!");
									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							if (Integer.parseInt(escolheContaMenuSaque) == 1) {

								if (contaCorrente.cadastroNomeDeUsuario() == null) {

									System.out.println("Você ainda não possui conta corrente, escolha outra conta!");

								} else {

									for (ContaCorrente contaCorrenteCliente : listaContaCorrenteClientes) {

										double saqueConta = 0.0;
										while (true) {
											System.out.print("Seu saldo é de: "
													+ String.format("%.2f", contaCorrenteCliente.getSaldo())
													+ "\nQuanto você deseja sacar?-->");

											saqueConta = trataExcecoesEntradaNumeros.verificaEntradaIncorreta();

											trataExcecoesEntradaNumeros
													.trataValorDeEntrada(trataExcecoesEntradaNumeros.getValorTratado());
											
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || saqueConta == 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												
												if (contaCorrente.getSaldo() >= saqueConta) {
													saqueConta = trataExcecoesEntradaNumeros.getValorTratado();
													contaCorrente.saque(saqueConta);
													
													if(contaCorrente.getSaldo() == saqueConta) {
														System.out.println("\nSaldo zerado!\n");
													} else {
														System.out.println("\nSaque realizado com sucesso!\n");
													}
													
													break;
												} //else if (contaCorrente.getSaldo() < 1000.00) {

													// chamar o limite de crédito...se houver...
												//} 
											else {
													System.out.println(
															"\nVocê não possui limite sufuciente para essa operação\n");
													break;
												}
												
											}

										}

									}

									System.out.print(
											"Saldo atual: " + String.format("%.2f", contaCorrente.getSaldo()) + "\n");

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

						break;

					case 6:

						break;

					case 7:

						break;
					}

					secaoCliente++;
				}

				while (!validacaoMenu) {

					System.out.print("Deseja sair do sistema?\nDIGITE 1- Para permanecer\nDIGITE 2- Para sair\n-->");
					acessoSistema = sc.nextLine();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoEntradaMenu(acessoSistema)) {
							throw new TratamentoExcecoesTexto("Digite uma opção válida!");
						} else {

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

			} else if (Integer.parseInt(entradaMenu) == 3) {
				break;
			}
		}
		sc.close();
	}
}
