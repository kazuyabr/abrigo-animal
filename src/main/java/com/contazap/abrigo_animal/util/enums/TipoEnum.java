package com.contazap.abrigo_animal.util.enums;

public enum TipoEnum {

	CACHORRO("CACHORRO"), GATO("GATO");

	private final String value;

	TipoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static TipoEnum getEnum(String type) {
		for (TipoEnum t : values()) {
			if (type.equals(t.getValue())) {
				return t;
			}
		}
		return null;
	}

}
