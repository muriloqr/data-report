package br.com.datareport.converter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import br.com.datareport.enumeration.DataTypeEnum;
import br.com.datareport.model.ItemVendaModel;
import br.com.datareport.model.ReportModel;
import br.com.datareport.model.VendaModel;

public class DataReportConverter {
	
	private ItemVendaConverter itemVendaConverter = new ItemVendaConverter(); 
	
	public ReportModel convert(Stream<String> readData) {
		ReportModel reportModel = new ReportModel();
		VendaModel vendaModel = new VendaModel();
		
		vendaModel.setVendaMaisCara(new BigDecimal("0"));
		vendaModel.setVendaMaisBarata(Double.MAX_VALUE);
		
		readData.forEach(data -> {
			String[] columnValues = data.split("ç");
			String identifier = columnValues[0];
			
			if (identifier.equals(DataTypeEnum.VENDEDOR.getValue())) {
				Long quantidadeVendedores = 0L;
				
				if (reportModel.getQuantidadeVendedores() != null) {
					quantidadeVendedores = reportModel.getQuantidadeVendedores();
				}
				
				reportModel.setQuantidadeVendedores(quantidadeVendedores + 1);
				
			} else if (identifier.equals(DataTypeEnum.CLIENTE.getValue())) {
				Long quantidadeClientes = 0L;
				
				if (reportModel.getQuantidadeClientes() != null) {
					quantidadeClientes = reportModel.getQuantidadeClientes();
				}
				
				reportModel.setQuantidadeClientes(quantidadeClientes + 1);
				
			} else if (identifier.equals(DataTypeEnum.VENDA.getValue())) {
				Long idVenda = Long.valueOf(columnValues[1]);
				String vendedorNome = columnValues[3];
				
				List<ItemVendaModel> itensVendaModel = itemVendaConverter.convert(columnValues[2]);
				
				BigDecimal valorMaisCaroOfItens = itensVendaModel
						.stream()
						.map(ItemVendaModel::getItemPrice)
						.max(Comparator.naturalOrder())
						.get();
				

				Double piorVendedorValor = itensVendaModel.stream().mapToDouble(i -> i.getItemPrice().doubleValue() ).sum();
				
				if (valorMaisCaroOfItens.compareTo(vendaModel.getVendaMaisCara()) == 1) {
					vendaModel.setVendaMaisCara(valorMaisCaroOfItens);
					vendaModel.setSaleId(idVenda);
				}
				
				if (piorVendedorValor < vendaModel.getVendaMaisBarata()) {
					vendaModel.setVendaMaisBarata(piorVendedorValor);
					vendaModel.setPiorVendedorNome(vendedorNome);
				}
			}
		});
		
		reportModel.setIdVendaMaisCara(vendaModel.getSaleId());
		reportModel.setPiorVendedor(vendaModel.getPiorVendedorNome());
		
		return reportModel;
	}
	
	public String convertToString(ReportModel reportModel) {
		String qntClientes = reportModel.getQuantidadeClientes().toString();
		String qntVendedores = reportModel.getQuantidadeVendedores().toString();
		String vendaCara = reportModel.getIdVendaMaisCara().toString();
		String piorVendedor = reportModel.getPiorVendedor();
		
		return qntClientes
				.concat("ç")
				.concat(qntVendedores)
				.concat("ç")
				.concat(vendaCara)
				.concat("ç")
				.concat(piorVendedor);
	}
}
