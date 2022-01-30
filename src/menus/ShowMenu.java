package menus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import agencias.Agencia;
import agencias.DataDoSistema;
import agencias.GeradorNumeroConta;
import agencias.TipoDeConta;
import clientes.PessoaFisica;
import contas.ChaveLoginConta;
import contas.ContaCorrente;
import contas.ContaInvestimento;
import contas.ContaPoupanca;
import contas.ValidaCpf;
import erros.TratamentoExcecoesNumeros;
import erros.TratamentoExcecoesTexto;
import relatorios.ContaSaldoNegativo;
import relatorios.ListaContas;
import relatorios.RelatoriosContas;
import relatorios.TotalValorInvestido;
import relatorios.TransacoesClientes;
import transacoes.DadosConta;

public class ShowMenu {

	public void menuCliente() {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		

		
		Set<ContaCorrente> listaContaCorrenteClientes = new LinkedHashSet<ContaCorrente>();
		Set<ContaPoupanca> listaContaPoupancaClientes = new LinkedHashSet<ContaPoupanca>();
		Set<ContaInvestimento> listaContaInvestimentoClientes = new LinkedHashSet<ContaInvestimento>();
		List<ContaCorrente> extratoBancarioContaCorrente = new ArrayList<>();
		List<ContaPoupanca> extratoBancarioPoupanca = new ArrayList<>();
		List<ContaInvestimento> extratoBancarioinvestimento = new ArrayList<>();
		List<DadosConta> listaDadosDaContaDestino = new ArrayList<>();
		List<ListaContas> listaDeContasCorrente = new ArrayList<>();
		List<ListaContas> listaDeContasPoupanca = new ArrayList<>();
		List<ListaContas> listaDeContasInvestimento = new ArrayList<>();
		List<ContaSaldoNegativo> listaDeContaSaldoNegativo = new ArrayList<>();
		List<TotalValorInvestido> listaTotalinvestido = new ArrayList<>();
		List<TransacoesClientes> listaTransacoesClientes = new ArrayList<>();
		// List<ChaveLoginConta> listaChavesLoginsUsuarios = new ArrayList<>(); para uso
		// futuro

		TratamentoExcecoesTexto trataExcecoesEntradaTexto = new TratamentoExcecoesTexto(null);
		TratamentoExcecoesNumeros trataExcecoesEntradaNumeros = new TratamentoExcecoesNumeros();
		PessoaFisica clientePessoaFisica = new PessoaFisica();
		ContaCorrente contaCorrente = new ContaCorrente(null, null, 0, null, null, 0);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, 0, null, null, 0);
		ContaInvestimento contaInvestimento = new ContaInvestimento(null, null, 0, null, null, 0);
		GeradorNumeroConta geraNumeroConta = new GeradorNumeroConta();
		DadosConta dadosDaContaDestino = new DadosConta(null, null, null, null, null, null, null, null);
		ListaContas dadosDeContaCorrente = new ListaContas(null, null, null);
		ListaContas dadosDeContaPoupanca = new ListaContas(null, null, null);
		ListaContas dadosDeContaInvestimento = new ListaContas(null, null, null);
		ContaSaldoNegativo contaSaldoNegativo = new ContaSaldoNegativo(null, null, null, 0.0, 0.0);
		TotalValorInvestido totalValorInvestidoContaInestimento = new TotalValorInvestido(null, null, 0.0);
		TransacoesClientes transacoesClientes = new TransacoesClientes(null, null, null, 0.0, 0.0, 0.0, 0.0);
		DataDoSistema verificaFimDeSemana = new DataDoSistema();
		DataDoSistema verificaDataAnteriorSistema = new DataDoSistema();
		ChaveLoginConta validaLoginUsuario = new ChaveLoginConta();
		ValidaCpf validacaoCpf = new ValidaCpf();

		
		int contCorrente = 0;
		int contPoupanca = 0;
		int contInvestimento = 0;

		double rendaCadastroCliente = 0;
		double depositoInicial = 0;
		double saldoContaCorrente = 0;
		double saldoContaPoupanca = 0;
		double saldoContaInvestimento = 0;
		double valorSaque = 0;
		double valorTransferencia = 0;
		double valorDeposito = 0;
		double chequeEspecialPreAprovado = 0;
		double totalInvestimento = 0;

		String entradaMenu = null;
		String opcoesMenuBanco = null;
		String escolheAgencia = null;
		String escolheConta = null;
		String escolheContaMenuSaque = null;
		String escolheMenuInvestimentoPoupanca = null;
		String nomeCadastroCliente = null;
		String cpfCadastroCliente = null;
		String inserirNumeroAgencia = null;
		String inserirNumeroConta = null;
		String inserirNumeroAgenciaTransferencia = null;
		String inserirNumeroContaTransferencia = null;
		String inserirNomeDeUsuarioCadastro = null;
		String inserirNomeDeUsuarioLogin = null;
		String inserirSenhaDoUsuarioCadastro = null;
		String inserirSenhaDoUsuarioLogin = null;
		String chaveContaCorrente = null;
		String chaveContaPoupanca = null;
		String chaveContaInvestimento = null;
		String controlaChavesTranferencias = null;
		String armazenaAgencia = null;
		String tranformaValores = null;
		String verificaTipoConta = "";
		String confirmartransferencia = null;
		String menuConfirmaDepositoPoupanca = null;
		String menuConfirmaDepositoInvestimento = null;
		String sairMenuPlataforma = null;
		String chaveLoginUsuario = null;
		String chaveCadastroUsuario = null;
		String alteraChaveUsuario = null;
		String chaveUsuarioSenha = null;

		boolean validacaoMenu = false;
		boolean validacaoLogin = false;

		LocalDateTime dataDoSistema = LocalDateTime.now();

