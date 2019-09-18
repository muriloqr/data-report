package br.com.datareport.model;

import java.math.BigDecimal;

public class VendaModel {
	
	private Long saleId;
	private BigDecimal vendaMaisCara;
	private Double vendaMaisBarata;
	private String piorVendedorNome;
	
	public Long getSaleId() {
		return saleId;
	}
	
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public BigDecimal getVendaMaisCara() {
		return vendaMaisCara;
	}

	public void setVendaMaisCara(BigDecimal vendaMaisCara) {
		this.vendaMaisCara = vendaMaisCara;
	}

	public Double getVendaMaisBarata() {
		return vendaMaisBarata;
	}

	public void setVendaMaisBarata(Double vendaMaisBarata) {
		this.vendaMaisBarata = vendaMaisBarata;
	}

	public String getPiorVendedorNome() {
		return piorVendedorNome;
	}

	public void setPiorVendedorNome(String piorVendedorNome) {
		this.piorVendedorNome = piorVendedorNome;
	}
}
