package br.com.datareport.model;

import java.math.BigDecimal;

public class ItemVendaModel {
	
	private Long itemID;
	private Long itemQuantity;
	private BigDecimal itemPrice;
	
	public Long getItemID() {
		return itemID;
	}
	
	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}
	
	public Long getItemQuantity() {
		return itemQuantity;
	}
	
	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