		while (true) {// Loop sistema banco
			System.out.println("#########################################################");
			System.out.println("# Bem-vindo ao DEVInMoney, o banco parceiro da sua vida #");
			System.out.print("#########################################################\n");

			System.out.println("\nDigite uma das opções listadas abaixo para você desfrutar de nossas soluções:\n");

			while (!validacaoMenu) {
				System.out.println("#########################################################");
				System.out.println("#                                                       #");
				System.out.println("#           DIGITE 1- PARA CRIAR UMA CONTA              #");
				System.out.println("#           DIGITE 2- SE VOCE JÁ É NOSSO CLIENTE        #");
				System.out.println("#           DIGITE 3- RELATÓRIOS BANCÁRIOS              #");
				System.out.println("#           DIGITE 4- PARA SAIR DO SISTEMA              #");
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

//####################################################################################################################################################################

			if (Integer.parseInt(entradaMenu) == 1) {// bloco do usuário

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

					while (true) {
						System.out.print("CPF: ");

						cpfCadastroCliente = clientePessoaFisica.cadastrarCPF();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoCpfClientes(cpfCadastroCliente) || !validacaoCpf.validacaoCpf(cpfCadastroCliente)) {
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

						trataExcecoesEntradaNumeros
								.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
						rendaCadastroCliente = trataExcecoesEntradaNumeros.getValorTratado();

						if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
								|| trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble() <= 0.00) {
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

							if (!trataExcecoesEntradaTexto.trataExcecaoEscolhaContaCadastro(escolheConta)) {
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
						inserirNomeDeUsuarioCadastro = contaCorrente.cadastroNomeDeUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoNomeDeUsuario(inserirNomeDeUsuarioCadastro)) {
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
						inserirSenhaDoUsuarioCadastro = contaCorrente.cadastroDeSenhaUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuarioCadastro)) {
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

							if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuarioCadastro)) {
								throw new TratamentoExcecoesTexto(
										"Senha inválida!\nInsira novamente a sua senha, quatro letras e dois numeros!");

							} else {

								if (verificaSenha.equals(inserirSenhaDoUsuarioCadastro)) {
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
					System.out.println("Login: " + inserirNomeDeUsuarioCadastro);

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

//####################################################################################################################################################################

				if (Integer.parseInt(escolheAgencia) == 1) {
					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente).concat("-")
								.concat(Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Corrente");

						System.out.println("Numero da conta: " + geraNumeroConta.geradorDeContaCorrente(contCorrente));
						System.out.println("Agência: " + Agencia.FLORIANOPOLIS.getAgencias());

						while (true) {
							System.out.print(
									"\nPara ativar a sua conta, será preciso fazer um dépósito de no mínimo R$ 1.00\nDigite o valor do depósito: ");
							depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

							trataExcecoesEntradaNumeros
									.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
							System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
							if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
								System.out.println(
										"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

								if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

								}
							} else {
								depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
								contaCorrente.depositoSaldoInicial(depositoInicial);
								break;
							}

							break;
						}

						saldoContaCorrente = contaCorrente.getSaldo();

						System.out.println("\nO saldo inicial da sua nova conta é de "
								+ String.format("%.2f", saldoContaCorrente));
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.FLORIANOPOLIS.getAgencias(), saldoContaCorrente);
						listaContaCorrenteClientes.add(contaCorrente);

						armazenaAgencia = Agencia.FLORIANOPOLIS.getAgencias();

						dadosDeContaCorrente = new ListaContas(nomeCadastroCliente, chaveContaCorrente,
								Agencia.FLORIANOPOLIS.getAgencias());
						listaDeContasCorrente.add(dadosDeContaCorrente);

						chequeEspecialPreAprovado = contaCorrente.setValorChequeEspecial(rendaCadastroCliente);

						chaveCadastroUsuario = chaveContaCorrente.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);

						break;

					case 2:
						contPoupanca++;

						verificaTipoConta = TipoDeConta.POUPANCA.getTipoDeConta();
						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca).concat("-")
								.concat(Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Poupança");

						System.out.println("Numero da conta: " + geraNumeroConta.geradorDeContaPoupanca(contPoupanca));
						System.out.println("Agência: " + Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println("\nDeseja realizar o primeiro depósito na conta?\n1- SIM\n2- NÃO\n-->");

						while (true) {

							menuConfirmaDepositoPoupanca = sc.nextLine();

							try {

								if (!trataExcecoesEntradaTexto
										.trataExcecaoConfirmaDados(menuConfirmaDepositoPoupanca)) {
									throw new TratamentoExcecoesTexto(
											"Opção inválida, escolha uma das opções listadas no menu");
								} else {

									break;
								}

							} catch (TratamentoExcecoesTexto e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						if (Integer.parseInt(menuConfirmaDepositoPoupanca) == 1) {

							while (true) {
								System.out.print("\nDigite o valor que você deseja depositar: ");
								depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

								trataExcecoesEntradaNumeros
										.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
								System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
								if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
									System.out.println(
											"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

									if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

									}
								} else {
									depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
									contaPoupanca.depositoSaldoInicial(depositoInicial);
									break;
								}

								break;
							}

							saldoContaPoupanca = contaPoupanca.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaPoupanca));

							contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaPoupanca, Agencia.FLORIANOPOLIS.getAgencias(),
									saldoContaPoupanca);
							listaContaPoupancaClientes.add(contaPoupanca);

							dadosDeContaPoupanca = new ListaContas(nomeCadastroCliente, chaveContaPoupanca,
									Agencia.FLORIANOPOLIS.getAgencias());
							listaDeContasPoupanca.add(dadosDeContaPoupanca);

						} else if (Integer.parseInt(menuConfirmaDepositoPoupanca) == 2) {

							saldoContaPoupanca = contaPoupanca.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaPoupanca));

							contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaPoupanca, Agencia.FLORIANOPOLIS.getAgencias(),
									saldoContaPoupanca);
							listaContaPoupancaClientes.add(contaPoupanca);

							dadosDeContaPoupanca = new ListaContas(nomeCadastroCliente, chaveContaPoupanca,
									Agencia.FLORIANOPOLIS.getAgencias());
							listaDeContasPoupanca.add(dadosDeContaPoupanca);

						}

						chaveCadastroUsuario = chaveContaPoupanca.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);
						break;

					case 3:
						contInvestimento++;

						verificaTipoConta = TipoDeConta.INVESTIMENTO.getTipoDeConta();
						chaveContaInvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat("-").concat(Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Investimento");

						System.out.println(
								"Numero da conta: " + geraNumeroConta.geradorDeContaInvestimento(contInvestimento));
						System.out.println("Agência: " + Agencia.FLORIANOPOLIS.getAgencias());

						System.out.println("\nDeseja realizar o primeiro depósito na conta?\n1- SIM\n2- NÃO\n-->");

						while (true) {

							menuConfirmaDepositoInvestimento = sc.nextLine();

							try {

								if (!trataExcecoesEntradaTexto
										.trataExcecaoConfirmaDados(menuConfirmaDepositoInvestimento)) {
									throw new TratamentoExcecoesTexto(
											"Opção inválida, escolha uma das opções listadas no menu");
								} else {

									break;
								}

							} catch (TratamentoExcecoesTexto e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						if (Integer.parseInt(menuConfirmaDepositoInvestimento) == 1) {

							while (true) {
								System.out.print("\nDigite o valor que você deseja depositar: ");
								depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

								trataExcecoesEntradaNumeros
										.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
								System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
								if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
									System.out.println(
											"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

									if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

									}
								} else {
									depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
									contaInvestimento.depositoSaldoInicial(depositoInicial);
									break;
								}

								break;
							}

							saldoContaInvestimento = contaInvestimento.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaInvestimento));

							contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaInvestimento, Agencia.FLORIANOPOLIS.getAgencias(),
									saldoContaInvestimento);
							listaContaInvestimentoClientes.add(contaInvestimento);

							dadosDeContaInvestimento = new ListaContas(nomeCadastroCliente, chaveContaInvestimento,
									Agencia.FLORIANOPOLIS.getAgencias());
							listaDeContasInvestimento.add(dadosDeContaInvestimento);

						} else if (Integer.parseInt(menuConfirmaDepositoInvestimento) == 2) {

							saldoContaInvestimento = contaInvestimento.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaInvestimento));

							contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaInvestimento, Agencia.FLORIANOPOLIS.getAgencias(),
									saldoContaInvestimento);
							listaContaInvestimentoClientes.add(contaInvestimento);

							dadosDeContaInvestimento = new ListaContas(nomeCadastroCliente, chaveContaInvestimento,
									Agencia.FLORIANOPOLIS.getAgencias());
							listaDeContasInvestimento.add(dadosDeContaInvestimento);

						}

						chaveCadastroUsuario = chaveContaInvestimento.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);
						break;
					}

				} else if (Integer.parseInt(escolheAgencia) == 2) {

					switch (Integer.parseInt(escolheConta)) {

					case 1:
						contCorrente++;

						chaveContaCorrente = geraNumeroConta.geradorDeContaCorrente(contCorrente).concat("-")
								.concat(Agencia.SAOJOSE.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Corrente");

						System.out.println("Numero da conta: " + geraNumeroConta.geradorDeContaCorrente(contCorrente));
						System.out.println("Agência: " + Agencia.SAOJOSE.getAgencias());

						while (true) {
							System.out.print(
									"\nPara ativar a sua conta, será preciso fazer um dépósito de no mínimo R$ 1.00\nDigite o valor do depósito: ");
							depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

							trataExcecoesEntradaNumeros
									.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
							System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
							if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
								System.out.println(
										"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

								if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

								}
							} else {
								depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
								contaCorrente.depositoSaldoInicial(depositoInicial);
								break;
							}

							break;
						}

						saldoContaCorrente = contaCorrente.getSaldo();

						System.out.println("\nO saldo inicial da sua nova conta é de "
								+ String.format("%.2f", saldoContaCorrente));
						contaCorrente = new ContaCorrente(nomeCadastroCliente, cpfCadastroCliente, rendaCadastroCliente,
								chaveContaCorrente, Agencia.SAOJOSE.getAgencias(), saldoContaCorrente);
						listaContaCorrenteClientes.add(contaCorrente);

						armazenaAgencia = Agencia.SAOJOSE.getAgencias();

						dadosDeContaCorrente = new ListaContas(nomeCadastroCliente, chaveContaCorrente,
								Agencia.SAOJOSE.getAgencias());
						listaDeContasCorrente.add(dadosDeContaCorrente);

						chequeEspecialPreAprovado = contaCorrente.setValorChequeEspecial(rendaCadastroCliente);

						chaveCadastroUsuario = chaveContaCorrente.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);

						break;

					case 2:
						contPoupanca++;

						verificaTipoConta = TipoDeConta.POUPANCA.getTipoDeConta();
						chaveContaPoupanca = geraNumeroConta.geradorDeContaPoupanca(contPoupanca).concat("-")
								.concat(Agencia.SAOJOSE.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Poupança");

						System.out.println("Numero da conta: " + geraNumeroConta.geradorDeContaPoupanca(contPoupanca));
						System.out.println("Agência: " + Agencia.SAOJOSE.getAgencias());
						System.out.println("\nDeseja realizar o primeiro depósito na conta?\n1- SIM\n2- NÃO\n-->");

						while (true) {

							menuConfirmaDepositoPoupanca = sc.nextLine();

							try {

								if (!trataExcecoesEntradaTexto
										.trataExcecaoConfirmaDados(menuConfirmaDepositoPoupanca)) {
									throw new TratamentoExcecoesTexto(
											"Opção inválida, escolha uma das opções listadas no menu");
								} else {

									break;
								}

							} catch (TratamentoExcecoesTexto e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						if (Integer.parseInt(menuConfirmaDepositoPoupanca) == 1) {

							while (true) {
								System.out.print("\nDigite o valor que você deseja depositar: ");
								depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

								trataExcecoesEntradaNumeros
										.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
								System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
								if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
									System.out.println(
											"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

									if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

									}
								} else {
									depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
									contaPoupanca.depositoSaldoInicial(depositoInicial);
									break;
								}

								break;
							}

							saldoContaPoupanca = contaPoupanca.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaPoupanca));

							contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaPoupanca, Agencia.SAOJOSE.getAgencias(),
									saldoContaPoupanca);
							listaContaPoupancaClientes.add(contaPoupanca);

							dadosDeContaPoupanca = new ListaContas(nomeCadastroCliente, chaveContaPoupanca,
									Agencia.SAOJOSE.getAgencias());
							listaDeContasPoupanca.add(dadosDeContaPoupanca);

						} else if (Integer.parseInt(menuConfirmaDepositoPoupanca) == 2) {

							saldoContaPoupanca = contaPoupanca.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaPoupanca));

							contaPoupanca = new ContaPoupanca(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaPoupanca, Agencia.SAOJOSE.getAgencias(),
									saldoContaPoupanca);
							listaContaPoupancaClientes.add(contaPoupanca);

							dadosDeContaPoupanca = new ListaContas(nomeCadastroCliente, chaveContaPoupanca,
									Agencia.SAOJOSE.getAgencias());
							listaDeContasPoupanca.add(dadosDeContaPoupanca);

						}

						chaveCadastroUsuario = chaveContaPoupanca.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);
						break;

					case 3:
						contInvestimento++;

						verificaTipoConta = TipoDeConta.INVESTIMENTO.getTipoDeConta();
						chaveContaInvestimento = geraNumeroConta.geradorDeContaInvestimento(contInvestimento)
								.concat("-").concat(Agencia.SAOJOSE.getAgencias());

						System.out.println(
								"\nAnote também seu numero de conta e agência, você irá precisar para ter acesso a sua plataforma de serviços\n");

						System.out.println("Tipo de conta: Conta Investimento");

						System.out.println(
								"Numero da conta: " + geraNumeroConta.geradorDeContaInvestimento(contInvestimento));
						System.out.println("Agência: " + Agencia.SAOJOSE.getAgencias());

						System.out.println("\nDeseja realizar o primeiro depósito na conta?\n1- SIM\n2- NÃO\n-->");

						while (true) {

							menuConfirmaDepositoInvestimento = sc.nextLine();

							try {

								if (!trataExcecoesEntradaTexto
										.trataExcecaoConfirmaDados(menuConfirmaDepositoInvestimento)) {
									throw new TratamentoExcecoesTexto(
											"Opção inválida, escolha uma das opções listadas no menu");
								} else {

									break;
								}

							} catch (TratamentoExcecoesTexto e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						if (Integer.parseInt(menuConfirmaDepositoInvestimento) == 1) {

							while (true) {
								System.out.print("\nDigite o valor que você deseja depositar: ");
								depositoInicial = trataExcecoesEntradaNumeros.verificaEntradaIncorretaDouble();

								trataExcecoesEntradaNumeros
										.trataValorDeEntradaDouble(trataExcecoesEntradaNumeros.getValorTratado());
								System.out.println(trataExcecoesEntradaNumeros.getValorTratado());
								if (!trataExcecoesEntradaNumeros.isTrataSintaxe() || depositoInicial <= 0.00) {
									System.out.println(
											"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

									if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

									}
								} else {
									depositoInicial = trataExcecoesEntradaNumeros.getValorTratado();
									contaInvestimento.depositoSaldoInicial(depositoInicial);
									break;
								}

								break;
							}

							saldoContaInvestimento = contaInvestimento.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaInvestimento));

							contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaInvestimento, Agencia.SAOJOSE.getAgencias(),
									saldoContaInvestimento);
							listaContaInvestimentoClientes.add(contaInvestimento);

							dadosDeContaInvestimento = new ListaContas(nomeCadastroCliente, chaveContaInvestimento,
									Agencia.SAOJOSE.getAgencias());
							listaDeContasInvestimento.add(dadosDeContaInvestimento);

						} else if (Integer.parseInt(menuConfirmaDepositoInvestimento) == 2) {

							saldoContaInvestimento = contaInvestimento.getSaldo();

							System.out.println("\nO saldo inicial da sua nova conta é de "
									+ String.format("%.2f", saldoContaInvestimento));

							contaInvestimento = new ContaInvestimento(nomeCadastroCliente, cpfCadastroCliente,
									rendaCadastroCliente, chaveContaInvestimento, Agencia.SAOJOSE.getAgencias(),
									saldoContaInvestimento);
							listaContaInvestimentoClientes.add(contaInvestimento);

							dadosDeContaInvestimento = new ListaContas(nomeCadastroCliente, chaveContaInvestimento,
									Agencia.SAOJOSE.getAgencias());
							listaDeContasInvestimento.add(dadosDeContaInvestimento);

						}

						chaveCadastroUsuario = chaveContaInvestimento.concat(inserirNomeDeUsuarioCadastro)
								.concat(inserirSenhaDoUsuarioCadastro);
						break;
					}

				}

