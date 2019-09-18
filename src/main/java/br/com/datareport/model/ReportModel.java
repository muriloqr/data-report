package br.com.datareport.model;

public class ReportModel {
	
	private Long quantidadeClientes;
	private Long quantidadeVendedores;
	private Long idVendaMaisCara;
	private String piorVendedor;
	
	public Long getQuantidadeClientes() {
		return quantidadeClientes;
	}
	
	public void setQuantidadeClientes(Long quantidadeClientes) {
		this.quantidadeClientes = quantidadeClientes;
	}
	
	public Long getQuantidadeVendedores() {
		return quantidadeVendedores;
	}
	
	public void setQuantidadeVendedores(Long quantidadeVendedores) {
		this.quantidadeVendedores = quantidadeVendedores;
	}
	
	public Long getIdVendaMaisCara() {
		return idVendaMaisCara;
	}
	
	public void setIdVendaMaisCara(Long idVendaMaisCara) {
		this.idVendaMaisCara = idVendaMaisCara;
	}
	
	public String getPiorVendedor() {
		return piorVendedor;
	}
	
	public void setPiorVendedor(String piorVendedor) {
		this.piorVendedor = piorVendedor;
	}
	
}
