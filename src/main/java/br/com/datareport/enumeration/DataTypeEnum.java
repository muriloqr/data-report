package br.com.datareport.enumeration;

public enum DataTypeEnum {
    VENDEDOR("001"),
    CLIENTE("002"),
    VENDA("003");
	
    private String value;

    public String getValue() {
        return value;
    }

    DataTypeEnum(String value){
        this.value = value;
    }
}