//####################################################################################################################################################################

			} else if (Integer.parseInt(entradaMenu) == 2) {
				validacaoLogin = false;
				while (!validacaoLogin) {

					while (!validacaoMenu) {

						System.out.print("Olá, informe a sua agencia com três dígitos: ");
						inserirNumeroAgencia = clientePessoaFisica.escolheAgencia();

						try {

							if (!trataExcecoesEntradaTexto
									.trataExcecaoSelecionaAgenciaCorrentista(inserirNumeroAgencia)) {
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

						System.out.print("\nInforme o numero da sua conta seprando o dígito com um traço: Ex: 1-1: ");
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
						inserirNomeDeUsuarioLogin = contaCorrente.cadastroNomeDeUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoNomeDeUsuario(inserirNomeDeUsuarioLogin)) {
								throw new TratamentoExcecoesTexto("Usuário inválido, digite o nome do seu usuario!");

							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}
					}

					while (!validacaoMenu) {

						System.out.print("\nInsira a sua senha de QUATRO LETRAS E DOIS NÚMEROS: ");
						inserirSenhaDoUsuarioLogin = contaCorrente.cadastroDeSenhaUsuario();

						try {

							if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuarioLogin)) {
								throw new TratamentoExcecoesTexto(

										"Senha inválida!\nDigite novamente a sua senha, quatro letras e dois numeros!");
							} else {

								break;
							}

						} catch (TratamentoExcecoesTexto e) {
							System.out.println("\n" + e.getMessage() + "\n");
						}

					}

					chaveLoginUsuario = inserirNumeroConta.concat("-").concat(inserirNumeroAgencia)
							.concat(inserirNomeDeUsuarioLogin).concat(inserirSenhaDoUsuarioLogin);

					if (chaveCadastroUsuario.equals(chaveLoginUsuario)) {
						validacaoLogin = true;
					} else {

						System.out.println("\nDados para acesso a sua plataforma inválidos!\n");
						validacaoLogin = false;
					}

				}
				boolean menuOperacoes = false;
				while (!menuOperacoes) {

					while (true) {

						System.out.println(
								"\n--------------------------------------------------------------------------------------");
						System.out.print("Olá " + nomeCadastroCliente + ", "); // VERIFICAR ARRAY....
						System.out.print("Agência: " + inserirNumeroAgencia + ", ");
						System.out.println("Conta: " + inserirNumeroConta);

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
						System.out.println("#           DIGITE 7- SIMULAR RENDIMENTOS POUPANÇA           #");
						System.out.println("#           DIGITE 8- SIMULAR RENDIMENTOS CONTA INESTIMENTO  #");
						System.out.println("#           DIGITE 9- ALTERAR DADOS CADASTRAIS               #");
						System.out.println("#           DIGITE 10- SAIR                                  #");
						System.out.println("#                                                            #");
						System.out.println("##############################################################");

						System.out.print("-->");
						opcoesMenuBanco = sc.nextLine();

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

						if (Integer.parseInt(escolheConta) == 1) {

							System.out.print("Olá " + nomeCadastroCliente + ", ");
							System.out.print("Agência: " + inserirNumeroAgencia + ", ");
							System.out.println("Conta: " + inserirNumeroConta);

							System.out.println("\n##############################################################");
							System.out.println("#    Aqui está seu extrato de movimentações                  #");
							System.out.print("##############################################################\n");

							contaCorrente.extrato();
						} else {
							System.out.println("\nVocê não está logado nesta conta\n");
						}

						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################
					case 2:

						if (Integer.parseInt(escolheConta) == 2) {

							System.out.print("Olá " + nomeCadastroCliente + ", ");
							System.out.print("Agência: " + inserirNumeroAgencia + ", ");
							System.out.println("Conta: " + inserirNumeroConta);

							System.out.println("\n##############################################################");
							System.out.println("#    Aqui está seu extrato de movimentações                  #");
							System.out.print("##############################################################\n");

							contaPoupanca.extrato();
						} else {
							System.out.println("\nVocê não está logado nesta conta\n");
						}

						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################
					case 3:

						if (Integer.parseInt(escolheConta) == 3) {

							System.out.print("Olá " + nomeCadastroCliente + ", ");
							System.out.print("Agência: " + inserirNumeroAgencia + ", ");
							System.out.println("Conta: " + inserirNumeroConta);

							System.out.println("\n##############################################################");
							System.out.println("#    Aqui está seu extrato de movimentações                  #");
							System.out.print("##############################################################\n");

							contaInvestimento.extrato();
						} else {
							System.out.println("\nVocê não está logado nesta conta\n");
						}

						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################
					case 4:

						/*
						 * Teste para evitatr transações com datas anteriores, testar somente o segundo
						 * argumento do método.
						 */
						LocalDateTime dataSistema = null;
						LocalDateTime testeRetroagirData = null;

						dataSistema = LocalDateTime.now();
						testeRetroagirData = LocalDateTime.of(2022, 01, 28, 00, 00);

						boolean controlaDataTransacoes = verificaDataAnteriorSistema.verificaTransacoes(dataSistema,
								dataSistema);

						if (controlaDataTransacoes == false) {

							System.out.println("\nNão é permitido fazer transações com datas anteriores\n");
						} else {

							while (true) {

								System.out.print(
										"\nEscolha qual a conta você deseja realizar o saque\n1- CORRENTE\n2- POUPANCA\n3- INVESTIMENTO\n-->");

								escolheContaMenuSaque = sc.nextLine();
						
								System.out.println("Pressione ENTER");
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
									if (contaCorrente.cadastroNomeDeUsuario() == null) {// se chave conta + login +
																						// senha
																						// for diferente, corta o acesso

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println("Seu saldo é de: "
												+ String.format("%.2f", contaCorrente.getSaldo()) + "\n");
										System.out.println("O total do seu cheque especial é de: "
												+ String.format("%.2f", contaCorrente.getValorChequeEspecial()));

										while (true) {
											System.out.print("Quanto você deseja sacar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorSaque = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorSaque = trataExcecoesEntradaNumeros.getValorTratado();

												break;
											}
										}

										contaCorrente.saque(valorSaque);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaCorrente.getSaldo()) + "\n");
										System.out.println("O total do seu cheque especial é de: "
												+ String.format("%.2f", contaCorrente.getValorChequeEspecial()));

										break;
									}

								} else if (Integer.parseInt(escolheContaMenuSaque) == 2) {

									if (contaPoupanca.cadastroNomeDeUsuario() == null) {// verificar...

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println("Seu saldo é de: "
												+ String.format("%.2f", contaPoupanca.getSaldo()) + "\n");

										while (true) {
											System.out.print("Quanto você deseja sacar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorSaque = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorSaque = trataExcecoesEntradaNumeros.getValorTratado();
												break;
											}
										}

										contaPoupanca.saque(valorSaque);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaPoupanca.getSaldo()) + "\n");

										break;
									}

								} else if (Integer.parseInt(escolheContaMenuSaque) == 3) {

									if (contaInvestimento.cadastroNomeDeUsuario() == null) {// verificar...

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println("Seu saldo é de: "
												+ String.format("%.2f", contaInvestimento.getSaldo()) + "\n");

										while (true) {
											System.out.print("Quanto você deseja sacar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorSaque = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorSaque = trataExcecoesEntradaNumeros.getValorTratado();
												break;
											}
										}

										contaInvestimento.saque(valorSaque);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaInvestimento.getSaldo()) + "\n");

										break;
									}

								}
							}
						}
						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################
					case 5:

						/*
						 * Teste para evitatr transações com datas anteriores, testar somente o segundo
						 * argumento do método.
						 */
						dataSistema = null;
						testeRetroagirData = null;

						dataSistema = LocalDateTime.now();
						testeRetroagirData = LocalDateTime.of(2022, 01, 28, 00, 00);

						controlaDataTransacoes = verificaDataAnteriorSistema.verificaTransacoes(dataSistema,
								dataSistema);

						if (controlaDataTransacoes == false) {

							// Teste para verificar se a transferencia está sendo feita no final de semana
//						LocalDateTime teste = LocalDateTime.of(2022, 01, 28, 00, 00);
//						boolean transferenciaFimDeSemana = verificaFimDeSemana.verificaFimDeSemana(teste);

							boolean transferenciaFimDeSemana = verificaFimDeSemana.verificaFimDeSemana(dataDoSistema);

							if (transferenciaFimDeSemana == true) {

								System.out.println("\nNão é permitido transferências nos finais de semana\n");

							} else {

								String dataTransferencia = null;
								while (true) {

									System.out.print(
											"\nEscolha de qual conta você deseja realizar a transferência\n1- CORRENTE\n2- POUPANCA\n3- INVESTIMENTO\n-->");

									escolheContaMenuSaque = sc.nextLine();

									System.out.println("Pressione ENTER");
									while (true) {
										try {

											if (!trataExcecoesEntradaTexto
													.trataExcecaoMenuSaque(escolheContaMenuSaque)) {
												throw new TratamentoExcecoesTexto("Digite uma opção válida!");
											} else {

												break;
											}

										} catch (TratamentoExcecoesTexto e) {
											System.out.println("\n" + e.getMessage() + "\n");
										}
									}

									if (Integer.parseInt(escolheContaMenuSaque) == 1) {
										if (contaCorrente.cadastroNomeDeUsuario() == null) {// verificar...

											System.out.println(
													"Você ainda não possui conta corrente, escolha outra conta!");

										} else {

											while (!validacaoMenu) {

												System.out.print(
														"Digite o número da agência de destino com três dígitos: ");
												inserirNumeroAgenciaTransferencia = clientePessoaFisica
														.escolheAgencia();

												try {

													if (!trataExcecoesEntradaTexto
															.trataExcecaoSelecionaAgenciaCorrentista(
																	inserirNumeroAgenciaTransferencia)) {
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

												System.out.print(
														"\nInforme o numero da sua conta de destino seguido do dígito: Ex: 1-1: ");
												inserirNumeroContaTransferencia = clientePessoaFisica
														.insereNumeroConta();

												try {

													if (!trataExcecoesEntradaTexto.trataExcecaoInserirConta(
															inserirNumeroContaTransferencia)) {
														throw new TratamentoExcecoesTexto("Digite uma conta válida!");
													} else {

														break;
													}

												} catch (TratamentoExcecoesTexto e) {
													System.out.println("\n" + e.getMessage() + "\n");
												}
											}

											controlaChavesTranferencias = inserirNumeroConta.concat("-")
													.concat(inserirNumeroAgenciaTransferencia);

											if (controlaChavesTranferencias.equals(inserirNumeroContaTransferencia
													.concat("-").concat(inserirNumeroAgenciaTransferencia))) {

												System.out.println(
														"\nVocê não pode fazer transferência para si mesmo, escolha outro tipo de conta!\n");
											} else {

												System.out.println("\nConfira os dados da agência de destino");

												if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.FLORIANOPOLIS.getAgencias())) {

													System.out.println("\nAgência Florianópolis: "
															+ Agencia.FLORIANOPOLIS.getAgencias() + "");

												} else if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.SAOJOSE.getAgencias())) {

													System.out.println("\nAgência São José: "
															+ Agencia.SAOJOSE.getAgencias() + "");
												} else {
													System.out.println("\nOutro banco");
												}

												if (TipoDeConta.CORRENTE.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Corrente: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.POUPANCA.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Poupança: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.INVESTIMENTO.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Investimento: "
															+ inserirNumeroContaTransferencia + "\n");

												} else {
													System.out.println("\nConta de outro banco\n");
												}

												// ver depois pra puxar nome....

												System.out.println("Seu saldo é de: "
														+ String.format("%.2f", contaCorrente.getSaldo()));
												System.out.println("O total do seu cheque especial é de: " + String
														.format("%.2f", contaCorrente.getValorChequeEspecial()));

												while (true) {
													System.out.print("Quanto você deseja transferir? ");

													trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
															trataExcecoesEntradaNumeros.getValorTratado());
													valorTransferencia = trataExcecoesEntradaNumeros.getValorTratado();
													if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
															|| trataExcecoesEntradaNumeros
																	.verificaEntradaIncorretaDouble() <= 0.00) {
														System.out.println(
																"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

														if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

														}
													} else {
														valorTransferencia = trataExcecoesEntradaNumeros
																.getValorTratado();
														break;
													}
												}

												while (true) {

													System.out.println(
															"\nVocê confirma a oparação?\n1- Para SIM\n2- Para NÃO\n-->");
													confirmartransferencia = clientePessoaFisica.escolheAgencia();

													try {

														if (!trataExcecoesEntradaTexto
																.trataExcecaoConfirmaDados(confirmartransferencia)) {
															throw new TratamentoExcecoesTexto(
																	"Digite corretamente o numero correspondente a agência!");
														} else {

															dataTransferencia = LocalDateTime.now().format(
																	DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

															if (TipoDeConta.INVESTIMENTO.getTipoDeConta().equals(
																	inserirNumeroContaTransferencia.substring(2, 3))) {

																totalInvestimento += valorTransferencia;
															}
															break;
														}

													} catch (TratamentoExcecoesTexto e) {
														System.out.println("\n" + e.getMessage() + "\n");
													}
												}

												if (Integer.parseInt(confirmartransferencia) == 1) {
													contaCorrente.transferir(valorTransferencia);
													System.out.print("Saldo atual: "
															+ String.format("%.2f", contaCorrente.getSaldo()) + "\n");
													System.out.println("O total do seu cheque especial é de: " + String
															.format("%.2f", contaCorrente.getValorChequeEspecial()));

													break;
												} else {
													System.out.println("\nOperação cancelada\n");
												}

												break;
											}
										}
									} else if (Integer.parseInt(escolheContaMenuSaque) == 2) {

										if (contaPoupanca.cadastroNomeDeUsuario() == null) {// verificar...

											System.out.println(
													"Você ainda não possui conta corrente, escolha outra conta!");

										} else {

											while (!validacaoMenu) {

												System.out.print(
														"Digite o número da agência de destino com três dígitos: ");
												inserirNumeroAgenciaTransferencia = clientePessoaFisica
														.escolheAgencia();

												try {

													if (!trataExcecoesEntradaTexto
															.trataExcecaoSelecionaAgenciaCorrentista(
																	inserirNumeroAgenciaTransferencia)) {
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

												System.out.print(
														"\nInforme o numero da sua conta de destino seguido do dígito: Ex: 1-1: ");
												inserirNumeroContaTransferencia = clientePessoaFisica
														.insereNumeroConta();

												try {

													if (!trataExcecoesEntradaTexto.trataExcecaoInserirConta(
															inserirNumeroContaTransferencia)) {
														throw new TratamentoExcecoesTexto("Digite uma conta válida!");
													} else {

														break;
													}

												} catch (TratamentoExcecoesTexto e) {
													System.out.println("\n" + e.getMessage() + "\n");
												}
											}

											controlaChavesTranferencias = inserirNumeroConta.concat("-")
													.concat(inserirNumeroAgenciaTransferencia);

											if (controlaChavesTranferencias.equals(inserirNumeroContaTransferencia
													.concat("-").concat(inserirNumeroAgenciaTransferencia))) {

												System.out.println("\nConfira os dados da agência de destino");

												if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.FLORIANOPOLIS.getAgencias())) {

													System.out.println("\nAgência Florianópolis: "
															+ Agencia.FLORIANOPOLIS.getAgencias() + "");

												} else if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.SAOJOSE.getAgencias())) {

													System.out.println("\nAgência São José: "
															+ Agencia.SAOJOSE.getAgencias() + "");
												} else {
													System.out.println("\nOutro banco");
												}

												if (TipoDeConta.CORRENTE.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Corrente: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.POUPANCA.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Poupança: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.INVESTIMENTO.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Investimento: "
															+ inserirNumeroContaTransferencia + "\n");

												} else {
													System.out.println("\nConta de outro banco\n");
												}

												// ver depois pra puxar nome....

												System.out.println("Seu saldo é de: "
														+ String.format("%.2f", contaPoupanca.getSaldo()));

												while (true) {
													System.out.print("Quanto você deseja transferir? ");

													trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
															trataExcecoesEntradaNumeros.getValorTratado());
													valorTransferencia = trataExcecoesEntradaNumeros.getValorTratado();
													if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
															|| trataExcecoesEntradaNumeros
																	.verificaEntradaIncorretaDouble() <= 0.00) {
														System.out.println(
																"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

														if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

														}
													} else {
														valorTransferencia = trataExcecoesEntradaNumeros
																.getValorTratado();
														break;
													}
												}

												while (true) {

													System.out.println(
															"\nVocê confirma a operação?\n1- Para SIM\n2- Para NÃO\n-->");
													confirmartransferencia = clientePessoaFisica.escolheAgencia();

													try {

														if (!trataExcecoesEntradaTexto
																.trataExcecaoConfirmaDados(confirmartransferencia)) {
															throw new TratamentoExcecoesTexto(
																	"Digite corretamente o numero correspondente a agência!");
														} else {

															dataTransferencia = LocalDateTime.now().format(
																	DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

															if (TipoDeConta.INVESTIMENTO.getTipoDeConta().equals(
																	inserirNumeroContaTransferencia.substring(2, 3))) {

																totalInvestimento += valorTransferencia;
															}

															break;
														}

													} catch (TratamentoExcecoesTexto e) {
														System.out.println("\n" + e.getMessage() + "\n");
													}
												}

												if (Integer.parseInt(confirmartransferencia) == 1) {
													contaPoupanca.transferir(valorTransferencia);
													System.out.print("Saldo atual: "
															+ String.format("%.2f", contaPoupanca.getSaldo()) + "\n");

													break;
												} else {
													System.out.println("\nOperação cancelada\n");
												}

												break;
											}
										}

									} else if (Integer.parseInt(escolheContaMenuSaque) == 3) {

										if (contaInvestimento.cadastroNomeDeUsuario() == null) {// verificar...

											System.out.println(
													"Você ainda não possui conta corrente, escolha outra conta!");

										} else {

											while (!validacaoMenu) {

												System.out.print(
														"Digite o número da agência de destino com três dígitos: ");
												inserirNumeroAgenciaTransferencia = clientePessoaFisica
														.escolheAgencia();

												try {

													if (!trataExcecoesEntradaTexto
															.trataExcecaoSelecionaAgenciaCorrentista(
																	inserirNumeroAgenciaTransferencia)) {
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

												System.out.print(
														"\nInforme o numero da sua conta de destino seguido do dígito: Ex: 1-1: ");
												inserirNumeroContaTransferencia = clientePessoaFisica
														.insereNumeroConta();

												try {

													if (!trataExcecoesEntradaTexto.trataExcecaoInserirConta(
															inserirNumeroContaTransferencia)) {
														throw new TratamentoExcecoesTexto("Digite uma conta válida!");
													} else {

														break;
													}

												} catch (TratamentoExcecoesTexto e) {
													System.out.println("\n" + e.getMessage() + "\n");
												}
											}

											controlaChavesTranferencias = inserirNumeroConta.concat("-")
													.concat(inserirNumeroAgenciaTransferencia);

											if (controlaChavesTranferencias.equals(inserirNumeroContaTransferencia
													.concat("-").concat(inserirNumeroAgenciaTransferencia))) {

												System.out.println("\nConfira os dados da agência de destino");

												if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.FLORIANOPOLIS.getAgencias())) {

													System.out.println("\nAgência Florianópolis: "
															+ Agencia.FLORIANOPOLIS.getAgencias() + "");

												} else if (inserirNumeroAgenciaTransferencia
														.equals(Agencia.SAOJOSE.getAgencias())) {

													System.out.println("\nAgência São José: "
															+ Agencia.SAOJOSE.getAgencias() + "");
												} else {
													System.out.println("\nOutro banco");
												}

												if (TipoDeConta.CORRENTE.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Corrente: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.POUPANCA.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Poupança: "
															+ inserirNumeroContaTransferencia + "\n");

												} else if (TipoDeConta.INVESTIMENTO.getTipoDeConta()
														.equals(inserirNumeroContaTransferencia.substring(2, 3))) {

													System.out.println("\nConta Investimento: "
															+ inserirNumeroContaTransferencia + "\n");

												} else {
													System.out.println("\nConta de outro banco\n");
												}

												// ver depois pra puxar nome....

												System.out.println("Seu saldo é de: "
														+ String.format("%.2f", contaInvestimento.getSaldo()));

												while (true) {
													System.out.print("Quanto você deseja transferir? ");

													trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
															trataExcecoesEntradaNumeros.getValorTratado());
													valorTransferencia = trataExcecoesEntradaNumeros.getValorTratado();
													if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
															|| trataExcecoesEntradaNumeros
																	.verificaEntradaIncorretaDouble() <= 0.00) {
														System.out.println(
																"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

														if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

														}
													} else {
														valorTransferencia = trataExcecoesEntradaNumeros
																.getValorTratado();
														break;
													}
												}

												while (true) {

													System.out.println(
															"\nVocê confirma a oparação?\n1- Para SIM\n2- Para NÃO\n-->");
													confirmartransferencia = clientePessoaFisica.escolheAgencia();

													try {

														if (!trataExcecoesEntradaTexto
																.trataExcecaoConfirmaDados(confirmartransferencia)) {
															throw new TratamentoExcecoesTexto(
																	"Digite corretamente o numero correspondente a agência!");
														} else {

															dataTransferencia = LocalDateTime.now().format(
																	DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

															if (TipoDeConta.INVESTIMENTO.getTipoDeConta().equals(
																	inserirNumeroContaTransferencia.substring(2, 3))) {

																totalInvestimento += valorTransferencia;
															}

															break;
														}

													} catch (TratamentoExcecoesTexto e) {
														System.out.println("\n" + e.getMessage() + "\n");
													}
												}

												if (Integer.parseInt(confirmartransferencia) == 1) {
													contaInvestimento.transferir(valorTransferencia);
													System.out.print("Saldo atual: "
															+ String.format("%.2f", contaInvestimento.getSaldo())
															+ "\n");

													break;
												} else {
													System.out.println("\nOperação cancelada\n");
												}

												break;
											}
										}
									}

									String valorFormatado = Double.toString(valorTransferencia);
									dadosDaContaDestino = new DadosConta(inserirNumeroAgencia, inserirNumeroConta,
											inserirNomeDeUsuarioCadastro, inserirNumeroAgenciaTransferencia,
											inserirNumeroContaTransferencia, "Teste", valorFormatado,
											dataTransferencia);
									listaDadosDaContaDestino.add(dadosDaContaDestino);
								}
							}
						}
						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################
					case 6:

						/*
						 * Teste para evitatr transações com datas anteriores, testar somente o segundo
						 * argumento do método.
						 */
						dataSistema = null;
						testeRetroagirData = null;

						dataSistema = LocalDateTime.now();
						testeRetroagirData = LocalDateTime.of(2022, 01, 28, 00, 00);

						controlaDataTransacoes = verificaDataAnteriorSistema.verificaTransacoes(dataSistema,
								dataSistema);

						if (controlaDataTransacoes == false) {

							while (true) {

								System.out.print(
										"\nEscolha qual a conta você deseja realizar o depósito\n1- CORRENTE\n2- POUPANCA\n3- INVESTIMENTO\n-->");

								String escolheContaMenu = sc.nextLine();

								System.out.println("Pressione ENTER");
								while (true) {
									try {

										if (!trataExcecoesEntradaTexto.trataExcecaoMenuSaque(escolheContaMenu)) {
											throw new TratamentoExcecoesTexto("Digite uma opção válida!");
										} else {

											break;
										}

									} catch (TratamentoExcecoesTexto e) {
										System.out.println("\n" + e.getMessage() + "\n");
									}
								}

								if (Integer.parseInt(escolheContaMenu) == 1) {
									if (contaCorrente.cadastroNomeDeUsuario() == null) {// verificar...

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println(
												"Seu saldo é de: " + String.format("%.2f", contaCorrente.getSaldo()));
										System.out.println("O total do seu cheque especial é de: "
												+ String.format("%.2f", contaCorrente.getValorChequeEspecial()));

										while (true) {
											System.out.print("Quanto você deseja depositar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();

												break;
											}
										}

										contaCorrente.deposito(valorDeposito, chequeEspecialPreAprovado);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaCorrente.getSaldo()) + "\n");
										System.out.println("O total do seu cheque especial é de: "
												+ String.format("%.2f", contaCorrente.getValorChequeEspecial()));

										break;
									}

								} else if (Integer.parseInt(escolheContaMenu) == 2) {

									if (contaPoupanca.cadastroNomeDeUsuario() == null) {// verificar...

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println(
												"Seu saldo é de: " + String.format("%.2f", contaPoupanca.getSaldo()));

										while (true) {
											System.out.print("Quanto você deseja depositar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();

												break;
											}
										}

										contaPoupanca.deposito(valorDeposito, 0);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaPoupanca.getSaldo()) + "\n");

										break;
									}

								} else if (Integer.parseInt(escolheContaMenu) == 3) {

									if (contaInvestimento.cadastroNomeDeUsuario() == null) {// verificar...

										System.out
												.println("Você ainda não possui conta corrente, escolha outra conta!");

									} else {

										System.out.println("Seu saldo é de: "
												+ String.format("%.2f", contaInvestimento.getSaldo()));

										while (true) {
											System.out.print("Quanto você deseja depositar? ");

											trataExcecoesEntradaNumeros.trataValorDeEntradaDouble(
													trataExcecoesEntradaNumeros.getValorTratado());
											valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();
											if (!trataExcecoesEntradaNumeros.isTrataSintaxe()
													|| trataExcecoesEntradaNumeros
															.verificaEntradaIncorretaDouble() <= 0.00) {
												System.out.println(
														"\nValor incorreto, digite apenas números, use o ponto para separar as casas decimais\nVocê deve inserir as casas decimais mesmo que seja zero.\n");

												if (trataExcecoesEntradaNumeros.getValorTratado() == 0.0) {

												}
											} else {
												valorDeposito = trataExcecoesEntradaNumeros.getValorTratado();

												totalInvestimento += valorDeposito;
												break;
											}
										}

										contaInvestimento.deposito(valorDeposito, 0);

										System.out.print("Saldo atual: "
												+ String.format("%.2f", contaInvestimento.getSaldo()) + "\n");

										break;
									}
								}
							}
						}
						sairMenuPlataforma = "3";
						break;

