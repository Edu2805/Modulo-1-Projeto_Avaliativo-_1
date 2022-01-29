package transacoes;

import java.util.List;


public class DadosConta {

	String agenciaOrigem;
	String contaOrigem;
	String nomeOrigem;
	String agenciaDestino;
	String contaDestino;
	String nomeDestino;
	String valorTransferencia;
	String data;
	public DadosConta(String agenciaOrigem, String contaOrigem, String nomeOrigem, String agenciaDestino,
			String contaDestino, String nomeDestino, String valorTransferencia, String data) {
		super();
		this.agenciaOrigem = agenciaOrigem;
		this.contaOrigem = contaOrigem;
		this.nomeOrigem = nomeOrigem;
		this.agenciaDestino = agenciaDestino;
		this.contaDestino = contaDestino;
		this.nomeDestino = nomeDestino;
		this.valorTransferencia = valorTransferencia;
		this.data = data;
		
	}
	
	
	public void recebeDadosTransferenciaContaDestino(List<DadosConta> listaDadosDaContaDestino) {
		
		System.out.println("------------------------------------------------------------------------------------------------");
		for (DadosConta dadosConta : listaDadosDaContaDestino) {
			
			System.out.println("Agência origem: " + dadosConta.agenciaOrigem + ", Conta origem: " + dadosConta.contaOrigem 
					+ ", Agência destino: " + dadosConta.agenciaDestino + ", Conta destino: " + dadosConta.contaDestino 
					+ ", Valor: " +  dadosConta.valorTransferencia + ", Data e hora: " + dadosConta.data);
			
		}
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	public String getAgenciaOrigem() {
		return agenciaOrigem;
	}
	public void setAgenciaOrigem(String agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public String getNomeOrigem() {
		return nomeOrigem;
	}
	public void setNomeOrigem(String nomeOrigem) {
		this.nomeOrigem = nomeOrigem;
	}
	public String getAgenciaDestino() {
		return agenciaDestino;
	}
	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(String valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
