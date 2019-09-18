package br.com.datareport.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import br.com.datareport.model.ItemVendaModel;

public class ItemVendaConverter {
	
	public List<ItemVendaModel> convert(String itens) {
		List<ItemVendaModel> itensVendaModel = new ArrayList<ItemVendaModel>();
		
		itens = itens.replaceAll("(\\[)|(\\])", "");
		
		Stream<String> vendas = Arrays.stream(itens.split(","));
		
		vendas.forEach(venda -> {
			ItemVendaModel itemVendaModel = new ItemVendaModel();
			String[] vendaDetails = venda.split("-");
			
			
			itemVendaModel.setItemID(Long.valueOf(vendaDetails[0]));
			itemVendaModel.setItemQuantity(Long.valueOf(vendaDetails[1]));
			itemVendaModel.setItemPrice(new BigDecimal(vendaDetails[2]));
			
			itensVendaModel.add(itemVendaModel);
		});
		
		return itensVendaModel; 
	}
}