//####################################################################################################################################################################
					case 7:

						if (escolheConta.equals("2")) {

							while (true) {

								System.out.print(
										"\nDeseja fazer uma simulação de rendimentos da poupança?\n1- Para SIM\n2- Para NÃO\n-->");
								escolheMenuInvestimentoPoupanca = sc.nextLine();

								try {

									if (!trataExcecoesEntradaTexto
											.trataExcecaoConfirmaDados(escolheMenuInvestimentoPoupanca)) {
										throw new TratamentoExcecoesTexto("Digite uma opção válida!");
									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							if (Integer.parseInt(escolheMenuInvestimentoPoupanca) == 1) {

								contaPoupanca.simulacaoDeInvestimento();

							} else if (Integer.parseInt(escolheMenuInvestimentoPoupanca) == 2) {

								break;
							}

						} else {
							System.out.println("\nOpção não disponível para essa categoria de conta\n");
						}

						sairMenuPlataforma = "3";
						break;
//####################################################################################################################################################################						
					case 8:

						if (escolheConta.equals("3")) {

							while (true) {

								System.out.print(
										"\nDeseja fazer uma simulação de rendimentos exclusicos?\n1- Para SIM\n2- Para NÃO\n-->");
								escolheMenuInvestimentoPoupanca = sc.nextLine();

								try {

									if (!trataExcecoesEntradaTexto
											.trataExcecaoConfirmaDados(escolheMenuInvestimentoPoupanca)) {
										throw new TratamentoExcecoesTexto("Digite uma opção válida!");
									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							if (Integer.parseInt(escolheMenuInvestimentoPoupanca) == 1) {

								contaInvestimento.simulacaoInvestimento();

							} else if (Integer.parseInt(escolheMenuInvestimentoPoupanca) == 2) {

								break;
							}

						} else {
							System.out.println("\nOpção não disponível para essa categoria de conta\n");
						}

						sairMenuPlataforma = "3";

						break;
//####################################################################################################################################################################
					case 9:

						System.out.println("##############################################################");
						System.out.println("#                ALTERAR DADOS CADASTRAIS                    #");
						System.out.print("##############################################################\n");

						System.out.println(
								"Antes de alterar os seus dados, precisamos que vc digite as informações solicitadas!\n");

						validacaoMenu = false;
						while (!validacaoMenu) {

							while (true) {
								System.out.print("Olá, informe a sua agencia com três dígitos: ");
								inserirNumeroAgencia = clientePessoaFisica.escolheAgencia();

								try {

									if (!trataExcecoesEntradaTexto
											.trataExcecaoSelecionaAgenciaCorrentista(inserirNumeroAgencia)) {
										throw new TratamentoExcecoesTexto(
												"Digite uma ag	agência válida: Agência 001 para Florianópolis ou agência 002 para São José!");
									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							while (true) {

								System.out.print(
										"\nInforme o numero da sua conta seprando o dígito com um traço: Ex: 1-1: ");
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

							while (true) {

								System.out.print("\nInsira o seu nome de usuário: ");
								inserirNomeDeUsuarioLogin = contaCorrente.cadastroNomeDeUsuario();

								try {

									if (!trataExcecoesEntradaTexto
											.trataExcecaoNomeDeUsuario(inserirNomeDeUsuarioLogin)) {
										throw new TratamentoExcecoesTexto(
												"Usuário inválido, digite o nome do seu usuario!");

									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}
							}

							while (true) {
								System.out.print("\nInsira a sua senha de QUATRO LETRAS E DOIS NÚMEROS: ");
								inserirSenhaDoUsuarioLogin = contaCorrente.cadastroDeSenhaUsuario();

								try {

									if (!trataExcecoesEntradaTexto
											.trataExcecaoSenhaDeUsuario(inserirSenhaDoUsuarioLogin)) {
										throw new TratamentoExcecoesTexto(

												"Senha inválida!\nDigite novamente a sua senha, quatro letras e dois numeros!");
									} else {

										break;
									}

								} catch (TratamentoExcecoesTexto e) {
									System.out.println("\n" + e.getMessage() + "\n");
								}

							}

							chaveLoginUsuario = inserirNumeroConta.concat("-").concat(inserirNumeroAgencia)
									.concat(inserirNomeDeUsuarioLogin).concat(inserirSenhaDoUsuarioLogin);

							if (chaveCadastroUsuario.equals(chaveLoginUsuario)) {
								validacaoLogin = true;
							} else {

								System.out.println("\nDados para acesso a sua plataforma inválidos!\n");
								validacaoLogin = false;
							}

							if (chaveCadastroUsuario.equals(chaveLoginUsuario)) {

								break;

							} else {

								System.out.println("\nDados inválidos, digite as informações novamente!\n");

							}

						}

						if (Integer.parseInt(escolheConta) == 1) {

							alteraChaveUsuario = contaCorrente.alteraDadosCadastrais(nomeCadastroCliente,
									inserirNomeDeUsuarioLogin, inserirSenhaDoUsuarioLogin);

							chaveUsuarioSenha = validaLoginUsuario.trataChaveAlteracadastro(alteraChaveUsuario);

							chaveCadastroUsuario = chaveContaCorrente.concat(chaveUsuarioSenha);

							chaveLoginUsuario = chaveCadastroUsuario;

						} else if (Integer.parseInt(escolheConta) == 2) {

							alteraChaveUsuario = contaPoupanca.alteraDadosCadastrais(nomeCadastroCliente,
									inserirNomeDeUsuarioLogin, inserirSenhaDoUsuarioLogin);

							chaveUsuarioSenha = validaLoginUsuario.trataChaveAlteracadastro(alteraChaveUsuario);

							chaveCadastroUsuario = chaveContaPoupanca.concat(chaveUsuarioSenha);

							chaveLoginUsuario = chaveCadastroUsuario;

						}
						if (Integer.parseInt(escolheConta) == 3) {

							alteraChaveUsuario = contaInvestimento.alteraDadosCadastrais(nomeCadastroCliente,
									inserirNomeDeUsuarioLogin, inserirSenhaDoUsuarioLogin);

							chaveUsuarioSenha = validaLoginUsuario.trataChaveAlteracadastro(alteraChaveUsuario);

							chaveCadastroUsuario = chaveContaInvestimento.concat(chaveUsuarioSenha);

							chaveLoginUsuario = chaveCadastroUsuario;
							
						}
						

						sairMenuPlataforma = "3";

						break;

					case 10:

						while (true) {

							System.out.println("\nDeseja sair da sua plataforma de serviços?\n1- SIM\n2- NÃO\n-->");

							sairMenuPlataforma = sc.nextLine();

							try {

								if (!trataExcecoesEntradaTexto.trataExcecaoSaidaPlataforma(sairMenuPlataforma)) {
									throw new TratamentoExcecoesTexto("Digite uma opção válida!");
								} else {

									System.out.println("\nMuito obrigado!\n");

									break;
								}

							} catch (TratamentoExcecoesTexto e) {
								System.out.println("\n" + e.getMessage() + "\n");
							}
						}

						break;
//####################################################################################################################################################################
					}

					if (Integer.parseInt(sairMenuPlataforma) == 1) {// problema....

						menuOperacoes = true;
						validacaoLogin = true;
						break;
					} else if (Integer.parseInt(sairMenuPlataforma) == 2 || Integer.parseInt(sairMenuPlataforma) == 3) {

						continue;
					}
				}

				if (chequeEspecialPreAprovado > contaCorrente.getValorChequeEspecial()) {
					if (inserirNumeroAgencia.equals(Agencia.FLORIANOPOLIS.getAgencias())) {

						contaSaldoNegativo = new ContaSaldoNegativo(nomeCadastroCliente, chaveContaCorrente,
								Agencia.FLORIANOPOLIS.getAgencias(), chequeEspecialPreAprovado,
								contaCorrente.getValorChequeEspecial());
						listaDeContaSaldoNegativo.add(contaSaldoNegativo);

					} else if (inserirNumeroAgencia.equals(Agencia.SAOJOSE.getAgencias())) {

						contaSaldoNegativo = new ContaSaldoNegativo(nomeCadastroCliente, chaveContaCorrente,
								Agencia.SAOJOSE.getAgencias(), chequeEspecialPreAprovado,
								contaCorrente.getValorChequeEspecial());
						listaDeContaSaldoNegativo.add(contaSaldoNegativo);

					}
				}

				contaInvestimento.setSaldo(0.0);
			} else if (Integer.parseInt(entradaMenu) == 3) {

				System.out.println("##############################################################");
				System.out.println("#           GERENCIAL - Área de relatórios do banco          #");
				System.out.print("##############################################################\n");
				System.out.println("##############################################################");
				System.out.println("#                                                            #");
				System.out.println("#     DIGITE 1- LISTAR HISTORICO DE TRANSFERENCIAS           #");
				System.out.println("#     DIGITE 2- LISTAR CONTAS CADASTRADAS                    #");
				System.out.println("#     DIGITE 3- LISTAR CONTAS COM SALDO NEGATIVO             #");
				System.out.println("#     DIGITE 4- LISTAR TOTAL DE VALORES INVESTIDOS           #");
				System.out.println("#     DIGITE 5- LISTAR TOTAL DE TRANSAÇÕES POR CLIENTE       #");
				System.out.println("#     DIGITE 9- SAIR                                         #");
				System.out.println("#                                                            #");
				System.out.println("##############################################################");
				System.out.print("-->");
				while (true) {

					sairMenuPlataforma = sc.nextLine();

					try {

						if (!trataExcecoesEntradaTexto.trataExcecaoMenuGerencial(sairMenuPlataforma)) {
							throw new TratamentoExcecoesTexto("Digite uma opção válida!");
						} else {

							System.out.println("\nMuito obrigado!\n");

							break;
						}

					} catch (TratamentoExcecoesTexto e) {
						System.out.println("\n" + e.getMessage() + "\n");
					}
				}

				switch (Integer.parseInt(sairMenuPlataforma)) {

				case 1:

					System.out.println("##############################################################");
					System.out.println("#           GERENCIAL - DADOS DE TRANSFERENCIA               #");
					System.out.print("##############################################################\n");

					dadosDaContaDestino.recebeDadosTransferenciaContaDestino(listaDadosDaContaDestino);

					break;

				case 2:

					System.out.println("##############################################################");
					System.out.println("#           GERENCIAL - LISTA DE CONTAS                      #");
					System.out.print("##############################################################\n");

					dadosDeContaCorrente.listaContaCorrente(listaDeContasCorrente);
					dadosDeContaPoupanca.listaContaPoupanca(listaDeContasPoupanca);
					dadosDeContaInvestimento.listaContaInvestimento(listaDeContasInvestimento);

					break;

				case 3:

					System.out.println("##############################################################");
					System.out.println("#           GERENCIAL - LISTA DE CONTAS NEGATIVAS            #");
					System.out.print("##############################################################\n");

					contaSaldoNegativo.listaContaCorrente(listaDeContaSaldoNegativo);

					break;

				case 4:

					System.out.println("##############################################################");
					System.out.println("#     GERENCIAL - LISTA DE VALORES TOTAIS DE INVESTIMENTO    #");
					System.out.print("##############################################################\n");

					totalValorInvestidoContaInestimento = new TotalValorInvestido(nomeCadastroCliente,
							chaveContaInvestimento, totalInvestimento);
					listaTotalinvestido.add(totalValorInvestidoContaInestimento);

					totalValorInvestidoContaInestimento.listaTotalInvestido(listaTotalinvestido);

					totalInvestimento = 0.0;
					break;

				case 5:

					System.out.println("##############################################################");
					System.out.println("#     GERENCIAL - LISTA TRASAÇÕES POR CLIENTE                #");
					System.out.print("##############################################################\n");

					transacoesClientes = new TransacoesClientes(nomeCadastroCliente, inserirNumeroAgencia,
							inserirNumeroConta, depositoInicial, valorDeposito, valorSaque, valorTransferencia);
					listaTransacoesClientes.add(transacoesClientes);

					transacoesClientes.transacaoSaque(listaTransacoesClientes);

					inserirNumeroAgencia = null;
					inserirNumeroConta = null;

					break;
				case 6:

					// saída do sistema gerencial....

					break;
				}

				if (Integer.parseInt(sairMenuPlataforma) == 6) {

					break;
				}

			} else if (Integer.parseInt(entradaMenu) == 4) {

				System.out.println("Obrigado!");

				break;

			}
		}
		sc.close();
	}
}
